package cs4800.clusteringproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import cs4800.clusteringproject.Algorithms.Kruskal;
import cs4800.clusteringproject.Graph.UndirectedGraph;
import cs4800.clusteringproject.Graph.Vertex;

public final class Main {
  public static void main(String[] args) {
    UndirectedGraph mst = Kruskal.run(new UndirectedGraph(parseFile(args[0])));
  }

  public static ArrayList<Vertex> parseFile(String fileName) {
    ArrayList<Vertex> result = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String currLine;
      int lineCount = 0;
      while ((currLine = reader.readLine()) != null) {
        if (lineCount >= 96) {
          ArrayList<Double> r = new ArrayList<>();
          String[] thisLineData = currLine.split(",");
          for (int i = 0; i < 19; i++) {
            r.add(Double.parseDouble(thisLineData[i]));
          }
          result.add(new Vertex(thisLineData[19], r));
        }
        lineCount++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}