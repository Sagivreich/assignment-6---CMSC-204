package graphpractice;





import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class GraphTest {
	private static Graph graph= new Graph();;
	private static Town[] town = new Town[12];
		 
public static void main(String[] args)
    {
       
		  
		  for (int i = 1; i < 6; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road_1");
		  graph.addEdge(town[1], town[3], 4, "Road_2");
                  graph.addEdge(town[2], town[3], 4, "Road_6");
		  graph.addEdge(town[1], town[5], 6, "Road_3");
		  graph.addEdge(town[3], town[5], 1, "Road_4");
		  graph.addEdge(town[4], town[5], 2, "Road_5");
                  graph.printGraph();
               
                 ArrayList<String> array=  graph.dijkstra(town[1], town[3]);
                 if(array!=null)
                 {
                       for(int j=0;j<array.size();j++)
                        {
                            System.out.print(array.get(j)+" ");
                        }
                 }
             
	}


}