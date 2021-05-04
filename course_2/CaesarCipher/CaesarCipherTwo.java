
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1,key2;
    
    
    public CaesarCipherTwo(int key1,int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key1=key1;
        this.key2=key2;
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
    }
    
    public String encrypt(String input) {
       
        StringBuilder encrypted = new StringBuilder(input);
        
        for(int i = 0; i < encrypted.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            encrypted=changeOneChar(encrypted,shiftedAlphabet1,i);
            
            if(i+1<encrypted.length())
            encrypted=changeOneChar(encrypted,shiftedAlphabet2,i+1);
        }
        System.out.println(encrypted);
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    private StringBuilder changeOneChar(StringBuilder encrypted,String shifted,int i){
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shifted.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            
            return encrypted;
    }
    
    public String decrypt(String input){
    
        CaesarCipherTwo obj=new CaesarCipherTwo(26-this.key1,26-this.key2);
        return obj.encrypt(input);
    }
}
