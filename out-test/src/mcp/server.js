"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.BaseMCPServer = void 0;
const sdk_1 = require("@modelcontextprotocol/sdk");
class BaseMCPServer {
    constructor(transport) {
        this.tools = new Map();
        this.server = (0, sdk_1.createServer)(transport);
    }
    async start() {
        await this.server.start();
        console.log('MCP Server started');
    }
    async stop() {
        await this.server.stop();
        console.log('MCP Server stopped');
    }
    registerTool(tool) {
        this.tools.set(tool.name, tool);
        this.server.registerTool(tool);
        console.log(`Tool ${tool.name} registered`);
    }
}
exports.BaseMCPServer = BaseMCPServer;
//# sourceMappingURL=server.js.map