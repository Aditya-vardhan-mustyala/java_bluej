
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;
public class Part4 {
    public void youtube()
    {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String line : ur.lines())
        {
            String temp=line;
            line=line.toLowerCase();
            int pos=line.indexOf("youtube.com");
            if(pos!=-1)
            {
                int srt,end;
                srt=line.indexOf("\"");
                end=line.lastIndexOf("\"",line.length());
                System.out.println("link is "+line.substring(srt,end));
            }
                     
            
        }
         
    }
}
