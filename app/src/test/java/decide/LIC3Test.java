package decide;

import org.junit.Test;
import static org.junit.Assert.*;
import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC3;

public class LIC3Test {

    LIC3 lic3 = new LIC3();
    Parameters parameters = new Parameters();

    // Test cases for false
    @Test
    public void pointsArrayHasTwoElements() {
        parameters.AREA1 = 10;
        Point[] points = new Point[2];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 2);

        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void colinearPoints() {
        parameters.AREA1 = 10;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 2);
        points[2] = new Point(1, 3);

        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleLessThanArea() {
        parameters.AREA1 = 10;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(1, 5);

        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleExactlyArea() {
        parameters.AREA1 = 1;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(1, 3);

        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleNonConsecutiveGreaterThanArea() {
        parameters.AREA1 = 3;
        Point[] points = new Point[4];
        points[0] = new Point(1, 1);
        points[1] = new Point(3, 3);
        points[2] = new Point(3, 3);
        points[3] = new Point(1, 5);

        assertFalse(lic3.compute(points, parameters));
    }

    // Test cases for true
    @Test
    public void triangleGreaterThanArea() {
        parameters.AREA1 = 3;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(3, 3);
        points[2] = new Point(1, 5);

        assertTrue(lic3.compute(points, parameters));
    }

    @Test
    public void triangleLastPointsGreaterThanArea() {
        parameters.AREA1 = 3;
        Point[] points = new Point[4];
        points[0] = new Point(3, 3);
        points[1] = new Point(1, 1);
        points[2] = new Point(3, 3);
        points[3] = new Point(1, 5);

        assertTrue(lic3.compute(points, parameters));
    }

}
