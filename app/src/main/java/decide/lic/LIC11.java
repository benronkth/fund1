/**
 * Class for LIC11, described in Assignment 1.
 * @author Nicky Obreykov
 * @date 2020-01-30
 * @version 1.0
 */

package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC11 extends AbstractLIC {
    /**
     * @param points     Set of data points, described by their coordinates
     * @param parameters Set of parameters, where G_PTS is used
     * @return Boolean value. True if there exists at least one set of 2 data
     *         points, (X[i], Y[i]) and (X[j], Y[j]), separated by exactly G_PTS
     *         consecutive intervening points such that X[j]-X[i] < 0 where i < j.
     *         False otherwise.
     */

    public boolean compute(Point[] points, Parameters parameters) {
        // Condition is not met when NUMPOINTS < 3 as 1 <= G_PTS <= (NUMPOINTS - 2)
        if (points.length < 3) {
            return false;
        }

        for (int i = 0; i < points.length - parameters.G_PTS - 1; i++) {
            if (points[i + parameters.G_PTS + 1].x - points[i].x < 0) {
                return true;
            }
        }
        return false;
    }
}