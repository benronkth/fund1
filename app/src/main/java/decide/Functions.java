package decide;

import decide.datastructures.Point;

public class Functions {
    
     /**
     * Calculates the Euclidean distance between two points using:
     * Euclidean distance: d^2 = (px1 - px2)^2 + (py1-py2)^2 
     * 
     * @param startPoint the start point 
     * @param startPoint the end point 
     * @return the Euclidean distance between the points.
     */

    public double getDistance(Point startPoint, Point endPoint){ 
        // Euclidean distance: d^2 = (px1 - px2)^2 + (py1-py2)^2      
        double distance = Math.sqrt(Math.pow(startPoint.x - endPoint.x , 2) + Math.pow(startPoint.y - endPoint.y, 2)); 
        return distance;
    }


    
     /**
     * Calculates which quadrant a point is located in.
     * 
     * @param points the point whose quadrant should be determined  
     * @return the quadrant number where the point is located in.
     */
    public int getQuadrant(Point point){

        // Ambigues cases
        if(point.x == 0){
            // the point (0,0) is in quadrant I
            // the point (0,1) is in quadrant I
            if(point.y >= 0){
                return 1;
            }else{
                // the point (0,-l) is in quadrant III
                return 3;
            }
        }
        if(point.y == 0){
            //  the point (1,0) is in quadrant I
            if(point.x>=0){
                return 1;
            }else{
                // the point (-l,0) is in quadrant II
                return 2;
            }
        }

        if(point.x > 0){
            // First quadrant
            if(point.y > 0){
                return 1;
            }else{
                // Fourth quadrant
                return 4;
            }
        }else{
            // Second quadrant
            if(point.y > 0){
                return 2;
            }else{
                // third quadrant
                return 3;
            }

        }

    }
}
