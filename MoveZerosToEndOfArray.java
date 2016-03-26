//Move the Zeros to the End of Array in O(n)
package movezerostoendofarray;
public class MoveZerosToEndOfArray {
    
    void movedToEnd(int []arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                arr[count++] = arr[i];
            }
        }
        
    
        count = count -1;
        while(count<arr.length)
        {
            arr[count++] = 0;
        }
    }
    
    public static void main(String[] args) {
        MoveZerosToEndOfArray obj = new MoveZerosToEndOfArray();
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0,0,8,9,0,5, 6, 0, 9};
        System.out.println("Array Contents are");
        for(int i:arr)
        {
            System.out.print(" "+i);
        }
        obj.movedToEnd(arr);
        System.out.println("\n Array Contents after moving to end are");
         for(int i:arr)
        {
            System.out.print(" "+i);
        }
       
    }
    
}
