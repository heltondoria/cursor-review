// package com.codereview.mcp.config;

// import com.codereview.mcp.service.CodeReviewService;
// import org.springframework.ai.tool.method.MethodToolCallbackProvider;
// import org.springframework.ai.tool.ToolCallbackProvider;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// /**
//  * Configuração das ferramentas MCP para revisão de código.
//  */
// @Configuration
// public class McpToolsConfig {

//     /**
//      * Registra as ferramentas de revisão de código como callbacks MCP.
//      *
//      * @param codeReviewService Serviço de revisão de código
//      * @return Provider de callbacks para ferramentas
//      */
//     @Bean
//     public ToolCallbackProvider codeReviewTools(CodeReviewService codeReviewService) {
//         return MethodToolCallbackProvider.builder()
//                 .toolObjects(codeReviewService)
//                 .build();
//     }
// }