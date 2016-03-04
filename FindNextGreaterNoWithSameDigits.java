//Find next greater number with same set of digits
package findnextgreaternowithsamedigits;

import java.util.Arrays;
import java.util.Scanner;

public class FindNextGreaterNoWithSameDigits {
    
    void findNext(int[] array)
    {
       int index =-1;
        for(int i=array.length-1;i>0;i--)
        {
            //find the first digit greater than previous element
            if(array[i]>array[i-1])
            {
                index = i;
                break;
            }
        }
        //if no such digit ,then all digits are decending order.So next element cant be found
        if(index == 0)
        {
            System.out.println("Next number greater than the input not possible");
            return;
        }
            
        //find the next number greater than index i-1
        int smallest = array[index-1];
        int newInd = index;
        int min = array[index];
        System.out.println("Smallest and min are"+smallest+ " "+ min);
        for(int i=index+1;i<array.length;i++)
        {
            if(array[i]<min&& array[i]>smallest)
            {
                //min = array[i];
                newInd = i;
            }
        }
          System.out.println("new index to be swapped is "+newInd);
            //Swap the two indices
            int temp = array[index-1];
            array[index-1]= array[newInd];
            array[newInd] = temp;
          //sort the number after the index-1.
        Arrays.sort(array,index,array.length);
        System.out.println("The next greater number is ");
        //print the next number.
        for(int i:array)
        {
            System.out.print(i);
        }
        
        
    }
    
    public static void main(String[] args) {
        FindNextGreaterNoWithSameDigits obj = new FindNextGreaterNoWithSameDigits();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input number whose next number greater than this with same digits is to be printed");
        //Converts input number to integer array
        int no = sc.nextInt();
        String number = String.valueOf(no);
        int numberArray[] = new int[number.length()];
        for(int i =0;i<number.length();i++)
        {
             numberArray[i]= Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        for(int i =0;i<number.length();i++)
        {
            System.out.println("Input array :"+numberArray[i]);   
       }
        //finds the next number.
        obj.findNext(numberArray);
    }
    
}
