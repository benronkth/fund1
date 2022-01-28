package decide;

import org.junit.Test;
import static org.junit.Assert.*;
import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC7;

public class LIC7Test {

    // Test cases for false
    @Test
    public void pointsArrayHasTwoElements() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 1;
        Point[] points = new Point[2];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 2);

        LIC7 lic7 = new LIC7();
        assertFalse(lic7.compute(points, parameters));
    }

    @Test
    public void distanceLessThanLENGTH1() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 2;
        parameters.K_PTS = 1;
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 1);

        LIC7 lic7 = new LIC7();
        assertFalse(lic7.compute(points, parameters));
    }

    @Test
    public void distanceExactlyLENGTH1() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 1;
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 1);

        LIC7 lic7 = new LIC7();
        assertFalse(lic7.compute(points, parameters));
    }

    @Test
    public void secondDistanceExactlyLENGTH1() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 2;
        parameters.K_PTS = 1;
        Point[] points = new Point[4];
        points[0] = new Point(0, 1);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 1);
        points[3] = new Point(0, 2);

        LIC7 lic7 = new LIC7();
        assertFalse(lic7.compute(points, parameters));
    }

    @Test
    public void distanceExactlyLENGTH1LargeKPTS() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 2;
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 3);
        points[2] = new Point(0, 3);
        points[3] = new Point(0, 1);

        LIC7 lic7 = new LIC7();
        assertFalse(lic7.compute(points, parameters));
    }

    // Test cases for true
    @Test
    public void distanceGreaterThanLENGTH1() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 1;
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 2);

        LIC7 lic7 = new LIC7();
        assertTrue(lic7.compute(points, parameters));
    }

    @Test
    public void secondDistanceGreaterThanLENGTH1() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 1;
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 1);
        points[3] = new Point(0, 2);

        LIC7 lic7 = new LIC7();
        assertTrue(lic7.compute(points, parameters));
    }

    @Test
    public void distanceGreaterThanLENGTH1LargeKPTS() {
        Parameters parameters = new Parameters();
        parameters.LENGTH1 = 1;
        parameters.K_PTS = 2;
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 3);
        points[2] = new Point(0, 3);
        points[3] = new Point(0, 2);

        LIC7 lic7 = new LIC7();
        assertTrue(lic7.compute(points, parameters));
    }
}