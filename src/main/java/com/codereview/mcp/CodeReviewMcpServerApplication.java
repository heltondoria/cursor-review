package com.codereview.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicação principal do servidor MCP para revisão de código.
 * Utiliza o Spring AI MCP Server Boot Starter para WebFlux.
 */
@SpringBootApplication
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