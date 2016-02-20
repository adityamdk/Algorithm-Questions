package setrowcoltozeromatrix;

import java.util.Arrays;

public class SetRowColToZeroMatrix {
    public static void main(String[] args) {
        
        int xarray[] = new int[3];
        int yarray[] = new int[3];
        int inputMatrix[][] = {{1,0,1},{0,1,1},{1,1,1}};
        System.out.println("Input matrix is ");
        for(int i =0;i<inputMatrix.length;i++)
        {    
            for(int j=0;j<inputMatrix[i].length;j++)
            {
                System.out.print(inputMatrix[i][j]+" ");
                xarray[i] = 0;
                yarray[i] = 0;
            }
            System.out.println("");
        }
        int k =0;
        int finalK =0;
        for(int i =0;i<inputMatrix.length;i++)
        {    
            for(int j=0;j<inputMatrix[i].length;j++)
            {
                if(inputMatrix[i][j]==0)
                {
                    xarray[k] = i;
                    yarray[k] = j;
                   
        //            System.out.println("Value added is i"+i+" j is"+j+" k is "+k);
                     k++;
                }
            }
            System.out.println("");
        }
         finalK =k;
        k =0;
        
        
       Arrays.sort(yarray, 0, finalK);
        Arrays.sort(yarray,0, finalK);
        
        for(int i=0;i<inputMatrix.length;i++)
        {
            if(i ==xarray[k] && k<=finalK)
            {
        
        //        System.out.println("I value chosen is "+i+"and k is "+k);
                for(int j=0;j<inputMatrix.length;j++)
                {
                    inputMatrix[i][j] = 0;
                }
                        k++;
            }
        }
        k = 0;
        for(int i=0;i<inputMatrix.length;i++)
        {
            
            if(i ==yarray[k] && k<=finalK)
            {
             
          //      System.out.println("j value chosen is "+i+"and k is "+k);
                for(int j=0;j<inputMatrix.length;j++)
                {
                    inputMatrix[j][i] = 0;
                }
                k++;
                
            }
        }
        
        System.out.println("The matrix with row and column value set to 0 if any row/col element is set to 0 is");
         for(int i =0;i<inputMatrix.length;i++)
        {    
            for(int j=0;j<inputMatrix[i].length;j++)
            {
                System.out.print(inputMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}