package decide;

import org.junit.Test;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC9;

import static org.junit.Assert.*;

public class LIC9Test {

    // False test cases

    @Test
    public void computationWith2Points() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertFalse(result);
    }

    @Test
    public void computationWithCoincidingPoints() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 0),
                new Point(1, 1),
                new Point(0, 0),
                new Point(1, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertFalse(result);
    }

    @Test
    public void computationWithBigEpsilon() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.EPSILON = Math.PI;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(1, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertFalse(result);
    }

    @Test
    public void computationWith180DegreeAngle() {
        LIC9 lic9 = new LIC9();

        Parameters parameters = new Parameters();
        parameters.EPSILON = 0;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(-1, 0),
        };
        boolean result = lic9.compute(points, parameters);
        assertFalse(result);
    }

    // True test cases

    @Test
    public void computationWith90DegreeAngle() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.EPSILON = Math.PI / 4;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 1),
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertTrue(result);
    }

    @Test
    public void computationWith90DegreeAngleLargeGap() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.EPSILON = Math.PI / 4;
        parameters.C_PTS = 1;
        parameters.D_PTS = 2;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 1),
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 0),
                new Point(0, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertTrue(result);
    }

    @Test
    public void computationWith45DegreeAngleStartingSecondPoint() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.EPSILON = Math.PI / 2;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(1, 1),
        };
        boolean result = lic9.compute(points, parameters);
        assertTrue(result);
    }

    @Test
    public void computationWith315DegreeAngleLargeGap() {
        LIC9 lic9 = new LIC9();
        Parameters parameters = new Parameters();
        parameters.EPSILON = Math.PI / 2;
        parameters.C_PTS = 2;
        parameters.D_PTS = 1;
        Point[] points = {
                new Point(1, 0),
                new Point(0, 1),
                new Point(0, 1),
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, -1),
        };
        boolean result = lic9.compute(points, parameters);
        assertTrue(result);
    }

}
