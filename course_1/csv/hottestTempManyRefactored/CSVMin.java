/**
 * Find the highest (hottest) temperature in any number of files of CSV weather data chosen by the user.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMin{

    public CSVRecord coldestHourInFile(CSVParser parser) {
        
        CSVRecord coldestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            coldestSoFar = getSmallOfTwo(currentRow, coldestSoFar);
        }
        System.out.println("coldest temperature was " + coldestSoFar.get("TemperatureF") +
                   " at " + coldestSoFar.get("TimeEST"));
        return coldestSoFar;
        
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        
    }

    public String fileWithColdestTemperature() {
        CSVRecord coldestSoFar = null;
        String name="";
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           
            
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp=0;
            if(coldestSoFar!=null)
            coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            
            if (coldestSoFar == null || currentTemp < coldestTemp  ) {
                coldestSoFar = currentRow;
                name=f.getName();
                
            }
        }
        
        return name;
    }

    public CSVRecord getSmallOfTwo (CSVRecord currentRow, CSVRecord coldestSoFar){
    
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double coldestTemp=0;
        if(coldestSoFar!=null)
        coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
        if (coldestSoFar == null || (currentTemp < coldestTemp && currentTemp!=-9999) ) {
            coldestSoFar = currentRow;
        }
        
        return coldestSoFar;  
    }
    
    public void testFileWithColdestTemperature() {
		String name= fileWithColdestTemperature();
		System.out.println("file with coldest temp is "+name);
	}
}
