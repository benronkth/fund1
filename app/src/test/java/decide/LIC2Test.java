package decide;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC2;

import static org.junit.Assert.*;

public class LIC2Test {

    // Negative test
    @Test public void computationWithNoPoints() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        Point[] points = {};
        boolean result = lic2.compute(points, params);
        assertFalse(result);
    }

    // Negative test
    @Test public void computationWith2Points() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
        };
        boolean result = lic2.compute(points, params);
        assertFalse(result);
    }

    // Negative test
    @Test public void computationWithCoincidingPoints() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(1, 1),
        };
        boolean result = lic2.compute(points, params);
        assertFalse(result);
    }

    // Negative Test, too big epsilon
    @Test public void computationWithBigEpsilon() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        params.EPSILON = Math.PI;
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1),
        };
        boolean result = lic2.compute(points, params);
        assertFalse(result);
    }

    // Negative Test, 180 degree angle can not be biggger than pi + epsilon or lesser than pi - epsilon
    @Test public void computationWith180DegreeAngle() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        params.EPSILON = 0;
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
        };
        boolean result = lic2.compute(points, params);
        assertFalse(result);
    }

    // Positive Test
    @Test public void computationWith90DegreeAngle() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        params.EPSILON = Math.PI / 4;
        Point[] points = {
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1),
        };
        boolean result = lic2.compute(points, params);
        assertTrue(result);
    }

    // Positive Test
    @Test public void computationWith45DegreeAngle() {
        LIC2 lic2 = new LIC2();
        Parameters params = new Parameters();
        params.EPSILON = Math.PI / 2;
        Point[] points = {
            new Point(1, 1),
            new Point(0, 0),
            new Point(0, 1),
        };
        boolean result = lic2.compute(points, params);
        assertTrue(result);
    }

}
