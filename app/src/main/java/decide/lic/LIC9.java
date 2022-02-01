/**
 * Class for LIC9, described in Assignment 1.
 * @author Nicky Obreykov
 * @date 2020-01-31
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC9 extends AbstractLIC {

    /**
     * @param points     the input data vectors containing different points
     * @param parameters the class containing different input parameters
     * @return true if there exists at least one set of three data points separated
     *         by exactly C_PTS and D_PTS consecutive intervening points,
     *         respectively that form an angle such that angle < (PI - EPSILON) or
     *         angle > (PI + EPSILON)
     */

    @Override
    public boolean compute(Point[] points, Parameters parameters) {
        // Condition not met when NUMPOINTS < 5
        if (points.length < 5) {
            return false;
        }

        for (int i = 0; i < points.length - parameters.C_PTS - parameters.D_PTS - 2; i++) {
            Point first = points[i];
            Point vertex = points[i + parameters.C_PTS + 1];
            Point last = points[i + parameters.C_PTS + 1 + parameters.D_PTS + 1];

            // If the first or last point coincides with the vertex, the LIC is not
            // satisfied with these points
            if (first.equals(vertex) || last.equals(vertex)) {
                continue;
            }

            double angle = Functions.getAngle(vertex, first, last);
            if (angle < Math.PI - parameters.EPSILON || angle > Math.PI + parameters.EPSILON) {
                return true;
            }
        }
        return false;
    }

}
