package decide;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC6;

public class LIC6Test {
    
    @Test public void falseWhenZeroPoints() {
        Point[] points = new Point[0];
        Parameters params = new Parameters();
        LIC6 lic = new LIC6();
        boolean result = lic.compute(points, params);
        assertFalse("False when 0 points", result);
    }

    @Test public void falseWhenTwoPoints() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(2, 2),
        };
        Parameters params = new Parameters();
        LIC6 lic = new LIC6();
        boolean result = lic.compute(points, params);
        assertFalse("False when < 3 points", result);
    }

    @Test public void falseWhen0Distance() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 0;
        LIC6 lic = new LIC6();
        boolean result = lic.compute(points, params);
        assertFalse("False when distance <= DIST", result);
    }

    @Test public void falseWhenLesserThanDistance() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 3;
        LIC6 lic = new LIC6();
        //Distance will be 3/2 * sqrt(2) ~= 2.14....
        boolean result = lic.compute(points, params);
        assertFalse("False when distance < DIST", result);
    }

    @Test public void falseWhenEqualDistance() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = (3.0/2.0) * Math.sqrt(2);
        LIC6 lic = new LIC6();
        //Distance will be 3/2 * sqrt(2) ~= 2.14....
        boolean result = lic.compute(points, params);
        assertFalse("False when distance == DIST", result);
    }

    @Test public void trueWhenGreaterDistance() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = (3.0/2.0) * Math.sqrt(2) - 0.001;
        LIC6 lic = new LIC6();
        //Distance will be 3/2 * sqrt(2) ~= 2.14....
        boolean result = lic.compute(points, params);
        assertTrue("Ture when distance > DIST", result);
    }

    @Test public void useEuclidianDistanceWhenCoinciding() {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(1, 1),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 2.99;
        LIC6 lic = new LIC6();
        boolean result = lic.compute(points, params);
        assertTrue("Uses euclidian distance when line points coinciding", result);
    }
}
