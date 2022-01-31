package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC11;

import org.junit.Test;
import static org.junit.Assert.*;

public class LIC11Test {

    // False test cases

    @Test
    public void pointsArrayHasTwoElements() {
        Point[] points = new Point[2];
        points[0] = new Point(1, 0);
        points[1] = new Point(0, 0);

        LIC11 lic11 = new LIC11();
        Parameters parameters = new Parameters();
        parameters.G_PTS = 1;
        assertFalse(lic11.compute(points, parameters));
    }

    @Test
    public void jGreaterThani() {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 0);
        points[2] = new Point(1, 0);

        LIC11 lic11 = new LIC11();
        Parameters parameters = new Parameters();
        parameters.G_PTS = 1;
        assertFalse(lic11.compute(points, parameters));
    }

    @Test
    public void jGreaterThaniLargeGap() {
        Point[] points = new Point[5];
        points[0] = new Point(1, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 0);
        points[3] = new Point(1, 0);
        points[4] = new Point(1, 0);

        LIC11 lic11 = new LIC11();
        Parameters parameters = new Parameters();
        parameters.G_PTS = 2;
        assertFalse(lic11.compute(points, parameters));
    }

    // True test cases
    @Test
    public void jLessThani() {
        Point[] points = new Point[3];
        points[0] = new Point(1, 0);
        points[1] = new Point(1, 0);
        points[2] = new Point(0, 0);

        LIC11 lic11 = new LIC11();
        Parameters parameters = new Parameters();
        parameters.G_PTS = 1;
        assertTrue(lic11.compute(points, parameters));
    }

    @Test
    public void jLessThaniLargeGap() {
        Point[] points = new Point[5];
        points[0] = new Point(2, 0);
        points[1] = new Point(1, 0);
        points[2] = new Point(0, 0);
        points[3] = new Point(2, 0);
        points[4] = new Point(0, 0);

        LIC11 lic11 = new LIC11();
        Parameters parameters = new Parameters();
        parameters.G_PTS = 2;
        assertTrue(lic11.compute(points, parameters));
    }
}
