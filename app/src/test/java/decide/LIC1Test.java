package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC1;
import org.junit.Test;
import static org.junit.Assert.*;

public class LIC1Test {

    // False test 1
    @Test public void lic1FalseEmptySetOfPoints() {
        // Points
        Point[] points = {};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;
        LIC1 LIC = new LIC1();
        assertFalse("False test case with empty set of points", LIC.compute(points, parameters));
    }

    // False test 2
    @Test public void lic1FalseSetOf3Points() {
        // Points
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0.6,0.4);
        Point[] points = {p1, p2, p3};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;
        LIC1 LIC = new LIC1();
        assertFalse("False test case with set of 3 points", LIC.compute(points, parameters));
    }

    // False test 3
    @Test public void lic1FalseSetOf6Points() {
        // Points
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0.6,0.4);
        Point p4 = new Point(0.7,0.5);
        Point p5 = new Point(0.5,0.2);
        Point p6 = new Point(0,0.4);
        Point[] points = {p1, p2, p3, p4, p5, p6};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;
        LIC1 LIC = new LIC1();
        assertFalse("False test case with set of 6 points", LIC.compute(points, parameters));
    }

    // False test 4 - Edge case
    @Test public void lic1EdgeFalseSetOf3PointsOnCircleOfRADIUS1() {
        // Points
        Point p1 = new Point(-1,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0,1);
        Point[] points = {p1, p2, p3};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 2;
        LIC1 LIC = new LIC1();
        assertFalse("False edge test case with set of 3 points on a circle of radius RADIUS_1", LIC.compute(points, parameters));
    }

    // True test
    @Test public void lic1TrueSetOf3Points() {
        // Points
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Point p3 = new Point(2,2);
        Point[] points = {p1, p2, p3};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;
        LIC1 LIC = new LIC1();
        assertTrue("True test case with set of 3 points", LIC.compute(points, parameters));
    }

    // True test 2
    @Test public void lic1TrueSetOf6PointsLast3NotInCircleOfRADIUS1() {
        // Points (last 3 options cause LIC1 true)
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0.6,0.4);
        Point p4 = new Point(0.7,0.5);
        Point p5 = new Point(5,5);
        Point p6 = new Point(0,0.2);
        Point[] points = {p1, p2, p3, p4, p5, p6};
        // Params: radius1
        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;
        LIC1 LIC = new LIC1();
        assertTrue("True test case with set of 6 points, last 3 not in a circle of radius RADIUS_1", LIC.compute(points, parameters));
    }
}
