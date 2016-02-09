//Prints the number of zeros in numbers of range 0 to n (ie 0 ,0 in 10 ,0 in 20 etc.)
package countnoofzeros;

import java.util.Scanner;

public class CountNoofZeros {

    public static void main(String[] args) {
        
        System.out.println("Enter the range of number,from  0 to ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0;
        while(n>0){
            count = count+(n/10);
            n = n/10;
        }
        System.out.println("The total number of zeros in "+count);
    }
}
