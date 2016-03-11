package findingfilesindirectory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
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
public ArrayList<String> FinalOutput = new ArrayList<>();
public FileFinder(String pattern,String words)
{
    
    matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);   
    word = words;
   // System.out.println("given pattern is "+word);
}
	
@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		Path name = file.getFileName();
                String fileName = file.normalize().toString();
               String line = "";
		System.out.println("Examining " + name);
		try
                {    
                    BufferedReader br = new BufferedReader(new FileReader(fileName));
                    Scanner sc = new Scanner(br);
                    
                    //to compare for lines
                    while ((line = br.readLine()) != null) {
                        
				if(line.toLowerCase().contains(word.toLowerCase()))
                                {
                                    FinalOutput.add(fileName);
                                }
			}
                    
                    
                }
                catch( java.nio.file.AccessDeniedException  e)
                {
                   System.out.println("inside catch"); 
                    e.printStackTrace();
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("inside catch"); 
                    e.printStackTrace();
                }
                
		return FileVisitResult.CONTINUE;
	}	
    
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}

}
