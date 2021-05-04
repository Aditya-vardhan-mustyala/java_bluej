import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String slice="";
        for(int i=whichSlice;i<message.length();i+=totalSlices)
        slice+=message.charAt(i);
        //System.out.println(slice);
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker[] ciphers = new CaesarCracker[klength];
        for (int i = 0; i < klength; i++) {
            ciphers[i] = new CaesarCracker(mostCommon);
            String msg=sliceString(encrypted,i,klength);
            key[i]=ciphers[i].getKey(msg);
            //System.out.println(key[i]);
        }
        //WRITE YOUR CODE HERE
        
        return key;
    }

    public void breakVigenere () {
        FileResource fr =new FileResource();
        String message=fr.asString();
        
        DirectoryResource dir =new DirectoryResource();
        HashMap<String,HashSet<String>> languages=new HashMap<String,HashSet<String>>();
        for(File f:dir.selectedFiles()){
            FileResource tr =new FileResource(f);
            HashSet<String> allwords=readDictionary(tr);
            languages.put(f.getName(),allwords);
          
        }
        
        
        
        breakForAllLangs(message,languages);
        
        //int[] key=tryKeyLength(message,5,'e');
        //VigenereCipher vc=new VigenereCipher(key);
        //String result=vc.decrypt(message);
        System.out.println("");
        
    }
    
    public HashSet<String> readDictionary(FileResource fr){
    
        HashSet<String> words=new HashSet<String>();
        for(String line:fr.lines()){
        
            line=line.toLowerCase();
            words.add(line);
            
        }
        return words;
    }
    
    public int countWords(String message,HashSet<String> dictionary){
    
        String[] allwords=message.split("\\W+");
        int count=0;
        for(String word:allwords){
            if(dictionary.contains(word.toLowerCase()))
            count++;
        }
        System.out.println(count);
        return count;
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
        String ans="";
        int max=0;
        for(int klen=1;klen<101;klen++){
            
            char mostcommon=mostCommonCharIn(dictionary);
            int[] key=tryKeyLength(encrypted,klen,mostcommon);
            VigenereCipher vc=new VigenereCipher(key);
            String result=vc.decrypt(encrypted);
            int count=countWords(result,dictionary);
            if(count>max){
            max=count;
            ans=result;
            }
        }
        return ans;
        
    }
    
    public char mostCommonCharIn(HashSet<String> dict){
    
        long[] freq=new long[26];
        Iterator<String> i=dict.iterator();  
        while(i.hasNext()){
            String word=i.next();
            for(int k=0;k<word.length();k++){
            
                char ch=word.charAt(k);
                ch=Character.toLowerCase(ch);
                if(Character.isAlphabetic(ch)){
                    int ind=(int)(ch-'a');
                    freq[ind]++;
                }
                
            }

        }  
        long max=0;
        int ind=-1;
        for(int k=0;k<freq.length;k++){
        
            if(freq[k]>max){
            
                max=freq[k];
                ind=k;
            }
        }
        
        
        return (char)(ind+65);
    }
    
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
    
        int max=0;
        String result="",final_lang="";
        for(String lang:languages.keySet()){
            String msg=breakForLanguage(encrypted,languages.get(lang));
            int count=countWords(encrypted,languages.get(lang));
            if(count>max){
            
                max=count;
                result=msg;
                final_lang=lang;
            }
        }
        System.out.println("language "+final_lang);
        System.out.println(result);
    }
}
