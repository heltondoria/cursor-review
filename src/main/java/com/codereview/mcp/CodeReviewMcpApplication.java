package com.codereview.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import com.codereview.mcp.service.CodeReviewService;

/**
 * Classe principal da aplicação de revisão de código.
 * Configura e inicia o servidor MCP para revisão de código.
 */
@SpringBootApplication
public class CodeReviewMcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeReviewMcpApplication.class, args);
    }

    /**
     * Registra as ferramentas de revisão de código como callbacks MCP.
     *
     * @param codeReviewService Serviço de revisão de código
     * @return Provider de callbacks para ferramentas
     */
    @Bean
    public ToolCallbackProvider codeReviewTools(CodeReviewService codeReviewService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(codeReviewService)
                .build();
    }
} 