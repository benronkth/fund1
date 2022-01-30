package decide;

import org.junit.Test;

import decide.datastructures.Point;

import static org.junit.Assert.*;

public class FunctionsTest {
    double precisionDelta = 0.00001;

    /**********************************************************************************
     * | Test cases for getDistance()
     ***********************************************************************************/

    @Test
    public void distanceCalculatedBetweenTwoPoints() {
        Functions functions = new Functions();
        Point startPoint = new Point(-3, 0);
        Point endPoint = new Point(0, 4);

        assertEquals(5, functions.getDistance(startPoint, endPoint), precisionDelta);
    }

    @Test
    public void distanceBetweenPointsThatAreAtTheSamePosition() {
        Functions functions = new Functions();
        Point startPoint = new Point(0, 0);

        assertEquals(0, functions.getDistance(startPoint, startPoint), precisionDelta);
    }

    /**********************************************************************************
     * | Test cases for getQuadrant()
     ***********************************************************************************/
    /**
     * Edge cases:
     * Where there is ambiguity as to which quadrant contains a given point,
     * priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example,
     * the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in
     * quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     */

    @Test
    public void theQuadrantForPointZeroAndZero() {
        Functions functions = new Functions();
        Point point = new Point(0, 0);
        assertEquals(1, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointMinusOneAndZero() {
        Functions functions = new Functions();
        Point point = new Point(-1, 0);
        assertEquals(2, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointZeroAndMinusOne() {
        Functions functions = new Functions();
        Point point = new Point(0, -1);
        assertEquals(3, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointZeroAndOne() {
        Functions functions = new Functions();
        Point point = new Point(0, 1);
        assertEquals(1, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointOneAndZero() {
        Functions functions = new Functions();
        Point point = new Point(1, 0);
        assertEquals(1, functions.getQuadrant(point));
    }

    // Other Cases

    @Test
    public void theQuadrantForPointOneAndOne() {
        Functions functions = new Functions();
        Point point = new Point(1, 1);
        assertEquals(1, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointMinusOneAndMinusOne() {
        Functions functions = new Functions();
        Point point = new Point(-1, -1);
        assertEquals(3, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointMinus10And8() {
        Functions functions = new Functions();
        Point point = new Point(-10, 8);
        assertEquals(2, functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPoint15AndMinus7() {
        Functions functions = new Functions();
        Point point = new Point(15, -7);
        assertEquals(4, functions.getQuadrant(point));
    }

    /**********************************************************************************
     * | Test cases for getCircumscribedCirclesRadius
     ***********************************************************************************/
    
    @Test
    public void theCircumscribedCirclesRadiusOfAZeroTriangle() {
        Functions functions = new Functions();
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(1, 1);
        assertEquals(0, functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }
    
    @Test
    public void theCircumscribedCirclesRadiusOfATriangle() {
        Functions functions = new Functions();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        Point point3 = new Point(8, 8);
        assertEquals(5*Math.sqrt(2), functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }

    
    @Test
    public void theCircumscribedCirclesRadiusOfARightTriangle() {
        Functions functions = new Functions();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 10);
        Point point3 = new Point(8, 0);
        assertEquals(Math.sqrt(41), functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }

    

}
