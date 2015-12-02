package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import cs4800.clusteringproject.Graph.Vertex;

/**
 * Represents a Union-Find data structure
 */
public final class UnionFind {
  private final HashMap<Vertex, ArrayList<Vertex>> children = new HashMap<>();
  private final HashMap<Vertex, Vertex> parent = new HashMap<>();

  /**
   * Puts the given {@link Vertex} in a singleton list
   *
   * @param v the {@link Vertex} to be put in a singleton list
   */
  public void create(Vertex v) {
    this.children.put(v, new ArrayList<>(Collections.singletonList(v)));
    this.parent.put(v, v);
  }

  /**
   * Finds the given {@link Vertex} in the collection of parents
   *
   * @param v the {@link Vertex} to be found
   * @return
   */
  public Vertex find(Vertex v) {
    return this.parent.get(v);
  }

  /**
   *
   * @param v1
   * @param v2
   */
  public void union(Vertex v1, Vertex v2) {
    if (this.children.get(this.find(v1)).size() > this.children.get(this.find(v2)).size()) {
      for (Vertex v : this.children.get(this.find(v2))) {
        this.parent.put(v, this.find(v1));
        this.children.get(this.find(v1)).add(v);
      }
    } else {
      for (Vertex v : this.children.get(this.find(v1))) {
        this.parent.put(v, this.find(v2));
        this.children.get(this.find(v2)).add(v);
      }
    }
  }
}
