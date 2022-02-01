package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC13;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LIC13Test {

    // Negative test 1
    @Test public void FalseComputationNotEnoughPoints () {
        LIC13 LIC = new LIC13();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(0,0),
                new Point(1,0)
        };
        // Parameters: A_PTS, B_PTS, RADIUS1, RADIUS2
        parameters.A_PTS = 1;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 1;
        parameters.RADIUS2 = 1;
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 2
    @Test public void FalseComputationOnlyFirstConditionMet () {
        LIC13 LIC = new LIC13();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(3,0),
                new Point(0,0),
                new Point(0,4)
        };
        // Parameters: A_PTS, B_PTS, RADIUS1, RADIUS2
        parameters.A_PTS = 1;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 2;
        parameters.RADIUS2 = 1;
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 3
    @Test public void FalseComputationOnlySecondConditionMet () {
        LIC13 LIC = new LIC13();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(1,0),
                new Point(0,0),
                new Point(0,1)
        };
        // Parameters: A_PTS, B_PTS, RADIUS1, RADIUS2
        parameters.A_PTS = 1;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 2;
        // The circumscribed circle is of radius sqrt(2)/2 = 0.71
        parameters.RADIUS2 = Math.sqrt(2)/2;
        assertFalse(LIC.compute(points, parameters));
    }

    // Positive test 1
    @Test public void TrueComputationSameSetOfPointsForTwoConditions () {
        LIC13 LIC = new LIC13();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(1,0),
                new Point(0,0),
                new Point(0,1)
        };
        // Parameters: A_PTS, B_PTS, RADIUS1, RADIUS2
        parameters.A_PTS = 1;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 0.7;
        // The circumscribed circle is of radius sqrt(2)/2 = 0.71
        parameters.RADIUS2 = Math.sqrt(2)/2;
        assertTrue(LIC.compute(points, parameters));
    }

    // Positive test 2
    @Test public void TrueComputationDifferentSetOfPointsForTwoConditions () {
        LIC13 LIC = new LIC13();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(0,0),
                new Point(3,0),
                new Point(1,0),
                new Point(0,4),
                new Point(0,1)
        };
        // Parameters: A_PTS, B_PTS, RADIUS1, RADIUS2
        parameters.A_PTS = 2;
        parameters.B_PTS = 1;
        parameters.RADIUS1 = 2;
        // The circumscribed circle is of radius sqrt(2)/2 = 0.71
        parameters.RADIUS2 = Math.sqrt(2)/2;
        assertTrue(LIC.compute(points, parameters));
    }
}
