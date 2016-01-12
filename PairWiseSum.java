/*
Given a Sum and an array,print two numbers of the array when added up is equal to the given sum. 
*/
package pairsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ADITYAMD
 */
public class PairSum {
    public static int[] pair(int[]numbers,int sum)
    {       
        int[]result = new int[2];
        Arrays.sort(numbers);
        int start =0;int end = numbers.length-1;
        while(start<end)
        {
            if(numbers[start]+numbers[end]==sum)
            {
                System.out.println(numbers[start] + " + " + numbers[end] + " = " + sum);
                start++;
                end--;
            }
            else if((numbers[start]+numbers[end])<sum)
            {
                    start++;
            }
            else
                end--; 
        }
        return result;
    }
    public static void main(String[] args) {
       
         int[] inputArray = {1,2,4,8,6};//{ 4, 6, 5, -10, 8, 5, 20 };  
        int targetNumber = 10;  
  
        int result[] =new int[2];
        result = pair(inputArray, targetNumber);
     
        
    }
    
}
