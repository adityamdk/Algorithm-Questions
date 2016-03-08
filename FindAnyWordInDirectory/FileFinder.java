package findingfilesindirectory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;

public class FileFinder extends SimpleFileVisitor<Path> {
private PathMatcher matcher;
public String word = "";
public ArrayList<Path> pathsFound = new ArrayList<>();

public FileFinder(String pattern,String words)
{
    matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);   
    word = words;
}
	
@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		Path name = file.getFileName();
                String fileName = file.normalize().toString();
               
		System.out.println("Examining " + name);
		if (matcher.matches(name)) {
			pathsFound.add(file);
                        
		}
                try
                {    
                    Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
                    while(sc.hasNext())
                    {
                        String token = sc.next();
                        if(token.equalsIgnoreCase(word))
                        {
                            System.out.println("Word Found in "+fileName); 
                        }
                    }
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("inside catch"); 
                    e.printStackTrace();
                }
                
		return FileVisitResult.CONTINUE;
	}	
}
