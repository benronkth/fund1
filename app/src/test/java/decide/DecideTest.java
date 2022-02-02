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







     //False test cases that combines LIC 0 4 8

     @Test public void falseTestWherePointsForLIC0AreNotConsecutive() { 

        Point points[] = new Point[5];
        // points[0] and points[4] are apart more than LENGHT1=10 
        // but because they are not consecutive the algorithm returns false.
        points[0] = new Point(2, 2);
        points[1] = new Point(4, 4);
        points[2] = new Point(6, 6);
        points[3] = new Point(8, 8);
        points[4] = new Point(-10, -10); 
        

        Parameters params = new Parameters();
        
        // For LIC 0
        params.LENGTH1 = 10; 
        
        // For LIC 4 
        params.QUADS = 1;  
        params.Q_PTS = 2;

        // For LIC 8
        params.A_PTS = 1;
        params.B_PTS = 1;
        params.RADIUS1 = 0;
        
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = PreliminaryUnlockingVector.allTrue();
        // Set puv and lcm values:
        // AND for all pairs of true LIC
        // OR when one of LIC true
        // NOTUSED for all others cases
        int[] LICsUsed = new int[] {0, 4, 8};
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
        assertFalse("LIC0 should return false because the far apart points are not consecutive.", result);
    }


    
     //True test cases that combines LIC 0 4 8

     @Test public void trueTestCombiningLIC0LIC4LIC8() { 

        Point points[] = new Point[9];
       
        // These points are outside a circle with radius 5 (LIC8 Passes) and
        // LENGHT1 is zero so LIC0 will trivially pass
        // The last 3 points are consequent and are in 3 different quadrants.

        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 3);
        points[4] = new Point(14, 0);
        points[5] = new Point(40, 0);
        points[3] = new Point(4, 0);
        points[6] = new Point(4, 80);
        points[7] = new Point(-4, 80);
        points[8] = new Point(-4, -80);
 
        

        Parameters params = new Parameters();
        
        // For LIC 0
        params.LENGTH1 = 0; 
        
        // For LIC 4 
        params.QUADS = 2;  
        params.Q_PTS = 3;

        // For LIC 8
        params.A_PTS = 1;
        params.B_PTS = 2;
        params.RADIUS1 = 5;
        
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix();
        PreliminaryUnlockingVector puv = PreliminaryUnlockingVector.allTrue();
        // Set puv and lcm values:
        // AND for all pairs of true LIC
        // OR when one of LIC true
        // NOTUSED for all others cases
        int[] LICsUsed = new int[] {0, 4, 8};
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
        assertTrue("Should return true because LIC0, LIC4 and LIC8 return true as well.", result);
    }
}
