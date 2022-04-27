import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RPNStacker {
    public static void main(String[] args) {
        String fileName = "Calc1.stk";

        try {
            List<Token> tokens = tokenize(fileName);
            printTokens(tokens);
            
            Integer result = getResult(tokens);
            System.out.println("The answer is: " + result);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public static List<Token> tokenize(String fileName) throws FileNotFoundException {
        File file = new File("src/" + fileName);
        return tokenize(file);
    }

    public static List<Token> tokenize(File file) throws FileNotFoundException {
        List<Token> tokens = new ArrayList<>();
        
        Scanner input = new Scanner(file);

        // While the input is not empty
        while (input.hasNext()) {        
            String lexeme = input.nextLine().trim();
            Token token;

            // Check the Token Type
            if (lexeme.matches("[0-9]+")) {
                token = new Token(TokenType.NUM, lexeme);
            } else if (lexeme.equals("+")) {
                token = new Token(TokenType.PLUS, lexeme);
            } else if (lexeme.equals("-")) {
                token = new Token(TokenType.MINUS, lexeme);
            } else if (lexeme.equals("*")) {
                token = new Token(TokenType.STAR, lexeme);
            } else if (lexeme.equals("/")) {
                token = new Token(TokenType.SLASH, lexeme);
            } else {
                input.close();
                throw new RuntimeException("Error: Unexpected character `" + lexeme + "`");
            }

            tokens.add(token);
        }

        input.close();

        return tokens;
    }

    public static void printTokens(List<Token> tokens) {
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    public static Integer getResult(List<Token> tokens) throws Exception {
        Stack<Integer> stack = new Stack<>();

        // Loop through the tokens and calculate the operation result
        for (Token token : tokens) {
            // Check the TokenType
            if (token.type == TokenType.NUM) {
                Integer number = Integer.parseInt(token.lexeme);
                stack.push(number);
            } else {
                Integer firstOperand;
                Integer secondOperand;
                Integer result = 0;

                // Get second operand, if the stack is not empty
                if (!stack.isEmpty()) {
                    secondOperand = stack.pop();
                } else {
                    throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the second operand!");
                }

                // Get first operand, if the stack is not empty
                if (!stack.isEmpty()) {
                    firstOperand = stack.pop();
                } else {
                    throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the first operand!");
                }

                // Check the operator (+, -, *, /)
                switch (token.type) {
                    case PLUS:
                        result = firstOperand + secondOperand;
                        break;
                    case MINUS:
                        result = firstOperand - secondOperand;
                        break;
                    case STAR:
                        result = firstOperand * secondOperand;
                        break;
                    case SLASH:
                        result = firstOperand / secondOperand;
                        break;
                    default:
                        break;
                }

                // `Push` the result of last operation on stack
                stack.push(result);
            } 
        }

        // Show the result, if the stack is not empty
        if (!stack.isEmpty()) {
            Integer finalResult = stack.pop();
            return finalResult;
        } else {
            throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the final result!");
        }
    }
}