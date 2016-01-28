//Program to check if a binary representation of a given number is palindrome or not.
package checkbinarypalindrome;

import java.util.Scanner;

public class CheckBinaryPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=0;
        System.out.println("enter the number whose binary representation is to be checked");
        int a = sc.nextInt();
        int saved =a;
        StringBuilder sb =new StringBuilder();
        while(a>0)
        {
            
           k  = a%2; 
           sb.append(k);
           a =a/2;
           
        }
        StringBuilder reversea = new StringBuilder();
        for(int i=sb.length()-1;i>=0;--i)
        {
            reversea.append(sb.charAt(i));
            
        }
         System.out.println("The given number is "+saved);
            System.out.println("Binary representation is"+sb);
            System.out.println("Binary reverse representation is"+reversea);
        if(sb.toString().equals(reversea.toString()))
        {
           
            System.out.println("the binary representation is palindrome");
        }
        else
        {
            System.out.println("the binary representation is not palindrome");
        }
    }
    
}
