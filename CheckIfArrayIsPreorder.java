//Program to check if a given array can represent a preorder of Binary search tree
/*Basic logic:
1) Find the first greater value on right side of current node. 
   Let the index of this node be j. Return true if following 
   conditions hold. Else return false
    (i)  All values after the above found greater value are 
         greater than current node.
    (ii) Recursive calls for the subarrays pre[i+1..j-1] and 
         pre[j+1..n-1] also return true.
Here optimized code is implemented.
*/

package checkifarrayispreorder;

import java.util.Stack;

public class CheckIfArrayIsPreorder {
    
    boolean canRepresentBST(int pre[])
    {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<pre.length;i++)
        {
            if(pre[i]<root)
                return false;
            
            while(!s.empty() && s.peek()<pre[i])
            {
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }
    
    public static void main(String[] args) {
        CheckIfArrayIsPreorder bst = new CheckIfArrayIsPreorder();
        int[] pre = new int[]{40, 30, 35, 80, 100};
        System.out.println("The given array is");
        for(int i =0;i<pre.length;i++)
        {
            System.out.print(" "+pre[i]);
        }
        int n = pre.length;
        if (bst.canRepresentBST(pre) == true) {
            System.out.println("\nThe given array is a Preorder of BST");
        } else {
            System.out.println("\nThe given array is not a Preorder of BST");
        }
        
    }
    
}
