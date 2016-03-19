//Longest Common Subsequence between two strings

package longestcommonsubsequence;
public class LongestCommonSubsequence {
    
    void lcs(String S1,String S2)
    {
        int m = S1.length();
        int n = S2.length();
        
        char []s1array = S1.toCharArray();
        char []s2array = S2.toCharArray();
        
        int lcsArray[][]= new int[m+1][n+1];
        
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
               if(i==0||j==0)
                   lcsArray[i][j] = 0;
               else if(s1array[i-1]==s2array[j-1])
               {
                   lcsArray[i][j] = lcsArray[i-1][j-1]+1;
               }
               else
                   lcsArray[i][j] = max(lcsArray[i-1][j],lcsArray[i][j-1]);
            }
        }
        
        System.out.println("The lowest common subarray length is "+lcsArray[m][n]);
        
            
        //Printing the LCS 
        int index = lcsArray[m][n];
        char printArray[] = new char[index+1];
        printArray[index] = '\0';
        
        int i=m,j=n;
        while(i>0 && j>0)
        {
            if(s1array[i-1] == s2array[j-1])
            {
                printArray[index-1] = s1array[i-1];
                i--;j--;index--;
            }
            else if(lcsArray[i-1][j]>lcsArray[i][j-1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }
        String result = new String(printArray);
        System.out.println("The lcs of two Strings "+S1+" "+S2+" are "+result);
        
    }
    
    public int max(int a,int b)
    {
        if(a>b)
            return a;
        else 
            return b;
    }        
          
    
    
    public static void main(String[] args)
    {
        LongestCommonSubsequence l = new LongestCommonSubsequence();    
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        l.lcs(X, Y);       
    }
}