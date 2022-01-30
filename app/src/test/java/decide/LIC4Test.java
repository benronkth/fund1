package decide;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC4;

import static org.junit.Assert.*;

public class LIC4Test {
    

    // Tests that should return false
    @Test public void computationWherePointArrayIsEmpty() {
        
        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 1; 
        parameters.Q_PTS = 2;
        Point[] emptyPoints = {};

        assertFalse(lic4.compute(emptyPoints, parameters));
    }

    @Test public void computationWherePointArrayHas1Element() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 3;  
        parameters.Q_PTS = 2;
        Point[] points = {new Point(1, 1)};

        assertFalse(lic4.compute(points, parameters));
    }
    
     
    @Test public void computationWherePointArrayHas3ElementButThereAreNo4ConsecutivePoints() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 1;  
        parameters.Q_PTS = 4;
        Point[] points = {new Point(1, 1),new Point(-1, -1),new Point(-1, 0)};

        assertFalse(lic4.compute(points, parameters));
    }

    
    @Test public void computationWherePointArrayHas10ElementInDifferentQuadsButThePointsAreNotConsecutive() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 3;  
        parameters.Q_PTS = 4;
        Point[] points = {new Point(2, 2),new Point(1, 1),new Point(0, 0),
                          new Point(-1, -1),new Point(-2, -2),new Point(-3, -3),
                          new Point(-1, 1),new Point(-2, 2),new Point(-3, 3), new Point(3, -3)};

        assertFalse(lic4.compute(points, parameters));
    }
    
    // Tests that should return true
    @Test public void computationWherePointsAreInQuadrant1And3() {
        
        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 1; 
        parameters.Q_PTS = 5;
        Point points[] = new Point[20];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(10 - i, 10 - i);
        }

        assertTrue(lic4.compute(points, parameters));
    }

    
    @Test public void computationWherePointsAreInQuadrant2And4() {
        
        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 2; 
        parameters.Q_PTS = 5;
        Point points[] = new Point[20];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(- 10 + i, 10 - i);
        }
 
        assertTrue(lic4.compute(points, parameters));
    }

    @Test public void computationWherePointArrayHas2Element() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 1;  
        parameters.Q_PTS = 2;
        Point[] points = {new Point(1, 1),new Point(-1, -1)};

        assertTrue(lic4.compute(points, parameters));
    }

    @Test public void computationWherePointArrayHas100ElementIn4Quadrants() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 3;  
        parameters.Q_PTS = 100;
        Point[] points = new Point[100];
        for (int i = 0; i < 25; i++) {
            // First Quadrant
            points[i] = new Point(1+i, 1+i);
        }
        for (int i = 25; i < 50; i++) {
            // Third Quadrant
            points[i] = new Point(-1-i, -1-i);
        }
        
        
        for (int i = 50; i < 75; i++) {
            // Second Quadrant
            points[i] = new Point(-1-i, 1+i);
        }
        for (int i = 75; i < 100; i++) {
            // Second Quadrant
            points[i] = new Point(1+i,-1-i);
        }
        assertTrue(lic4.compute(points, parameters));
    }
    
    @Test public void computationWherePointArrayHas100ElementWithQ_PTS51In3Quadrants() { 

        LIC4 lic4 = new LIC4();
        Parameters parameters = new Parameters();
        parameters.QUADS = 2;  
        parameters.Q_PTS = 51;
        Point[] points = new Point[100];
        for (int i = 0; i < 25; i++) {
            // First Quadrant
            points[i] = new Point(1+i, 1+i);
        }
        for (int i = 25; i < 50; i++) {
            // Third Quadrant
            points[i] = new Point(-1-i, -1-i);
        }
        
        
        for (int i = 50; i < 75; i++) {
            // Second Quadrant
            points[i] = new Point(-1-i, 1+i);
        }
        for (int i = 75; i < 100; i++) {
            // Second Quadrant
            points[i] = new Point(1+i,-1-i);
        }
        assertTrue(lic4.compute(points, parameters));
    }


}
