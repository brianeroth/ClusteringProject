package cs4800.clusteringproject.Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import cs4800.clusteringproject.Graph.Edge;
import cs4800.clusteringproject.Graph.UndirectedGraph;
import cs4800.clusteringproject.Graph.Vertex;

public final class Kruskal {
  public static UndirectedGraph run(UndirectedGraph graph) {
    UnionFind uf = new UnionFind();
    ArrayList<Edge> edges = new ArrayList<>();
    graph.getVertices().forEach(uf::create);
    graph.getEdges().stream().filter(e -> uf.find(e.getStartVertex())
        != uf.find(e.getEnd())).forEach(e -> {
      edges.add(e);
      uf.union(e.getStartVertex(), e.getEnd());
    });
    return new UndirectedGraph(edgesToVertices(edges), edges);
  }

  public static ArrayList<Vertex> edgesToVertices(ArrayList<Edge> edges) {
    HashSet<Vertex> vertices = new HashSet<>();
    ArrayList<Vertex> outVertices = new ArrayList<>();
    for (Edge e : edges) {
      vertices.add(e.getStartVertex());
      vertices.add(e.getEnd());
    }
    outVertices.addAll(vertices.stream().collect(Collectors.toList()));
    return outVertices;
  }
}
