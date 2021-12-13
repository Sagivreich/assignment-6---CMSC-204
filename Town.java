
package graphpractice;

import java.util.ArrayList;

public class Town implements Comparable<Town>
{
    String name;
    ArrayList<Road> adjTown;

    public Town() {
        adjTown = new  ArrayList<>();
    }

    public Town(String string) {
      this.name = string;
      this.adjTown= new  ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Road> getAdjTown() {
        return adjTown;
    }

//     public void removeTown(Town town) {
//          System.out.println(town.name);
//           ArrayList<Edge> adjTown1 = town.getAdjTown();
//         for(int i=0;i<adjTown1.size();i++)
//         {
//             System.out.println(adjTown1.get(i).end.name+ " is the name in loop");
////             if(adjTown.get(i).name == town.name)
////             {
////                 
////                 adjTown.remove(i);
////             }
//         }
//       
//    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAdjTown(Road adjTown) {
        this.adjTown.add(adjTown);
    }

    @Override
    public int compareTo(Town o) 
    {
        if(this.name == o.name)
        {
            return 1;
        }
        return -1;
    }
    
}
