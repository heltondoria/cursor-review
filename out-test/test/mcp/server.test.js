"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const server_1 = require("../../src/mcp/server");
class MockTransport {
    async send() { }
    async receive() { return {}; }
    async close() { }
}
describe('BaseMCPServer', () => {
    let server;
    let transport;
    beforeEach(() => {
        transport = new MockTransport();
        server = new server_1.BaseMCPServer(transport);
    });
    test('should register tool', () => {
        const tool = {
            name: 'test_tool',
            description: 'Test tool',
            execute: async (params) => {
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
//# sourceMappingURL=server.test.js.map