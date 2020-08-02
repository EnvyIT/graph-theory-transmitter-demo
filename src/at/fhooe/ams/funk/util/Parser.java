package at.fhooe.ams.funk.util;

import at.fhooe.ams.funk.model.Point;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

  public static Graph<Integer, DefaultWeightedEdge> parseGraph(String input) {
    Graph<Integer, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    List<Point> points = parseToPoints(input);
    points.forEach(point -> graph.addVertex(point.getName()));
    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        DefaultWeightedEdge edge = graph.addEdge(points.get(i).getName(), points.get(j).getName());
        graph.setEdgeWeight(edge, MathUtils.euclideanDistance(points.get(i), points.get(j)));
      }
    }
    return graph;
  }

  private static List<Point> parseToPoints(String input) {
    List<Point> points = new ArrayList<>();
    String normalized = StringUtil.normalizeTuple(StringUtil.normalizeSet(input));
    String[] split = normalized.split(",");
    for (int i = 0; i < split.length; i += 2) {
      points.add(new Point(Double.parseDouble(split[i]), Double.parseDouble(split[i + 1]), (i/2) + 1));
    }
    return points;
  }

}
