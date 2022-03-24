package RPNStacker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class RPNStacker {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        File file = new File("Calc1.stk");

        try {        
            Scanner input = new Scanner(file);
            Stack<Integer> stack = new Stack<>();

            // While the input is not empty
            while(input.hasNext()) {
                // If the next character in the input is a digit, `push` on the stack          
                if(input.hasNextInt()) {
                    int number = input.nextInt(); 
                    stack.push(number);
                } else {
                    char operator = input.next().charAt(0);                
                    int firstOperand;
                    int secondOperand;
                    int result;
                        
                    // Get second operand, if the stack is not empty
                    if(!stack.isEmpty()) {
                        secondOperand = stack.pop();
                    } else {
                        throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the second operand!");
                    }

                    // Get first operand, if the stack is not empty
                    if(!stack.isEmpty()) {
                        firstOperand = stack.pop();
                    } else {
                        throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the first operand!");
                    }

                    // Check the operator (+, -, *, /)
                    switch (operator) {
                        case '+':
                            result = firstOperand + secondOperand;
                            break;
                        case '-':
                            result = firstOperand - secondOperand;
                            break;
                        case '*':
                            result = firstOperand * secondOperand;
                            break;
                        case '/':
                            result = firstOperand / secondOperand;
                            break;
                        default:
                            throw new Exception("Error: Unexpected Symbol " + operator);
                    }

                    // `Push` the result of last operation on stack
                    stack.push(result);
                }            
            }
            
            input.close();

            // Show the result, if the stack is not empty
            if(!stack.isEmpty()) {
                System.out.println("The answer is: " + stack.pop());
            } else {
                throw new Exception("Error: Unexpected EMPTY STACK when trying to pop the operation result!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Calc1.stk not found!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}