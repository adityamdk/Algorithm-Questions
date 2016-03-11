//Program to find any string in a given directory 
package findingfilesindirectory;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FindingFilesInDirectory {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        //Path fileDirectory = Paths.get("files");
        Path fileDirectory = Paths.get(path);
        
        System.out.println("Current Directory "+fileDirectory);
       // Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word to be found in the directory");
        String word = sc.nextLine();
        
        FileFinder finder = new FileFinder("file1.txt",word);
        try
        {
            Files.walkFileTree(fileDirectory,finder);
            System.out.println("************************************************************"); 
                   System.out.println("Word found in following files:");
            Iterator<String> it = finder.FinalOutput.iterator();
            while(it.hasNext())
            {
                System.out.println(it.next());
            }
            System.out.println("");
            System.out.println("************************************************************");
           
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
      //  ArrayList<Path> foundFiles = finder.pathsFound;
		
	    
    }
    
}
