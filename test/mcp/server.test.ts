import { BaseMCPServer } from '../../src/mcp/server';
import { Tool, Transport } from '@modelcontextprotocol/sdk';

class MockTransport implements Transport {
  async send(): Promise<void> {}
  async receive(): Promise<unknown> { return {}; }
  async close(): Promise<void> {}
}

interface TestParams extends Record<string, unknown> {
  test: string;
}

describe('BaseMCPServer', () => {
  let server: BaseMCPServer<TestParams>;
  let transport: Transport;

  beforeEach(() => {
    transport = new MockTransport();
    server = new BaseMCPServer<TestParams>(transport);
  });

  test('should register tool', () => {
    const tool: Tool<TestParams> = {
      name: 'test_tool',
      description: 'Test tool',
      execute: async (params: { test: string }) => {
        console.log('Test tool executed:', params);
        return { success: true };
      },
      parameters: {
        type: 'object',
        properties: {
          test: {
            type: 'string',
            description: 'Test parameter'
          }
        },
        required: ['test']
      }
    };

    server.registerTool(tool);
    expect(server['tools'].has('test_tool')).toBe(true);
  });
}); 