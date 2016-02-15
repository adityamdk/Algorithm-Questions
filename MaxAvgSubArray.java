//Program which gives the sub array of length k which has maximum average .
package maxavgsubarray;

public class MaxAvgSubArray {
    
    static int maxSubArrayHelper(int []a,int n,int k)
    {
        if(k>n)return -1;
        
        int Sum =0;
        for(int i =0;i<k;i++)
        {
            Sum = Sum+a[i];
        }
        int maxSum = Sum;
        int maxIndex = 0;
        for(int i=k;i<n;i++)
        {
            Sum = Sum+a[i]-a[i-k];
            if(Sum>maxSum){
                maxIndex = i-k+1;
                maxSum = Sum;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        
        int array[]= {1,12,-5,-6,50,3};
        int k = 4;
        int n = array.length;
        int index = maxSubArrayHelper(array, n, k);
        System.out.println("The sub array of size "+k+"which generates max average starts at index "+index);
    }
    
}
