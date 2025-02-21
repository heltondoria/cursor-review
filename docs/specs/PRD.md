# PRD: Extensão de Revisão de Código para Cursor

## Sumário Executivo

Uma extensão para o Cursor que realiza revisões automáticas de código em tempo real, integrada ao composer através do protocolo MCP. A solução visa melhorar a qualidade do código gerado automaticamente, oferecendo feedback imediato antes mesmo do código ser persistido.

## Estado Atual e Motivação

### Contexto Atual

- O Cursor é uma ferramenta poderosa para geração de código via IA
- O código gerado pelo composer às vezes precisa de ajustes
- Revisões manuais podem ser demoradas e inconsistentes
- Ferramentas existentes (como LGTM) só funcionam após o commit

### Motivação

1. **Aprendizado Técnico**:
   - Ganhar experiência com desenvolvimento de servidores MCP
   - Aprofundar conhecimento em extensões VSCode/Cursor

2. **Oportunidade de Mercado**:
   - Complementar as capacidades do Cursor
   - Preencher lacuna entre geração e revisão de código
   - Oferecer feedback em tempo real

## Visão Geral

Uma extensão para o Cursor que permite realizar revisões automáticas de código usando LLMs, integrada através do protocolo MCP. A extensão analisará modificações propostas pelo composer antes de serem persistidas, fornecendo feedback imediato sobre potenciais problemas.

## Objetivos

1. Fornecer revisão automática de código em tempo real
2. Integrar naturalmente com o fluxo de trabalho do Cursor
3. Aproveitar as capacidades do MCP para melhor contextualização
4. Manter a simplicidade e usabilidade do LGTM

## Funcionalidades Principais

### 1. Servidor MCP Embutido

- Implementar um servidor MCP que será iniciado junto com a extensão
- Expor ferramentas (tools) para revisão de código
- Integrar com o sistema de composer do Cursor
- Suportar tanto STDIO quanto SSE como transportes

### 2. Ferramentas MCP

#### 2.1 Ferramenta de Revisão

```typescript
{
  name: "review_changes",
  description: "Revisa modificações propostas no código",
  inputSchema: {
    type: "object",
    properties: {
      diff: {
        type: "string",
        description: "Diff das modificações propostas"
      },
      context: {
        type: "string",
        description: "Contexto adicional do código"
      }
    }
  }
}
```

#### 2.2 Ferramenta de Configuração

```typescript
{
  name: "configure_review",
  description: "Configura parâmetros de revisão",
  inputSchema: {
    type: "object",
    properties: {
      minSeverity: {
        type: "number",
        minimum: 1,
        maximum: 5
      },
      excludePatterns: {
        type: "array",
        items: { type: "string" }
      }
    }
  }
}
```

### 3. Integração com Cursor

- Interceptar modificações propostas pelo composer
- Injetar resultados da revisão no contexto do chat
- Fornecer links diretos para as linhas relevantes
- Permitir aplicar/rejeitar sugestões diretamente

### 4. Regras de Processamento

- Herdar regras de processamento do LGTM:
  - Ignorar arquivos excluídos
  - Agrupar arquivos em requests
  - Filtrar por severidade
  - Validar formato dos comentários

## Configurações

| Configuração | Padrão | Descrição |
|--------------|---------|------------|
| `review.minSeverity` | 2 | Severidade mínima (1-5) |
| `review.excludePatterns` | [...] | Padrões glob para exclusão |
| `review.autoReview` | true | Revisar automaticamente |
| `review.maxGroupSize` | 5 | Máximo de arquivos por grupo |

## Fluxo de Trabalho

1. **Inicialização**
   - Extensão inicia servidor MCP
   - Registra ferramentas no Cursor
   - Carrega configurações

2. **Revisão**
   - Intercepta modificações do composer
   - Agrupa arquivos se necessário
   - Envia para revisão via MCP
   - Processa resultados
   - Injeta no contexto do chat

3. **Interação**
   - Usuário revisa sugestões
   - Pode aplicar/rejeitar mudanças
   - Configura preferências

## Requisitos Técnicos

1. **Dependências**
   - VS Code Extension API
   - MCP TypeScript SDK
   - Cursor API

2. **Compatibilidade**
   - VS Code 1.60+
   - Cursor com suporte a MCP
   - Windows/Mac/Linux

## Métricas de Sucesso

1. **Qualidade**
   - Taxa de falsos positivos < 10%
   - Precisão das sugestões > 80%

2. **Performance**
   - Tempo de revisão < 3s por arquivo
   - Uso de memória < 100MB

3. **Adoção**
   - Downloads > 1000/mês
   - Rating > 4.0/5.0

## Fases de Desenvolvimento

1. **Fase 1 - MVP**
   - Implementação básica do servidor MCP
   - Integração com composer
   - Revisão simples de código

2. **Fase 2 - Aprimoramentos**
   - Configurações avançadas
   - Melhorias na UI
   - Suporte a mais linguagens

3. **Fase 3 - Otimizações**
   - Performance
   - Customização
   - Telemetria

## Limitações e Riscos

- Dependência da API do Cursor
- Latência em revisões complexas
- Possíveis falsos positivos

## Alternativas Consideradas

### 1. Extensão LGTM

**Prós**:

- Base de usuários estabelecida
- Integração com GitHub
- Interface familiar

**Contras**:

- Forte acoplamento com GitHub Copilot
- Funciona apenas com código já commitado
- Não integra com o composer

### 2. Desenvolvimento do Zero

**Prós**:

- Controle total sobre a implementação
- Integração direta com composer
- Flexibilidade para evolução

**Contras**:

- Curva de aprendizado inicial
- Necessidade de construir base de usuários

## Cronograma

### Fase 1 - MVP (4 semanas)

- Semana 1-2: Implementação básica do servidor MCP
- Semana 3: Integração com composer
- Semana 4: Testes e ajustes

### Fase 2 - Aprimoramentos (6 semanas)

- Semana 1-2: Configurações avançadas
- Semana 3-4: Melhorias na UI
- Semana 5-6: Suporte a mais linguagens

### Fase 3 - Otimizações (4 semanas)

- Semana 1-2: Performance
- Semana 3: Customização
- Semana 4: Telemetria

## Apêndices

### Referências

1. [Documentação do Cursor](https://cursor.sh/docs)
2. [Protocolo MCP](https://mcp-docs.example.com)
3. [VS Code Extension API](https://code.visualstudio.com/api)
4. [LGTM Documentation](https://lgtm.com/docs)

### Documentação Adicional

- [Guia de Desenvolvimento](./DEVELOPMENT.md)
- [Workflow de Desenvolvimento](./WORKFLOW.md)
- [Guia de Contribuição](./CONTRIBUTING.md)
