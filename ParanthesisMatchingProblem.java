//Program to check if given parenthesis string is properly matched.
package paranthesismatchingproblem;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
   
public class ParanthesisMatchingProblem {
    static public boolean isValid(String input)
    {
        Stack<Character> parenStack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        if(input.length()<=1)
            return false;
        
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i =0;i<input.length();i++)
        {
            char temp = input.charAt(i);
            if(temp== '('||temp== '{'||temp== '[')
            {
                parenStack.push(temp);
                continue;
            }
            else if(temp== ')'||temp== '}'||temp== ']')
            {
                if(parenStack.size()==0)return false;
                if(temp!=map.get(parenStack.pop()))return false;
            }
            else
            {
                System.out.println("Invalid input: Input should only contain parenthesis!!!");
                return false;

            }
            
         }
        if(parenStack.size()!=0)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(isValid(input))
        System.out.println("The given parenthesis string is matched correctly");
        else
        System.out.println("The given parenthesis string is not matched correctly");
            
    }
    
}
