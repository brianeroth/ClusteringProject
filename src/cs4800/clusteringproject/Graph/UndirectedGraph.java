package cs4800.clusteringproject.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents an undirected graph with vertices and edges
 */
public final class UndirectedGraph {
  private final ArrayList<Vertex> vertices;
  private final ArrayList<Edge> edges;

  public UndirectedGraph(ArrayList<Vertex> vertices) {
    this.vertices = vertices;
    this.edges = this.makeEdges(this.vertices);
  }

  public UndirectedGraph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
  }

  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }

  public ArrayList<Edge> getEdges() {
    return this.edges;
  }

  public ArrayList<Edge> makeEdges(ArrayList<Vertex> vertices) {
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < vertices.size(); i++) {
      for (int j = i + 1; j < vertices.size(); j++) {
        edges.add(new Edge(this.calculateEdgeWeight(vertices.get(i), vertices.get(j)),
            vertices.get(i), vertices.get(j)));
      }
    }
    Collections.sort(edges);
    return edges;
  }

  public double calculateEdgeWeight(Vertex a, Vertex b) {
    double sum = 0;
    for (int i = 0; i < a.getAttributes().size(); i++) {
      sum += Math.pow((a.getAttributes().get(i) - b.getAttributes().get(i)), 2);
    }
    return Math.sqrt(sum);
  }
}
