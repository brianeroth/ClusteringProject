package cs4800.clusteringproject.Graph;

import java.util.Objects;

/**
 * Represents an edge in a graph
 */
public final class Edge implements Comparable {
  private final double weight;
  private final Vertex startVertex, endVertex;

  /**
   * Constructor for an {@link Edge}
   *
   * @param weight the weight of the {@link Edge}
   * @param startVertex the starting {@link Vertex} of the {@link Edge}
   * @param endVertex the ending {@link Vertex} of the {@link Edge}
   */
  public Edge(double weight, Vertex startVertex, Vertex endVertex) {
    this.weight = weight;
    this.startVertex = startVertex;
    this.endVertex = endVertex;
  }

  /**
   * Gets the weight of the {@link Edge}
   *
   * @return the weight of the {@link Edge}
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Gets the starting {@link Vertex} of the {@link Edge}
   *
   * @return the starting {@link Vertex} of the {@link Edge}
   */
  public Vertex getStartVertex() {
    return this.startVertex;
  }

  /**
   * Gets the ending {@link Vertex} of the {@link Edge}
   *
   * @return the ending {@link Vertex} of the {@link Edge}
   */
  public Vertex getEndVertex() {
    return this.endVertex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Edge edge = (Edge) o;
    return Double.compare(edge.getWeight(), this.getWeight()) == 0 &&
        Objects.equals(this.getStartVertex(), edge.getStartVertex()) &&
        Objects.equals(this.getEndVertex(), edge.getEndVertex());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getWeight(), this.getStartVertex(), this.getEndVertex());
  }

  @Override
  public int compareTo(Object o) {
    Edge o1 = (Edge) o;
    return (int) this.getWeight() - (int) o1.getWeight();
  }
}