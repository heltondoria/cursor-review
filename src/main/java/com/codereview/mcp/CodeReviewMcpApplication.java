package com.codereview.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação de revisão de código.
 * Configura e inicia o servidor MCP para revisão de código.
 */
@SpringBootApplication
public class CodeReviewMcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeReviewMcpApplication.class, args);
    }
} 