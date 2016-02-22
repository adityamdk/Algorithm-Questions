//Implement a queue using two stacks
package queueusingtwostacks;

import java.util.Stack;

class ModQueue
{
 Stack<Integer> mystack1 = new Stack<>();
 Stack<Integer> mystack2 = new Stack<>();
 
 void enqueue(int data)
 {
     System.out.println("Adding element "+data);
     mystack1.push(data);
 }
 
 
 int dequeue()
 {
     int x;
     if(mystack1.isEmpty() && mystack2.isEmpty())
     {
         System.out.println("Queue is empty");
         return -1;
     }
     if(mystack2.isEmpty())
     {
         while(!mystack1.isEmpty())
         {
             x = mystack1.pop();
             mystack2.push(x);
         }
     }
     x = mystack2.pop();
     System.out.println("Removing element "+x);
     return x;
 }
 
}



public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        ModQueue queue = new ModQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        
    }
    
}
