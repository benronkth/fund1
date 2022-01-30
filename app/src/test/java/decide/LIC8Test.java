package decide;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point; 
import decide.lic.LIC8;

import static org.junit.Assert.*;

public class LIC8Test {
    
    
    // True cases

    @Test
    public void computationWherePointsAreOutsideCircleOfRadius10() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 1;
        parameters.B_PTS = 2;
        parameters.RADIUS1 = 5;
        Point[] points = new Point[7];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 3);
        points[4] = new Point(14, 0);
        points[5] = new Point(40, 0);
        points[3] = new Point(4, 0);
        points[6] = new Point(4, 80);
 
        assertTrue(lic8.compute(points, parameters));
    }

    @Test
    public void computationWherePointArrayLenghtIs100() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 18;
        parameters.B_PTS = 15;
        parameters.RADIUS1 = 5;
        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i*i, i%25);
        } 
 
        assertTrue(lic8.compute(points, parameters));
    }


    
    // False cases
    
    @Test
    public void computationWherePointsAreInsideACircleOfRadius10() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 1;
        parameters.B_PTS = 3;
        parameters.RADIUS1 = 10;
        Point[] points = new Point[7];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 3);
        points[3] = new Point(14, 0);
        points[4] = new Point(40, 0);
        points[5] = new Point(4, 80);
        points[6] = new Point(4, 0);
 
        assertFalse(lic8.compute(points, parameters));
    }

     
    @Test
    public void computationWhereRadiusIsZero() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 1;
        parameters.B_PTS = 3;
        parameters.RADIUS1 = 0;
        Point[] points = new Point[7];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 3);
        points[3] = new Point(14, 0);
        points[4] = new Point(40, 0);
        points[5] = new Point(4, 80);
        points[6] = new Point(4, 0);
 
        assertTrue(lic8.compute(points, parameters));
    }

    
    @Test
    public void computationWherePointsArrayHasLength4() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 1;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 10;
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(1, 1);
        points[3] = new Point(1, 0);
 
        assertFalse(lic8.compute(points, parameters));
    }

    
    
    @Test
    public void computationWherePointsAreInTheSamePoint() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 5;
        parameters.B_PTS = 5;
        parameters.RADIUS1 = 1;
        Point[] points = new Point[20];
        for (int i = 0; i < points.length; i++) {
            
            points[i] = new Point(2, 2);
        } 
 
        assertFalse(lic8.compute(points, parameters));
    }

    
    @Test
    public void computationWherePointsAreOnCircleOfRadius10() {
        LIC8 lic8 = new LIC8();
        Parameters parameters = new Parameters();
        parameters.A_PTS = 1;
        parameters.B_PTS = 2;
        parameters.RADIUS1 = 5;
        Point[] points = new Point[7];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 3);
        points[4] = new Point(0, 0);
        points[5] = new Point(0, 0);
        points[3] = new Point(4, 0);
        points[6] = new Point(0, 0);
 
        assertFalse(lic8.compute(points, parameters));
    }

    
}
