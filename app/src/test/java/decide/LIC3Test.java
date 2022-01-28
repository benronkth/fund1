package decide;

import org.junit.Test;
import static org.junit.Assert.*;
import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC3;

public class LIC3Test {

    // Test cases for false
    @Test
    public void pointsArrayHasTwoElements() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 10;
        Point[] points = new Point[2];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 2);

        LIC3 lic3 = new LIC3();
        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void colinearPoints() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 0;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 2);
        points[2] = new Point(1, 3);

        LIC3 lic3 = new LIC3();
        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleLessThanArea() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 10;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(1, 5);

        LIC3 lic3 = new LIC3();
        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleExactlyArea() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 1;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(1, 3);

        LIC3 lic3 = new LIC3();
        assertFalse(lic3.compute(points, parameters));
    }

    @Test
    public void triangleNonConsecutiveGreaterThanArea() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 3;
        Point[] points = new Point[4];
        points[0] = new Point(1, 1);
        points[1] = new Point(3, 3);
        points[2] = new Point(3, 3);
        points[3] = new Point(1, 5);

        LIC3 lic3 = new LIC3();
        assertFalse(lic3.compute(points, parameters));
    }

    // Test cases for true
    @Test
    public void triangleGreaterThanArea() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 3;
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(3, 3);
        points[2] = new Point(1, 5);

        LIC3 lic3 = new LIC3();
        assertTrue(lic3.compute(points, parameters));
    }

    @Test
    public void triangleLastPointsGreaterThanArea() {
        Parameters parameters = new Parameters();
        parameters.AREA1 = 3;
        Point[] points = new Point[4];
        points[0] = new Point(3, 3);
        points[1] = new Point(1, 1);
        points[2] = new Point(3, 3);
        points[3] = new Point(1, 5);

        LIC3 lic3 = new LIC3();
        assertTrue(lic3.compute(points, parameters));
    }

}
