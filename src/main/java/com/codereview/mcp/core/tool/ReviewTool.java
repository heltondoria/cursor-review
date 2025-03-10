package com.codereview.mcp.core.tool;

import com.codereview.mcp.core.resource.CodeResource;

import java.util.Map;

/**
 * Interface que representa uma ferramenta de revisão de código.
 */
public interface ReviewTool {
    
    /**
     * Obtém o identificador único da ferramenta.
     *
     * @return Identificador único da ferramenta
     */
    String getId();
    
    /**
     * Obtém o nome da ferramenta.
     *
     * @return Nome da ferramenta
     */
    String getName();
    
    /**
     * Obtém a descrição da ferramenta.
     *
     * @return Descrição da ferramenta
     */
    String getDescription();
    
    /**
     * Executa a ferramenta de revisão em um recurso de código.
     *
     * @param resource Recurso de código a ser revisado
     * @param parameters Parâmetros adicionais para a execução da ferramenta
     * @return Resultado da revisão
     */
    ToolResult execute(CodeResource resource, Map<String, Object> parameters);
} 