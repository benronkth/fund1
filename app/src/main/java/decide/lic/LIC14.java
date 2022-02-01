package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC14 extends AbstractLIC {

    /**
     * There exists at least one set of three data points, separated by exactly E_PTS and F_PTS consecutive
     * intervening points, respectively, that are the vertices of a triangle with area greater
     * than AREA1. In addition, there exist three data points (which can be the same or different
     * from the three data points just mentioned) separated by exactly E_PTS and F_PTS consecutive
     * intervening points, respectively, that are the vertices of a triangle with area less than
     * AREA2. Both parts must be true for the LIC to be true. The condition is not met when NUMPOINTS < 5.
     * 0 <= AREA2
     *
     * @param points the input data vectors containing different points
     * @param parameters Set of input parameters, E_PTS, F_PTS, AREA1, and AREA2 used here
     * @return boolean value, true if the above condition is met, false otherwise
     */

    public boolean compute (Point[] points, Parameters parameters) {
        // Condition not met if less than 5 points
        if (points.length < 5) {
            return false;
        }

        
        boolean condition1 = false, condition2 = false;
        for (int i=0; i < points.length - parameters.E_PTS - parameters.F_PTS - 2; i++) {
            double areaTriangle = Functions.getAreaTriangle(points[i], points[i+parameters.E_PTS+1], points[i+parameters.E_PTS+parameters.F_PTS+2]);

            // First condition
            if (areaTriangle > parameters.AREA1) {
                condition1 = true;
            }

            // Second condition
            if (areaTriangle < parameters.AREA2) {
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
