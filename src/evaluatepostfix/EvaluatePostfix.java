package evaluatepostfix;

import java.util.Stack;

/*
Authors:
Surname, initals : Student number
Ammo, M     : 216022002
Booysen, M  : 216062241
Kruger, W   : 216009529
*/
public class EvaluatePostfix {

    public static void main(String[] args) {
        // TODO code application logic here
        String expression = "2 2 * 2 / 3 4 + 3 2 ^ * + 6 - 1 +"; 
        
         EvaluatePostfix post = new EvaluatePostfix();
         post.evaulate(expression);
    }
    
    //add function to call the function from another class but also for try - catch
    private void evaulate(String expression){
        try {
        System.out.println("The expression giving is : " + expression);
        System.out.println("The evaluated expression is : " + evaluatePostfixExpression(expression));
        } catch (Exception e) {
            System.out.println("Could not evaluate expression because of : " + e + "\nMight be because you enterd a wrong expression");
        }
 
    }
    
    // Evaluate (calculate) value of a postfix expression 
    private static int evaluatePostfixExpression(String expression) 
    { 
        // Creating the stack to hold values
        Stack <Integer> stack= new Stack<>(); 
          
        // Scan the expression for characters
        for(int i = 0; i < expression.length(); i++) 
        { 
            //checks if character is a space or other characters to ignore
            if(expression.charAt(i) == ' ' || expression.charAt(i) == '&' || expression.charAt(i) == '(' || expression.charAt(i) == ')') continue;
            
            if(expression.charAt(i) == '!' || expression.charAt(i) == '#' || expression.charAt(i) == '$' || expression.charAt(i) == '%') continue;
            
            //puts the character thats being looked at in the char variable to be converted to integer
            char character = expression.charAt(i); 
              
            // If the character is an operand eg: number: 0 - 9, 
            // push it to the stack. 
            if(isOperand(character)) 
               stack.push(charToInt(character)); 
              
            //  If the scanned character is an operator eg: +, -, *, /, ^ pop two to do calculation
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
     
     //converts character to integer and returns the int value
     private static int charToInt(Character character){
         return Integer.parseInt(String.valueOf(character));
     }
    
}
