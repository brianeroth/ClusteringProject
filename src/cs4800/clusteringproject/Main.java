package cs4800.clusteringproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import cs4800.clusteringproject.Algorithms.Cluster;
import cs4800.clusteringproject.Algorithms.Kruskal;
import cs4800.clusteringproject.Graph.Graph;
import cs4800.clusteringproject.Graph.Vertex;

/**
 * Main entry point for program. See README on how to setup.
 */
public final class Main {
  public static void main(String[] args) {
    if (Integer.parseInt(args[1]) <= 1) {
      throw new IllegalArgumentException("K needs to be greater than 1.");
    }
    int k = Integer.parseInt(args[1]);
    Graph minimumSpanningTree = Kruskal.run(new Graph(parseFile(args[0])));
    ArrayList<ArrayList<Vertex>> clusters = Cluster.kClustering(minimumSpanningTree, k);
    clusters.forEach(System.out::println);
    System.out.println("Purity for "+ k + "-clustering: " + Cluster.calculatePurity(clusters));
  }

  /**
   * Parses a file line by line into a collection of vertices
   *
   * @param fileName the name of the file to be processed
   * @return a collection of vertices
   */
  public static ArrayList<Vertex> parseFile(String fileName) {
    ArrayList<Vertex> vertices = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String currLine;
      int lineCount = 0;
      while ((currLine = reader.readLine()) != null) {
        if (lineCount >= 96) {
          String[] thisLineData = currLine.split(",");
          double[] attributes = new double[19];
          for (int i = 0; i < thisLineData.length - 1; i++) {
            attributes[i] = Double.parseDouble(thisLineData[i]);
          }
          vertices.add(new Vertex(thisLineData[thisLineData.length - 1], attributes));
        }
        lineCount++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return vertices;
  }
}