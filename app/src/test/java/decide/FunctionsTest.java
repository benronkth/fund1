package decide;

import org.junit.Test;

import decide.datastructures.Point;

import static org.junit.Assert.*;

public class FunctionsTest {
    Functions functions = new Functions();
    double precisionDelta = 0.00001;

    @Test public void distanceCalculatedBetweenTwoPoints() {
        Point startPoint = new Point(-3, 0);
        Point endPoint = new Point(0, 4);

        assertEquals(5,functions.getDistance(startPoint, endPoint), precisionDelta);
    }

    @Test public void distanceBetweenPointsThatAreAtTheSamePosition() {
        Point startPoint = new Point(0, 0); 

        assertEquals(0,functions.getDistance(startPoint, startPoint), precisionDelta);
    }



    /**
     * Edge cases:
     * Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     */

    @Test public void theQuadrantForPointZeroAndZero() {
        Point point = new Point(0, 0); 
        assertEquals(1,functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPointMinusOneAndZero() {
        Point point = new Point(-1, 0); 
        assertEquals(2,functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPointZeroAndMinusOne() {
        Point point = new Point(0, -1); 
        assertEquals(3,functions.getQuadrant(point));
    }
    
    @Test public void theQuadrantForPointZeroAndOne() {
        Point point = new Point(0, 1); 
        assertEquals(1,functions.getQuadrant(point));
    }
    @Test public void theQuadrantForPointOneAndZero() {
        Point point = new Point(1, 0); 
        assertEquals(1,functions.getQuadrant(point));
    }

    // Other Cases

    
    @Test public void theQuadrantForPointOneAndOne() {
        Point point = new Point(1, 1); 
        assertEquals(1,functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPointMinusOneAndMinusOne() {
        Point point = new Point(-1, -1); 
        assertEquals(3,functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPointMinus10And8() {
        Point point = new Point(-10, 8); 
        assertEquals(2,functions.getQuadrant(point));
    }

    @Test public void theQuadrantForPoint15AndMinus7() {
        Point point = new Point(15, -7); 
        assertEquals(4,functions.getQuadrant(point));
    }

    @Test public void getAreaTriangle0() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(2,0);
        assertEquals(0, functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }

    @Test public void getAreaTriangleRect() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,0);
        Point p3 = new Point(0,4);
        assertEquals(6, functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }

    @Test public void getAreaTriangleScalene() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,0);
        Point p3 = new Point(2,1);
        assertEquals(1.5, functions.getAreaTriangle(p1, p2, p3), precisionDelta);
    }
}
