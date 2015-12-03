package cs4800.clusteringproject.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents an undirected graph with vertices and edges
 */
public final class Graph {
  private final ArrayList<Vertex> vertices;
  private final ArrayList<Edge> edges;

  /**
   * Constructor for a {@link Graph} if the edges have not already been generated
   *
   * @param vertices the vertices of the {@link Graph}
   */
  public Graph(ArrayList<Vertex> vertices) {
    this.vertices = vertices;
    this.edges = this.createEdges(this.vertices);
  }

  /**
   * Constructor for a {@link Graph} if the vertices and edges have already been generated
   *
   * @param vertices the vertices of the {@link Graph}
   * @param edges    the edges of the {@link Graph}
   */
  public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
  }

  /**
   * Gets the vertices of the {@link Graph}
   *
   * @return the vertices of the {@link Graph}
   */
  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }

  /**
   * Gets the edges of the {@link Graph}
   *
   * @return the edges of the {@link Graph}
   */
  public ArrayList<Edge> getEdges() {
    return this.edges;
  }

  /**
   * Creates the edges in the {@link Graph}
   *
   * @param vertices the vertices to make edges from
   * @return a collection of the edges in the {@link Graph}
   */
  public ArrayList<Edge> createEdges(ArrayList<Vertex> vertices) {
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

  /**
   * Calculates the weight of an edge
   *
   * @param v1 the starting {@link Vertex} of the {@link Edge}
   * @param v2 the ending {@link Vertex} of the {@link Edge}
   * @return the weight of the {@link Edge}
   */
  public double calculateEdgeWeight(Vertex v1, Vertex v2) {
    double weight = 0.0;
    for (int i = 0; i < v1.getAttributes().length; i++) {
      weight += Math.pow(v1.getAttributes()[i] - v2.getAttributes()[i], 2);
    }
    return Math.sqrt(weight);
  }
}