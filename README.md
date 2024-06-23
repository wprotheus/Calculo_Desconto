# Sistema de Vendas com Descontos

## 1. Qual padrão de projeto pode ser utilizado no desenvolvimento de uma solução?
Devido ao requisito de permitir que o algoritimo seja mudado conforme escolha
do usuário, foi utilizado o **Strategy Pattern**. Esse padrão permite trocas de forma flexível e escalável.

## 2. Como poderíamos implementar estes tipos de desconto sem utilizar Padrões de Projetos?
Sem utilizar o padrão de projeto adequado, poderíamos implementar os vários tipos de descontos
utilizando as condicionais `if-else` ou `switch-case`.

## 3. Quais os problemas que tal implementação traria?
1. **Violação do princípio SOLID -> SRP**;
2. **Violação do princípio SOLID -> OCP**;
3. **Alto acoplamento**; e
4. **Manutenção mais complexa/trabalhosa**.