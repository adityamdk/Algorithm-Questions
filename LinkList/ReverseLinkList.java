/*Program to 
a)Reversing a linklist iteratively 
b)Reversing a linklist recursively*/

package reverselinklist;

class Node
{
    Node next;
    int data;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

public class ReverseLinkList {
    
    
    static Node ReverseLinkList(Node root)
    {
        Node current = root;
        Node prev = null;
        Node nexted= null;
       
        while(current!= null)
        {
            nexted = current.next;
            current.next = prev;
            prev = current;
            current = nexted;
        }
        root = prev;
        return root;
    }
     
    static Node ReverseRecursion(Node root)
    {
        Node first= root,rest=null;
        
         
        if(root == null)
            return root;
        
        
        rest = first.next;
        if(rest == null)
            return null;
        
        ReverseRecursion(rest);
        first.next.next = first;
        first.next = null;
        
        return root;
    }
    
    static void printList(Node root)
    {
        Node cur = root;
        for(cur=root;cur!=null;cur = cur.next)
        {
            System.out.print("  "+cur.data);
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(78);
        root.next =  new Node(89);
        root.next.next  = new Node(100);
        root.next.next.next =  new Node(101);
        root.next.next.next.next  = new Node(10);
        printList(root);
        System.out.println("\nAfter reversing iteratively");
        Node root1 = ReverseLinkList(root);
        printList(root1);
        
        System.out.println("\nAfter reversing recursively");
        Node root2 = ReverseLinkList(root1);
        printList(root2);
        
       
        
        
        
    }
    
}
