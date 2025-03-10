package com.codereview.mcp.transport;

/**
 * Interface que representa um transporte para comunicação MCP.
 */
public interface Transport {
    
    /**
     * Inicializa o transporte.
     */
    void initialize();
    
    /**
     * Inicia o transporte.
     */
    void start();
    
    /**
     * Para o transporte.
     */
    void stop();
    
    /**
     * Envia uma mensagem pelo transporte.
     *
     * @param message Mensagem a ser enviada
     */
    void send(String message);
    
    /**
     * Registra um handler para receber mensagens.
     *
     * @param handler Handler para receber mensagens
     */
    void registerHandler(MessageHandler handler);
    
    /**
     * Interface para handlers de mensagens.
     */
    interface MessageHandler {
        /**
         * Método chamado quando uma mensagem é recebida.
         *
         * @param message Mensagem recebida
         */
        void onMessage(String message);
    }
} 