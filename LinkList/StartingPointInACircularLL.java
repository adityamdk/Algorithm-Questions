//Given a circular linked list, implement an algorithm which 
//returns node at the beginning of the loop 

package startingpointinacircularll;


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
    
    
    static node  detectLoop(node head)
    {
        node slow = head, fast = head,cur = null;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Found loop at "+slow.data);
                return slow;
            }
        }
        return cur;
    }
    
    static void findStartingPoint(node head)
    {
        node cur = null;
        node ptr = head;
        if(head == null)return;
        else
        {
           cur = detectLoop(head);
           if(cur!=null)
           {
               while(cur!=ptr)
               {
                   ptr = ptr.next;
                   cur = cur.next;
               }
               System.out.println("the starting point of the circular list is "+cur.data);
           }
        }
    }
    
}



public class StartingPointInACircularLL {

    public static void main(String[] args) {
        
        node root = new node(1);
        root.next = new node(2);
        root.next.next = new node(3);
        root.next.next.next = new node(4);
        root.next.next.next.next  = new node(5);
        root.next.next.next.next.next = root.next;
        //root.printnodes(root);

        root.findStartingPoint(root);
    }
    
}
