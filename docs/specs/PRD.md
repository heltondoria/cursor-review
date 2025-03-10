# Documento de Requisitos do Produto (PRD)

## CodeReview MCP Server

### Visão Geral

O CodeReview MCP Server é um servidor baseado no protocolo Model Context Protocol (MCP) que fornece capacidades de revisão de código automatizada para modelos de linguagem. Implementado em Java com Spring Boot e o SDK Java MCP, o servidor analisa código-fonte para identificar problemas de qualidade, segurança, legibilidade e manutenibilidade, classificando os achados por severidade.

O servidor é projetado para integração com editores de código que suportam o protocolo MCP, como o Cursor, permitindo revisões de código diretamente na interface do editor através da janela de chat.

### Objetivos

1. Criar um servidor MCP em Java que se integre facilmente com clientes MCP como Claude Desktop e Cursor
2. Fornecer revisões de código automatizadas de alta qualidade usando LLMs
3. Suportar múltiplos transportes (stdio e SSE) para flexibilidade de integração
4. Classificar problemas encontrados por severidade para priorização
5. Permitir revisão de arquivos individuais, diferenças entre commits e branches inteiras
6. Integrar-se ao fluxo de trabalho do desenvolvedor através da janela de chat do editor

### Público-alvo

- Desenvolvedores que desejam revisões de código automatizadas
- Equipes de desenvolvimento que buscam melhorar a qualidade do código
- Usuários de Claude Desktop, Cursor ou outros clientes MCP
- Profissionais de segurança que precisam identificar vulnerabilidades no código

### Requisitos Funcionais

#### 1. Recursos MCP

1.1. **Recursos de Código**

- Expor recursos para arquivos de código-fonte
- Suportar navegação de diretórios e arquivos
- Permitir visualização de conteúdo de arquivos

1.2. **Ferramentas de Revisão**

- Implementar ferramenta para revisar um único arquivo (`reviewCurrentFile`)
- Implementar ferramenta para revisar diferenças entre commits (`reviewChanges`)
- Implementar ferramenta para revisar uma branch inteira (`reviewBranch`)
- Implementar ferramenta para revisar código selecionado (`reviewSelection`)

1.3. **Prompts Pré-definidos**

- Fornecer prompts para revisão de segurança
- Fornecer prompts para revisão de qualidade de código
- Fornecer prompts para revisão de performance
- Permitir customização de prompts pelo usuário

#### 2. Funcionalidades de Revisão de Código

2.1. **Análise de Qualidade**

- Detectar code smells (duplicação, métodos longos, etc.)
- Identificar violações de princípios SOLID
- Avaliar complexidade ciclomática
- Verificar convenções de nomenclatura

2.2. **Análise de Segurança**

- Identificar vulnerabilidades comuns (OWASP Top 10)
- Detectar uso inseguro de APIs
- Identificar problemas de validação de entrada
- Detectar vazamentos de informações sensíveis

2.3. **Análise de Legibilidade**

- Avaliar clareza do código
- Verificar qualidade de comentários e documentação
- Identificar estruturas de código confusas

2.4. **Análise de Manutenibilidade**

- Avaliar acoplamento e coesão
- Identificar dívida técnica
- Detectar problemas de design que dificultam manutenção futura

2.5. **Classificação de Severidade**

- Crítica (5): Problemas que podem causar falhas graves ou vulnerabilidades de segurança
- Alta (4): Problemas que afetam significativamente a qualidade ou manutenibilidade
- Média (3): Problemas que devem ser corrigidos, mas não são urgentes
- Baixa (2): Problemas menores ou sugestões de melhoria
- Informativa (1): Observações que não necessariamente requerem ação

#### 3. Integração com Editores

3.1. **Integração com Cursor**

- Suporte a transporte stdio para integração com Cursor
- Exibição de resultados na janela de chat do Cursor
- Links clicáveis para navegar diretamente para as linhas com problemas
- Comandos de chat para acionar revisões (ex: `/review-file`, `/review-branch`)

3.2. **Integração com Claude Desktop**

- Suporte a transporte stdio para integração com Claude Desktop
- Exibição formatada dos resultados da revisão
- Suporte a recursos e ferramentas MCP

#### 4. Suporte a Linguagens

4.1. **Linguagens Prioritárias**

- Java
- JavaScript/TypeScript
- Python
- C#
- Go

4.2. **Suporte Estendido**

- Ruby
- PHP
- Rust
- Kotlin
- Swift

#### 5. Integração com Sistemas de Controle de Versão

5.1. **Suporte a Git**

- Analisar diferenças entre commits
- Analisar branches
- Analisar pull requests
- Suporte a repositórios locais

### Requisitos Não-Funcionais

#### 1. Desempenho

- Tempo de resposta para análise de arquivo único: < 5 segundos
- Tempo de resposta para análise de diferenças: < 30 segundos para até 20 arquivos
- Capacidade de processar repositórios com até 100.000 linhas de código
- Agrupamento eficiente de arquivos para minimizar chamadas ao LLM

#### 2. Segurança

- Todo o código analisado deve permanecer local (sem envio para serviços externos)
- Não armazenar dados sensíveis
- Implementar autenticação para transporte SSE
- Validar e sanitizar todas as entradas do usuário

