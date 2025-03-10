# CodeReview MCP Server

Servidor MCP (Model Context Protocol) para revisão de código automatizada.

## Descrição

O CodeReview MCP Server é um servidor baseado no protocolo Model Context Protocol (MCP) que fornece capacidades de revisão de código automatizada para modelos de linguagem. O servidor é implementado em Java com Spring Boot e o SDK Java MCP, suportando inicialmente o transporte stdio para integração com clientes como o Cursor e o Claude Desktop.

## Requisitos

- Java 21 ou superior
- Maven 3.8 ou superior

## Estrutura do Projeto

```
com.codereview.mcp
├── CodeReviewMcpServerApplication.java
├── config
│   ├── McpConfig.java
│   ├── McpServerConfig.java
│   ├── TransportConfig.java
│   └── TransportType.java
├── core
│   ├── McpServer.java
│   ├── resource
│   │   ├── CodeResource.java
│   │   ├── ResourceManager.java
│   │   └── ResourceType.java
│   ├── tool
│   │   ├── ReviewTool.java
│   │   ├── ToolManager.java
│   │   └── ToolResult.java
│   └── prompt
│       ├── PromptManager.java
│       └── ReviewPrompt.java
├── transport
│   ├── Transport.java
│   ├── TransportFactory.java
│   └── stdio
│       └── StdioTransport.java
└── util
    └── LoggingUtil.java
```

## Compilação

Para compilar o projeto, execute:

```bash
mvn clean package
```

## Execução

Para executar o servidor, execute:

```bash
java -jar target/mcp-server-0.0.1-SNAPSHOT.jar
```

## Configuração

As configurações do servidor podem ser ajustadas no arquivo `application.properties`:

```properties
# Configurações do servidor MCP
mcp.server.serverName=CodeReview MCP Server
mcp.server.serverVersion=0.1.0
mcp.server.transportType=STDIO

# Configurações de logging
logging.level.root=INFO
logging.level.com.codereview.mcp=DEBUG
```

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.
