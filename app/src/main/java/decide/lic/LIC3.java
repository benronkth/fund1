package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC3 extends AbstractLIC {

    /**
     * @param points     Set of data points, described by their coordinates
     * @param parameters Set of parameters, where AREA1 is used
     * @return true if there exists at least one set of three consecutive
     *         data points that form a triangle with area greater than AREA1, false
     *         otherwise
     */

    @Override
    public boolean compute(Point[] points, Parameters parameters) {
        for (int i = 0; i < points.length - 2; i++) {

            Point a = points[i];
            Point b = points[i + 1];
            Point c = points[i + 2];

            // Calculating the area using the Shoelace formula
            double area = 0.5 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y));

            if (area > parameters.AREA1) {
                return true;
            }
        }
        return false;
    }

}
