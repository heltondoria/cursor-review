package com.codereview.mcp.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import com.codereview.mcp.util.PromptGenerator;
import com.codereview.mcp.util.LanguageDetector;
import com.codereview.mcp.model.ReviewOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
/**
 * Serviço de revisão de código que expõe ferramentas MCP.
 */
@Service
public class CodeReviewService {
    
    /**
     * Revisa um arquivo de código.
     * 
     * @param fileName Arquivo a ser revisado
     * @param language Linguagem de programação
     * @return Resultado da revisão
     */
    @Tool(description = "Revisa um trecho de código e fornece sugestões de melhoria")
    public String reviewCode(String fileName, String language) {
        // logger.info("Revisando código em {}", language);
        // Detectar a linguagem automaticamente se não for especificada
        if (language == null || language.isEmpty()) {
            // logger.info("Linguagem não especificada, tentando detectar automaticamente");
            language = LanguageDetector.detectLanguage(fileName);
            // logger.info("Linguagem detectada: {}", language);
        }
        
        ReviewOptions options = new ReviewOptions(
            2, // minSeverity
            Arrays.asList("Qualidade", "Bug", "Performance", "Seguranca", "Legibilidade"),
            null // customPrompt
        );
        return PromptGenerator.generatePrompt(fileName, language, options);
    }    
}