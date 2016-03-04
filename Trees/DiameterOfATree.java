//Diameter of a Binary Tree
package diameterofatree;



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


public class DiameterOfATree {
    
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

    
    
    
    int diameter(node root)
    {
        if(root==null)
            return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int lheight = height(root.left);
        int rheight = height(root.right);
        int k = Math.max(rheight+lheight+1,leftDiameter);
        return Math.max(k,rightDiameter);   
    }
    
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
    
    public static void main(String[] args) {
        DiameterOfATree dt = new DiameterOfATree();
                node root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		root.left.right.left = new node(6);
		root.left.right.left.right = new node(7);
		root.left.left.left = new node(8);
        
        
        int finalDiameter = dt.diameter(root);
        
        System.out.println("The Given input tree is ");
        dt.LevelOrdered(root);
        System.out.println("Diameter of the tree  is "+finalDiameter);
    }
    
}
