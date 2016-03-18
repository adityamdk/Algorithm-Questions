//The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
package longestincreasingsubsequence;
public class LongestIncreasingSubsequence {
    
    static int lis(int [] array)
    {
        int maxlen = 0;
        int len = array.length;
        int lisArray[] = new int[len];
        for(int i =0;i<len;i++)
        {
            lisArray[i] = 1;
        }
        //L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1
        for(int i =0;i<len;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(array[i]>array[j] && lisArray[i]<lisArray[j]+1)
                {
                    lisArray[i]= lisArray[j]+1;
                }
            }
        }
        
        for(int i=0;i<len;i++)
        {
            if(maxlen<lisArray[i])
                maxlen = lisArray[i];
        }
        
        return maxlen;
    }
    
    public static void main(String[] args) {
    
        int array[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("The length of longest increasing subsequence is "+lis(array));
        
    }
    
}
