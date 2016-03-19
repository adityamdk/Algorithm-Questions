//Dynamic programming to solve the edit distance between two strings.
package editdistance;

import java.util.Scanner;

public class EditDistance {

    static int editdistance(String s1,String s2)
    {
        int m = s1.length()+1;
        int n =s2.length()+1;
        
        
        //array which stores results of subproblem
        int distanceArray[][] = new int[m][n];
        
        //filling the array in bottom up fashion
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {
                    distanceArray[i][j] = j;
                }
                else if(j==0)
                {
                    distanceArray[i][j] = i;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    distanceArray[i][j] = distanceArray[i-1][j-1];
                }
                else
                {
                    distanceArray[i][j] = 1+min(distanceArray[i][j-1],distanceArray[i-1][j],distanceArray[i-1][j-1]);
                }
            }
        }
        
        return distanceArray[m-1][n-1];
    }
    
    static int min(int a,int b,int c)
    {
        int least =a;
        if(b<a) least = b;
        if(c<least) least = c;
        return least;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //String str1 = "sunday";
        //String str2 = "saturday";
        System.out.println("Enter the strings whose edit distance is to be checked");
        System.out.println("Enter String 1:");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2:");
        String str2 = sc.nextLine();
        
        System.out.println("Edit Distance between "+str1+" and  "+str2+" are "+editdistance(str1,str2));
        return ;

    }
    
}
