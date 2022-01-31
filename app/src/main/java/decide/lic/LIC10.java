/**
 * Class for LIC10, described in Assignment 1.
 * @author  Chloe Porion
 * @date 2020-01-29
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC10 extends AbstractLIC {
    public boolean compute (Point[] points, Parameters parameters) {
        // Condition not met when NUMPOINTS<5
        if (points.length < 5) {
            return false;
        }

        Functions functions = new Functions();
        for (int i = 0; i < points.length - parameters.E_PTS - parameters.F_PTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + parameters.E_PTS + 1];
            Point p3 = points[i + parameters.E_PTS + 1 + parameters.F_PTS + 1];
            double area = functions.getAreaTriangle(p1, p2, p3);
            if (area > parameters.AREA1) {
                return true;
            }
        }
        return false;
    }
}
