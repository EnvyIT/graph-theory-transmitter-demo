package at.fhooe.ams.funk.util;

import at.fhooe.ams.funk.model.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

  @Test
  public void parserShouldParseInputAndContainAllPointsWithNames() {
    String input = "{(2,2),(4,5),(3,3),(1,6)}";
    Graph<Integer, DefaultWeightedEdge> graph = Parser.parseGraph(input);
    Set<Integer> vertices = graph.vertexSet();
    Assertions.assertEquals(4, vertices.size());
    List<Point> expectedPoints = createPointList(
        new Point(2, 2, 1),
        new Point(4, 5, 2),
        new Point(3, 3, 3),
        new Point(1, 6, 4));
    expectedPoints.forEach(expectedPoint -> Assertions.assertTrue(vertices.contains(expectedPoint.getName()), String.format("Should contain %s", expectedPoint.getName())));
  }

  private List<Point> createPointList(Point... expectedPoints) {
    return Arrays.stream(expectedPoints).collect(Collectors.toList());
  }

}
