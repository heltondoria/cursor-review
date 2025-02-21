"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.createTransport = createTransport;
const sdk_1 = require("@modelcontextprotocol/sdk");
function createTransport() {
    return (0, sdk_1.createStdioTransport)();
}
//# sourceMappingURL=transport.js.map