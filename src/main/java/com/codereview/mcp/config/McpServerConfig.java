package com.codereview.mcp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuração do servidor MCP.
 * Contém as propriedades necessárias para inicializar e configurar o servidor MCP.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mcp.server")
public class McpServerConfig {
    /**
     * Nome do servidor MCP.
     */
    private String serverName = "CodeReview MCP Server";
    
    /**
     * Versão do servidor MCP.
     */
    private String serverVersion = "0.1.0";
    
    /**
     * Tipo de transporte utilizado pelo servidor.
     */
    private TransportType transportType = TransportType.STDIO;
    
    /**
     * Configurações adicionais para o servidor MCP.
     */
    private Map<String, Object> additionalConfig = new HashMap<>();
} 