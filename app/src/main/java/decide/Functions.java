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
     * Calculates the radius of a smallest circle (circumscribed circle) that 
     * is created using a triangle. 
     * 
     * @param points the corner points of the triangle
     * @return the radius of a smallest circle (circumscribed circle)
     */
    public double getCircumscribedCirclesRadius(Point point1, Point point2, Point point3){
        // Sides triangle
 
        double side1 = getDistance(point1, point2);
        double side2 = getDistance(point2, point3);
        double side3 = getDistance(point1, point3);

         // Area of the triangle with the Heron's formula 
        double s = (side1 + side2 + side3)/2; 
        double areaTriangle = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
 
         // Get radius of the circumscribed circle of the triangle 
         if(areaTriangle==0){
            double max = (Math.max(Math.max(side1, side2),side3));
            return max/2;
         }
        double circumscribedCircleRadius = (side1 * side2 * side3)/(4 * areaTriangle); 
        return circumscribedCircleRadius;
    }


    
    
    /**
     * Finds the mid point of the longest side of a triangle. This 
     * function is useful when we want to draw a circle on the longest
     * side of a triangle.
     * 
     * @param point1 the first point
     * @param point2 the second point
     * @return the midpoint between point1 and point2
     */

    public Point getMidPointOfTheLongestSideInTriangle(Point point1, Point point2, Point point3){

        double side1 = getDistance(point1, point2);
        double side2 = getDistance(point2, point3);
        double side3 = getDistance(point1, point3);
        double longestSide = Math.max(Math.max(side1, side2), side3);

        if(longestSide == side1){
            return getMidPointOfTwoCoordinates(point1, point2);
        }else if(longestSide == side2){
            return getMidPointOfTwoCoordinates(point2, point3);
        }else{
            return getMidPointOfTwoCoordinates(point1, point3);
        }

    }

      /**
     * Finds the mid point of the longest side of a triangle. This 
     * function is useful when we want to draw a circle on the longest
     * side of a triangle.
     * 
     * @param point1 the first point
     * @param point2 the second point
     * @return the midpoint between point1 and point2
     */

    public Point getPointOusideOfTheLongestSideInTriangle(Point point1, Point point2, Point point3){

        double side1 = getDistance(point1, point2);
        double side2 = getDistance(point2, point3);
        double side3 = getDistance(point1, point3);
        double longestSide = Math.max(Math.max(side1, side2), side3);

        if(longestSide == side1){ 
            return point3;
        }else if(longestSide == side2){
            return point1;
        }else{
            return point2;
        }

    }

    
    /**
     * Finds the mid point between 2 points in 2d space.
     * 
     * @param point1 the first point
     * @param point2 the second point
     * @return the midpoint between point1 and point2
     */
    public Point getMidPointOfTwoCoordinates(Point point1, Point point2){
        
        return new Point((point1.x + point2.x)/2, (point1.y + point2.y)/2);
    }

  
    
    /**
     * Determines if a point is outside a circle.
     * 
     * @param circlesCenter the circles center point
     * @param radius the circles radius
     * @param point the point in question
     * @return true if the point is outside the circle and false otherwise.
     */
    public boolean isPointOutsideCircle(Point circlesCenter, double radius, Point point){
        
        double distanceFromCirclesCenterToThePoint = getDistance(circlesCenter, point);
        
        return distanceFromCirclesCenterToThePoint > radius;
    }
}
