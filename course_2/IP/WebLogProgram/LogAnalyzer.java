
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records=new ArrayList<LogEntry>();
         // complete constructor
     }
        
     public void readFile(String filename) {
         FileResource fr=new FileResource();
         for(String line:fr.lines())
         records.add(WebLogParser.parseEntry(line));
        }
        
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
        HashSet<String> uni=new HashSet<String>();
         for(LogEntry rec:records){
            
             String t=rec.getIpAddress();
             if(!uni.contains(t))
             uni.add(t);
             
            }
            return uni.size();
        }
        
        
     
     
}
