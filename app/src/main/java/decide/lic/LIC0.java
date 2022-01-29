/**
 * Class for LIC0, described in Assignment 1.
 * @author  Benjamin Ronneling
 * @date 2020-01-27
 * @version 1.0
 */

package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;


public class LIC0 extends AbstractLIC {


    /**
     * The compute method for LIC0 where true is returned when:
     * There exists at least one set of two consecutive data points that are a
     * distance greater than the length, LENGTH1, apart. (0 ≤ LENGTH1)
     * Consecutive: Two points are consecutive if they are adjacent in the input
     * data vectors X and Y.
     * Thus (X[i],Y[i]) and (X[i+1],Y[i+1]) are adjacent.
     * 
     * @param points the input data vectors containing different points
     * @param parameters the class containing different input parameters
     * @return true if there exists at least one set of two consecutive data points that are a
     * distance greater than LENGTH1 apart, and false otherwise.
     */

    @Override 
    public boolean compute(Point[] points, Parameters parameters) {
        
        for(int i = 0; i < points.length - 1; i++){
            // Euclidean distance: d^2 = (px1 - px2)^2 + (py1-py2)^2 
            double distance = Math.sqrt(Math.pow(points[i].x - points[i+1].x , 2) + Math.pow(points[i].y - points[i+1].y, 2)); 
            if(distance > parameters.LENGTH1){
                return true;
            }
        }
        return false;
    }

}
