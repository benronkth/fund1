package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC7 extends AbstractLIC {

    /**
     * @param points     Set of data points, described by their coordinates
     * @param parameters Set of parameters, where LENGTH1 and K_PTS is used
     * @return true if there exists at least one set of two data points separated by
     *         exactly K_PTS consecutive interveining points that are a distance
     *         greater than the length, LENGTH1, apart. Otherwise, return false
     */

    @Override
    public boolean compute(Point[] points, Parameters parameters) {
        // Condition is not met when NUMPOINTS < 3 as 1 <= K_PTS <= (NUMPOINTS - 2)
        if (points.length < 3)
            return false;

        for (int i = 0; i < points.length - parameters.K_PTS - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + parameters.K_PTS + 1];

            double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));

            if (distance > parameters.LENGTH1)
                return true;
        }
        return false;
    }

}