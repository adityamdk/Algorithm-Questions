//Implemented a simple web crawler with search functionality

package webcrawlerimplemented;

import java.io.IOException;
import java.util.Scanner;

public class WebCrawlerImplemented {
    public static void main(String[] args) throws IOException {
            Spider mySpider = new Spider();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the seed URL to be crawled(eg:http://www.usc.edu)");
            String url = sc.nextLine();
            System.out.println("Enter the word to be searched");
            String word = sc.nextLine();
            mySpider.search(url,word);
            System.out.println("*************************************************************");
            System.out.println("Word found at :");
            mySpider.output();
            System.out.println("*************************************************************");
    }
    
}
