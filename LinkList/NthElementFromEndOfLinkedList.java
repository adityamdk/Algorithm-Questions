//Program to return Nth element from the end of the LinkedList

package nthelementfromendoflinkedlist;

import java.util.Scanner;

class node
{
    int data;
    node next;
    node(int value)
    {
        data = value;
        next = null;
    }
            
}


public class NthElementFromEndOfLinkedList {
    
    public node NthElement(node root,int n)
    {
        node first=root,second=root;
        int count =1;
        while(count<=n)
        {
          if(first==null)
          {
              return null;
          }    
         first = first.next;
         count++;
        }
        
        while(first.next!=null)
        {
            first= first.next;
            second = second.next;
             } 
        return second;    
        
    }
    
    public static void main(String[] args) 
    {
        NthElementFromEndOfLinkedList obj = new NthElementFromEndOfLinkedList();
        System.out.println("Enter the value of \'n\' to get the n from last element of the linkedlist");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        node root ;
         root = new node(1);
         root.next = new node(2);
         root.next.next = new node(3);
         root.next.next.next = new node(4);
         root.next.next.next.next = new node(5);
         root.next.next.next.next.next = new node(6);
         node cur = root;
         System.out.println("The contents of the list are");
         while(cur!=null)
         {
             System.out.println(" "+cur.data);
             cur = cur.next;
         }
         
         node pointer = obj.NthElement(root,n);
         if(pointer == null)
         {
             System.out.println(n+" is greater than the size of the list ");
         }
         else
         System.out.println(n+"th Element from the end of the list is "+pointer.data);
    }
    
}
