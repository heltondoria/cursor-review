package com.codereview.mcp.core.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Gerenciador de ferramentas de revisão.
 * Responsável por gerenciar o ciclo de vida das ferramentas de revisão.
 */
@Slf4j
public class ToolManager {
    
    private final Map<String, ReviewTool> tools = new HashMap<>();
    
    /**
     * Inicializa o gerenciador de ferramentas.
     */
    public void initialize() {
        log.info("Inicializando gerenciador de ferramentas");
    }
    
    /**
     * Registra uma ferramenta no gerenciador.
     *
     * @param tool Ferramenta a ser registrada
     * @return A ferramenta registrada
     */
    public ReviewTool registerTool(ReviewTool tool) {
        log.info("Registrando ferramenta: {}", tool.getId());
        tools.put(tool.getId(), tool);
        return tool;
    }
    
    /**
     * Obtém uma ferramenta pelo seu identificador.
     *
     * @param id Identificador da ferramenta
     * @return A ferramenta, se encontrada
     */
    public Optional<ReviewTool> getTool(String id) {
        return Optional.ofNullable(tools.get(id));
    }
    
    /**
     * Remove uma ferramenta do gerenciador.
     *
     * @param id Identificador da ferramenta a ser removida
     * @return true se a ferramenta foi removida, false caso contrário
     */
    public boolean removeTool(String id) {
        if (tools.containsKey(id)) {
            log.info("Removendo ferramenta: {}", id);
            tools.remove(id);
            return true;
        }
        return false;
    }
    
    /**
     * Obtém todas as ferramentas registradas.
     *
     * @return Mapa de ferramentas registradas
     */
    public Map<String, ReviewTool> getAllTools() {
        return new HashMap<>(tools);
    }
} 