
package graphpractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph implements GraphInterface<Town,Road> {
      Town vertex;
      ArrayList<Town> graph;
    private ArrayList<String> towns = new ArrayList<>();
    Graph() 
    {
      graph= new ArrayList<>();
    }

    @Override
    public boolean addVertex(Town town) {
     
       graph.add(town);
       towns.add(town.name);
       return true;
    }

    @Override
    public boolean addEdge(Town source, Town destination, int weight, String name) 
    { 
       
        boolean bool=false;
           for(int i=0;i<graph.size();i++)
       {
          
          if(graph.get(i).name == null ? source.name == null : graph.get(i).name.equals(source.name)) 
          {
            Road edge = new Road(source, destination, weight, name);
            graph.get(i).setAdjTown(edge);
            bool = true;
          }
          if(graph.get(i).name == null ? destination.name == null : graph.get(i).name.equals(destination.name)) 
          {
            Road edge = new Road(destination,source, weight, name);
            graph.get(i).setAdjTown(edge);
          }
       
       }
           return bool;
    }

    @Override
    public boolean containsEdge(Town source, Town destination) 
    {
        ArrayList<Road> adj= new ArrayList<Road>();
    
       for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == source.name ) 
          {
              adj = graph.get(i).getAdjTown();
              break;
          }
       }
                for(int i=0;i<adj.size();i++)
                {
                   if(adj.get(i).start.name==source.name && adj.get(i).end.name==destination.name) 
                   {
                       return true;
                   }
                }
       return false;
    }

    @Override
    public boolean containsVertex(Town town) 
    {
        for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == town.name ) 
          {
            return true;
          }
        }
        return false;
    }

    @Override
    public ArrayList<String> edgeSet() 
    {
        
    ArrayList<Road> edges = new ArrayList<>();
          for(int i=0;i<graph.size();i++)
            {
              edges.addAll(graph.get(i).getAdjTown());
            }
          
         ArrayList<String> roads = new ArrayList<>();
         for(int j=0;j<edges.size();j++)
         {
             roads.add(edges.get(j).name);
         }
        return roads;
       
    }

    @Override
    public ArrayList<Road> edgesOf(Town town) 
    {
         for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == town.name ) 
          {
              return graph.get(i).getAdjTown();
          }
       }
        return null;
       
    }

    @Override
    public boolean removeEdge(Town town, Town town0, int wight, String road_12) {
       boolean found = false;
        for(int i=0;i<graph.size();i++)
       {
           Town town1 = graph.get(i);
          if(town1.name==town.getName()) 
          {
           
                ArrayList<Road> adjTown1 = town1.getAdjTown();
                 for(int j=0;j<adjTown1.size();j++)
                 {
                     
                        if(adjTown1.get(j).end.name == town0.name)
                        {
                            found = true;
                            town1.adjTown.remove(j);
                        }
                 }
     
                 
          }
          else if(town1.name==town0.getName()) 
          {
               
                ArrayList<Road> adjTown1 = town1.getAdjTown();
                 for(int j=0;j<adjTown1.size();j++)
                 {
                  
                        if(adjTown1.get(j).end.name == town.name)
                        {
                            town1.adjTown.remove(j);
                        }
                 }
     
                 
          }
         }
        return found;
     }

    @Override
    public boolean removeVertex(Town town) 
    {
         boolean found = false;
        for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == town.name ) 
          {
              graph.remove(i);
              found = true;
          }
       }
        return found;
    }

    @Override
    public Town getVertex(Town town) 
    {
        
        for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == town.name ) 
          {
              return graph.get(i);
          }
       }
        return null;
    }
    
    @Override
    public ArrayList<String> vertexSet() 
    {
        ArrayList<String> set = new ArrayList<>();
        for(int j=0;j<graph.size();j++)
         {
             set.add(graph.get(j).name);
         }
         return set;
    }
       


    @Override
    public String getEdge(Town vertex, Town vertex0) 
    {
        for(int i=0;i<graph.size();i++)
       {
          if(graph.get(i).name == vertex.name) 
          {
              ArrayList<Road> edge= graph.get(i).getAdjTown();
             
                      for(int j=0;j<edge.size();j++)
                      {
                          if(edge.get(i).end.name == vertex0.name) 
                          {
                              
                              System.out.println("Found");
                              
                              return edge.get(i).name;
                          }
                      }
          }
       }
        return null;
    }

      @Override
  public void printGraph()
  {
         for(int i=0;i<graph.size();i++)
       {
           System.out.print(graph.get(i).name+": ");
           ArrayList<Road> adjTown = graph.get(i).getAdjTown();
           for(int j=0;j<adjTown.size();j++)
           {
                System.out.print(adjTown.get(j).end.name+"="+adjTown.get(j).distance+",");
           }
             System.out.println();
       }
  }

  
  
   
    
      public int minimumDistance(int distance[], Boolean spSet[])  
        {  
              
            int min_dis = Integer.MAX_VALUE, min_index = -1;  
            for (int j= 0; j < graph.size(); j++)  
            {  
                if (spSet[j] == false && distance[j] < min_dis)   
                {  
                    min_dis = distance[j];  
                    min_index = j;  
                }  
            }  
        return min_index;  

        }

