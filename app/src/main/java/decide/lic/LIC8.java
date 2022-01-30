package decide.lic;

import decide.Functions;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public class LIC8 extends AbstractLIC {
    Functions functions = new Functions();

    @Override
    public boolean compute(Point[] points, Parameters parameters) {
        
        if (points.length<5) {
            return false;
        }

        int totalPointsThatShouldBeConsecutive = 3 + parameters.A_PTS + parameters.B_PTS;

        System.out.println("Test with radius: "+parameters.RADIUS1);

        for (int i = 0; i <= points.length - totalPointsThatShouldBeConsecutive; i++) {
            int firstIndex = i;
            int secondIndex = firstIndex + parameters.A_PTS + 1;
            int thirdIndex = secondIndex + parameters.B_PTS + 1 ; 
            System.out.println("indexes: "+ firstIndex + " - "+secondIndex+" - "+thirdIndex + " Radius: "+parameters.RADIUS1);
            Point circlesCenter = functions.getMidPointOfTheLongestSideInTriangle(points[firstIndex], points[secondIndex], points[thirdIndex]);
            Point pointOutsideCircle = functions.getPointOusideOfTheLongestSideInTriangle(points[firstIndex], points[secondIndex], points[thirdIndex]);
            if(functions.isPointOutsideCircle(circlesCenter, parameters.RADIUS1, pointOutsideCircle)){
                System.out.println("returned true");
                return true;
                
            };
        }
        System.out.println("returned false");
        
        return false;
    }

}
