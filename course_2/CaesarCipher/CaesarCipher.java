import edu.duke.*;

public class CaesarCipher {
    private String alphabet ;
    private String shiftedAlphabet;
    
    
    public CaesarCipher(int key){
    
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        
        System.out.println(alphabet);
        System.out.println(shiftedAlphabet);
    }
    
    public String encrypt(String input) {
       
        StringBuilder encrypted = new StringBuilder(input);
        
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        System.out.println(encrypted);
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
       
        StringBuilder decrypted = new StringBuilder(input);
        
        for(int i = 0; i < decrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = decrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = shiftedAlphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = alphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                decrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return decrypted.toString();
    }
    
    
}

