package com.codereview.mcp.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Utilitário para configuração e gerenciamento de logs.
 */
@Slf4j
public class LoggingUtil {
    
    private LoggingUtil() {
        // Classe utilitária não deve ser instanciada
    }
    
    /**
     * Configura o sistema de logging.
     */
    public static void configureLogging() {
        log.info("Configurando sistema de logging");
        
        // Aqui poderia ser implementada uma configuração mais avançada de logging
        // como ajuste de níveis, formatação, etc.
        
        log.info("Sistema de logging configurado com sucesso");
    }
} 