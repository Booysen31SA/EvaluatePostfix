package evaluatepostfix;
/*
Authors:
Surname, initals : Student number
Ammo, M     : 216022002
Booysen, M  : 216062241
Kruger, W   : 216009529
*/
import static java.lang.Math.pow;
import java.util.Stack;

public class Functions {
    
    // Evaluate value of a postfix expression 
    static int evaluatePostfixExpression(String expression) 
    { 
        // Creating the stack to hold values
        Stack <Integer> stack= new Stack<>(); 
          
        // Scan the expression for characters
        for(int i = 0; i < expression.length(); i++) 
        { 
            //puts the character thats being looked at in the char variable
            char character = expression.charAt(i); 
              
            // If the character is an operand eg: number: 0 - 9, 
            // push it to the stack. 
            if(isOperand(character)) 
               stack.push(character - '0'); 
              
            //  If the scanned character is an operator eg: +, -, *, / pop two to do calculation
            // elements from stack apply the operator 
            else
            { 
                int numberOne = stack.pop(); // pop value one 
                int numberTwo = stack.pop(); // pop value two
                  
                //Does calculation based on operator, and then push the calulated value to stack
                switch(character) 
                { 
                    case '+': 
                    stack.push(numberTwo+numberOne); 
                    break; 
                      
                    case '-': 
                    stack.push(numberTwo- numberOne); 
                    break; 
                      
                    case '/': 
                    stack.push(numberTwo/numberOne); 
                    break; 
                      
                    case '*': 
                    stack.push(numberTwo*numberOne); 
                    break; 
                    
                    case '^':
                        int powerOf = (int) Math.pow(numberTwo, numberOne);
                        stack.push(powerOf);
              } 
            } 
        } 
        return stack.pop();   //returns the calulated value   
    } 
    
     private static boolean isOperand(char character){
         //if chatacter is between 0 - 9 it returns true because its a number, false if its a operator
        if(character >= '0' && character <= '9') return true;
        return false;
    }
}
