# Regras de Revisão de Código

Este documento centraliza todas as regras usadas pela extensão LGTM para realizar revisões de código automatizadas.

## Regras de Processamento

### Seleção de Arquivos

- Arquivos deletados são ignorados
- Arquivos que correspondem aos padrões glob em `lgtm.exclude` são ignorados
- Por padrão, ignora:
  - package-lock.json
  - yarn.lock
  - pnpm-lock.yaml
  - *.min.js

### Agrupamento de Arquivos

- Por padrão, múltiplos arquivos são agrupados em um único request
- O agrupamento pode ser desativado via `lgtm.mergeFileReviewRequests`
- Arquivos são agrupados até atingir o limite de tokens do modelo

### Validação de Comentários

- Comentários devem ter:
  - `file`: caminho do arquivo (string não vazia)
  - `comment`: texto do comentário (string)
  - `line`: número da linha (número >= 0)
  - `severity`: severidade (número entre 1-5)
- Comentários com severidade menor que `lgtm.minSeverity` são filtrados
- Comentários são ordenados por severidade (maior para menor)
- Nomes de arquivos incorretos são corrigidos usando distância Levenshtein

## Regras para o Modelo de IA

### Formato do Diff

- Cabeçalho do diff seguido por linhas de diff
- Formato: `<NÚMERO_LINHA><TAB><TIPO_DIFF><LINHA>`
- Tipos de diff:
  - `+`: linhas adicionadas
  - `-`: linhas removidas (NÚMERO_LINHA será 0)
  - ``: linhas não alteradas (contexto)

### Regras de Revisão

- Comentar sobre:
  - Bugs
  - Vulnerabilidades de segurança
  - Code smells
  - Erros de digitação
- Apenas comentar linhas adicionadas
- Todos os comentários devem ser acionáveis
- Não comentar sobre formatação
- Não fazer suposições sobre código não incluído no diff

### Regras de Saída

- Responder apenas com JSON
- Formato do comentário:

  ```json
  {
    "file": "caminho/do/arquivo",
    "line": 123,
    "comment": "Descrição do problema",
    "severity": 4
  }
  ```

- Severidade:
  1. Provavelmente irrelevante
  2. Baixa
  3. Média
  4. Alta
  5. Crítica

## Configurações Disponíveis

| Configuração | Padrão | Descrição |
|--------------|---------|------------|
| `lgtm.minSeverity` | 2 | Severidade mínima dos comentários (1-5) |
| `lgtm.customPrompt` | "" | Texto adicional para o prompt de revisão |
| `lgtm.exclude` | [...] | Padrões glob para excluir arquivos |
| `lgtm.enableDebugOutput` | false | Habilita saída de debug |
| `lgtm.chatModel` | "gpt-4o" | Modelo de IA a ser usado |
| `lgtm.mergeFileReviewRequests` | true | Combina múltiplos arquivos por request |
