//Print K closest values to a given value in array.

package kclosestvaluesinarray;

import java.util.Scanner;

public class KClosestValuesInArray {
    
    static int closestValue(int a[],int low,int high,int k)
    {
        if(a[high]<=k)
        {
            return high;
        }
        if(a[low]>k)
        {
            return low;
        }
        int mid = (high+low)/2;
        if(a[mid]<=k && a[mid+1]>k)
        {
            return mid;
        }
        if(a[mid]<k)
           return closestValue(a,mid+1,high,k);
        
            return closestValue(a,low,mid-1,k);
        
    }
    static void KclosestValues(int a[],int j,int k)
    {
        int low = closestValue(a, 0,a.length-1,k);
        int high = low+1;
        int count = 0;
        //if(a[low]== k)low--;
        while(high<a.length-1 && low>=0 && count<j)
        {
            if(Math.abs(k-a[low])<Math.abs(a[high]-k)){
                System.out.print(" "+a[low]);
                low--;count++;
             }
            else
            {
                System.out.print(" "+a[high]);
                high++;count++;
            }
           
        }
         while(count<j && low>=0){
                System.out.print(" "+a[low]);
                low--;count++;
            }
             while(count<j && high<a.length-1){
                 System.out.print(" "+a[high]);
                high++;count++;
            }
        
    }
    
    public static void main(String[] args) {
        int arr[] ={12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
        System.out.println("Enter number of closest values to be printed");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println("Enter value whose closeness is to be checked");
         int j = sc.nextInt();
        KclosestValues(arr,k,j);
        
    }
    
}
