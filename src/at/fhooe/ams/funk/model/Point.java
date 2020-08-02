package at.fhooe.ams.funk.model;

import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point implements Coordinate {

  private double x;
  private double y;
  private int name;

  @Override
  public double getX() {
    return this.x;
  }

  @Override
  public double getY() {
    return this.y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return Double.compare(point.x, x) == 0 &&
        Double.compare(point.y, y) == 0 &&
        name == point.name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, name);
  }

  @Override
  public String toString() {
    return String.format("%s (%.2f , %.2f)", name, x, y);
  }

}
