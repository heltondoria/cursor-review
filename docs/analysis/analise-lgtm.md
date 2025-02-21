# Análise da extensão LGTM

## Ativação e Interface

- A extensão cria um participante de chat chamado "lgtm" no VS Code
- Aceita 3 comandos: /review, /branch e /commit
- Permite revisar mudanças entre branches, commits ou tags

## Fluxo de Revisão

- Obtém o escopo da revisão (commits/branches alvo e base)
- Coleta as diferenças (diffs) dos arquivos alterados
- Agrupa múltiplos arquivos em um único request quando possível
- Envia os diffs para o modelo de IA com um prompt específico
- Processa a resposta JSON do modelo
- Filtra e ordena os comentários por severidade
- Exibe os resultados no chat com links para as linhas relevantes

## Regras de Processamento

- Ignora arquivos excluídos via glob patterns
- Ignora arquivos deletados
- Filtra comentários por severidade mínima configurável
- Corrige nomes de arquivos incorretos na resposta do modelo
- Valida formato e campos dos comentários
