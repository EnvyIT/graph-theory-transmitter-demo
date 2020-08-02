package at.fhooe.ams.funk.algorithm;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NetworkTransmissionController {

  public static Map<Integer, Double> getMinimumRadiusPerTransmitter(Graph<Integer, DefaultWeightedEdge> graph) {
    SpanningTree<DefaultWeightedEdge> spanningTree = calculateSpanningTree(graph);
    Set<Integer> vertices = graph.vertexSet();
    Map<Integer, Double> radii = vertices.stream().collect(Collectors.toMap(v -> v, v -> 0.0));
    vertices.forEach(vertex -> {
     spanningTree.getEdges().stream()
        .filter(defaultWeightedEdge -> graph.getEdgeSource(defaultWeightedEdge).equals(vertex) || graph.getEdgeTarget(defaultWeightedEdge).equals(vertex))
        .forEach(edge -> {
          double radius = graph.getEdgeWeight(edge);
          if(radii.get(vertex) < radius) {
            radii.put(vertex, radius);
          }
        });
    });
    return radii;
  }

  private static SpanningTreeAlgorithm.SpanningTree<DefaultWeightedEdge> calculateSpanningTree(
      Graph<Integer, DefaultWeightedEdge> graph) {
    return new KruskalMinimumSpanningTree<>(graph).getSpanningTree();
  }

  public static void print(Map<Integer, Double> actualRadii) {
    System.out.println("\n============ Optimal radius for transmitters ===============");
    actualRadii.forEach((key, value) -> System.out.printf("Transmitter: %d - Radius: %f\n", key, value));
  }

}
