/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

import java.util.ArrayList;

public interface GraphInterface<Town,Road> {

    public boolean addVertex(Town town);
    public boolean addEdge(Town town, Town town0, int i, String road_1);
    public boolean containsEdge(Town town, Town town0);
    public boolean containsVertex(Town town);
    public ArrayList<String> edgeSet();
    public ArrayList<Road> edgesOf(Town town);
    public boolean removeEdge(Town town, Town town0, int i, String road_1);
    public boolean removeVertex(Town town);
    public ArrayList<String> vertexSet();
//    public ArrayList<String> shortestpath(Town beginIndex, Town endIndex);
    public String getEdge(Town vertex, Town vertex0);
    public void printGraph();
    public ArrayList<String> dijkstra(Town s,Town destination);
    public Town getVertex(Town vtr);
}
