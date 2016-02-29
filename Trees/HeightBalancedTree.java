/*Program checks if a tree is height balanced.A balanced tree is defined to be a tree such that 
no two leaf nodes differ in distance from the root by more than one 
 */
package heightbalancedtree;


class node
{
    node left,right;
    int data;
    node(int datas)
    {
    data = datas;
    left = right = null;
    }
}

public class HeightBalancedTree {
    static node root;
    //gets the maximum depth of the tree
    public static int maxDepth(node root)
    {
        int max =0;
        if(root == null)
        {
            return max;
        }
        max = 1+Math.max(maxDepth(root.left), maxDepth(root.right));
        
        return max;
    }
    //computes the max height of the given tree
     int height(node root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh<rh) return (rh+1);
            else return (lh+1);
        }
    }
    //prints the level order of the tree
    void LevelOrdered()
    {
        int h = height(root);
        for(int i =1;i<=h;i++)
        {
            LevelOrderHelper(root,i);
            System.out.println("");
        }
    }
   //helps in Printing level order of the tree 
    void LevelOrderHelper(node root,int h)
    {
        if(root==null)return;
        if(h==1)
        {
            System.out.print(root.data+" ");
        }
        else if(h>1)
        {
            LevelOrderHelper(root.left,h-1);
            LevelOrderHelper(root.right,h-1);        
        }
    }
    //gets the minumum depth of the tree
    public static int minDepth(node root)
    {
        int min =0;
        if(root == null)
        {
            return min;
        }
        min = 1+Math.min(minDepth(root.left), minDepth(root.right));
        
        return min;
    }
    //checks of the tree is balenced by checking difference between the max and min depth of tree is less than 1
    public static boolean isTreeBalanced(node root)
    {
        return (maxDepth(root)-minDepth(root)<=1);
    }
    public static void main(String[] args) {
        
        HeightBalancedTree hbt = new HeightBalancedTree();
        hbt.root = new node(1);
        hbt.root.left = new node(2);
        hbt.root.right = new node(3);
        hbt.root.left.left = new node(4);
        hbt.root.left.right = new node(5);
        hbt.root.right.left = new node(6);
        hbt.root.right.right = new node(7);
        hbt.root.left.right.left = new node(8);
        hbt.root.left.right.right = new node(9);
        hbt.root.left.right.left.left = new node(10);
        hbt.root.left.right.left.right = new node(11);
        
        System.out.println("The contents of the tree are");
        System.out.println("**********************************************");
        hbt.LevelOrdered();
        System.out.println("**********************************************");
        
        
        boolean value = isTreeBalanced(hbt.root);
        if(value)
        {
            System.out.println("The tree is height balanced(ie all leaf nodes differ by maximum of one height level)");
        }
        else
        {
           System.out.println("The tree is not height balanced(ie all leaf nodes differ by maximum of one height level)");
        }
      }    
    }
    
