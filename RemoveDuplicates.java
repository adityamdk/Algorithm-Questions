//Program to remove duplicates in an array
package removeduplicates;

import java.util.Arrays;


public class RemoveDuplicates {

    
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
       
	int[] clean = Arrays.copyOf(input, j + 1);
       //Reversing the contents of the array to ssort the array in descending order
        for (int k = 0; k < clean.length / 2; k++) 
        {
            int temp = clean[k];
            clean[k] = clean[clean.length - 1 - k];
            clean[clean.length - 1 - k] = temp;
        }
	return clean;
    }
}
