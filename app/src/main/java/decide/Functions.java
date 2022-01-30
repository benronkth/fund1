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

    /**
     * Calculates the radian angle between three points, using p1 as vertex
     * https://www.mathsisfun.com/algebra/trig-cosine-law.html
     * 
     * @param p1 vertex point of angle
     * @param p2 first point of angle
     * @param p3 second point of angle
     * @return the angle in radians
     */
    public static double getAngle(Point p1, Point p2, Point p3) {
        double length12 = new Functions().getDistance(p1, p2);
        double length13 = new Functions().getDistance(p1, p3);
        double length23 = new Functions().getDistance(p2, p3);
        double numerator = Math.pow(length12, 2) + Math.pow(length13, 2) - Math.pow(length23, 2);
        double denominator = 2 * length12 * length13;
        return Math.acos(numerator / denominator);
    }
    
    /*
     * Computation of the area of a triangle defined by its vertices using the Shoelace formula
     *
     * @param p1 First point
     * @param p2 Second point
     * @param p3 Third point
     * @return The area of the triangle defined by the three points
     */

    public double getAreaTriangle (Point p1, Point p2, Point p3) {
        return 0.5 * (p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y));
    }
}
