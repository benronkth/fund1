/**
 * Class for LIC4, described in Assignment 1.
 * @author  Benjamin Ronneling
 * @date 2020-01-27
 * @version 1.0
 */

package decide.lic;

import decide.Functions;
import decide.datastructures.Parameters;
import decide.datastructures.Point;


public class LIC4 extends AbstractLIC {

     
    /**
     * The compute method for LIC4 where true is returned when:
     * There exists at least one set of Q_PTS consecutive data points that lie in more than QUADS
     * quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     * (2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
     * 
     * Consecutive: Two points are consecutive if they are adjacent in the input data vectors X and Y.
     * Thus (X[i],Y[i]) and (X[i+1],Y[i+1]) are adjacent.
     * 
     * Quadrant: The x and y axes of the Cartesian coordinate system divide a plane into four areas
     * called quadrants. They are labeled I, II, III, IV, beginning with the area where both coordinates are
     * positive and numbering counterclockwise.
     * 
     * @param points the input data vectors containing different points
     * @param parameters the class containing different input parameters like Q_PTS and QUADS
     * @return true if there exists at least one set of Q_PTS consecutive data points that are 
     * in more than QUADS number of quadrants.
     */

    @Override 
    public boolean compute(Point[] points, Parameters parameters) {
         

        int[] pointQuadrants = new int[points.length];
        // Find Quadrant for all the different points
        for(int i = 0; i < points.length; i++){           
            pointQuadrants[i] = Functions.getQuadrant(points[i]); 
        }

        
        // Check if consecutive Q_PTS number of them are in QUADS quadrants
        for(int i = 0; i <= points.length - parameters.Q_PTS ; i++){
            // Create an array that with 4 elements for each quadrants (where element j is 
            // set to TRUE if there are points available in the quadrant j)
            boolean[] visitedQuadrants = new boolean[4]; 
            int quads = parameters.QUADS;
            for(int j=i; j < (i + parameters.Q_PTS); j++){ 
                visitedQuadrants[pointQuadrants[j]-1] = true;
            }

            // Decrease the number of visited quadrants from the quads variable, 
            // and if the the difference is less than zero then QUAD number of quadrants are visited
            for (int j = 0; j < visitedQuadrants.length; j++) {
                quads -= (visitedQuadrants[j] ? 1 : 0) ; 
            } 
            if(quads<0){ 
                    return true;
            }
        }

        return false;
    }

 

}
