package com.codereview.mcp.core.tool;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa o resultado da execução de uma ferramenta de revisão.
 */
@Data
@Builder
public class ToolResult {
    
    /**
     * Identificador único do resultado.
     */
    private final String id;
    
    /**
     * Identificador da ferramenta que gerou o resultado.
     */
    private final String toolId;
    
    /**
     * Identificador do recurso que foi revisado.
     */
    private final String resourceId;
    
    /**
     * Status da execução da ferramenta.
     */
    private final ToolStatus status;
    
    /**
     * Mensagem descritiva do resultado.
     */
    private final String message;
    
    /**
     * Dados adicionais do resultado.
     */
    @Builder.Default
    private final Map<String, Object> data = new HashMap<>();
    
    /**
     * Enum que define os possíveis status de execução de uma ferramenta.
     */
    public enum ToolStatus {
        /**
         * Execução bem-sucedida.
         */
        SUCCESS,
        
        /**
         * Execução com avisos.
         */
        WARNING,
        
        /**
         * Execução com erros.
         */
        ERROR,
        
        /**
         * Execução cancelada.
         */
        CANCELLED
    }
} 