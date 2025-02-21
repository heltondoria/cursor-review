"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.activate = activate;
exports.deactivate = deactivate;
const vscode = __importStar(require("vscode"));
const server_1 = require("./mcp/server");
const transport_1 = require("./mcp/transport");
function activate(context) {
    console.log('Cursor Code Review extension is now active');
    // Inicializar servidor MCP
    const transport = (0, transport_1.createTransport)();
    const mcpServer = new server_1.BaseMCPServer(transport);
    // Registrar ferramentas MCP
    mcpServer.registerTool({
        name: 'review_changes',
        description: 'Revisa modificações propostas no código',
        execute: async (params) => {
            console.log('Reviewing changes:', params);
            return { success: true };
        },
        parameters: {
            type: 'object',
            properties: {
                diff: {
                    type: 'string',
                    description: 'Diff das modificações propostas'
                },
                context: {
                    type: 'string',
                    description: 'Contexto adicional do código'
                }
            },
            required: ['diff']
        }
    });
    // Iniciar servidor
    mcpServer.start().catch(err => {
        console.error('Failed to start MCP server:', err);
    });
    // Registrar comandos
    const startReview = vscode.commands.registerCommand('cursor-code-review.startReview', () => {
        vscode.window.showInformationMessage('Starting code review...');
    });
    const configureReview = vscode.commands.registerCommand('cursor-code-review.configureReview', () => {
        vscode.window.showInformationMessage('Opening review configuration...');
    });
    context.subscriptions.push(startReview, configureReview, {
        dispose: () => {
            mcpServer.stop().catch(err => {
                console.error('Failed to stop MCP server:', err);
            });
        }
    });
}
function deactivate() { }
//# sourceMappingURL=extension.js.map