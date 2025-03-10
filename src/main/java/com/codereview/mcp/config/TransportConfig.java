package com.codereview.mcp.config;

import com.codereview.mcp.transport.TransportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração dos transportes do servidor MCP.
 */
@Configuration
public class TransportConfig {
    
    private final McpServerConfig serverConfig;
    
    /**
     * Construtor da configuração de transporte.
     *
     * @param serverConfig Configuração do servidor MCP
     */
    public TransportConfig(McpServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
    
    /**
     * Cria e configura a fábrica de transportes.
     *
     * @return Fábrica de transportes configurada
     */
    @Bean
    public TransportFactory transportFactory() {
        return new TransportFactory(serverConfig);
    }
} 