//an n-gram is a contiguous sequence of n items from a given sequence of text 
package ngramgeneration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NGramGeneration {
   private static void generateNgrams(int N,String input,ArrayList ngram)
   {
       int start =0;
       
       String [] tokens = input.split("\\s+"); //split sentence into tokens
       //Generate N grams
       for(int i=0;i<tokens.length-N+1;i++)
       {
           String s= "";
           start = i;
           int count = 0;
           while(count<N)
           {
               s = s+" "+tokens[start+count];
               count++;
           }
           ngram.add(s);
       }
   }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence whose n gram is to be generated");
        String input = sc.nextLine();
        System.out.println("Enter the size of N gram");
        int N = sc.nextInt();
        ArrayList<Integer> ngram = new ArrayList<>(); 
        generateNgrams(N,input,ngram);
         Iterator it = ngram.iterator();
         System.out.println("N grams of input string are");
         while(it.hasNext())
         {
             System.out.println(it.next()+"");
         }
    }
    
}
