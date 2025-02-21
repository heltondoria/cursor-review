import * as vscode from 'vscode';
import { BaseMCPServer } from './mcp/server';
import { createTransport } from './mcp/transport';

interface ReviewParams extends Record<string, unknown> {
  diff: string;
  context?: string;
}

export function activate(context: vscode.ExtensionContext) {
  console.log('Cursor Code Review extension is now active');

  // Inicializar servidor MCP
  const transport = createTransport();
  const mcpServer = new BaseMCPServer<ReviewParams>(transport);

  // Registrar ferramentas MCP
  mcpServer.registerTool({
    name: 'review_changes',
    description: 'Revisa modificações propostas no código',
    execute: async (params: { diff: string; context?: string }) => {
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

  context.subscriptions.push(
    startReview, 
    configureReview,
    {
      dispose: () => {
        mcpServer.stop().catch(err => {
          console.error('Failed to stop MCP server:', err);
        });
      }
    }
  );
}

export function deactivate() {} 