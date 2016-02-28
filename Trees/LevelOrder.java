// Recursive level order traversal program for trees 
//which has the following functions
//1) Height of tree 
//2)Level order traversal
//3)Spiral Level order traversal of tree.
package levelorder.iterative;

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
public class LevelOrder {

    static node root;
    
    public LevelOrder()
    {
        root = null;
    }
    void LevelOrdered()
    {
        int h = height(root);
        for(int i =1;i<=h;i++)
        {
            LevelOrderHelper(root,i);
            System.out.println("");
        }
    }
    
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
    
        void ReverseLevelOrdered()
    {
        int h = height(root);
        boolean val = false;
        for(int i =1;i<=h;i++)
        {
            RLevelOrderHelper(root,i,val);
            System.out.println("");
            val = !val;
         //   System.out.println("val is "+val);
        }
    }
    
    void RLevelOrderHelper(node root,int h,boolean val)
    {
        if(root==null)return;
        if(h==1)
        {
            System.out.print(root.data+" ");
        }
        else if(h>1)
        {
            if(val)
            {
              //  System.out.println("In false");
            RLevelOrderHelper(root.left,h-1,val);
            RLevelOrderHelper(root.right,h-1,val);  
            }
           else
            {
              //  System.out.println("In true");
            RLevelOrderHelper(root.right,h-1,val);
            RLevelOrderHelper(root.left,h-1,val);  
            }   
        }
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
        LevelOrder loi = new LevelOrder();
        loi.root = new node(1);
        loi.root.left = new node(2);
        loi.root.right = new node(3);
        loi.root.left.left = new node(4);
        loi.root.left.right = new node(5);
        loi.root.left.right.left = new node(6);
        loi.root.left.right.right = new node(7);
          loi.root.left.right.left.left = new node(8);
        loi.root.left.right.left.right = new node(9);
        System.out.println("the height is "+ loi.height(root));
        System.out.println("Level order traversal is");
         loi.LevelOrdered();
         System.out.println("Reverse Level order traversal is");
         loi.ReverseLevelOrdered();
    }
    
}
