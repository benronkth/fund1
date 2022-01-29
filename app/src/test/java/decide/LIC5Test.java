package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC5;

import org.junit.Test;
import static org.junit.Assert.*;

public class LIC5Test {

    // False test 1
    @Test public void lic5FalseSetOf2Points (){
        // Points
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point[] points = {p1, p2};
        // Test
        LIC5 LIC = new LIC5();
        Parameters parameters = new Parameters();
        assertFalse("False test case with set of 2 points", LIC.compute(points, parameters));
    }

    // False test 2
    @Test public void lic5FalseSetOf4Points (){
        // Points
        Point p1 = new Point(0,5);
        Point p2 = new Point(1,4);
        Point p3 = new Point(1.1,6);
        Point p4 = new Point(3,1);
        Point[] points = {p1, p2, p3, p4};
        // Test
        LIC5 LIC = new LIC5();
        Parameters parameters = new Parameters();
        assertFalse("False test case with set of 4 points", LIC.compute(points, parameters));
    }

    // False test 3 - Edge case
    @Test public void lic5FalseSetOf2PointsEdgeCaseSameXCoordinate (){
        // Points
        Point p1 = new Point(0,5);
        Point p2 = new Point(0,4);
        Point[] points = {p1, p2};
        // Test
        LIC5 LIC = new LIC5();
        Parameters parameters = new Parameters();
        assertFalse("False test case with set of 2 points, edge case, same x coordinate", LIC.compute(points, parameters));
    }

    // True test 1
    @Test public void lic5TrueSetOf2Points (){
        // Points
        Point p1 = new Point(1,0);
        Point p2 = new Point(0,0);
        Point[] points = {p1, p2};
        // Test
        LIC5 LIC = new LIC5();
        Parameters parameters = new Parameters();
        assertTrue("True test case with set of 2 points", LIC.compute(points, parameters));
    }

    // True test 2
    @Test public void lic5TrueSetOf4PointsLast2FollowCondition (){
        // Points
        Point p1 = new Point(0,5);
        Point p2 = new Point(1,4);
        Point p3 = new Point(2,6);
        Point p4 = new Point(-1,1);
        Point[] points = {p1, p2, p3, p4};
        // Test
        LIC5 LIC = new LIC5();
        Parameters parameters = new Parameters();
        assertTrue("True test case with set of 4 points, last 2 such that x4-x3<0", LIC.compute(points, parameters));
    }
}
