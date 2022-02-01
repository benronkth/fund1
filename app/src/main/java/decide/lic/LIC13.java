package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC13 extends AbstractLIC {

    /**
     * There exists at least one set of three data points, separated by exactly A_PTS and B_PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     * the same or different from the three data points just mentioned) separated by exactly A_PTS
     * and B_PTS consecutive intervening points, respectively, that can be contained in or on a
     * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
     * not met when NUMPOINTS < 5.
     *
     * @param points the input data vectors containing different points
     * @param parameters Set of input parameters, A_PTS, B_PTS, RADIUS1, and RADIUS2 used here
     * @return boolean value, true if the above condition is met, false otherwise
     */

    public boolean compute (Point[] points, Parameters parameters) {
        // Condition not met if less than 5 points
        if (points.length < 5) {
            return false;
        }

        boolean condition1 = false, condition2 = false;
        for (int i=0; i < points.length - parameters.A_PTS - parameters.B_PTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i+parameters.A_PTS+1];
            Point p3 = points[i+parameters.A_PTS+parameters.B_PTS+2];
            double radiusCircumscribedCircle = Functions.getCircumscribedCirclesRadius(p1,p2,p3);

            // Precision for double numbers
            double epsilon = 1e-15;

            // First condition
            if (radiusCircumscribedCircle - parameters.RADIUS1 > epsilon) {
                condition1 = true;
            }

            // Second condition
            if (radiusCircumscribedCircle - parameters.RADIUS2 <= epsilon) {
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
