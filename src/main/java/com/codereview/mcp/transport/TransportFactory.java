package com.codereview.mcp.transport;

import com.codereview.mcp.config.McpServerConfig;
import com.codereview.mcp.transport.stdio.StdioTransport;
import lombok.extern.slf4j.Slf4j;

/**
 * Fábrica para criação de transportes.
 */
@Slf4j
public class TransportFactory {
    
    private final McpServerConfig config;
    
    /**
     * Construtor da fábrica de transportes.
     *
     * @param config Configuração do servidor MCP
     */
    public TransportFactory(McpServerConfig config) {
        this.config = config;
    }
    
    /**
     * Cria um transporte com base na configuração.
     *
     * @return Transporte criado
     */
    public Transport createTransport() {
        log.info("Criando transporte do tipo: {}", config.getTransportType());
        
        return switch (config.getTransportType()) {
            case STDIO -> createStdioTransport();
            case SSE -> throw new UnsupportedOperationException("Transporte SSE ainda não implementado");
            default -> throw new IllegalArgumentException("Tipo de transporte desconhecido: " + config.getTransportType());
        };
    }
    
    /**
     * Cria um transporte stdio.
     *
     * @return Transporte stdio
     */
    private Transport createStdioTransport() {
        log.info("Criando transporte stdio");
        return new StdioTransport();
    }
} 