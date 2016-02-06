//Program to print the powerset of a given set

package powerset;

import java.util.Scanner;


public class PowerSet {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in set");
        int no = sc.nextInt();
        double nos = (double)no;
        int powerset = (int)(Math.pow(2.0,nos));
        System.out.println("Enter the contents of the set");
        int []array= new int[no];
        for(int i =0;i<no;i++)
        {
            array[i] = sc.nextInt();
        }
        for(int i =0;i<powerset;i++)
        {
            for(int j=0;j<no;j++)
            {
                int k = (1<<j);
                int ik = i&k;
                if(ik>=1)
                {
                    System.out.print(array[j]);
                }
               
            }
            System.out.println("");
        }
        
    }
    
}
