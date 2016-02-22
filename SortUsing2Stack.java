//Java program to sort a stack using a temporary stack.
package sortusing2stack;

import java.util.Stack;

public class SortUsing2Stack {
    
    static Stack<Integer>  sort(Stack<Integer> s)
    {
        Stack<Integer> stack2 = new Stack<Integer>();
        while(!s.isEmpty())
        {
            int temp = s.pop();
            while(!stack2.isEmpty() && stack2.peek()>temp)
            {
                s.push(stack2.pop());   
            }
            stack2.push(temp);
        }
        return stack2;
    }
    
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<Integer>();
        input.push(2);
        input.push(1);
        input.push(3);
        input.push(4);
        input.push(5);
        input.push(0);
        System.out.println("The input stack is"+input);
      
        Stack<Integer> s1 = sort(input);
        
        System.out.println("The sorted stack is"+s1);
      
    }
    
}
