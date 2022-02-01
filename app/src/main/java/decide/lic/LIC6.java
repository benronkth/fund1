package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC6 extends AbstractLIC {

    /**
     * @param points     Array of data points
     * @param parameters Set of parameters
     * @return true if there exists at least one set of N_PTS consecutive
     *         data points that contain one point that is a distance greater than DIST 
     *         from the line formed by the first and last point in the N_PTS set
     */

    @Override
    public boolean compute(Point[] points, Parameters parameters) {
        if (points.length < 3) {
            return false;
        }
        for (int i = 0; i < points.length - parameters.N_PTS + 1; i++) {

            Point first = points[i];
            Point last = points[i + parameters.N_PTS - 1];

            for (int j = 0; j < parameters.N_PTS - 2; j++) {
                Point point = points[i + 1 + j];
                double distance;
                // if first and last points coincide and do not form a line, use distance to line points instead
                if (first.equals(last)) {
                    distance = Functions.getDistance(first, point);
                } else {
                    distance = Functions.getDistanceFromLine(first, last, point);
                }
                if (distance > parameters.DIST) {
                    return true;
                }
            }
        }
        return false;
    }

}
