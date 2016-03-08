//Program to find files in a given directory 
package findingfilesindirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FindingFilesInDirectory {
    public static void main(String[] args) throws IOException {
        
        Path fileDirectory = Paths.get("files");
        System.out.println("File to be found is \"file1.txt\"");
        FileFinder finder = new FileFinder("file1.txt");
        Files.walkFileTree(fileDirectory,finder);
        
	ArrayList<Path> foundFiles = finder.pathsFound;
		
	if (foundFiles.size() > 0) 
        {
            for (Path path : foundFiles)
            {
                System.out.println("Path to file is"+path.toRealPath(LinkOption.NOFOLLOW_LINKS));
            }
	}
	else 
        {
            System.out.println("No files were found!");
	}
        
    }
    
}
