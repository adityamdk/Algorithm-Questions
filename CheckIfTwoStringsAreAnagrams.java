//Write a method to decide if two strings are anagrams or not 
package checkiftwostringsareanagrams;

import java.util.Arrays;

public class CheckIfTwoStringsAreAnagrams {
    
    static boolean AreAnagram(String s1,String s2)
    {
        char array1[] = s1.toCharArray();
        char array2[] = s2.toCharArray();
        if(s1.length()!=s2.length())
            return false;
        //Sorting the input strings to compare
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        for(int i=0;i<s1.length()-1;i++)
        {
            if(array1[i]==array2[i])
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "mnaaarg";
        System.out.println("The strings to check if theya re anagrams are \""+s1+" and \" \""+s2+"\"");
        if(AreAnagram(s1,s2))
        {
            System.out.println("The given strings are \"anagrams\"");
        }
        else
        {
            System.out.println("The given strings are \"not anagrams\"");
        }    
        
    }
    
}
