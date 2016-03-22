package webcrawlerimplemented;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider 
{
    private ArrayList<String>FinalResult = new ArrayList<>();
    private static final int MAX_PAGES = 10;
    public static int count = 0;
    private Set<String> pageVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<>();

    // function to search for a word  
    public void search(String url,String searchWord) throws IOException
    {
        
        while(pageVisited.size()<MAX_PAGES)
        {
            String currentPageURL;
            SpiderLeg leg = new SpiderLeg();
            if(pagesToVisit.isEmpty())
            {
                currentPageURL = url;
                pageVisited.add(url);
            }
            else
            {
                currentPageURL = this.nextUrl();
            }
            leg.crawl(currentPageURL);
            boolean success = leg.searchForWord(searchWord);
            if(success)
            {
                //System.out.println("String "+searchWord+" found in page "+currentPageURL);
                //String words = "String "+searchWord+" found in page "+currentPageURL;
              //  System.out.println("Adding *********"+ words);
                FinalResult.add("String "+searchWord+" found in page "+currentPageURL);
                count++;
            }
            pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println("\nDone: Total number of pages Visited "+pageVisited.size());
    }
    //Returns the next URL to visit (in the order that they were found). We also do a check to make 
    //sure this method doesn't return a URL that has already been visited.
    private String nextUrl()
    {
        String nextUrl;
        do
        {
            nextUrl = pagesToVisit.remove(0);
        }    
        while(pageVisited.contains(nextUrl));
        pageVisited.add(nextUrl);
        return nextUrl;
    }
    public void output()
    {
        Iterator it = FinalResult.iterator();
        int i=0;
        while(it.hasNext() && i<count)
        {
          
            i++;
            System.out.println(it.next());
        }
    }
    
}
