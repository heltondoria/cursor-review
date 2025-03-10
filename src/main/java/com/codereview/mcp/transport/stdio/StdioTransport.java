package com.codereview.mcp.transport.stdio;

import com.codereview.mcp.transport.Transport;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Implementação de transporte que utiliza stdin/stdout para comunicação.
 */
@Slf4j
public class StdioTransport implements Transport {
    
    private final List<MessageHandler> handlers = new ArrayList<>();
    private ExecutorService executorService;
    private PrintWriter writer;
    private boolean running = false;
    
    /**
     * Inicializa o transporte stdio.
     */
    @Override
    public void initialize() {
        log.info("Inicializando transporte stdio");
        writer = new PrintWriter(System.out, true);
        executorService = Executors.newSingleThreadExecutor();
    }
    
    /**
     * Inicia o transporte stdio.
     */
    @Override
    public void start() {
        log.info("Iniciando transporte stdio");
        running = true;
        
        executorService.submit(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                log.info("Aguardando mensagens na entrada padrão");
                
                String line;
                while (running && (line = reader.readLine()) != null) {
                    String message = line;
                    log.debug("Mensagem recebida: {}", message);
                    
                    for (MessageHandler handler : handlers) {
                        try {
                            handler.onMessage(message);
                        } catch (Exception e) {
                            log.error("Erro ao processar mensagem", e);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("Erro no transporte stdio", e);
            } finally {
                log.info("Transporte stdio finalizado");
            }
        });
    }
    
    /**
     * Para o transporte stdio.
     */
    @Override
    public void stop() {
        log.info("Parando transporte stdio");
        running = false;
        executorService.shutdown();
    }
    
    /**
     * Envia uma mensagem pelo transporte stdio.
     *
     * @param message Mensagem a ser enviada
     */
    @Override
    public void send(String message) {
        log.debug("Enviando mensagem: {}", message);
        writer.println(message);
        writer.flush();
    }
    
    /**
     * Registra um handler para receber mensagens.
     *
     * @param handler Handler para receber mensagens
     */
    @Override
    public void registerHandler(MessageHandler handler) {
        log.info("Registrando handler de mensagens");
        handlers.add(handler);
    }
} 