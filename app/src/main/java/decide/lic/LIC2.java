/**
 * Class for LIC2, described in Assignment 1.
 * @author Martin Larsson
 * @date 2020-01-29
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;


public class LIC2 extends AbstractLIC {


    /**
     * The compute method for LIC2 looking at an angle formed by three consecutive data points
     * 
     * @param points the input data vectors containing different points
     * @param parameters the class containing different input parameters
     * @return true if there exists at least one set of three consecutive data points that form an angle
     * where angle < (PI - EPSILON) or angle > (PI + EPSILON)
     */

    @Override 
    public boolean compute(Point[] points, Parameters parameters) {
        for(int i = 0; i < points.length - 2; i++){
            Point first = points[i];
            Point vertex = points[i+1];
            Point last = points[i+2];

            //If the first or last point coincides with the vertex, the LIC is not satisfied with these points
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