#### 3. Compatibilidade

- Compatível com MCP versão 2024-11-05 ou superior
- Suporte a transporte stdio para integração com Claude Desktop e Cursor
- Suporte a transporte SSE para integração via HTTP
- Compatível com Java 17 ou superior

#### 4. Escalabilidade

- Suportar múltiplas conexões simultâneas via SSE
- Gerenciar recursos de memória eficientemente para análises de grandes repositórios
- Implementar mecanismos de throttling para evitar sobrecarga do LLM

#### 5. Usabilidade

- Mensagens de erro claras e acionáveis
- Documentação abrangente para todas as ferramentas e recursos
- Exemplos de uso para cada funcionalidade
- Interface de chat intuitiva no editor

### Arquitetura Técnica

#### 1. Componentes Principais

1.1. **Core MCP**

- Implementação dos handlers MCP
- Gerenciamento de recursos
- Gerenciamento de ferramentas
- Gerenciamento de prompts

1.2. **Transportes**

- Implementação de transporte stdio
- Implementação de transporte SSE com Spring WebFlux

1.3. **Analisadores de Código**

- Analisador de qualidade
- Analisador de segurança
- Analisador de legibilidade
- Analisador de manutenibilidade

1.4. **Integrações VCS**

- Integração com Git
- Parser de diff

1.5. **Integração com LLM**

- Gerenciamento de prompts
- Processamento de respostas
- Validação e correção de resultados

#### 2. Tecnologias

- Java 17+
- Spring Boot 3.x
- MCP Java SDK
- Spring WebFlux para SSE
- JGit para integração Git
- JavaParser para análise estática de código Java
- ESLint/TSLint para análise de JavaScript/TypeScript
- Pylint para análise de Python

#### 3. Fluxo de Dados

1. Cliente MCP (Cursor/Claude Desktop) se conecta ao servidor via stdio ou SSE
2. Usuário invoca uma ferramenta de revisão através da interface de chat
3. Servidor obtém o código a ser revisado (arquivo atual, seleção, diff)
4. Servidor prepara o prompt com as regras de revisão e o código
5. Servidor envia o prompt para o LLM
6. Servidor processa a resposta do LLM, validando e corrigindo se necessário
7. Servidor formata os resultados e envia de volta ao cliente
8. Cliente exibe os resultados na interface de chat com links para as linhas relevantes

### Regras de Revisão de Código

#### 1. Regras de Processamento

- Arquivos deletados são ignorados
- Arquivos binários são ignorados
- Arquivos que correspondem a padrões configuráveis são ignorados (ex: *.min.js, package-lock.json)
- Comentários são ordenados por severidade (maior para menor)
- Apenas comentar sobre linhas adicionadas ou modificadas em diffs
- Todos os comentários devem ser acionáveis

#### 2. Formato de Saída

```json
{
  "file": "caminho/do/arquivo",
  "line": 123,
  "comment": "Descrição do problema",
  "severity": 4,
  "category": "security"
}
```

#### 3. Categorias de Problemas

- **security**: Problemas de segurança
- **quality**: Problemas de qualidade de código
- **performance**: Problemas de desempenho
- **maintainability**: Problemas de manutenibilidade
- **readability**: Problemas de legibilidade
- **best-practice**: Violações de boas práticas

#### 4. Formato do Diff

- Cabeçalho do diff seguido por linhas de diff
- Formato: `<NÚMERO_LINHA><TAB><TIPO_DIFF><LINHA>`
- Tipos de diff:
  - `+`: linhas adicionadas
  - `-`: linhas removidas (NÚMERO_LINHA será 0)
  - ``: linhas não alteradas (contexto)

### Integração com Cursor

#### 1. Comandos de Chat

O servidor MCP será acessível através dos seguintes comandos na janela de chat do Cursor:

- `/review-file [--focus=<categoria>]`: Revisa o arquivo atual
- `/review-selection [--focus=<categoria>]`: Revisa o código selecionado
- `/review-changes <baseRef> <targetRef> [--focus=<categoria>]`: Revisa diferenças entre commits/branches
- `/review-branch <branch> [--focus=<categoria>]`: Revisa uma branch inteira

#### 2. Exibição de Resultados

Os resultados da revisão serão exibidos na janela de chat do Cursor com:

- Links clicáveis para navegar para as linhas com problemas
- Formatação colorida baseada na severidade
- Agrupamento por arquivo e categoria
- Contagem total de problemas por severidade

#### 3. Fluxo de Trabalho

1. Usuário abre o Cursor e conecta ao servidor MCP
2. Usuário trabalha no código normalmente
3. Quando desejar uma revisão, o usuário digita um comando na janela de chat
4. O servidor MCP processa o comando e realiza a revisão
5. Os resultados são exibidos na janela de chat
6. Usuário pode clicar nos links para navegar para os problemas e corrigi-los

### Configurações

O servidor deve suportar as seguintes configurações:

