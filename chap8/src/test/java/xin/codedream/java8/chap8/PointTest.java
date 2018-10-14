package xin.codedream.java8.chap8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * PointTest
 *
 * @author NGLSL
 * @date 2018/10/14
 */
public class PointTest {

    @Test
    public void testMoveRightBy() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);

        Assert.assertEquals(15, p2.getX());
        Assert.assertEquals(5, p2.getY());
    }

    @Test
    public void testComparingTwoPoints() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.COMPARE_BY_X_AND_THEN_Y.compare(p1, p2);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testMoveAllPointsRightBy() {
        List<Point> points =
                Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints =
                Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        Assert.assertEquals(expectedPoints, newPoints);
    }
}