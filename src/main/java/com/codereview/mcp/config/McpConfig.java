package com.codereview.mcp.config;

import com.codereview.mcp.core.McpServer;
import com.codereview.mcp.core.prompt.PromptManager;
import com.codereview.mcp.core.resource.ResourceManager;
import com.codereview.mcp.core.tool.ToolManager;
import com.codereview.mcp.transport.TransportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração principal do MCP.
 * Configura os componentes principais do servidor MCP.
 */
@Configuration
public class McpConfig {
    
    private final McpServerConfig serverConfig;
    private final TransportFactory transportFactory;
    
    /**
     * Construtor da configuração MCP.
     *
     * @param serverConfig Configuração do servidor
     * @param transportFactory Fábrica de transportes
     */
    public McpConfig(McpServerConfig serverConfig, TransportFactory transportFactory) {
        this.serverConfig = serverConfig;
        this.transportFactory = transportFactory;
    }
    
    /**
     * Cria e configura o gerenciador de recursos.
     *
     * @return Gerenciador de recursos configurado
     */
    @Bean
    public ResourceManager resourceManager() {
        return new ResourceManager();
    }
    
    /**
     * Cria e configura o gerenciador de ferramentas.
     *
     * @return Gerenciador de ferramentas configurado
     */
    @Bean
    public ToolManager toolManager() {
        return new ToolManager();
    }
    
    /**
     * Cria e configura o gerenciador de prompts.
     *
     * @return Gerenciador de prompts configurado
     */
    @Bean
    public PromptManager promptManager() {
        return new PromptManager();
    }
    
    /**
     * Cria e configura o servidor MCP.
     *
     * @param resourceManager Gerenciador de recursos
     * @param toolManager Gerenciador de ferramentas
     * @param promptManager Gerenciador de prompts
     * @return Servidor MCP configurado
     */
    @Bean
    public McpServer mcpServer(
            ResourceManager resourceManager,
            ToolManager toolManager,
            PromptManager promptManager) {
        return new McpServer(
                serverConfig,
                transportFactory,
                resourceManager,
                toolManager,
                promptManager
        );
    }
} 