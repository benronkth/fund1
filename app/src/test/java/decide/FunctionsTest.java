package decide;

import org.junit.Test;

import decide.datastructures.Point;

import static org.junit.Assert.*;

public class FunctionsTest {
    double precisionDelta = 0.00001;
    ;
    /**********************************************************************************
     * | Test cases for getDistance()
     ***********************************************************************************/

    @Test public void zeroDistanceFromLine() {
        Point start = new Point(1, 1);
        Point end = new Point(4, 4);
        Point point = new Point(2, 2);
        double result = Functions.getDistanceFromLine(start, end, point);
        assertEquals(0, result, precisionDelta);
    }

    @Test public void distanceFromLine() {
        Point start = new Point(1, 1);
        Point end = new Point(4, 4);
        Point point = new Point(1, 4);
        double result = Functions.getDistanceFromLine(start, end, point);
        assertEquals((3.0/2.0) * Math.sqrt(2), result, precisionDelta);
    }

    @Test
    public void distanceCalculatedBetweenTwoPoints() {
        
        Point startPoint = new Point(-3, 0);
        Point endPoint = new Point(0, 4);

        assertEquals(5, Functions.getDistance(startPoint, endPoint), precisionDelta);
    }

    @Test
    public void distanceBetweenPointsThatAreAtTheSamePosition() {
        
        Point startPoint = new Point(0, 0);

        assertEquals(0, Functions.getDistance(startPoint, startPoint), precisionDelta);
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
        
        Point point = new Point(0, 0);
        assertEquals(1, Functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointMinusOneAndZero() {
        
        Point point = new Point(-1, 0);
        assertEquals(2, Functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointZeroAndMinusOne() {
        
        Point point = new Point(0, -1);
        assertEquals(3, Functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointZeroAndOne() {
        
        Point point = new Point(0, 1);
        assertEquals(1, Functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointOneAndZero() {
        
        Point point = new Point(1, 0);
        assertEquals(1, Functions.getQuadrant(point));
    }

    // Other Cases

    @Test
    public void theQuadrantForPointOneAndOne() {
        
        Point point = new Point(1, 1);
        assertEquals(1, Functions.getQuadrant(point));
    }

    @Test
    public void theQuadrantForPointMinusOneAndMinusOne() {
        
        Point point = new Point(-1, -1);
        assertEquals(3, Functions.getQuadrant(point));
    }
 

    /**********************************************************************************
     * | Test cases for getCircumscribedCirclesRadius
     ***********************************************************************************/
    
    @Test
    public void theCircumscribedCirclesRadiusOfAZeroTriangle() {
        
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(1, 1);
        assertEquals(0, Functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }
    
    @Test
    public void theCircumscribedCirclesRadiusOfATriangle() {
        
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        Point point3 = new Point(8, 8);
        assertEquals(5*Math.sqrt(2), Functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }

    
    @Test
    public void theCircumscribedCirclesRadiusOfARightTriangle() {
        
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 10);
        Point point3 = new Point(8, 0);
        assertEquals(Math.sqrt(41), Functions.getCircumscribedCirclesRadius(point1,point2,point3), precisionDelta);
    }

    @Test public void theQuadrantForPointMinus10And8() {
        Point point = new Point(-10, 8); 
        assertEquals(2,Functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPoint15AndMinus7() {
        Point point = new Point(15, -7); 
        assertEquals(4,Functions.getQuadrant(point));
    }

    @Test public void getAngleInvalid() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(10, 10);
        double angle = Functions.getAngle(p1, p2, p3);
        assertEquals(Double.NaN, angle, precisionDelta);
    }

    @Test public void getAngle0Degrees() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(20, 10);
        Point p3 = new Point(20, 10);
        double angle = Functions.getAngle(p1, p2, p3);
        assertEquals(0, angle, precisionDelta);
    }

    @Test public void getAngle90Degrees() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(20, 10);
        double angle = Functions.getAngle(p1, p2, p3);
        assertEquals(Math.PI / 2, angle,  precisionDelta);
    }

    @Test public void getAngle180Degrees() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(0, 10);
        Point p3 = new Point(20, 10);
        double angle = Functions.getAngle(p1, p2, p3);
        assertEquals(Math.PI, angle, precisionDelta);
    }
    @Test public void getAreaTriangle0() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(2,0);
        assertEquals(0, Functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }

    @Test public void getAreaTriangleRect() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,0);
        Point p3 = new Point(0,4);
        assertEquals(6, Functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }

    @Test public void getAreaTriangleScalene() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,0);
        Point p3 = new Point(2,1);
        assertEquals(1.5, Functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }
}
