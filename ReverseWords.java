/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversewords;

import java.util.Scanner;

/**
 *
 * @author ADITYAMD
 */
public class ReverseWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String scan = in.nextLine();
        String splitted[] = scan.split(" ");
        int j =0;
        
        //for(String sc:splitted)
        //    System.out.println(sc);
        
        
        String[] ulta = new String[splitted.length];
        for(int i =(splitted.length-1);i>=0;i--)
        { 
             System.out.println("i"+i);
             ulta[j] =   splitted[i];
          //System.out.println("i is"+i+"\n value is "+splitted[i]+"\n ulta"+ ulta[j]);
             j++;     
        }
        String reverse = "";
        for(String sc:ulta)
            reverse =reverse+" "+sc;
            //System.out.println(sc);
        System.out.println("Reverse String is  "+reverse+" ");        
    }
    
}
