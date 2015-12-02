package cs4800.clusteringproject.Graph;

import java.util.Objects;

/**
 * Represents an edge in a graph
 */
public final class Edge implements Comparable {
  private final double weight;
  private final Vertex start, end;

  /**
   * Constructor for an {@link Edge}
   * @param weight the weight of the {@link Edge}
   * @param start the starting {@link Vertex} of the {@link Edge}
   * @param end the ending {@link Vertex} of the {@link Edge}
   */
  public Edge(double weight, Vertex start, Vertex end) {
    this.weight = weight;
    this.start = start;
    this.end = end;
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
  public Vertex getStart() {
    return this.start;
  }

  /**
   * Gets the ending {@link Vertex} of the {@link Edge}
   *
   * @return the ending {@link Vertex} of the {@link Edge}
   */
  public Vertex getEnd() {
    return this.end;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Edge edge = (Edge) o;
    return Double.compare(edge.getWeight(), getWeight()) == 0 && !(getStart() != null ?
        !getStart().equals(edge.getStart()) :
        edge.getStart() != null) && !(getEnd() != null ?
        !getEnd().equals(edge.getEnd()) :
        edge.getEnd() != null);

  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getStart(), this.getEnd(), this.getWeight());
  }

  @Override
  public int compareTo(Object o) {
    Edge o2 = (Edge) o;
    if(this.getWeight() > o2.getWeight()) {
      return 1;
    } else if (this.getWeight() < o2.getWeight()) {
      return -1;
    } else {
      return 0;
    }
  }
}
