
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String a,String b)
    {
        int pos1,pos2=-1;
        System.out.println("a is "+a+"\n b is "+b);
        pos1=b.indexOf(a);
        
        if(pos1!=-1)
        pos2=b.indexOf(a,pos1+a.length());
        
        if(pos1!=-1 && pos2!=-1)
        return true;
        
        return false;
    }
    public void testing()
    {
        System.out.println(twoOccurrences("asd","fsgasdasd"));
        System.out.println(twoOccurrences("asudg","fsgasdasd"));
        
        System.out.println(String.format("The part of the string after %s in %s is %s.","an","banana",lastPart("an","banana")));
        System.out.println(String.format("The part of the string after %s in %s is %s.","zoo","forest",lastPart("zoo","forest")));
    }
    
    public String lastPart(String a,String b)
    {
        System.out.println("a is "+a+"\n b is "+b);
        int pos;
        pos=b.indexOf(a);
        if(pos==-1)
        return b;
        
        return b.substring(pos+a.length());
        
    }
}
