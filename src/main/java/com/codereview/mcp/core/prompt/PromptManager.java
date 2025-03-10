package com.codereview.mcp.core.prompt;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Gerenciador de prompts de revisão.
 * Responsável por gerenciar o ciclo de vida dos prompts de revisão.
 */
@Slf4j
public class PromptManager {
    
    private final Map<String, ReviewPrompt> prompts = new HashMap<>();
    
    /**
     * Inicializa o gerenciador de prompts.
     */
    public void initialize() {
        log.info("Inicializando gerenciador de prompts");
    }
    
    /**
     * Registra um prompt no gerenciador.
     *
     * @param prompt Prompt a ser registrado
     * @return O prompt registrado
     */
    public ReviewPrompt registerPrompt(ReviewPrompt prompt) {
        log.info("Registrando prompt: {}", prompt.getId());
        prompts.put(prompt.getId(), prompt);
        return prompt;
    }
    
    /**
     * Obtém um prompt pelo seu identificador.
     *
     * @param id Identificador do prompt
     * @return O prompt, se encontrado
     */
    public Optional<ReviewPrompt> getPrompt(String id) {
        return Optional.ofNullable(prompts.get(id));
    }
    
    /**
     * Remove um prompt do gerenciador.
     *
     * @param id Identificador do prompt a ser removido
     * @return true se o prompt foi removido, false caso contrário
     */
    public boolean removePrompt(String id) {
        if (prompts.containsKey(id)) {
            log.info("Removendo prompt: {}", id);
            prompts.remove(id);
            return true;
        }
        return false;
    }
    
    /**
     * Obtém todos os prompts registrados.
     *
     * @return Mapa de prompts registrados
     */
    public Map<String, ReviewPrompt> getAllPrompts() {
        return new HashMap<>(prompts);
    }
} 