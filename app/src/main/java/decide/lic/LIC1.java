/**
 * Class for LIC1, described in Assignment 1.
 * @author  Chloe Porion
 * @date 2020-01-28
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC1 extends AbstractLIC {

    /**
     * @param points Set of data points of type Point described by their coordinates
     * @param parameters Set of input parameters among which RADIUS_1 (>=0) used here
     * @return boolean value, true if there exists at least a set of three consecutive points in
     * the input data points that cannot all be contained within or on a circle of radius RADIUS_1
     */

    public boolean compute(Point[] points, Parameters parameters) {
        
        // Go through all the points
        // Consider all set of 3 consecutive data points
        for (int i=0; i < points.length-2; i++) {
            // Points
            Point point1 = points[i];
            Point point2 = points[i+1];
            Point point3 = points[i+2];
            // Sides triangle
            double side1 = Functions.getDistance(point1, point2);
            double side2 = Functions.getDistance(point2, point3);
            double side3 = Functions.getDistance(point1, point3);
            // Area of the triangle with the Heron's formula
            double s = (side1 + side2 + side3)/2;
            double areaTriangle = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
            // Get radius of the circumscribed circle of the triangle
            double circumscribedCircleRadius = (side1 * side2 * side3)/(4 * areaTriangle);
            if (circumscribedCircleRadius > parameters.RADIUS1) {
                return true;
            }
        }
        return false;
    }
}