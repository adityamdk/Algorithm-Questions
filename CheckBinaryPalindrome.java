//Program to check if a binary representation of a given number is palindrome or not.
package integercheckforbinaryrepresentationbeingstring;
import java.util.Scanner;
public class IntegerCheckforBinaryRepresentationBeingString {

    static boolean isPalindrome(String s)
    {
        int n = s.length();
        for(int i=0;i<(n/2);i++)
        {
            if(s.charAt(i)!=s.charAt(n-i-1))
            {
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string whose binary representation is to be checked for palindrome");
        int number = input.nextInt();
        //converting int to binary representation
        String binaryRep = Integer.toBinaryString(number);
        System.out.println("Binary representation of number is "+binaryRep);
        boolean status = isPalindrome(binaryRep);
        
        if(status == true)
            System.out.println("Number in binary representation is palindrome");
        else
            System.out.print("Number in binary representation is not a palindrome");
    }
    
}
