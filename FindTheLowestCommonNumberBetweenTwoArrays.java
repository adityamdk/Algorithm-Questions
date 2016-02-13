//Java program to find the lowest common number between two arrays
import java.util.HashSet;

public class FindTheLowestCommonNumberBetweenTwoArrays {
    
    public static void main(String[] args) {
           int arrayA[] = {25,45,1000,76,2,4,6};
           int arrayB[] = {52,25,100,8,1,4,6};
    //Code to find the lowest common Number between two arrays 
        HashSet<Integer> set = new HashSet<>();
        
            for(int i :arrayA)
            {
                set.add(i);
            }
        int least = Integer.MAX_VALUE;    
        for(int j:arrayB){
            if(set.contains(j))
            {
                if(j<least){
                    least = j;
                }
            }
        }    
        System.out.println("The lowest common number between two arrays is "+least);    
    }
    
}
