package com.codereview.mcp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilitário para detectar a linguagem de programação com base na extensão do arquivo.
 */
public class LanguageDetector {
    
    private static final Map<String, String> EXTENSION_TO_LANGUAGE = new HashMap<>();
    
    static {
        // Linguagens comuns
        EXTENSION_TO_LANGUAGE.put("java", "Java");
        EXTENSION_TO_LANGUAGE.put("js", "JavaScript");
        EXTENSION_TO_LANGUAGE.put("ts", "TypeScript");
        EXTENSION_TO_LANGUAGE.put("jsx", "JavaScript (React)");
        EXTENSION_TO_LANGUAGE.put("tsx", "TypeScript (React)");
        EXTENSION_TO_LANGUAGE.put("py", "Python");
        EXTENSION_TO_LANGUAGE.put("rb", "Ruby");
        EXTENSION_TO_LANGUAGE.put("php", "PHP");
        EXTENSION_TO_LANGUAGE.put("c", "C");
        EXTENSION_TO_LANGUAGE.put("cpp", "C++");
        EXTENSION_TO_LANGUAGE.put("cs", "C#");
        EXTENSION_TO_LANGUAGE.put("go", "Go");
        EXTENSION_TO_LANGUAGE.put("rs", "Rust");
        EXTENSION_TO_LANGUAGE.put("swift", "Swift");
        EXTENSION_TO_LANGUAGE.put("kt", "Kotlin");
        EXTENSION_TO_LANGUAGE.put("scala", "Scala");
        EXTENSION_TO_LANGUAGE.put("html", "HTML");
        EXTENSION_TO_LANGUAGE.put("css", "CSS");
        EXTENSION_TO_LANGUAGE.put("scss", "SCSS");
        EXTENSION_TO_LANGUAGE.put("sql", "SQL");
        EXTENSION_TO_LANGUAGE.put("sh", "Shell");
        EXTENSION_TO_LANGUAGE.put("md", "Markdown");
        EXTENSION_TO_LANGUAGE.put("json", "JSON");
        EXTENSION_TO_LANGUAGE.put("xml", "XML");
        EXTENSION_TO_LANGUAGE.put("yaml", "YAML");
        EXTENSION_TO_LANGUAGE.put("yml", "YAML");
    }
    
    /**
     * Detecta a linguagem de programação com base no nome do arquivo.
     *
     * @param fileName Nome do arquivo
     * @return Linguagem detectada ou "Unknown" se não for possível detectar
     */
    public static String detectLanguage(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "Unknown";
        }
        
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "Unknown";
        }
        
        String extension = fileName.substring(lastDotIndex + 1).toLowerCase();
        return EXTENSION_TO_LANGUAGE.getOrDefault(extension, "Unknown");
    }
} 