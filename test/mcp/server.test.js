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
            execute: async () => ({ success: true }),
            parameters: {
                type: 'object',
                properties: {}
            }
        };
        server.registerTool(tool);
        // Por enquanto só testamos que não lança exceção
        expect(true).toBe(true);
    });
});
//# sourceMappingURL=server.test.js.map