import { Tool, createServer, Transport } from '@modelcontextprotocol/sdk';
import { MCPServer } from './types';

export class BaseMCPServer<T extends Record<string, unknown>> implements MCPServer<T> {
  private tools: Map<string, Tool<T>> = new Map();
  private server: ReturnType<typeof createServer>;

  constructor(transport: Transport) {
    this.server = createServer(transport);
  }

  async start(): Promise<void> {
    await this.server.start();
    console.log('MCP Server started');
  }

  async stop(): Promise<void> {
    await this.server.stop();
    console.log('MCP Server stopped');
  }

  registerTool(tool: Tool<T>): void {
    this.tools.set(tool.name, tool);
    this.server.registerTool(tool);
    console.log(`Tool ${tool.name} registered`);
  }
} 