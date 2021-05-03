/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
    
    public void tester(){
    
         FileResource fr = new FileResource();
	 CSVParser parser = fr.getCSVParser();
	    
	 System.out.println(countryInfo(parser,"Germany"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");

        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));

        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser,String country){
        for(CSVRecord rec:parser){
        
            if(rec.get("Country").equals(country))
            return String.format("%s : %s : %s",rec.get(0),rec.get(1),rec.get(2));
        }
        
        return "NOT FOUND";
    
        
    }
    
    public void listExportersTwoProducts(CSVParser parser,String export1,String export2){
        for(CSVRecord rec:parser){
            String exp=rec.get(1);
            if(exp.contains(export1) && exp.contains(export2))
            System.out.println(rec.get(0));
        }
        
        
    }
    
    public int numberOfExporters(CSVParser parser,String export){
    
        int count=0;
        for(CSVRecord rec:parser){
            String exp=rec.get(1);
            if(exp.contains(export))
            count++;
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser,String amount){
        int len=amount.length();
        for(CSVRecord rec:parser){
            if(rec.get(2).length()>len)
            System.out.println(rec.get(0)+" "+rec.get(2));
        }
        
    }
    
}