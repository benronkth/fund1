package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC10;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LIC10Test {

    // Negative test
    @Test public void lic10FalseSetOfLessThan5Points () {
        LIC10 LIC = new LIC10();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(5,3),
                new Point(-2,4)
        };
        // Parameters: AREA1, E_PTS, F_PTS
        parameters.AREA1 = 1;
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        assertFalse("False test case with set of 4 points", LIC.compute(points, parameters));
    }

    // Negative test
    @Test public void lic10FalseLargeGaps () {
        LIC10 LIC = new LIC10();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(5,3),
                new Point(-2,4)
        };
        // Parameters: AREA1, E_PTS, F_PTS
        parameters.AREA1 = 1;
        parameters.E_PTS = 3;
        parameters.F_PTS = 2;
        assertFalse("False test case, set of 4 points, too large gaps", LIC.compute(points, parameters));
    }

    // Negative test
    @Test public void lic10FalseAreasSmallerThanAREA1 () {
        LIC10 LIC = new LIC10();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(1,1),
                new Point(3,0),
                new Point(1,2),
                new Point(2,1),
                new Point(2,1)
        };
        // Parameters: AREA1, E_PTS, F_PTS
        parameters.AREA1 = 2;
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        assertFalse("False test case, set of 6 points, areas smaller than AREA1", LIC.compute(points, parameters));
    }

    // Positive test
    @Test public void lic10TrueAreaGreaterThanAREA1 () {
        LIC10 LIC = new LIC10();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(1,1),
                new Point(0,0),
                new Point(1,2),
                new Point(3,0),
                new Point(2,1),
                new Point(0,4)
        };
        // Parameters: AREA1, E_PTS, F_PTS
        parameters.AREA1 = 2;
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        assertTrue(LIC.compute(points, parameters));
    }

    // Positive test
    @Test public void lic10TrueAreaGreaterThanAREA1LargerGaps () {
        LIC10 LIC = new LIC10();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(1,1),
                new Point(-1,1),
                new Point(3,0),
                new Point(2,1),
                new Point(0,4)
        };
        // Parameters: AREA1, E_PTS, F_PTS
        parameters.AREA1 = 2;
        parameters.E_PTS = 2;
        parameters.F_PTS = 1;
        assertTrue(LIC.compute(points, parameters));
    }
}
