package com.codereview.mcp.core.resource;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Gerenciador de recursos de código.
 * Responsável por gerenciar o ciclo de vida dos recursos de código.
 */
@Slf4j
public class ResourceManager {
    
    private final Map<String, CodeResource> resources = new HashMap<>();
    
    /**
     * Inicializa o gerenciador de recursos.
     */
    public void initialize() {
        log.info("Inicializando gerenciador de recursos");
    }
    
    /**
     * Registra um recurso no gerenciador.
     *
     * @param resource Recurso a ser registrado
     * @return O recurso registrado
     */
    public CodeResource registerResource(CodeResource resource) {
        log.info("Registrando recurso: {}", resource.getId());
        resources.put(resource.getId(), resource);
        return resource;
    }
    
    /**
     * Obtém um recurso pelo seu identificador.
     *
     * @param id Identificador do recurso
     * @return O recurso, se encontrado
     */
    public Optional<CodeResource> getResource(String id) {
        return Optional.ofNullable(resources.get(id));
    }
    
    /**
     * Remove um recurso do gerenciador.
     *
     * @param id Identificador do recurso a ser removido
     * @return true se o recurso foi removido, false caso contrário
     */
    public boolean removeResource(String id) {
        if (resources.containsKey(id)) {
            log.info("Removendo recurso: {}", id);
            resources.remove(id);
            return true;
        }
        return false;
    }
    
    /**
     * Obtém todos os recursos registrados.
     *
     * @return Mapa de recursos registrados
     */
    public Map<String, CodeResource> getAllResources() {
        return new HashMap<>(resources);
    }
} 