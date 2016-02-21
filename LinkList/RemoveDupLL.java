//Remove duplicates in Link list.

package removedupll;
class node
{
    int data;
    node next;
    node(int item)
    {
        next = null;
        data = item;
    }
    
    void printnodes(node root)
    {
        if(root == null)
        {
            return ;
        }
        else
        {
            while(root!=null)
            {
                System.out.print(" "+root.data);
                root = root.next;
            }
        }    
    }
    
    void removeduplicates(node root)
    {
        
        node cur= null,prev = null;
        prev = root;
        while(prev!=null && prev.next!=null)
        {
            cur = prev;
            while(cur.next!=null)
            {
            
                if(prev.data==cur.next.data)
                {
                  
                    cur.next = cur.next.next;
                   
                }
                else
                {
                    cur = cur.next;
                }    
            }
            prev = prev.next;
        }
        
}
    
}

public class RemoveDupLL {
    public static void main(String[] args) {
        node root = new node(1);
        root.next = new node(2);
        root.next.next = new node(3);
        root.next.next.next = new node(1);
        root.next.next.next.next  = new node(2);
        root.printnodes(root);
        root.removeduplicates(root);
       
       System.out.println("\nAfter removing duplicates");
        root.printnodes(root);
    
    }
    
}
