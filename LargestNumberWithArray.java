//Given a list of non negative integers, arrange them such that they form the largest number.

package largestnumberwitharray;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberWithArray {
    
    static String LargestNo(int []nums)
    {
    String result = "";
    
    String []str = new String[nums.length];
    for(int i=0;i<nums.length;i++)
    {
        str[i] = String.valueOf(nums[i]);
    }
    
     Arrays.sort(str,new Comparator<String>(){
          
         public int compare(String str1,String str2)
         {
             String leftRight = str1+str2;
             String rightLeft = str2+str1;
             return -leftRight.compareTo(rightLeft);
         }
     });
     
    StringBuilder sb = new StringBuilder();
     for(String s:str)
     {
         sb.append(s);
     }
     if(sb.charAt(0)==0 && sb.length()>2)
         sb.deleteCharAt(0);
     
     result = sb.toString();
    return result;
    }
    
    public static void main(String[] args) {
    int array[] = {3, 30, 34, 5, 9};
    String result = LargestNo(array);
        System.out.println("The largest number possible with the given array elements are "+result);
    }
    
}
