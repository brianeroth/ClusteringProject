package cs4800.clusteringproject.Graph;

import java.util.ArrayList;

/**
 * Represents a vertex in a graph
 */
public final class Vertex {
  private final String label;
  private final ArrayList<Double> attributes;

  /**
   * Constructor for a {@link Vertex}
   *
   * @param label the label of the vertex
   * @param attributes the vertex's attributes from low-level image processing algorithms
   */
  public Vertex(String label, ArrayList<Double> attributes) {
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
  public ArrayList<Double> getAttributes() {
    return this.attributes;
  }
}
