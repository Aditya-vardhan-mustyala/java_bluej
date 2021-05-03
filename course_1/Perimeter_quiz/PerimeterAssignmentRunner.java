import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int c=0;
        for (Point p:s.getPoints())
        {
            c++;
        }
        
        
        // Put code here
        return c;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double per=getPerimeter(s);
        int n=getNumPoints(s);
        double r=(double)(per/n);
        return r;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max=0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist>max)
            max=currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int maxx;
        Point p1=s.getLastPoint();
        maxx=p1.getX();
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            int x = currPt.getX();
            
            // Update totalPerim by currDist
            if(x>maxx)
            maxx=x;
            // Update prevPt to be currPt
            
        }
        return maxx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);  
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>max)
            max=length;
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; 
        DirectoryResource dr = new DirectoryResource();
        double max=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);  
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>max)
            max=length;
            temp=f;
            
        }
        // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        System.out.println("getNumPoints: "+getNumPoints(s));
         System.out.println("getAverageLength: "+getAverageLength(s));
         System.out.println("getLargestSide: "+getLargestSide(s));
         System.out.println("getLargestx: "+getLargestX(s));
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("getLargestPerimeterMultipleFiles: "+getLargestPerimeterMultipleFiles());
        
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("getFileWithLargestPerimeter: "+getFileWithLargestPerimeter());
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
