//Program to check if a binary tree is  sum tree. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree  

package sumofallchildnodesinatree;
class node {
    int data;
    node left,right;
    node(int item){
        data = item;
        left = right = null;
    }
}


public class SumOfAllChildNodesInATree {
    static node root;
    //Returns the sum at any given node of a tree
    int sum(node n)
    {
        if(n == null)
        {
            return 0;
        }
        return sum(n.left)+sum(n.right)+n.data;
    }
    
    //function to check if a tree is a sum tree
    int CheckIfSumTree(node n)
    {
        int left,right ;
        if((n==null)||(n.left==null && n.right==null))
        {
            return 1;
        }
                left = sum(n.left);
                right = sum(n.right);
                
                if((n.data== left+right)&&(CheckIfSumTree(n.left)!=0)&&(CheckIfSumTree(n.right)!=0))
                {
                    return 1;
                }
                return 0;
    }
    
    //Returns the height of a tree
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
    void LevelOrdered(node root)
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

    
    public static void main(String[] args) {
       SumOfAllChildNodesInATree tree = new SumOfAllChildNodesInATree();
       tree.root = new node(26);
       tree.root.left = new node(10);
       tree.root.right = new node(3);
       tree.root.left.left = new node(4);
       tree.root.left.right = new node(6);
       tree.root.right.right = new node(3);
       
       System.out.println("The Given input tree is ");
       tree.LevelOrdered(root);
        
       if (tree.CheckIfSumTree(root) != 0) {
            System.out.println("The given tree is a sum tree");
       } else {
            System.out.println("The given tree is not a sum tree");
        }
    }
    
}
