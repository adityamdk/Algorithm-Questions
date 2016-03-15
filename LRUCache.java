//Program which implements LRU(Least Recently Used) Cache
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;



public class LRUCache {
    //Using linked hashmap to retain the insertion order in HashMap
    LinkedHashMap <Integer,String>MyLinkedHashMap;
    Integer capacity;
    //constructor 
    public LRUCache(int capacity) {
        MyLinkedHashMap = new LinkedHashMap(capacity);        
        this.capacity = new Integer(capacity);
    }
    
    //Used to retrieve the contents of a page and thus add it considering it as being accessed
    public String get(int key) {
        
        if(MyLinkedHashMap.containsKey(key))
        {
            String val = MyLinkedHashMap.get(key);
            MyLinkedHashMap.remove(key);
            MyLinkedHashMap.put(key, val);
            return val;
        }
        else
        {
            return null;
        }
    }
    //Used to add new elements to the LRU cache
    public void set(int key, String value) {
        if(MyLinkedHashMap.containsKey(key))
        {
            MyLinkedHashMap.remove(key);
            MyLinkedHashMap.put(key, value);
        }
        else
        {
           //remove the 1st element of hashmap since this is the least recently used page 
           if(MyLinkedHashMap.size() >= capacity )
           {               
               Set s = MyLinkedHashMap.keySet();               
               Iterator it = s.iterator();            
               MyLinkedHashMap.remove(it.next());
               MyLinkedHashMap.put(key, value);             
           }
           else
           {
               MyLinkedHashMap.put(key, value);
           }
    }
       
  }
     public void displayContents()
        {
            Set s =  MyLinkedHashMap.keySet();               
            Iterator it = s.iterator();   
            while(it.hasNext())
            {
                Integer key = (Integer)it.next();
                String value = MyLinkedHashMap.get(key);
                System.out.println(value);
            }   
        }

    public static void main(String[] args) {
        System.out.println("Program to implement LRU caching operations");
        LRUCache lru = new LRUCache(4);//considering cache of size 4
        lru.set(1, "Page 1");
        lru.set(2, "Page 2");
        lru.set(3, "Page 3");
        lru.set(4, "Page 4");
        System.out.println("Initial Contents in a LRU cache of size 4");
        lru.displayContents();
        System.out.println("After adding a new page");
        
        lru.set(5, "Page 5");
        lru.displayContents();
        System.out.println("After adding an existing page");
        lru.set(4, "Page 4");
        lru.displayContents();
         
    }
    
}
