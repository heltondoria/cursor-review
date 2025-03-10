package com.codereview.mcp.config;

/**
 * Enum que define os tipos de transporte suportados pelo servidor MCP.
 */
public enum TransportType {
    /**
     * Transporte via entrada/saída padrão (stdin/stdout).
     */
    STDIO,
    
    /**
     * Transporte via Server-Sent Events (SSE).
     */
    SSE
} 