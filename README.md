# RPNStacker
Repositório referente a atividade [RPNStacker Adhoc] da disciplina de Compiladores 2021.2 do Centro de Infórmatica da Universidade Federal de Pernambuco (CIn - UFPE). 

# Roteiro

## Task 1
- Rever a Aula 07 sobre notação pósfixa [Reverse Polish Notation - RPN];
- Implementar uma linguagem RPNStacker em Java usando uma pilha como estrutura de dados;
- Desenvovler um programa que lê um arquivo com a expressão em RPN e avalia a mesma.

### Exemplo de Entrada
```
4
8
+
3
*
```

**Saída: 36**

## Task 02
- Rever a Aula 11 sobre Introdução à Análise Léxica [_scanning_]
- Evoluir o projeto da Task 01 para implementar uma _feature_ de _scanning_:
   - No geral, nosso programa lê um arquivo com a expressao em RPN e devolve a expressão avaliada;
   - A _feature_ de _scanning_ deve retornar uma lista de _tokens_;
   - A partir dessa lista de _tokens_ que é realizada a interpretacao das expressões com uma pilha;
   - A _feature_ de _scanning_ deve retornar um erro caso não reconheça um "num" [número] ou "op" [operador].

### Exemplo de Entrada [Com Sucesso]:
``` 
10
10
+
```

**Saída: 20**

A Lista de Tokens Reconhecida [Caso a Imprima]:
```
Token [type=NUM, lexeme=10]
Token [type=NUM, lexeme=10]
Token [type=PLUS, lexeme=+]
```

### Exemplo de Entrada [Com Falha]:
``` 
10
s
+
```

**Error: Unexpected character: `s`**
 
