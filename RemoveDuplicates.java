/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicates;

import java.util.Arrays;

/**
 *
 * @author ADITYAMD
 */

public class RemoveDuplicates {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
	int[] arr = { 1, 2, 2, 3, 3,4,5,6,4,5,6,7,8,8,8,77,7,8,7 };
	arr = removDuplicates(arr);
        for(int i:arr)
	System.out.print(" "+i);
}
    
   
public static int[] removDuplicates(int[] input) {
    Arrays.sort(input);
	if (input.length < 2)
	   return input;
	int j = 0,i = 1;
	
        while (i < input.length) 
        {
		if (input[i] == input[j])
                {
                    i++;
		} else 
                {
                    j++;
		input[j] = input[i];
                    i++;
		}
	}
        //System.out.println("count"+(j+1));
	int[] clean = Arrays.copyOf(input, j + 1);
       
        for (int k = 0; k < clean.length / 2; k++) 
        {
            int temp = clean[k];
            clean[k] = clean[clean.length - 1 - k];
            clean[clean.length - 1 - k] = temp;
        }
	return clean;
    }
}
