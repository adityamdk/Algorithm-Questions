/* Program to to print all paths which sum up to that value  
Note that it can be any path in the tree- it does not have to start at the root */
package sumuptoavaluebinarytree;

import java.util.ArrayList;


class Node
{
    int data;
    Node left,right;
    int visited = 0;
    Node(int item)
    {
        left=right = null;
        data = item;
    }
}

public class SumUpToAValueBinaryTree {
    
    static Node n1;
    
    void findSum(Node root,ArrayList<Integer> path,int sum,int level)
    {
       
        if(root == null )return;
        int temp = sum;
        path.add(root.data);
        for(int i=level;i>-1;i--)
        {
            temp=temp-path.get(i);
            if(temp == 0 && root.visited == 0)
            {
                int intermediate = sum;
                root.visited = 1;
                System.out.println("Sum found at node "+root.data+"\nPath to node is:");
                for(int j=level;j>-1;j--)
                {
                    System.out.println(" "+path.get(j));
                    intermediate = intermediate-path.get(i);
                    if(intermediate==0)break;
                    
                }
                System.out.println(" ");
            }
            ArrayList<Integer> left = (ArrayList<Integer>)path.clone();
            ArrayList<Integer> right = (ArrayList<Integer>)path.clone();
            findSum(root.left,left,sum,level+1);
            findSum(root.right,right,sum,level+1);
        }
    }    
        
    void LevelOrdered()
    {
        int h = height(n1);
        for(int i =1;i<=h;i++)
        {
            LevelOrderHelper(n1,i);
            System.out.println("");
        }
    }
    
    void LevelOrderHelper(Node root,int h)
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

    int height(Node root)
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
 
    public static void main(String[] args) 
    {
        SumUpToAValueBinaryTree st= new SumUpToAValueBinaryTree();
        int sum = 11;
        st.n1 = new Node(1);
        st.n1.right = new Node(4);
        st.n1.left = new Node(3);
        st.n1.left.left = new Node(7);
        st.n1.left.right = new Node(4);
         st.n1.right.left = new Node(5);
        st.n1.right.right = new Node(6);
        st.n1.right.right.right = new Node(11);
        
        System.out.println("The Given Tree is ");
        System.out.println("**********************************************************");
        st.LevelOrdered();
        System.out.println("**********************************************************");
        System.out.println("Given Sum:"+sum+"\n");
        ArrayList<Integer> path = new ArrayList<Integer>();
        st.findSum(n1, path, sum, 0);

    }
    
}
