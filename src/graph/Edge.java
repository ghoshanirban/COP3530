package graph;

public class Edge {
    private final int source, destination; // an edge is represented using a pair of integers
    private double weight = 1.0; // default value

    public Edge(int source, int destination) { // this constructor is used when the edge is not weighted
        this.source = source; this.destination = destination;
    }

    public Edge(int source, int destination, double w) { // this constructor is used when the edge is weighted
        this.source = source; this.destination = destination;
        weight = w;
    }

    public Integer getSource() { return source; }
    public Integer getDestination() { return destination; }
    public double getWeight() { return weight; }

    public boolean equals(Object obj) {
        if (obj instanceof Edge)
            return (source == ((Edge) obj).source && destination == ((Edge) obj).destination);
        else
            return false;
    }

    public String toString() {
        return source + ", " + destination + ", " + weight;
    }

    public int hashCode() { // a hashCode method for the Edge class that uses left shifts and XOR operator
        return (source << 16) ^ destination;
    }
}