//Given an image represented by an NxN matrix, where each pixel in the image is 4 ,bytes, write a method to rotate the image by 90 degrees  

package rotatematrixby90degrees;
public class RotateMatrixBy90Degrees {
    
    
    public static void main(String[] args) {
        
        int inputMatrix[][]= 
        { { 1, 2, 3,4,5},
          { 6,7,8,9,10 }, 
          {11,12,13,14,15},
          {16,17,18,19,20},
          {21,22,23,24,25} };
        
        
        
        int RotatedMatrix[][]= new int[inputMatrix.length][inputMatrix[0].length];
        
        System.out.println("The  matrix we have is: ");
        //Display the input matrix
        for(int i =0;i<inputMatrix.length;i++)
        {    
            for(int j=0;j<inputMatrix[i].length;j++)
            {
                System.out.print(inputMatrix[i][j]+" ");
                RotatedMatrix[i][j] = 0;
            }
            System.out.println("");
        }
        
        //Rotate the input matrix  
        int l = RotatedMatrix.length; 
        for(int i =0;i<l;i++)
        {    
         for(int j=0;j< l;j++)
         {
             RotatedMatrix[i][j] = inputMatrix[l-j-1][i];
         }
         
        }
       //Rotated matrix is 
        System.out.println("The rotated matrix is:  ");
       
            for(int i =0;i<l;i++)
            {    
                for(int j=0;j<l;j++)
                {
                    System.out.print(RotatedMatrix[i][j]+" ");
                }
                System.out.println("");
            }
    }
}
    
