//Program to remove duplicates elements in char array
package removeduplicatesinchararray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesInCharArray {
    public static void main(String[] args) {
        String[] input = { "A", "B", "C", "D", "B", "A", "E", "E", "B", "C" };
        System.out.println("The given array is "+Arrays.toString(input));
        List<String> myArray = Arrays.asList(input);
        Set<String> Unique = new HashSet<>(myArray);
        System.out.println("The array without repetition is :");
        String [] uniqueString = new String[Unique.size()];
        Unique.toArray(uniqueString);
        for(String s:uniqueString)
        {
            System.out.print(s+", ");
        }
    }
    
}
