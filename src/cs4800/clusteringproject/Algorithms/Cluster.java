package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import cs4800.clusteringproject.Graph.Edge;
import cs4800.clusteringproject.Graph.Graph;
import cs4800.clusteringproject.Graph.Vertex;

/**
 * Represents a clustering algorithm for graphs
 */
public final class Cluster {
  /**
   * Performs a clustering based on a given value for k
   *
   * @param graph the graph to be clustered
   * @param k     the value of k
   * @return forest of graphs
   */
  public static ArrayList<ArrayList<Vertex>> kClustering(Graph graph, int k) {
    UF uf = new UF();
    ArrayList<Edge> edges = new ArrayList<>(graph.getEdges());
    for (int i = 0; i < k - 1; i++) {
      edges.remove(Collections.max(edges));
    }
    graph.getVertices().forEach(uf::create);
    for (Edge e : edges) {
      uf.union(e.getStartVertex(), e.getEndVertex());
    }
    return uf.clusters();
  }

  /**
   * Finds the most frequent {@link Vertex} {@code label} in a collection
   *
   * @param vertices the vertices to evaluate
   * @return the most frequent {@code label} in a collection of vertices
   */
  public static int findMostFrequentLabel(ArrayList<Vertex> vertices) {
    HashMap<String, Integer> frequencyMap = new HashMap<>();
    for (Vertex v : vertices) {
      if (frequencyMap.containsKey(v.getLabel())) {
        frequencyMap.put(v.getLabel(), frequencyMap.get(v.getLabel()) + 1);
      } else {
        frequencyMap.put(v.getLabel(), 1);
      }
    }
    return Collections.max(frequencyMap.values());
  }

  /**
   * Calculates the purity of a forest
   *
   * @param forest the forest to be evaluated
   * @return the purity of the forest
   */
  public static double calculatePurity(ArrayList<ArrayList<Vertex>> forest) {
    int numOfVertices = 0;
    int mostFrequentLabel = 0;
    for (ArrayList<Vertex> vertices : forest) {
      numOfVertices += vertices.size();
      mostFrequentLabel += findMostFrequentLabel(vertices);
    }
    return (1.0 / numOfVertices) * mostFrequentLabel;
  }
}