package decide;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import decide.lic.AbstractLIC;
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

    /**
     * True test LICs 1, 5, 10, 12, 13, and 14
     *
     * LIC1: points 1 2 3
     * LIC5: points 4 5
     * LIC10: points 5 8 10
     * LIC12: points 3 6 and 4 7
     * LIC13: points 5 8 10 and 1 2 3
     * LIC14: points 5 8 10 and 4 7 9
     */
    @Test public void trueAtLeast6LICsTrueFocusOn6LICs () {
        Parameters params = new Parameters();
        // Set parameters
        params.RADIUS1 = 1;
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 2;
        params.K_PTS = 2;
        params.LENGTH1 = 2;
        params.LENGTH2 = 1;
        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS2 = 2;
        params.AREA2 = 1;
        Point[] points = new Point[] {
                new Point(0,0),
                new Point(1,1),
                new Point(2,2),
                new Point(1,0),
                new Point(0,0),
                new Point(0,0),
                new Point(0.5,0),
                new Point(3,0),
                new Point(0,0),
                new Point(0,4)
        };
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector();
        // Set puv and lcm values:
        // AND for all pairs of true LIC
        // OR when one of LIC true
        // NOTUSED for all others cases
        int[] LICsUsed = new int[] {1, 5, 10, 12, 13, 14};
        for (int lic1: LICsUsed) {
            for (int lic2 = 0; lic2<15 ; lic2++) {
                lcm.matrix[lic1][lic2] = LCMValue.ORR;
                lcm.matrix[lic2][lic1] = LCMValue.ORR;
            }
            for (int lic2: LICsUsed) {
                lcm.matrix[lic1][lic2] = LCMValue.ANDD;
                lcm.matrix[lic2][lic1] = LCMValue.ANDD;
            }
            puv.matrix[lic1] = true;
        }
        boolean result = Decide.decide(points, params, lcm, puv);
        assertTrue("Positive test case with 6 LICs: 1 5 10 12 13 and 14", result);
    }

    /** False test LICs 1, 5, 10, 12, 13, and 14
     * LIC14 false, only AREA2 modified compared to positive test case above
     **/
    @Test public void falseAtLeast6LICsTrueAnd1FalseFocusOn6LICs () {
        Parameters params = new Parameters();
        // Set parameters
        params.RADIUS1 = 1;
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 2;
        params.K_PTS = 2;
        params.LENGTH1 = 2;
        params.LENGTH2 = 1;
        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS2 = 2;
        params.AREA2 = 0;
        Point[] points = new Point[] {
                new Point(0,0),
                new Point(1,1),
                new Point(2,2),
                new Point(1,0),
                new Point(0,0),
                new Point(0,0),
                new Point(0.5,0),
                new Point(3,0),
                new Point(0,0),
                new Point(0,4)
        };
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector();
        // Set puv and lcm values:
        // AND for all pairs of true LIC
        // OR when one of LIC true
        // NOTUSED for all others cases
        int[] LICsUsed = new int[] {1, 5, 10, 12, 13, 14};
        for (int lic1: LICsUsed) {
            for (int lic2 = 0; lic2<15 ; lic2++) {
                lcm.matrix[lic1][lic2] = LCMValue.ORR;
                lcm.matrix[lic2][lic1] = LCMValue.ORR;
            }
            for (int lic2: LICsUsed) {
                lcm.matrix[lic1][lic2] = LCMValue.ANDD;
                lcm.matrix[lic2][lic1] = LCMValue.ANDD;
            }
            puv.matrix[lic1] = true;
        }
        boolean result = Decide.decide(points, params, lcm, puv);
        assertFalse("Negative test case with 6 LICs: 1 5 10 12 13 and 14, LIC14 false", result);
    }
}
