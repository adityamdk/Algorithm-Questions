//Program to print all permutations of a string
package allsubpalindromes;

import java.util.HashSet;
import java.util.Scanner;

public class AllSubPalindromes {

    static int palindrome(String str) {
        
        HashSet mySet = new HashSet<>();
        int length = str.length();
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                
                if(isPalindrome(str.substring(i,j)))
                    {
                        mySet.add(str.substring(i,j));
                }
            }
        }
        int size = mySet.size();
        System.out.println("All permutations of input string are:");
        System.out.println(mySet);
        return size;
    }

    static boolean isPalindrome(String str){
        if(str.length()>0){
            for(int i=0,j=str.length()-1;i<=j;i++,j--){
                if(str.charAt(i)==str.charAt(j)){
                    continue;
                }else
                    {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    
    
    
    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input string whose permutations is to be printed");
        String sc = input.nextLine();
        //String sc ="aabaa";
        palindrome(sc);
        
    }
    
}
