export interface Tool<T extends Record<string, unknown>> {
  name: string;
  description: string;
  execute: (params: T) => Promise<{
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

class MockServer<T extends Record<string, unknown>> {
  private tools = new Map<string, Tool<T>>();
  private transport: Transport;

  constructor(transport: Transport) {
    this.transport = transport;
  }

  async start(): Promise<void> {
    await this.transport.receive();
  }

  async stop(): Promise<void> {
    await this.transport.close();
  }

  registerTool(tool: Tool<T>): void {
    this.tools.set(tool.name, tool);
  }
}

export function createServer(transport: Transport) {
  return new MockServer(transport);
}

export function createStdioTransport(): Transport {
  return {
    send: async (message: unknown) => {
      console.log('Mock Transport Send:', message);
    },
    receive: async () => {
      return { type: 'mock_message' };
    },
    close: async () => {
      console.log('Mock Transport Closed');
    }
  };
} 