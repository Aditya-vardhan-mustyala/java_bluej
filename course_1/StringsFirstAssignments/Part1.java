
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String  findSimpleGene(String dna)
    {
        int srt_pos,end_pos;
        System.out.println("given dna is "+dna);
        srt_pos= dna.indexOf("ATG");
        if (srt_pos==-1)
        {
        System.out.println("no atg");
        return "";
    }
        
        end_pos=dna.indexOf("TAA",srt_pos+3);
        if (end_pos==-1){
        System.out.println("no taa");
        return "";}
        
        if((end_pos-srt_pos)%3==0){
            
        return dna.substring(srt_pos,end_pos+3);}
        
        else
        {System.out.println("not modulo 3 length");
        return "";}
        
             
    }
    
    public void  testSimpleGene()
    {
        System.out.println("GRDSFD => "+findSimpleGene("GRDSFD"));
    System.out.println("GRDSFDTAA => "+findSimpleGene("GRDSFDTAA"));
    System.out.println("GATGRDSFD => "+findSimpleGene("GATGRDSFD"));
    System.out.println("GATGRDSFDTTAA => "+findSimpleGene("GATGRDSFDTTAA"));
    System.out.println("GATGRDSFDTAA => "+findSimpleGene("GATGRDSFDTAA"));
}
    

}
