//Given a number,return the complement of the number in binary.Eg: 5 in binary is 101,its complement is 010,if i pass 5 two should be returned.
package complementofnumberinbinary;

import java.util.Scanner;

public class ComplementOfNumberInBinary {
    public static void main(String[] args) {
        System.out.println("Enter a number whose complement is to be returned");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        String binary = Integer.toBinaryString(no);
        System.out.println("Binary representation of number is "+binary);
        int count =0;
        String complement = new String();
        while(count <binary.length())
        {
          if(binary.charAt(count)=='1')
          {
              complement = complement+"0";
          }
          else
          {
              complement= complement+"1";
          }
          count++;
        }
         System.out.println("Binary representation of complement is "+complement);
        int decimal = Integer.parseInt(complement,2);
        System.out.println("The complement of "+no+" is "+decimal);
    }
    
}
