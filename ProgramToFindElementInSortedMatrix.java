//Given a matrix in which each row and each column is sorted, write a method to find an element in it 
package programtofindelementinsortedmatrix;

import java.util.Scanner;

public class ProgramToFindElementInSortedMatrix {
    //Function to fin d the element in matrix
    static void findElement(int [][]mat,int element,int rows,int cols)
    {
        int r = 0;
        int c = cols-1;
        while(r<rows && c>=0)
        {
            if(mat[r][c] == element)
            {
                System.out.println("Element found at row = "+r+" Column  = "+c);
                return;
            }
            else if(mat[r][c]<element)
            {
                r++;
            }
            else
            {
                c--;       
            }
        }
        System.out.println("Element not found");
        return;
    }
    
    public static void main(String[] args) {
       int matrix[][]={
           {1,2,3},
           {4,5,6},
           {7,8,9}
       };
       
        System.out.println("The given matrix is ");
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[1].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Enter the element to be found in matrix");
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        findElement(matrix, ele, matrix.length, matrix[1].length);
    }
    
}
