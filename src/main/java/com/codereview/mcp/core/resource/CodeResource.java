package com.codereview.mcp.core.resource;

/**
 * Interface que representa um recurso de código.
 * Um recurso de código pode ser um arquivo, um trecho de código, etc.
 */
public interface CodeResource {
    
    /**
     * Obtém o identificador único do recurso.
     *
     * @return Identificador único do recurso
     */
    String getId();
    
    /**
     * Obtém o nome do recurso.
     *
     * @return Nome do recurso
     */
    String getName();
    
    /**
     * Obtém o tipo do recurso.
     *
     * @return Tipo do recurso
     */
    ResourceType getType();
    
    /**
     * Obtém o conteúdo do recurso.
     *
     * @return Conteúdo do recurso
     */
    String getContent();
} 