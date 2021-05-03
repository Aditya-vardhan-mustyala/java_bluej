
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna,String start_codon,String end_codon)
    {
        int srt_pos,end_pos;
        System.out.println("given dna is "+dna);
        String temp=dna.toUpperCase();
        start_codon=start_codon.toUpperCase();
        end_codon=end_codon.toUpperCase();
        
        srt_pos= dna.indexOf(start_codon);
        if (srt_pos==-1)
        {
        System.out.println("no atg");
        return "";
    }
        
        end_pos=dna.indexOf(end_codon,srt_pos+3);
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
        System.out.println(String.format("GRDSFD => %s",findSimpleGene("GRDSFD","ATG","TAA")));
    System.out.println(String.format("GRDSFDTAA => %s",findSimpleGene("GRDSFDTAA","ATG","TAA")));
        System.out.println(String.format("GATGRDSFD => %s",findSimpleGene("GATGRDSFD","ATG","TAA")));
    System.out.println(String.format("GATGRDSFDTTAA => %s",findSimpleGene("GATGRDSFDTTAA","ATG","TAA")));
    System.out.println(String.format("GATGRDSFDTAA  => %s",findSimpleGene("GATGRDSFDTAA","ATG","TAA")));
    
}
    

}
