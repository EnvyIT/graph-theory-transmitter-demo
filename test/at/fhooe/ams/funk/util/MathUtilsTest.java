package at.fhooe.ams.funk.util;

import at.fhooe.ams.funk.model.Coordinate;
import at.fhooe.ams.funk.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

  @Test
  void euclideanDistance() {
    //arrange
    Coordinate pointP = new Point(5, 5, 1);
    Coordinate pointQ = new Point(4, 2, 2);
    //act
    double result = MathUtils.euclideanDistance(pointP, pointQ);
    //assert
    Assertions.assertEquals(3.16228, result, 0.0001);
  }

  @Test
  void manhattanDistance() {
    //arrange
    Coordinate pointP = new Point(5, 5, 1);
    Coordinate pointQ = new Point(4, 2, 2);
    //act
    double result = MathUtils.manhattanDistance(pointP, pointQ);
    //assert
    Assertions.assertEquals(4, result);
  }

  @Test
  void checkerboardDistance() {
    //arrange
    Coordinate pointP = new Point(5, 5, 1);
    Coordinate pointQ = new Point(4, 2, 2);
    //act
    double result = MathUtils.checkerboardDistance(pointP, pointQ);
    //assert
    Assertions.assertEquals(3, result);
  }
}
