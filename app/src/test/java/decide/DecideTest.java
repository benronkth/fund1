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
}
