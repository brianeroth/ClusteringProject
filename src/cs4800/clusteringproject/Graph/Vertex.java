package cs4800.clusteringproject.Graph;

import java.util.Arrays;

/**
 * Represents a vertex in a graph
 */
public final class Vertex {
  private final String label;
  private final double[] attributes;

  /**
   * Constructor for a {@link Vertex}
   *
   * @param label the label of the vertex
   * @param attributes the vertex's attributes from low-level image processing algorithms
   */
  public Vertex(String label, double[] attributes) {
    this.label = label;
    this.attributes = attributes;
  }

  /**
   * Gets the label of the {@link Vertex}
   *
   * @return the label of the {@link Vertex}
   */
  public String getLabel() {
    return this.label;
  }

  /**
   * Gets the attributes of the {@link Vertex}
   *
   * @return the attributes of the {@link Vertex}
   */
  public double[] getAttributes() {
    return this.attributes;
  }

  @Override
  public String toString() {
    return "(Vertex) " +
              "label:" + this.label +
              "data:"  + Arrays.toString(this.attributes);
  }
}