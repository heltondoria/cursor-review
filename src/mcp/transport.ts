import { Transport, createStdioTransport } from '@modelcontextprotocol/sdk';

export function createTransport(): Transport {
  return createStdioTransport();
} 