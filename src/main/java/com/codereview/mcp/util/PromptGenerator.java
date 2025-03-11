package com.codereview.mcp.util;

import com.codereview.mcp.model.ReviewOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gerador de prompts para revisão de código.
 * Cria prompts estruturados para enviar ao LLM.
 */
public class PromptGenerator {
    // Categorias de revisão disponíveis
    private static final Map<String, String> REVIEW_CATEGORIES = new HashMap<>();
    
    static {
        REVIEW_CATEGORIES.put("Qualidade", """
            Qualidade do código e boas práticas
               - Princípios SOLID
               - Padrões de design
               - Convenções de nomenclatura
               - Estrutura e organização
            """);
        
        REVIEW_CATEGORIES.put("Bug", """
            Bugs e problemas potenciais
               - Condições de corrida
               - Vazamentos de memória
               - Exceções não tratadas
               - Null pointers
            """);
        
        REVIEW_CATEGORIES.put("Performance", """
            Performance
               - Algoritmos ineficientes
               - Uso excessivo de memória
               - Operações de I/O bloqueantes
               - Problemas de concorrência
            """);
        
        REVIEW_CATEGORIES.put("Segurança", """
            Segurança
               - Injeções (SQL, XSS, etc.)
               - Validação de entrada
               - Autenticação e autorização
               - Gerenciamento de sessão
            """);
        
        REVIEW_CATEGORIES.put("Legibilidade", """
            Legibilidade e manutenibilidade
               - Complexidade ciclomática
               - Comentários e documentação
               - Duplicação de código
               - Código morto
            """);
    }
        
    // Mapa de linguagens específicas que podem precisar de considerações especiais
    private static final Map<String, String> LANGUAGE_SPECIFIC_TIPS = new HashMap<>();
    
    static {
        // Dicas específicas para cada linguagem (opcional)
        LANGUAGE_SPECIFIC_TIPS.put("Java", "Verifique também o uso adequado de exceções, coleções e concorrência.");
        LANGUAGE_SPECIFIC_TIPS.put("JavaScript", "Verifique também o uso adequado de promises/async/await e coerção de tipos.");
        LANGUAGE_SPECIFIC_TIPS.put("TypeScript", "Verifique também o uso adequado do sistema de tipos, interfaces vs. tipos.");
        LANGUAGE_SPECIFIC_TIPS.put("Python", "Verifique também o uso adequado de list comprehensions, geradores e tipagem opcional.");
        LANGUAGE_SPECIFIC_TIPS.put("C#", "Verifique também o uso adequado de async/await, LINQ e recursos de linguagem modernos.");
        LANGUAGE_SPECIFIC_TIPS.put("PHP", "Verifique também o uso adequado de namespaces, traits e recursos modernos do PHP.");
        LANGUAGE_SPECIFIC_TIPS.put("Ruby", "Verifique também o uso adequado de blocos, mixins e convenções Ruby.");
        LANGUAGE_SPECIFIC_TIPS.put("Go", "Verifique também o uso adequado de goroutines, canais e tratamento de erros.");
        LANGUAGE_SPECIFIC_TIPS.put("Rust", "Verifique também o uso adequado do sistema de ownership, borrowing e lifetime.");
    }
    
    /**
     * Gera um prompt para revisão de código com base nas opções fornecidas.
     *
     * @param code Código a ser revisado
     * @param language Linguagem de programação
     * @param options Opções de revisão
     * @return Prompt formatado para o LLM
     */
    public static String generatePrompt(String filename, String language, ReviewOptions options) {
      StringBuilder categoriesContent = new StringBuilder();
      
      // Se categorias específicas foram solicitadas
      if (options != null && options.categories() != null && !options.categories().isEmpty()) {
         List<String> requestedCategories = options.categories();
          for (String category : requestedCategories) {
              String trimmedCategory = category.trim();
              if (REVIEW_CATEGORIES.containsKey(trimmedCategory)) {
                  categoriesContent.append(REVIEW_CATEGORIES.get(trimmedCategory)).append("\n");
              }
          }
      } else {
          // Se nenhuma categoria foi especificada, use Qualidade como padrão
          categoriesContent.append(REVIEW_CATEGORIES.get("Qualidade")).append("\n");
      }
      
      if (language != null && !language.isEmpty()) {
        categoriesContent.append(LANGUAGE_SPECIFIC_TIPS.get(language)).append("\n");
      }

      // Usar prompt personalizado se fornecido
      if (options != null && options.customPrompt() != null && !options.customPrompt().isEmpty()) {
          return String.format(options.customPrompt(), filename,language);
      }
      
      // Construir o prompt dinâmico
      return String.format("""
                      
          Analise o código %s em %s e forneça uma revisão detalhada. Identifique problemas relacionados a:
          
          %s

          Para cada problema encontrado, formate sua resposta assim:
          **Linha X**: **Categoria** (Severidade: Y) - Descrição do problema
          
          Onde:
          - X é o número da linha
          - Categoria é uma das seguintes: Qualidade, Bug, Performance, Segurança, Legibilidade, BoasPraticas, CodigoMorto
          - Y é a severidade do problema (1-5, onde 1 é baixa e 5 é crítica)
          - Descrição explica o problema e sugere uma solução
          """, language, filename, categoriesContent.toString());
  }
} 