/*
Problem from Codeeval: Beautiful String:

When John was a little kid he didn't have much to do. There was no internet, no Facebook, and no programs to hack on. So he did the only thing he could... he evaluated the beauty of strings in a quest to discover the most beautiful string in the world.

Given a string s, little Johnny defined the beauty of the string as the sum of the beauty of the letters in it. The beauty of each letter is an integer between 1 and 26, inclusive, and no two letters have the same beauty. Johnny doesn't care about whether letters are uppercase or lowercase, so that doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as beautiful as lowercase 'f', for example.)

You're a student writing a report on the youth of this famous hacker. You found the string that Johnny considered most beautiful. What is the maximum possible beauty of this string?
Input sample:

Your program should accept as its first argument a path to a filename. Each line in this file has a sentence. E.g.   
1)ABbCcc
2)Good luck in the Facebook Hacker Cup this year!
3)Ignore punctuation, please :)
4)Sometimes test cases are hard to make up.
5)So I just go consult Professor Dalves

Output :
Beautiful String Values:
1)152
2)754
3)491
4)729
5)646

*/
package largestnumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ADITYAMD
 */
public class BeautifulString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toLowerCase();
        char[] chars = input.toCharArray();
        input =input.trim();
         Arrays.sort(chars);
        System.out.println("Input is "+input);
        String sortedInput = new String(chars);
        
         
       
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=0;i<chars.length;)
        {
            char charInput = chars[i];
            int occ =0;
            
            //System.out.println("current character is "+charInput+" value of i is"+i);
            
            if(((charInput >=65)&&(charInput <=90))||((charInput >=97)&&(charInput <=122)))
            {    
          //      System.out.println("Inside if");
                occ = sortedInput.lastIndexOf(charInput)-sortedInput.indexOf(charInput)+1;
                ll.add(occ);
                i= i+occ-1;
            }
           i =i+1;
        }
        Collections.sort(ll);
        int k =26;
        int totalVal = 0;
        
        for(int show:ll)
        {
         //  System.out.println("value is "+show);
        }
        
        for(int i =ll.size()-1;i>=0;i--)
        {
             
            int currentVal = ll.get(i);
           // System.out.println("inside for loop curvalue is"+currentVal+"i is "+(i)+"multiplication value is "+(currentVal*k)+"totalVal is "+totalVal+"k is "+k);
            ll.set(i,currentVal*k);
            k--;
            totalVal = totalVal+ll.get(i);
        }
        System.out.println(totalVal);
        
        
        
    }
    
}
