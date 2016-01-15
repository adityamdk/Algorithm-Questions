/*Program to perform basic stack operations on char array and String reversal Using Stack
 */
package stringreversal;


public class StringReversal {

   
    public static void main(String[] args) {
        
        Stack s = new Stack(6);
        s.push('a');
        s.push('b');
        s.push('c');
        s.pop();
        s.display();
        
        System.out.println("Now reversing String");
		String in = "NewYork";
        String out = ReverseString(in);
        System.out.println("Reversed string : "+out+" and Input String : "+in);
        
    }
    
    
    
 public static  String ReverseString(String input)
    {
      String output="";
        Stack s =new Stack(input.length());
        int i =0;
        for(int k=0;k<input.length();i++)
        {
         
            char st = input.charAt(k);
            s.push(st);
            k++;
        }
        
        while(!s.isEmpty())
        {
            char p = s.pop();
            output = output+p;
        }
        return output;
    }
    
}
class Stack
{
     private int size;
    private char array[];
    private int top;
   
    Stack(int input)
    {
        size = input;
        array = new char[size];
        top = -1;
    }
    
    public boolean isEmpty()
    {
        return (-1 == top);
    }      
           
    public boolean isFull()
    {
        return (size == top-1);
    }        
    
    public char pop()
    {
        if(isEmpty())
        {
            return '\0';
        }
        char c = array[top--];
     
        return c;
    }   
    
    public boolean push(char c)
    {
          if(isFull())
        {
            return false;
        }
        top++;
        array[top] = c;
       
        return true;
    }
    public void display()
    {   System.out.println("contents of Stack are");
        for(int i=0;i<=top;i++)
        {
            System.out.println(array[i]+" ");
        }
    }
    
}