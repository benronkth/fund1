/**
 * Class for LIC12, described in Assignment 1.
 * @author  Chloe Porion
 * @date 2020-01-30
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC12 extends AbstractLIC {

    /**
     * There exists at least one set of two data points, separated by exactly K_PTS consecutive
     * intervening points, which are a distance greater than the length, LENGTH1, apart. In addition,
     * there exists at least one set of two data points (which can be the same or different from
     * the two data points just mentioned), separated by exactly K_PTS consecutive intervening
     * points, that are a distance less than the length, LENGTH2, apart. Both parts must be true
     * for the LIC to be true. The condition is not met when NUMPOINTS < 3.
     * 0 <= LENGTH1 and 0 <= LENGTH2
     *
     * @param points the input data vectors containing different points
     * @param parameters Set of input parameters, K_PTS, LENGTH1, and LENGTH2 used here
     * @return boolean value, true if the above condition is met, false otherwise
     */

    public boolean compute (Point[] points, Parameters parameters) {
        // Condition not met when NUMPOINTS < 3
        if (points.length < 3) {
            return false;
        }

        boolean condition1 = false, condition2 = false;
        
        for (int i = 0; i < points.length - parameters.K_PTS - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + parameters.K_PTS + 1];
            double dist = Functions.getDistance(p1, p2);
            // First condition
            if (dist > parameters.LENGTH1) {
                condition1 = true;
            }

            // Second condition
            if (dist < parameters.LENGTH2) {
                condition2 = true;
            }

            // Global check
            if (condition1 && condition2) {
                return true;
            }
        }
        return false;
    }
}
