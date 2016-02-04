/*
Program to find the median of 2 sorted arrays of equal length. 
*/
package mergemeadian;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeMeadian {
    
    
    
    double median(int []array1,int []array2,int n)
    {
        int m1= -1,m2=-1;
        int i =0,j =0;
        int count =0;        
       
        for(count =0;count<=n;count++)
        {
            if(i ==n)
            {
                m1 = m2;
                m2 = array2[0];
                break;
            }
            if(j ==n)
            {
                m1 = m2;
                m2 = array1[0];
                break;
            }
            if(array1[i]<array2[i])
            {
                m1 = m2;
                m2 = array1[i];
                i++;
            }
            //if(array1[i]>=array2[j])
            else
            {
                m1 = m2;
                m2 = array2[j];
                j++;
            }
        }
        System.out.println("s1 and s2 are"+ m1+" "+m2);
        double media = (m1+m2)/(2.0);
        return media;
    }
    
    public static void main(String args[])
    {
        MergeMeadian m = new MergeMeadian();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of arrays");
        int n = sc.nextInt();
        System.out.println("Enter input array");
        int []array = new int[n];
        for(int i =0;i<n;i++)
        {
            array[i] = sc.nextInt();
            
        }
        //int ar1[] = {1, 12, 15, 26, 38};
    //int ar2[] = {2, 13, 17, 30, 45};
       // System.out.println("Enter3 the size of 2st array");
        //int m = sc.nextInt();
        System.out.println("Enter 2nd input array");
        int []array2 = new int[n];
        for(int i =0;i<n;i++)
        {
            array2[i] = sc.nextInt();   
        }
        //sorting the two arrays
        Arrays.sort(array);
        Arrays.sort(array2);
        for(int i=0;i<n;i++)
        {
        System.out.println("Array 1 is "+array[i]);
            
        }
        for(int i=0;i<n;i++)
        {
        System.out.println("Array 2 is "+array2[i]);
            
        }//checking for the median of two sotrted arrays
        int i =0,j=0;
        double median = m.median(array,array2,n);
        System.out.println("median is "+median);
        
    }
        
    
}
