/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*;
import java.io.File;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0,total_names=0;
        int totalBoys = 0,boys_names=0;
        int totalGirls = 0,girls_names=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boys_names++;
            }
            else {
                totalGirls += numBorn;
                girls_names++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        
        System.out.println("\n\ntotal names = " + total_names);
        System.out.println("female girls names = " + girls_names);
        System.out.println("male boys names = " + boys_names);
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data/yob2014.csv");
        totalBirths(fr);
    }
    
    public int getRank(FileResource fr,String name,String gender){
        int rank=1;
        //FileResource fr = new FileResource(String.format("data/yob%s.csv",year));
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)){
                
                if(rec.get(0).equals(name))
                return rank;
                
                rank++;   
            }   
        }
        return -1;
        
    }
    
    public String getName(FileResource fr,int rank,String gender)throws java.io.IOException{
        //FileResource fr = new FileResource(String.format("data/yob%s.csv",year));
        CSVParser cp=fr.getCSVParser(false);
        java.util.List<CSVRecord> rows=cp.getRecords();
        int girl_names=0;
        if(gender.equals("F")){
            return getNameAtRank(rank,gender,girl_names,rows);           
        }
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("M"))
            break;
            girl_names++;
        }
        return getNameAtRank(rank,gender,girl_names,rows);
    }
    
    public String getNameAtRank(int rank,String gender,int girl_names,java.util.List<CSVRecord> rows){
        CSVRecord row=rows.get(girl_names+rank-1);
        if(row.get(1).equals(gender))
        return row.get(0);
        else
        return "NO NAME"; 
        
    }
        
    public void whatIsNameInYear(String name,FileResource fr_old,FileResource fr_new,String gender)throws java.io.IOException{
        int rank=getRank(fr_old,name,gender);
        String newname=getName(fr_new,rank,gender);
        System.out.println(String.format("%s born in would be %s if she was born in .",name,newname));
            
    }
    
    public String yearOfHighestRank(String name,String gender){
        int year=0;
        String year_s="";
        DirectoryResource dr = new DirectoryResource();
        int min=-1;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int rank=getRank(fr,name,gender);
            if(rank<min){
            
                min=rank;
                year_s=f.getName();
                
            }
        
            
        }
        if(min==-1)
        return "-1";
        
        return year_s;
        
    }
    
    public Double getAverageRank(String name,String gender){
    
        DirectoryResource dr = new DirectoryResource();
        double avg=0;
        int count=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int rank=getRank(fr,name,gender);
            
            if(rank!=-1){
                avg+=rank;
                count++;
            }
            
        }
        if(count!=0)
        return avg/count;
        
        return -1.0;
        
    }
    
    public int getTotalBirthsRankedHigher(FileResource fr,String name,String gender){
        int count=0;
        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name))
                return count;
                count+=Integer.parseInt(rec.get(2));
            }
        }
        return -1;
    }
}
