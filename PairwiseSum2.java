//Function to find the pairwise sum of a given target
package pairwisesum2;

public class PairwiseSum2 {
public static final int MAX =10000; //Max size of hashmap.

    static void pairSum(int target,int []array)
    {
        boolean []checker = new boolean[MAX];
        for (int i =0;i<array.length;i++)
        {
            int diff = target - array[i];
            if((diff>=0)&&(checker[diff]))
            {
                System.out.println("the pairs are "+diff+" and  "+array[i]);
            }
            checker[array[i]] = true;
        }
    }
    
    public static void main(String[] args) {
        
        int array [] = {1,2,3,4,5,6,7,8};
        int target = 9;
        pairSum(target,array);
        

    }
    
}
