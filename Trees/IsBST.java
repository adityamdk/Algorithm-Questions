//Program to check if a given binary tree is BST or not 
package isbst;

class Node
{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}


public class IsBST {

    static boolean isBinaryST(Node root,int max,int min)
    {
        if(root ==null)
            return true;
        
        if(root.data<min||root.data>max)
        {
            return false;
        }
        return (isBinaryST(root.left,root.data-1,min)&& isBinaryST(root.right,root.data+1,max));
    }
    
    public static void main(String[] args) {
        Node root = new Node(3);
        root.right = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        boolean val = isBinaryST(root,1,5);
        System.out.println("The given tree is binary search tree is "+val);
    }
    
}
