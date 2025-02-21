declare module '@modelcontextprotocol/sdk' {
  export interface Tool<T extends Record<string, unknown>> {
    name: string;
    description: string;
    execute: (params: T & Record<string, unknown>) => Promise<{
      success: boolean;
      data?: unknown;
    }>;
    parameters: {
      type: string;
      properties: Record<string, unknown>;
      required?: string[];
    };
  }

  export interface Transport {
    send(message: unknown): Promise<void>;
    receive(): Promise<unknown>;
    close(): Promise<void>;
  }

  export function createServer(transport: Transport): {
    start(): Promise<void>;
    stop(): Promise<void>;
    registerTool<T extends Record<string, unknown>>(tool: Tool<T>): void;
  };

  export function createStdioTransport(): Transport;
} 