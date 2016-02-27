//A program which implements hashmap internal working with arrayList.
package customhashmap;

import java.util.ArrayList;
 //Creating a bucket class which holds all the elements of the hashmap as key value pair.
class MyBucket<T,P>
{
    T key;
    P value;
    MyBucket next;
  
    MyBucket(T key, P val)
    {
        this.value = val;
        this.key = key;
        next = null;
    }
}
public class CustomHashMap<T,P> {

    private ArrayList <MyBucket>hashList;
    private int HASH_SIZE = 100;
    public CustomHashMap()
    {
        hashList = new ArrayList<MyBucket>();
        //initializing the contents of hash map.
        for(int i =0;i<HASH_SIZE;i++)
        {
            hashList.add(new MyBucket(null,null));
        }
    }
    
    public void put(T key, P val)
    {
        int hashcode = key.hashCode();
        hashcode = hashcode % HASH_SIZE;                
        MyBucket ob = hashList.get(hashcode);
        while(ob.next!=null)
        {
            //updating the value to the most recent one for a given key.
            if(ob.next.key.equals(key))
            {
                ob.next.value=val;return;
            }
            ob = ob.next;
        }
        ob.next = new MyBucket(key,val);        
     }
    
    public P get(T key)
    {
        int hashcode = key.hashCode();
        hashcode = hashcode % HASH_SIZE;
        MyBucket ob = hashList.get(hashcode);
        if(ob.next == null) return null;
        
        while(ob.next != null)
        {
            if(ob.next.key.equals(key))
            {
                return (P) ob.next.value;
            }
            ob = ob.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        CustomHashMap <Integer,String> customHashMap = new CustomHashMap<Integer,String>();
        customHashMap.put(5, "US");
        customHashMap.put(5, "India");
        customHashMap.put(15, "England");   
        System.out.println("Value for the key 15 is "+customHashMap.get(15));
        System.out.println("Value for the key 5 is "+customHashMap.get(5));
       
    }
}