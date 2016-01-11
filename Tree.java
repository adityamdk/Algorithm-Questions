/*
 Tree program to construct tree,inorder,preorder,postOrder traversals,Finding path of a node from root node and finding,Lowest Common Ancestor of two nodes
 */
package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 *
 * @author ADITYAMD
 */
class Node
{
    Node left,right;
    int data;
   // ArrayList path;

    Node(int k)
    {
        left = right = null;
        data =k;
    }
    
    public void printTreeInorder(Node root)
    {
        //System.out.println("Inorder tree traversal");
        if(root == null)return;
        printTreeInorder(root.left);
        System.out.print(root.data+" ");
        printTreeInorder(root.right);
    }
    
    public void printTreePostorder(Node root)
    {
       // System.out.println("PostOrder tree traversal");
        if(root == null)return;
        printTreePostorder(root.left);
        printTreePostorder(root.right);
        System.out.print(root.data+" ");
    }
    
    public void printTreePreorder(Node root)
    {
       // System.out.println("PreOrder tree traversal");
         if(root == null)return;
        System.out.print(root.data+" ");
        printTreePreorder(root.left);
        printTreePreorder(root.right);
        
    }
    
   	public Boolean findPath(Node root, int find,ArrayList<Integer> path){
		if(root==null) return false;
		if(root.data==find ||findPath(root.left,find,path) ||findPath(root.right,find,path)){
			
			path.add(root.data);
			return true;
		}
		return false;
	}
        
       public int findLCA(Node root,int node1,int node2) 
       {
           ArrayList<Integer> pathNode1,pathNode2;
           pathNode1 = new ArrayList<>();
            pathNode2 = new ArrayList<>();
           // Node v1 = new Node(node1);
            //Node v2 = new Node(node2);
           if((!findPath(root,node1,pathNode1))||(!findPath(root,node1,pathNode2)))
            {
                     return -1;  
            }
           Iterator IT1 =pathNode1.iterator();
           Iterator IT2 =pathNode2.iterator();
           while(IT1.hasNext()&&IT2.hasNext())
           {
               Integer element1 = (Integer) IT1.next();
               Integer element2 = (Integer) IT2.next();
               if((int)element1 ==(int)element2)return element1;
           }    
           
           return -1;
       }
    
}

  

public class Tree {
    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        // TODO code application logic here
        Node root = new Node(30);
        ArrayList<Integer> listed = new ArrayList<>();
        
        Node n2 = new Node(10);
          root.left = new Node(8);
          root.right = new Node(52);
          root.left.right = new Node(3);
          root.left.left = new Node(20);
          root.left.left.right = n2;
          root.left.left.left = new Node(29);
          
           System.out.println("\nInOrder tree traversal");
           root.printTreeInorder(root);
           System.out.println("\nPreOrder tree traversal");
           root.printTreePreorder(root);
           System.out.println("\nPostOrder tree traversal");
           root.printTreePostorder(root);
          
        
            ArrayList<Integer> pathed = new ArrayList();
            root.findPath(root,10,pathed);
	    Collections.reverse(pathed);
	    System.out.println(" Path in the tree to the node  to 10 is" + pathed);
            
            int LCA = root.findLCA(root,8,3);
            System.out.println("The LCA of 8 and 3 is"+LCA);
            
            
            //Finding the LCA now 
            
          
    }
    
}



