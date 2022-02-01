package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC14;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LIC14Test {

    // Negative test 1
    @Test public void FalseComputationNotEnoughPoints () {
        LIC14 LIC = new LIC14();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(0,0),
                new Point(1,0)
        };
        // Parameters: E_PTS, F_PTS, AREA1, AREA2
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        parameters.AREA1 = 1;
        parameters.AREA2 = 1;
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 2
    @Test public void FalseComputationOnlyFirstConditionMet () {
        LIC14 LIC = new LIC14();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(3,0),
                new Point(0,0),
                new Point(0,4)
        };
        // Parameters: E_PTS, F_PTS, AREA1, AREA2
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        parameters.AREA1 = 2;
        parameters.AREA2 = 6;
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 3
    @Test public void FalseComputationOnlySecondConditionMet () {
        LIC14 LIC = new LIC14();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(1,0),
                new Point(0,0),
                new Point(0,1)
        };
        // Parameters: E_PTS, F_PTS, AREA1, AREA2
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        parameters.AREA1 = 2;
        parameters.AREA2 = 1;
        assertFalse(LIC.compute(points, parameters));
    }

    // Positive test 1
    @Test public void TrueComputationSameSetOfPointsForTwoConditions () {
        LIC14 LIC = new LIC14();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(0,0),
                new Point(1,0),
                new Point(0,0),
                new Point(0,1)
        };
        // Parameters: E_PTS, F_PTS, AREA1, AREA2
        parameters.E_PTS = 1;
        parameters.F_PTS = 1;
        parameters.AREA1 = 0.4;
        parameters.AREA2 = 0.6;
        assertTrue(LIC.compute(points, parameters));
    }

    // Positive test 2
    @Test public void TrueComputationDifferentSetOfPointsForTwoConditions () {
        LIC14 LIC = new LIC14();
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
        // Parameters: E_PTS, F_PTS, AREA1, AREA2
        parameters.E_PTS = 2;
        parameters.F_PTS = 1;
        parameters.AREA1 = 5;
        parameters.AREA2 = 1;
        assertTrue(LIC.compute(points, parameters));
    }
}