public ArrayList<String>  dijkstra(Town s,Town destination)  
{  

        boolean found=false;
        int distance[] = new int[graph.size()]; 
        Boolean spSet[] = new Boolean[graph.size()];  
        ArrayList<String> vertices =  new ArrayList<String>(); 
        ArrayList<String> previous = new ArrayList<String>();
         ArrayList<String> routes = new ArrayList<String>();
        for (int j = 0; j < graph.size(); j++)   
        {  
        distance[j] = Integer.MAX_VALUE;  
        spSet[j] = false;  
        vertices.add(graph.get(j).name);
        previous.add(null);
        }  
        int currentIndex= vertices.indexOf(s.name);
        distance[currentIndex] = 0;  
        previous.set(currentIndex, null);
        int prev=0;
        for (int k = 0; k < graph.size() - 1; k++)   
        {   
//
        int current = minimumDistance(distance, spSet);  
         Town vtr=null;
        if(current!=-1)
        { 
            vtr = graph.get(current);
        }

       if(vtr.name == null ? destination.name == null : vtr.name.equals(destination.name))
       {
           found = true; 
          System.out.print("Destination reached");
       }
       else
       {
        ArrayList<Road> road = vtr.getAdjTown();
        for (int j = 0; j < road.size(); j++)  
        {
            currentIndex = vertices.indexOf(road.get(j).end.name);
              // System.out.println(vtr.name + " Distance "+road.get(j).end.name);
             if (!spSet[currentIndex] //// not visited
                 && distance[current] != Integer.MAX_VALUE
                && distance[current] + road.get(j).distance < distance[currentIndex])   //// distance less than that
                {  
                  distance[currentIndex] = distance[current] + road.get(j).distance;
                  previous.set(currentIndex,vertices.get(current));
                } 
             prev = currentIndex;
        }
         spSet[current] = true;  

       }
        }
       
        if(found)
        {
             int previousIndex = vertices.indexOf(destination.name);
               routes.add(vertices.get(previousIndex));
             while(!vertices.get(previousIndex).equals(s.name))
             {
       //          System.out.println(vertices.get(previousIndex)+" is previous");
                 previousIndex = vertices.indexOf(previous.get(previousIndex)); 
                 routes.add(vertices.get(previousIndex));
             }
             ArrayList<String> path = new ArrayList<String>();
           //  int i=0;
             for(int j=routes.size()-1;j>=0;j--)
             {
                 path.add(routes.get(j));
             }

           return path; 
        }
        else
        {
             return null;
        }
       
}
 
    public void populateTownGraph(java.io.File codeFile) throws IOException
    {
            String resulted = "";
            File file= codeFile;
            FileReader fr=new FileReader(codeFile);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;
            while((line=br.readLine())!=null)
            {
                String[] result = line.split(",");
                String roadName = result[0];
                String[] results = result[1].split(";");
                int weight = Integer.parseInt(results[0]);
                String town1 = results[1];
                String town2 = results[2];
                if(!towns.contains(town1))
                 {
                     addVertex(new Town(town1));
                 }
                if(!towns.contains(town2))
                     {
                      addVertex(new Town(town2));
                     }
                  addEdge(new Town(town1),new Town(town2),weight,roadName);
            }
            fr.close();
       
    }
    
}
