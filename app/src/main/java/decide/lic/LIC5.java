/**
 * Class for LIC5, described in Assignment 1.
 * @author  Chloe Porion
 * @date 2020-01-28
 * @version 1.0
 */

package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC5 extends AbstractLIC {

    /**
     * @param points Set of data points, described by their coordinates
     * @param parameters Set of parameters, none is used here
     * @return Boolean value. True if there exists at least one set of 2 consecutive data points,
     * (X[i], Y[i]) and (X[j], Y[j]), such that X[j]-X[i] < 0 with i = j-1. False otherwise.
     */

    public boolean compute (Point[] points, Parameters parameters) {
        for (int i = 0; i < points.length-1; i++) {
            if (points[i+1].x - points[i].x < 0) {
                return true;
            }
        }
        return false;
    }
}
