package decide;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import decide.datastructures.LogicalConnectorMatrix;
import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.datastructures.PreliminaryUnlockingVector;
import decide.datastructures.LogicalConnectorMatrix.LCMValue;

public class DecideTest {
    
    //Empty test
    @Test public void falseEmptyCase() {
        Point[] points = new Point[0];
        Parameters params = new Parameters();
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = PreliminaryUnlockingVector.allTrue();
        lcm.matrix[0][1] = LCMValue.ANDD;
        boolean result = Decide.decide(points, params, lcm, puv);
        assertFalse("Empty test case should be false", result);
    }

    @Test public void trueSmallCase() {
        Parameters params = new Parameters();
        params.LENGTH1 = 10;
        params.RADIUS1 = 1;
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1 + params.LENGTH1 + 1, 1 + params.LENGTH1 +1),
            new Point(0,0),
            new Point(1,1),
            new Point(2,2),
        };
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector();
        lcm.matrix[0][1] = LCMValue.ANDD;
        lcm.matrix[1][0] = LCMValue.ANDD;
        puv.matrix[0] = true;
        puv.matrix[1] = true;
        boolean result = Decide.decide(points, params, lcm, puv);
        assertTrue("Simple test case with LIC0 and LIC1", result);
    }

    @Test public void negativeTestCaseWithLIC1and2and6() {
        //LIC1 is true, 2 and 6 are false
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = (3.0/2.0) * Math.sqrt(2);
        params.EPSILON = Math.PI;
        params.RADIUS1 = 100;
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = PreliminaryUnlockingVector.allTrue();
        lcm.matrix[1][2] = LCMValue.ORR;
        lcm.matrix[2][1] = LCMValue.ORR;
        lcm.matrix[2][6] = LCMValue.ORR;
        lcm.matrix[6][2] = LCMValue.ORR;
        boolean result = Decide.decide(points, params, lcm, puv);
        assertFalse("Negative test case with LIC1, LIC2, LIC6", result);
    }

    @Test public void positiveTestCaseWithLIC2and5and6() {
        //LIC1 is true, 2 and 6 are false
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1),
            new Point(0, 5),
            new Point(1, 4),
            new Point(2, 6),
            new Point(-1,1),
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = (3.0/2.0) * Math.sqrt(2) - 0.001;
        params.EPSILON = Math.PI / 4;
        params.RADIUS1 = 100;
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = PreliminaryUnlockingVector.allTrue();
        lcm.matrix[2][5] = LCMValue.ANDD;
        lcm.matrix[5][2] = LCMValue.ANDD;
        lcm.matrix[2][6] = LCMValue.ANDD;
        lcm.matrix[6][2] = LCMValue.ANDD;
        boolean result = Decide.decide(points, params, lcm, puv);
        assertTrue("Positive test case with LIC2, LIC5, LIC6", result);
    }
}
