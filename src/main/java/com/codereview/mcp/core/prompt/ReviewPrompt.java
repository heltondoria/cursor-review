package com.codereview.mcp.core.prompt;

import java.util.Map;

/**
 * Interface que representa um prompt de revisão de código.
 */
public interface ReviewPrompt {
    
    /**
     * Obtém o identificador único do prompt.
     *
     * @return Identificador único do prompt
     */
    String getId();
    
    /**
     * Obtém o nome do prompt.
     *
     * @return Nome do prompt
     */
    String getName();
    
    /**
     * Obtém a descrição do prompt.
     *
     * @return Descrição do prompt
     */
    String getDescription();
    
    /**
     * Obtém o conteúdo do prompt.
     *
     * @return Conteúdo do prompt
     */
    String getContent();
    
    /**
     * Gera o prompt com os parâmetros fornecidos.
     *
     * @param parameters Parâmetros para geração do prompt
     * @return Prompt gerado
     */
    String generate(Map<String, Object> parameters);
} 