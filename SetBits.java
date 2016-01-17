//Java Program to count the number of Set Bits of a given number in binary representation.
package setbits;
import java.util.Scanner;

public class SetBits {

     public static void main(String[] args) {
         System.out.println("Enter a no whose set bits is to be found out");
         Scanner sc= new Scanner(System.in);
            int k = sc.nextInt();
            int count =0;
            while(k>0)
            {
               k= k& (k-1);
                count = count + 1;
            }
            System.out.println(count);
    }
    
}
