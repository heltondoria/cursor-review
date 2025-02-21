# Cursor Code Review Extension

Uma extensão para o Cursor que realiza revisões automáticas de código em tempo real usando LLMs, integrada através do protocolo MCP.

## Estrutura do Projeto

```shell
📁 cursor-code-review/
├── 📁 src/                      # Código fonte da extensão
│   ├── 📁 mcp/                 # Implementação do protocolo MCP
│   │   ├── server.ts           # Servidor MCP
│   │   ├── tools.ts            # Ferramentas MCP
│   │   └── transport.ts        # Implementação de transportes
│   │
│   ├── 📁 review/             # Lógica de revisão de código
│   │   ├── analyzer.ts         # Análise de código
│   │   ├── processor.ts        # Processamento de regras
│   │   └── suggestions.ts      # Geração de sugestões
│   │
│   ├── 📁 cursor/             # Integração com Cursor
│   │   ├── composer.ts         # Integração com composer
│   │   ├── chat.ts            # Integração com chat
│   │   └── commands.ts        # Comandos da extensão
│   │
│   ├── 📁 config/             # Configurações
│   │   ├── settings.ts        # Gerenciamento de configurações
│   │   └── defaults.ts        # Valores padrão
│   │
│   ├── 📁 utils/              # Utilitários
│   │   ├── diff.ts            # Utilitários para diff
│   │   └── logger.ts          # Sistema de logging
│   │
│   └── extension.ts           # Ponto de entrada da extensão
│
├── 📁 test/                    # Testes
│   ├── 📁 mcp/                # Testes dos componentes MCP
│   ├── 📁 review/             # Testes da lógica de revisão
│   └── 📁 integration/        # Testes de integração
│
├── 📁 docs/                    # Documentação
│   ├── 📁 specs/              # Especificações
│   │   ├── PRD.md             # Product Requirements Document
│   │   ├── WORKFLOW.md        # Workflow de desenvolvimento
│   │   └── STORIES.md         # User Stories
│   └── 📁 api/               # Documentação da API
│
├── 📁 resources/              # Recursos estáticos
│   ├── icons/                # Ícones da extensão
│   └── templates/            # Templates
│
├── package.json              # Configuração do projeto
├── tsconfig.json            # Configuração TypeScript
└── README.md                # Este arquivo
```

## Componentes Principais

### MCP (src/mcp/)

Implementação do protocolo MCP para comunicação com o Cursor:

- `server.ts`: Servidor MCP embutido
- `tools.ts`: Definição e implementação das ferramentas
- `transport.ts`: Suporte a STDIO e SSE

### Review (src/review/)

Lógica central de revisão de código:

- `analyzer.ts`: Análise estática e dinâmica
- `processor.ts`: Processamento de regras
- `suggestions.ts`: Geração de sugestões

### Cursor (src/cursor/)

Integração com o editor Cursor:

- `composer.ts`: Integração com o composer
- `chat.ts`: Integração com contexto do chat
- `commands.ts`: Comandos da extensão

### Config (src/config/)

Gerenciamento de configurações:

- `settings.ts`: Configurações da extensão
- `defaults.ts`: Valores padrão

### Utils (src/utils/)

Utilitários compartilhados:

- `diff.ts`: Processamento de diffs
- `logger.ts`: Sistema de logging

## Desenvolvimento

### Pré-requisitos

- Node.js >= 14
- TypeScript >= 4.5
- VS Code >= 1.60

### Instalação

```bash
npm install
```

### Scripts

```bash
npm run build     # Compila o projeto
npm run test      # Executa testes
npm run watch     # Modo de desenvolvimento
npm run package   # Cria VSIX para distribuição
```

### Testes

O projeto usa Jest para testes:

- Unitários: `npm run test:unit`
- Integração: `npm run test:integration`
- Coverage: `npm run test:coverage`

## Documentação

- [PRD](docs/specs/PRD.md) - Documento de requisitos
- [Workflow](docs/specs/WORKFLOW.md) - Processo de desenvolvimento
- [Stories](docs/specs/STORIES.md) - User stories

## Contribuição

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/amazing`)
3. Commit suas mudanças (`git commit -m 'Add amazing feature'`)
4. Push para a branch (`git push origin feature/amazing`)
5. Abra um Pull Request

## Licença

MIT
