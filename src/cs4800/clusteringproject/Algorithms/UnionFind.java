package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import cs4800.clusteringproject.Graph.Vertex;

public final class UnionFind {
  private final HashMap<Vertex, ArrayList<Vertex>> children = new HashMap<>();
  private final HashMap<Vertex, Vertex> parent = new HashMap<>();

  public void create(Vertex v) {
    this.children.put(v, new ArrayList<>(Collections.singletonList(v)));
    this.parent.put(v, v);
  }

  public Vertex find(Vertex v) {
    return this.parent.get(v);
  }

  public void union(Vertex a, Vertex b) {
    if (this.children.get(this.find(a)).size() > this.children.get(this.find(b)).size()) {
      for (Vertex v : this.children.get(this.find(b))) {
        this.parent.put(v, this.find(a));
        this.children.get(this.find(a)).add(v);
      }
    } else {
      for (Vertex v : this.children.get(this.find(a))) {
        this.parent.put(v, this.find(b));
        this.children.get(this.find(b)).add(v);
      }
    }
  }
}
