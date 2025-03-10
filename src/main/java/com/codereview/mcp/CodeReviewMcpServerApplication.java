package com.codereview.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Classe principal da aplicação do servidor MCP para revisão de código.
 * Inicializa o contexto Spring e configura o servidor MCP.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.codereview.mcp")
public class CodeReviewMcpServerApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(CodeReviewMcpServerApplication.class, args);
    }
} 