/*Program to print all permutations of string
 */
package allpermutationsofstring;

public class AllPermutationsOfString {

   
    
    //Generates permutations of the string.
    static void  permute(String begin,String end)
    {
       if(end.length()<=1)
       {
           System.out.println(begin+end);
           
       }
       else
       {
           for(int i=0;i<end.length();i++)
           {
               try
               {
                   permute(begin+end.charAt(i),end.substring(0,i)+end.substring(i+1));
               }
               catch(StringIndexOutOfBoundsException e)
               {
                   e.printStackTrace();
               }
           }
       }
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
     
   
     String input = "ABCD"; 
   
    permute("",input);
    
    }
    
}
