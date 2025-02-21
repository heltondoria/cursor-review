import { Tool } from '@modelcontextprotocol/sdk';

export interface MCPTool {
  name: string;
  description: string;
  inputSchema: {
    type: string;
    properties: Record<string, unknown>;
  };
}

export interface MCPServer<T extends Record<string, unknown>> {
  start(): Promise<void>;
  stop(): Promise<void>;
  registerTool(tool: Tool<T>): void;
}

export interface MCPTransport {
  send(message: unknown): Promise<void>;
  receive(): Promise<unknown>;
  close(): Promise<void>;
} 