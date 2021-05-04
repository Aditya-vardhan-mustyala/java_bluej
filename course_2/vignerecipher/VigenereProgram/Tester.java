import edu.duke.*;
/**
 * Write a description of TestCaesarCraker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public void testCaesarCraker(){
        CaesarCracker cc=new CaesarCracker();
        FileResource fr =new FileResource();
        String sr=fr.asString();
        System.out.println(cc.decrypt(sr));
        
        
    }
    
    public void testVigenereBreaker(){
    
        //VigenereBreaker obj =new VigenereBreaker();
        //obj.sliceString("abcdefghijklm", 0, 3);
        //obj.sliceString("abcdefghijklm", 1, 3);
        //obj.sliceString("abcdefghijklm", 2, 3);
        //obj.sliceString("abcdefghijklm", 0, 4);
        //obj.sliceString("abcdefghijklm", 3, 5);
        //obj.sliceString("abcdefghijklm", 4, 5);
        
        //VigenereBreaker obj2 =new VigenereBreaker();
        //FileResource fr =new FileResource();
        //String sr=fr.asString();
        //obj2.tryKeyLength(sr,5,'e');
        
        VigenereBreaker obj3 =new VigenereBreaker();
        obj3.breakVigenere();
        
    }

}
