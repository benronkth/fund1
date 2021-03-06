package decide;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC0;

import static org.junit.Assert.*;

public class LIC0Test {
    
    LIC0 lic0 = new LIC0();
    Parameters parameters = new Parameters();

    // Tests that should return false
    @Test public void computationWherePointArrayIsEmpty() {
        parameters.LENGTH1 = 10;
        Point[] emptyPoints = {};

        assertFalse(lic0.compute(emptyPoints, parameters));
    }

    @Test public void computationWherePointArrayHas1Element() { 

        parameters.LENGTH1 = 10;
        Point point = new Point(1, 1);
        Point[] points = {point};

        assertFalse(lic0.compute(points, parameters));
    }

    
    @Test public void computationWhereLENGHT1IsZeroAndDistancesAreZeros() {
        
        Point points[] = new Point[5];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(0, 0);
        }
        parameters.LENGTH1 = 0; 

        assertFalse(lic0.compute(points, parameters));
    }

    @Test public void computationWherePointsAreNotConsecutiveButAreLENGHT1Apart () {
        
        Point points[] = new Point[5];
        // points[0] and points[4] are squart(128) apart which is more than 10
        // but because they are not consecutive the algorithm returns false.
        points[0] = new Point(2, 2);
        points[1] = new Point(4, 4);
        points[2] = new Point(6, 6);
        points[3] = new Point(8, 8);
        points[4] = new Point(10, 10); 

        parameters.LENGTH1 = 10; 
 
        assertFalse(lic0.compute(points, parameters));
    }
    
    // Tests that should return true
    @Test public void computationWhereDistanceIsGreaterThanLENGHT1() {
        
        Point points[] = new Point[2];
        points[0] = new Point(1, 1);
        parameters.LENGTH1 = 10;
        points[1] = new Point(points[0].x + parameters.LENGTH1 + 1, points[0].y + parameters.LENGTH1 +1);

        assertTrue(lic0.compute(points, parameters));
    }

   
    
    @Test public void computationWhereLENGHT1IsZero() {
        
        Point points[] = new Point[15];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i*i, i*i);
        }
        parameters.LENGTH1 = 0; 

        assertTrue(lic0.compute(points, parameters));
    }

}
