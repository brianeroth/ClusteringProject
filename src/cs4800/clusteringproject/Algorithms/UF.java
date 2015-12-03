package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import cs4800.clusteringproject.Graph.Vertex;

/**
 * Represents a Union-Find data structure
 */
public final class UF {
  private final HashMap<Vertex, Vertex> parent = new HashMap<>();
  private final HashMap<Vertex, ArrayList<Vertex>> children = new HashMap<>();

  /**
   * Puts the given {@link Vertex} in a singleton list
   *
   * @param v the {@link Vertex} to be put in a singleton list
   */
  public void create(Vertex v) {
    this.children.put(v, new ArrayList<>(Collections.singleton(v)));
    this.parent.put(v, v);
  }

  /**
   * Finds the given {@link Vertex} in the collection of parents
   *
   * @param v the {@link Vertex} to be found
   */
  public Vertex find(Vertex v) {
    return this.parent.get(v);
  }

  /**
   * Unions two vertices together
   *
   * @param v1 the first {@link Vertex} to be unioned
   * @param v2 the second {@link Vertex} to be unioned
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

  /**
   * Creates a forest
   *
   * @return a forest of graphs
   */
  public ArrayList<ArrayList<Vertex>> clusters() {
    HashMap<Vertex, ArrayList<Vertex>> graphs = new HashMap<>();
    ArrayList<ArrayList<Vertex>> forest = new ArrayList<>();
    for (Vertex v : this.parent.keySet()) {
      if (graphs.containsKey(this.find(v))) {
        graphs.get(this.find(v)).add(v);
      } else {
        graphs.put(this.find(v), new ArrayList<>(Collections.singleton(v)));
      }
    }
    forest.addAll(graphs.keySet().stream().map(graphs::get).collect(Collectors.toList()));
    return forest;
  }
}
