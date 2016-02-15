//Java program that reads a postfix expression in string and prints the evaluated value of expression 
package cal;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Cal {

    public static int solution(String S) {
        // write your code in Java SE 8
        int result = 0;
        List<String> myList = new ArrayList<String>();
        //Parse the input string
        if(!S.isEmpty())
        {
                 String []smj = S.split("");
                 
                 for(String i : smj){
                     myList.add(i);
                 }
        }
        else
        {
            return -1;
        }
        Stack<String> myStack = new Stack<String>();
        Iterator<String> it = myList.iterator();
        while(it.hasNext())
        {
                String temp = it.next();
         //If the input is a digit just push it
                if(temp.matches("[0-9]*"))
                {
                    myStack.push(temp);
                 }
                 //Else pop the operands and do + or *
                else if(temp.matches("[*+]"))
                {
                    //If operator is *
                    if(temp.equals("*"))
                    {
                        String popped = "";
                        if(!myStack.isEmpty())
                        {
                            popped = myStack.pop();
                        }
                        else
                        {
                            return -1;
                        }
                        int right = Integer.parseInt(popped);
                        if(!myStack.isEmpty())
                        {
                            popped = myStack.pop();
                        }
                        else
                        {
                            return -1;
                        }
                        int left = Integer.parseInt(popped);
                         result = left * right;
                        myStack.push(""+result);
                    }
                     //if the operator is +
                    if(temp.equals("+"))
                    {
                         String popped = "";
                        if(!myStack.isEmpty())
                        {
                             popped = myStack.pop();
                        }
                        else
                        {
                            return -1;
                        }
                        int right = Integer.parseInt(popped);
                        if(!myStack.isEmpty())
                        {
                             popped = myStack.pop();
                        }
                        else
                        {
                            return -1;
                        }
                        int left = Integer.parseInt(popped);
                         result = left + right;
                        myStack.push(""+result);
                    }
            
            }
    }
    //checking the final vlue in stack
    String mypop = "";
    if(!myStack.isEmpty())
    {
        mypop = myStack.pop();
    }
    else
    {
        return -1;
    }
     result = Integer.parseInt(mypop);
    double maxInt = Math.pow(2,12);
    maxInt = maxInt-1;
    int max = (int)maxInt;
    if(result> max)
    {
        return -1;    
    } 
     return result;    
}
  
    public static void main(String[] args) {
       String str = "13+62*7+*";
        System.out.println("Given Input String is "+str);
        int st = solution(str);
        System.out.println("the value is "+st);
        
        
    }
    
}
