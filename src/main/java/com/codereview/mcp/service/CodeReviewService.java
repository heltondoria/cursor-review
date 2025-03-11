package com.codereview.mcp.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Serviço de revisão de código que expõe ferramentas MCP.
 */
@Service
public class CodeReviewService {
    
    private static final Logger logger = LoggerFactory.getLogger(CodeReviewService.class);
    
    /**
     * Revisa um trecho de código.
     * 
     * @param code Código a ser revisado
     * @param language Linguagem de programação
     * @return Resultado da revisão
     */
    @Tool(description = "Revisa um trecho de código e fornece sugestões de melhoria")
    public String reviewCode(String code, String language) {
        logger.info("Revisando código em {}", language);
        
        // Aqui você implementaria a lógica real de revisão de código
        // Por exemplo, analisando o código, verificando padrões, etc.
        
        return String.format("""
                # Revisão de Código (%s)
                
                ## Análise
                
                O código fornecido foi analisado e as seguintes observações foram feitas:
                
                - Boa estrutura geral
                - Nomes de variáveis claros e descritivos
                - Comentários adequados
                
                ## Sugestões de Melhoria
                
                1. Considere adicionar mais testes unitários
                2. Verifique o tratamento de erros
                3. Documente as funções públicas
                
                ## Código Revisado
                
                ```%s
                %s
                ```
                """, language, language, code);
    }
    
    /**
     * Verifica se o código segue as melhores práticas.
     * 
     * @param code Código a ser verificado
     * @param language Linguagem de programação
     * @return Resultado da verificação
     */
    @Tool(description = "Verifica se o código segue as melhores práticas e padrões de codificação")
    public String checkBestPractices(String code, String language) {
        logger.info("Verificando melhores práticas para código em {}", language);
        
        // Aqui você implementaria a verificação de melhores práticas
        
        return String.format("""
                # Verificação de Melhores Práticas (%s)
                
                ## Padrões Verificados
                
                - Convenções de nomenclatura
                - Estrutura do código
                - Complexidade ciclomática
                - Tratamento de erros
                
                ## Resultados
                
                O código está em conformidade com a maioria das melhores práticas.
                
                ## Recomendações
                
                1. Reduza a complexidade do método principal
                2. Adicione mais comentários explicativos
                3. Considere refatorar para melhorar a legibilidade
                """, language);
    }
}