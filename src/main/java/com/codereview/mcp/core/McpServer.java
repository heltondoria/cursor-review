package com.codereview.mcp.core;

import com.codereview.mcp.config.McpServerConfig;
import com.codereview.mcp.core.prompt.PromptManager;
import com.codereview.mcp.core.resource.ResourceManager;
import com.codereview.mcp.core.tool.ToolManager;
import com.codereview.mcp.transport.TransportFactory;
import com.codereview.mcp.util.LoggingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

/**
 * Servidor MCP principal.
 * Responsável por inicializar e gerenciar o ciclo de vida do servidor MCP.
 */
@Slf4j
public class McpServer implements CommandLineRunner {
    
    private final McpServerConfig config;
    private final TransportFactory transportFactory;
    private final ResourceManager resourceManager;
    private final ToolManager toolManager;
    private final PromptManager promptManager;
    
    /**
     * Construtor do servidor MCP.
     *
     * @param config Configuração do servidor
     * @param transportFactory Fábrica de transportes
     * @param resourceManager Gerenciador de recursos
     * @param toolManager Gerenciador de ferramentas
     * @param promptManager Gerenciador de prompts
     */
    public McpServer(
            McpServerConfig config,
            TransportFactory transportFactory,
            ResourceManager resourceManager,
            ToolManager toolManager,
            PromptManager promptManager) {
        this.config = config;
        this.transportFactory = transportFactory;
        this.resourceManager = resourceManager;
        this.toolManager = toolManager;
        this.promptManager = promptManager;
    }
    
    /**
     * Inicializa o servidor MCP.
     */
    public void initialize() {
        log.info("Inicializando servidor MCP: {}", config.getServerName());
        log.info("Versão: {}", config.getServerVersion());
        log.info("Tipo de transporte: {}", config.getTransportType());
        
        // Inicializa os gerenciadores
        resourceManager.initialize();
        toolManager.initialize();
        promptManager.initialize();
        
        // Inicializa o transporte
        var transport = transportFactory.createTransport();
        transport.initialize();
        
        log.info("Servidor MCP inicializado com sucesso");
    }
    
    /**
     * Método executado quando a aplicação é iniciada.
     *
     * @param args Argumentos de linha de comando
     */
    @Override
    public void run(String... args) {
        try {
            LoggingUtil.configureLogging();
            initialize();
        } catch (Exception e) {
            log.error("Erro ao inicializar servidor MCP", e);
            System.exit(1);
        }
    }
} 