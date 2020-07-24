package evaluatepostfix;
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
        Functions postfix = new Functions();
        System.out.println("The expression giving is : " + expression);
        System.out.println("The evaluated expression is : " + postfix.evaluatePostfixExpression(expression));
        } catch (Exception e) {
            System.out.println("Could not evaluate expression because of : " + e + "\nMight be because you enterd a wrong expression");
        }
 
    }
    
}
