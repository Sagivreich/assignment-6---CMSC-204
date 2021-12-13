///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package graphpractice;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class TownGraphManager implements TownGraphManagerInterface{
//        private final GraphInterface<Town,Road> graph= new Graph();;
//	private final  ArrayList<String> towns = new ArrayList<>();
//    @Override
//    public boolean addRoad(String town1, String town2, int weight, String roadName) {
//             Town t1 = new Town(town1);
//             Town t2 = new Town(town2);
//             boolean result = graph.addEdge(t1, t2, weight, roadName);
//             return result;
//    }
//
//    @Override
//    public String getRoad(String town1, String town2) 
//    {
//         String result = graph.getEdge(new Town(town1), new Town(town2));
//         return result;
//    }
//
//    @Override
//    public boolean addTown(String v) {
//                          Town town = new Town(v);
//                          if(!towns.contains(v))
//                          {
//                               graph.addVertex(town);
//                               towns.add(town.name);
//                               return true;
//                          }
//                          return false;
//			 
//       }
//
//    @Override
//    public Town getTown(String name) 
//    {
//       Town vtr = graph.getVertex(new Town(name));
//        return  vtr;
//    }
//
//    @Override
//    public boolean containsTown(String v) 
//    {
//        boolean contains = graph.containsVertex(new Town(v));
//        return contains;
//    }
//
//    @Override
//    public boolean containsRoadConnection(String town1, String town2) 
//    {
//         boolean contains = graph.containsEdge(new Town(town1),new Town(town1));
//         return contains;
//       
//    }
//
//    @Override
//    public ArrayList<String> allRoads() 
//    {
//         ArrayList<Road>  list = graph.edgeSet();
//          ArrayList<String>  roads = new ArrayList<>();
//         for(int j=0;j<list.size();j++)
//         {
//             roads.add(list.get(j).name);
//         }
//         return roads;
//     }
//
//    @Override
//    public boolean deleteRoadConnection(String town1, String town2, String road) 
//    {
//          boolean contains = graph.removeEdge(new Town(town1), new Town(town2), 0, road);
//          return contains;
//    }
//
//    @Override
//    public boolean deleteTown(String v) {
//         boolean contains = graph.removeVertex(new Town(v));
//         return contains;
//      }
//
//    @Override
//    public ArrayList<String> allTowns() {
//        ArrayList<Town> str = graph.vertexSet();
//         ArrayList<String> town = new ArrayList<>();
//        for(int j=0;j<str.size();j++)
//         {
//             town.add(str.get(j).name);
//         }
//         return town;
//       }
//
//    @Override
//    public ArrayList<String> getPath(String town1, String town2) {
////        Town src = towns.get(getIndex(town1));
////        Town destination = towns.get(getIndex(town2));
//        ArrayList<String> path = graph.dijkstra(new Town(town1),new Town(town2));
//        return path;
//      }
////      public int getIndex(String town1){
////          for(int k=0;k<towns.size();k++)
////          {
////             if(towns.get(k).name==town1)
////             {
////                 return k;
////             }
////          }
////          return -1;
////      }
//    public void populateTownGraph(java.io.File codeFile) throws IOException
//    {
//            String resulted = "";
//            File file= codeFile;
//            FileReader fr=new FileReader(codeFile);
//            BufferedReader br=new BufferedReader(fr);
//            StringBuffer sb=new StringBuffer();
//            String line;
//            while((line=br.readLine())!=null)
//            {
//                String[] result = line.split(",");
//                String roadName = result[0];
//                String[] results = result[1].split(";");
//                int weight = Integer.parseInt(results[0]);
//                String town1 = results[1];
//                String town2 = results[2];
//                addTown(town1);
//                addTown(town2);
//                addRoad(town1,town2,weight,roadName);
//                System.out.println("Road "+roadName);
//                System.out.println("Miles " +weight);
//                System.out.println("Town1 "+town1);
//                System.out.println("Town2 "+town2);
//            }
//            fr.close();
//       
//    }
//    
//    public void printGraph()
//  {
//      graph.printGraph();
//  }
//}
