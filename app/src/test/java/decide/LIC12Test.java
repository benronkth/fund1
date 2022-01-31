package decide;

import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.lic.LIC12;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LIC12Test {

    // Negative test 1
    @Test public void FalseComputationNotEnoughPoints () {
        LIC12 LIC = new LIC12();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(1,0)
        };
        // Parameters: K_PTS, LENGTH1, LENGTH2
        parameters.K_PTS = 1;
        parameters.LENGTH1 = 1;
        parameters.LENGTH2 = 1;
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 2
    @Test public void FalseComputationOnlyFirstConditionMet () {
        LIC12 LIC = new LIC12();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(2,3),
                new Point(1,1)
        };
        // Parameters: K_PTS, LENGTH1, LENGTH2
        parameters.K_PTS = 1;
        parameters.LENGTH1 = 1;
        parameters.LENGTH2 = Math.sqrt(2);
        assertFalse(LIC.compute(points, parameters));
    }

    // Negative test 3
    @Test public void FalseComputationOnlySecondConditionMet () {
        LIC12 LIC = new LIC12();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(-1,1),
                new Point(1,1)
        };
        // Parameters: K_PTS, LENGTH1, LENGTH2
        parameters.K_PTS = 1;
        parameters.LENGTH1 = 3;
        parameters.LENGTH2 = 2;
        assertFalse(LIC.compute(points, parameters));
    }

    // Positive test 1
    @Test public void TrueComputationSameSetOfPointsForTwoConditions () {
        LIC12 LIC = new LIC12();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(-1,1),
                new Point(1,1)
        };
        // Parameters: K_PTS, LENGTH1, LENGTH2
        parameters.K_PTS = 1;
        parameters.LENGTH1 = 1;
        parameters.LENGTH2 = 2;
        assertTrue(LIC.compute(points, parameters));
    }

    // Positive test 2
    @Test public void TrueComputationDifferentSetOfPointsForTwoConditions () {
        LIC12 LIC = new LIC12();
        Parameters parameters = new Parameters();
        Point[] points = {
                new Point(0,0),
                new Point(-1,0),
                new Point(0,0),
                new Point(1,0),
                new Point(3,0)
        };
        // Parameters: K_PTS, LENGTH1, LENGTH2
        parameters.K_PTS = 2;
        parameters.LENGTH1 = 3;
        parameters.LENGTH2 = 2;
        assertTrue(LIC.compute(points, parameters));
    }
}
