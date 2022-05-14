# RPNStacker
Repositório referente a atividade [RPNStacker Adhoc] da disciplina de Compiladores 2021.2 do Centro de Infórmatica da Universidade Federal de Pernambuco (CIn - UFPE). 
Cada etapa da atividade foi feita separadamente e os resultados para cada uma delas podem ser vistos de acordo as _tags_ criadas neste repositório. Assim, o acompanhamento das entregas pode ser analisado de acordo com:
- [Task 01](https://github.com/matheusvtna/RPNStacker/tree/Task-01): Primeira entrega da atividade contendo apenas um código simples em Java contendo a implementação da RPNStacker usando uma pilha como estrutura de dados;
- [Task 02](https://github.com/matheusvtna/RPNStacker/tree/Task-02): Segunda entrega da atividade contendo a inserção do código em um Java _project_ e realizada a implementação da _feature_ de _scanning_;
- [Task 03](https://github.com/matheusvtna/RPNStacker/tree/Task-03): Terceira entrega da atividade contendo o projeto Postfix (disponibilizado pelo professor com a base para a atividade) foi atualizado para dar suporte ao uso de variáveis/ids. Nessa versão, os projetos das Tasks 01 e 02 foram deletados e foi mantido apenas o projeto Postfix.

# Roteiro

## Task 01
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

## Task 03
A Gramática da RPN para as Tasks 02 e 03 era a seguinte:
```
Expr = num
         |  Expr Expr op

Onde:
- op    = [+-/*]
- num   = [0-9]+
```

Agora, para a Task 03, a linguagem dará suporte para variáveis (IDs), por conseguinte, temos a seguinte mudança gramatical:
```
Expr = num
         |  id
         | Expr Expr op

Onde:
- op    = [+-/*]
- num   = [0-9]+
- id    = [_a-zA-Z][_a-zA-Z0-9]*
```

Assim, baseado na gramática acima [incluindo ID expr], o projeto Postfix (disponibilizado pelo professor com a base para a atividade) foi atualizado para dar suporte ao uso de variáveis/ids.

### Exemplos de Entrada [Com Sucesso]:
```
10
10
+
```
**Saída: 20**
<br/>
```
10
y
+
```
_Considerando que o ID `y` foi dado como _input_ e seu valor seja 10 (y = 10)._<br/>
**Saída: 20**

### Exemplos de Entrada [Com Falha]:
```
10
w
+
```
_Considerando que o ID `w` não foi dado como _input_ e, portanto, não estava no mapeamento._<br/>
**Saída: [Interpreter] Error: 'w' cannot be resolved!**
