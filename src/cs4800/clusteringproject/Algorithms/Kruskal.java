package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.HashSet;

import cs4800.clusteringproject.Graph.Edge;
import cs4800.clusteringproject.Graph.Graph;
import cs4800.clusteringproject.Graph.Vertex;

/**
 * Represents Kruskal's algorithm
 */
public final class Kruskal {
  /**
   * Runs Kruskal's algorithm with an {@link UF} data structure implementation
   *
   * @param graph the graph to be evaluated
   * @return the minimum spanning tree
   */
  public static Graph run(Graph graph) {
    UF uf = new UF();
    ArrayList<Edge> edges = new ArrayList<>();
    graph.getVertices().forEach(uf::create);
    graph.getEdges().stream().filter(e -> uf.find(e.getStartVertex()) != uf.find(e.getEndVertex()))
        .forEach(e -> {
          edges.add(e);
          uf.union(e.getStartVertex(), e.getEndVertex());
        });
    return new Graph(getVerticesFromEdges(edges), edges);
  }

  /**
   * Converts a collection of {@link Edge}s to a collection of {@link Vertex}
   *
   * @param edges the collection to be evaluated
   * @return a collection of {@link Vertex} based on the {@link Edge}s
   */
  public static ArrayList<Vertex> getVerticesFromEdges(ArrayList<Edge> edges) {
    HashSet<Vertex> vertices = new HashSet<>();
    for (Edge e : edges) {
      vertices.add(e.getStartVertex());
      vertices.add(e.getEndVertex());
    }
    return new ArrayList<>(vertices);
  }
}
