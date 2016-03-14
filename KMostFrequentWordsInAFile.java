//Program to print K most frequently occuring words in a file.
package kmostfrequentwordsinafile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KMostFrequentWordsInAFile {
    
    //function to get the count of each word in the file.
    public Map<String,Integer> getFileWordCount(String filename)
    {
        Map<String,Integer> fileWordCount = new HashMap<>();
        String line = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) 
                {
                    //tokenizing the line based on space
                    StringTokenizer st = new StringTokenizer(line," ");
                    while(st.hasMoreTokens())
                    {
                        String temp = st.nextToken().toLowerCase();
                        if(fileWordCount.containsKey(temp))
                        {
                            fileWordCount.put(temp, fileWordCount.get(temp)+1);
                        }
                        else
                        {
                            fileWordCount.put(temp,1);
                        }    
                    }
                }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException ex) {
               ex.printStackTrace();        
        }
        return fileWordCount;
    }
    
    //function to sort the hashmap based on value
    public List<Entry<String,Integer>> sortMapBasedOnValue(Map<String,Integer> map)
    {
        Set<Entry<String,Integer>> set = map.entrySet();
        List<Entry<String,Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>()
        {
            public int compare(Map.Entry<String,Integer> val1,Map.Entry<String,Integer> val2)
            {
                return (val2.getValue()).compareTo(val1.getValue());
            }
        });  
        return list;
    }
    
    
    public static void main(String[] args) {
        KMostFrequentWordsInAFile obj = new KMostFrequentWordsInAFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the filename whose k most occuring words is to be printed");
        String filename = sc.nextLine();
        Map<String,Integer> mymap = obj.getFileWordCount(filename);
        System.out.println("Enter the number k ");
        int k = sc.nextInt();
        List<Entry<String,Integer>> list = obj.sortMapBasedOnValue(mymap);
        Iterator<Entry<String,Integer>> it = list.iterator();
        int count = 0;
        System.out.println("Top k occuring words in file "+filename+" :");
        while(it.hasNext() && count<k)
        {
            Entry<String,Integer> temp;
            temp = it.next();
            System.out.println("Word is \""+temp.getKey()+"\" =====> Count is "+temp.getValue() );
            count++;
        }
    }
    
}
