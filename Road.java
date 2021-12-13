
package graphpractice;

public class Road implements Comparable<Road>{
     String name;
     Town start;
     Town end;
     int distance;

    public Road( Town reference_1,  Town reference_2, int distance,String name ) {
        this.start = reference_1;
        this.end = reference_2;
        this.name = name;
        this.distance = distance;
    }

    public void setSource( Town reference_1) {
        this.start = reference_1;
    }

    public void setDestination( Town reference_2) {
        this.end = reference_2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public  Town getSource() {
        return start;
    }

    public  Town getDestination() {
        return end;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Road o) 
    {
         if(this.distance == o.distance && this.end == o.end && this.name == o.name && this.start == o.start)
         {
            return 1; 
         }
         return -1;
    }
}
