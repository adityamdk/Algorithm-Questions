//Program to return Kth smallest element in Binary search tree

package kthsmallestelementinbst;

import java.util.Scanner;


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


public class KthSmallestElementinBST {  
    static int count  = 0;  
    node root;
    // Constructor
    KthSmallestElementinBST() { 
        root = null; 
    }
 

    //prints the kth smallest element in tree
    void printKthSmallestNode(int k)
    {
        printKthSmallestNodeHelper(root,k-1);
    }
    //helper function to print kth smallest element in tree
    void printKthSmallestNodeHelper(node root,int k)
    {
        
        if(root == null)return;
        printKthSmallestNodeHelper(root.left,k);
        
        if(count == k)
        {
            System.out.println("the "+(k+1)+"th smallest node is "+root.data); 
        } 
        count++;
        printKthSmallestNodeHelper(root.right,k);
        
    }
    //helps in inserting calues to Binary search tree
    void insert(int key)
    {
        root = insertBST(key,root);
    }
    //helper function to construct BST
    node insertBST(int key, node root)
    {
        if(root==null)
        {
            root =new node(key);
            return root;
        }
       
        if(key>root.data)
            root.right=insertBST(key,root.right);
        else
           root.left= insertBST(key,root.left);
        
        return root;
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
    
    //function that counts number of elements in tree
    int size()
    {
        return sizeHelper(root);
    }   
    //helper function that counts number of elements in tree
    int sizeHelper(node root)
    {
        if(root == null)
            return 0;
        else
            return sizeHelper(root.left)+sizeHelper(root.right)+1;
    }    
        
    public static void main(String[] args) 
    {
        int elements[] = { 50,30,20,40,70,60,80};
        
        KthSmallestElementinBST tree = new KthSmallestElementinBST();
        for(int i =0;i<elements.length-1;i++)
        {
           tree.insert(elements[i]);
        }
        
        System.out.println("The level order of the tree constructed: ");
        tree.LevelOrdered();
        System.out.println("Enter the number k,where the kth smallest element in BST will be returned" );
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
        if(k<=tree.size())
        {
             tree.printKthSmallestNode(k);
        }
        else
        {
            System.out.println("The number entered is greater than number of elements in tree");
        }
    }
 }
    

