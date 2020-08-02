package at.fhooe.ams.funk.util;

import at.fhooe.ams.funk.model.Coordinate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class MathUtils {

  public static double euclideanDistance(Coordinate p, Coordinate q) {
    return Math.sqrt(Math.pow(p.getX() - q.getX(), 2.0) + Math.pow(p.getY() - q.getY(), 2.0));
  }

  public static double manhattanDistance(Coordinate p, Coordinate q) {
    return Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
  }

  public static double checkerboardDistance(Coordinate p, Coordinate q) {
    return Math.max(Math.abs(p.getX() - q.getX()), Math.abs(p.getY() - q.getY()));
  }

}
