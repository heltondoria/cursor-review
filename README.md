# Servidor MCP para Revisão de Código

Este projeto implementa um servidor MCP (Model Context Protocol) para revisão de código, projetado para ser usado com IDEs que suportam o protocolo MCP, como o Cursor.

## Funcionalidades

- Revisão de código em diferentes linguagens de programação
- Detecção automática da linguagem com base na extensão do arquivo
- Suporte para arquivos grandes através de estratégia de chunking
- Filtragem de comentários por severidade e categoria
- Prompts personalizados para diferentes tipos de revisão
- Ferramentas especializadas para revisão de segurança e performance

## Requisitos

- Java 17 ou superior
- Maven 3.8 ou superior
- IDE com suporte a MCP (como Cursor)

## Configuração

O arquivo `application.properties` contém as configurações do servidor MCP:

```properties
# Configurações do servidor MCP
spring.ai.mcp.server.name=CodeReview MCP Server
spring.ai.mcp.server.version=0.1.0
spring.ai.mcp.server.transport.type=STDIO

# Configurações específicas da aplicação
app.review.max-file-size=1MB
app.review.default-min-severity=2
app.review.chunk-size=500
app.review.chunk-overlap=50
```

## Ferramentas MCP

O servidor expõe as seguintes ferramentas MCP:

### reviewCode

Revisa um arquivo de código e fornece sugestões de melhoria.

Parâmetros:
- `fileName`: Nome do arquivo
- `fileContent`: Conteúdo do arquivo
- `minSeverity` (opcional): Severidade mínima dos comentários (1-5, padrão: 2)
- `categories` (opcional): Categorias de comentários separadas por vírgula
- `customPrompt` (opcional): Prompt personalizado para a revisão
- `debug` (opcional): Modo de depuração

### reviewCriticalIssues

Revisa um arquivo de código e retorna apenas os problemas críticos (severidade >= 4).

Parâmetros:
- `fileName`: Nome do arquivo
- `fileContent`: Conteúdo do arquivo

### reviewSecurity

Revisa um arquivo de código focando em problemas de segurança.

Parâmetros:
- `fileName`: Nome do arquivo
- `fileContent`: Conteúdo do arquivo

### reviewPerformance

Revisa um arquivo de código focando em problemas de performance.

Parâmetros:
- `fileName`: Nome do arquivo
- `fileContent`: Conteúdo do arquivo

## Modelo de Dados

### ReviewOptions

Opções para personalizar a revisão de código:

- `minSeverity`: Severidade mínima dos comentários (1-5)
- `categories`: Lista de categorias a serem incluídas
- `customPrompt`: Prompt personalizado para a revisão
- `debug`: Modo de depuração

### ReviewComment

Representa um comentário de revisão:

- `file`: Nome do arquivo
- `line`: Número da linha
- `comment`: Texto do comentário
- `severity`: Severidade (1-5)
- `category`: Categoria do comentário

### ReviewResult

Resultado da revisão de código:

- `fileName`: Nome do arquivo revisado
- `comments`: Lista de comentários
- `severityCounts`: Contagem de comentários por severidade
- `processingTimeMs`: Tempo de processamento em milissegundos

## Compilação e Execução

Para compilar o projeto:

```bash
mvn clean package
```

Para executar o servidor MCP:

```bash
java -jar target/mcp-server-0.1.0-SNAPSHOT.jar
```

## Uso com Cursor

1. Inicie o servidor MCP
2. No Cursor, conecte-se ao servidor MCP através da janela de chat
3. Use as ferramentas MCP para revisar seu código

## Estrutura do Projeto

```
src/main/java/com/codereview/mcp/
├── CodeReviewMcpApplication.java
├── config/
│   └── McpConfig.java
├── model/
│   ├── ReviewComment.java
│   ├── ReviewOptions.java
│   └── ReviewResult.java
├── service/
│   └── ReviewService.java
├── tool/
│   └── ReviewTool.java
└── util/
    ├── ChunkingStrategy.java
    ├── LanguageDetector.java
    ├── PromptGenerator.java
    └── ReviewResultFormatter.java
```

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.
