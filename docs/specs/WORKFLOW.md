# Workflow de Desenvolvimento

## Processo de Stories

### 1. Criação e Refinamento

- **Origem**: Stories podem ser criadas a partir de:
  - PRD (Product Requirements Document)
  - Feedback de usuários
  - Issues técnicas
  - Melhorias propostas

- **Formato da Story**:

  ```code
  Como [persona]
  Quero [funcionalidade]
  Para que [benefício]
  ```

- **Critérios de Aceitação**:
  - Devem ser específicos e testáveis
  - Incluir cenários de sucesso e erro
  - Definir comportamentos esperados

### 2. Fluxo de Desenvolvimento

#### 2.1 Preparação

1. Story é movida para "Em Desenvolvimento"
2. Desenvolvedor cria branch: `feature/[número-story]-descricao-curta`
3. Atualiza status no sistema de tracking

#### 2.2 Desenvolvimento

1. Implementação seguindo TDD quando aplicável
2. Commits seguindo padrão:

   ```code
   [tipo]: descrição curta
   
   - Detalhes da alteração
   - Referência à story (#número)
   ```

   Tipos: feat, fix, docs, style, refactor, test, chore

#### 2.3 Revisão

1. Criar Pull Request com template:
   - Descrição da alteração
   - Link para story
   - Checklist de revisão
   - Screenshots (se UI)

2. Code Review:
   - Mínimo 1 aprovação
   - Todos comentários resolvidos
   - Testes passando

### 3. Definição de Pronto (DoD)

- [x] Código implementado
- [x] Testes unitários escritos
- [x] Testes de integração (quando aplicável)
- [x] Documentação atualizada
- [x] Code review aprovado
- [x] QA aprovado
- [x] Critérios de aceitação atendidos

### 4. Métricas de Qualidade

- Cobertura de testes > 80%
- Tempo médio de review < 24h
- Taxa de bugs em produção < 5%

## Integração com MCP

### 1. Revisão Automática

- Toda PR terá revisão automática via MCP
- Severidade mínima configurável
- Resultados integrados aos comentários da PR

### 2. Validações

- Padrões de código
- Segurança
- Performance
- Boas práticas

## Ferramentas

- Git para controle de versão
- GitHub para hospedagem e PRs
- Cursor como IDE principal
- MCP para revisão automática