1. **Severidade mínima**: Filtrar comentários abaixo de determinada severidade (padrão: 2)
2. **Padrões de exclusão**: Glob patterns para excluir arquivos da análise
3. **Categorias habilitadas**: Selecionar quais categorias de problemas analisar
4. **Linguagens habilitadas**: Selecionar quais linguagens analisar
5. **Prompt personalizado**: Texto adicional para o prompt de revisão
6. **Modelo LLM**: Modelo a ser usado para revisão (padrão: gpt-4o)
7. **Agrupar arquivos**: Combinar múltiplos arquivos por request (padrão: true)
8. **Modo debug**: Habilitar saída de debug (padrão: false)

### Implementação das Ferramentas MCP

#### 1. reviewCurrentFile

```java
@McpTool(name = "reviewCurrentFile", description = "Revisa o arquivo atualmente aberto no editor")
public ReviewResult reviewCurrentFile(ReviewOptions options) {
    // 1. Obter o conteúdo do arquivo atual
    // 2. Preparar o prompt com as regras de revisão
    // 3. Enviar para o LLM
    // 4. Processar e validar a resposta
    // 5. Retornar os resultados formatados
}
```

#### 2. reviewChanges

```java
@McpTool(name = "reviewChanges", description = "Revisa as mudanças entre commits ou branches")
public ReviewResult reviewChanges(String baseRef, String targetRef, ReviewOptions options) {
    // 1. Obter as diferenças entre baseRef e targetRef
    // 2. Agrupar arquivos se necessário
    // 3. Preparar o prompt com as regras de revisão
    // 4. Enviar para o LLM
    // 5. Processar e validar a resposta
    // 6. Retornar os resultados formatados
}
```

#### 3. reviewSelection

```java
@McpTool(name = "reviewSelection", description = "Revisa o código selecionado no editor")
public ReviewResult reviewSelection(ReviewOptions options) {
    // 1. Obter o código selecionado
    // 2. Preparar o prompt com as regras de revisão
    // 3. Enviar para o LLM
    // 4. Processar e validar a resposta
    // 5. Retornar os resultados formatados
}
```

### Prompts Pré-definidos

```java
@McpPrompt(name = "securityReview", description = "Revisão focada em segurança")
public String securityReviewPrompt() {
    return "Revise o código focando em vulnerabilidades de segurança como injeção SQL, XSS, CSRF...";
}

@McpPrompt(name = "performanceReview", description = "Revisão focada em performance")
public String performanceReviewPrompt() {
    return "Revise o código focando em problemas de performance como loops ineficientes...";
}

@McpPrompt(name = "qualityReview", description = "Revisão focada em qualidade de código")
public String qualityReviewPrompt() {
    return "Revise o código focando em problemas de qualidade como duplicação, complexidade...";
}
```

### Cronograma de Desenvolvimento

1. **Fase 1 (MVP - 4 semanas)**
   - Implementação básica do servidor MCP
   - Suporte a transporte stdio
   - Integração com Cursor
   - Revisão de arquivos individuais
   - Suporte a Java e JavaScript

2. **Fase 2 (8 semanas)**
   - Adição de transporte SSE
   - Revisão de diferenças entre commits
   - Expansão para Python, C# e Go
   - Implementação completa de todas as categorias de análise
   - Integração com Git

3. **Fase 3 (12 semanas)**
   - Suporte a linguagens adicionais
   - Melhorias de desempenho
   - Integração com ferramentas de análise estática
   - Documentação completa e exemplos
   - Testes abrangentes

### Métricas de Sucesso

1. **Qualidade das Revisões**
   - Taxa de falsos positivos < 10%
   - Taxa de detecção de problemas reais > 80%
   - Feedback positivo dos usuários > 4/5

2. **Desempenho**
   - Tempo médio de resposta dentro dos limites especificados
   - Uso de memória < 512MB para repositórios médios

3. **Adoção**
   - Número de usuários ativos
   - Número de revisões realizadas
   - Número de problemas corrigidos com base nas revisões

### Vantagens sobre Soluções Existentes

1. **Integração Nativa com Editores**: Integração direta com o fluxo de trabalho do desenvolvedor através do protocolo MCP
2. **Flexibilidade de LLMs**: Capacidade de usar diferentes modelos de linguagem
3. **Privacidade**: Todo o código permanece local, sem envio para serviços externos
4. **Personalização**: Prompts e regras de revisão personalizáveis
5. **Abrangência**: Análise de qualidade, segurança, legibilidade e manutenibilidade em um único lugar

### Conclusão

O CodeReview MCP Server fornecerá uma solução robusta e flexível para revisão de código automatizada, aproveitando o protocolo MCP para integração com modelos de linguagem e editores de código. Ao focar na qualidade, segurança, legibilidade e manutenibilidade do código, o servidor ajudará desenvolvedores e equipes a melhorar continuamente seus projetos, identificando problemas antes que eles cheguem à produção.

A integração com o Cursor através do protocolo MCP permitirá uma experiência de usuário fluida, onde os desenvolvedores podem solicitar revisões de código diretamente na janela de chat e receber feedback imediato com links para as linhas problemáticas. Esta abordagem integrada ao fluxo de trabalho do desenvolvedor aumentará significativamente a adoção e o impacto da ferramenta.
