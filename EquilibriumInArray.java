//Program to find the equilibrium index in array
//Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

package equilibriuminarray;
public class EquilibriumInArray {
    
    static int equilibriumPoint(int arr[]){
        int sum = 0,leftsum =0;
        int val = -1;
        for(int i=0;i<arr.length-1;i++)
        {
            sum = sum+arr[i];
        }
        for(int i=0;i<arr.length-1;i++)
        {
            sum = sum-arr[i];
            if(sum == leftsum){
                val = i;
            }
            leftsum=leftsum+arr[i];
        }
        return val;
    }
    
    public static void main(String[] args) {
        int array[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Equilibrium point is "+equilibriumPoint(array));
    }
    
}
