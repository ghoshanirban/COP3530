package graph;

import sets.HashSetSeparateChaining;
import java.util.*;

public class Graph implements GraphADT { // the vertices are numbered from 0 to vertexCount-1
    private final boolean isDirected;
    private final int vertexCount;
    private int edgeCount;
    ArrayList<Edge> edges = new ArrayList<>(); // stores the edges in a list
    ArrayList<HashSetSeparateChaining<Edge>> adjacencyMap; // adjacency maps are used to represent graphs

    public Graph(int vertexCount, boolean isDirected){ // creates and empty graph (directed/undirected)
        this.vertexCount = vertexCount;
        this.isDirected = isDirected;

        adjacencyMap = new ArrayList<>(vertexCount); // create an array of Hash-Sets
        for(int i = 0; i < vertexCount; i++) // Allocate 'vertexCount' Hash-Set objects
            adjacencyMap.add(new HashSetSeparateChaining<>());
    }

    public int getVertexCount() { return vertexCount; }
    public int getEdgeCount() { return edgeCount; }
    public boolean isDirected() { return isDirected; }

    public void addEdge(Edge e) {
        if( e.getSource() < 0 || e.getSource() > vertexCount - 1 )
            throw new IllegalArgumentException("Invalid source.");

        if( e.getDestination() < 0 || e.getDestination() > vertexCount - 1 )
            throw new IllegalArgumentException("Invalid destination.");

        edges.add(e);
        adjacencyMap.get(e.getSource()).add(e);
        if(!isDirected){
            Edge ePrime = new Edge(e.getDestination(), e.getSource(), e.getWeight());
            adjacencyMap.get(e.getDestination()).add(ePrime);
        }
        edgeCount++;
    }

    // one endpoint of an edge is source and the other is a destination
    // if the graph is directed, a directed edge goes from a 'source' vertex to a 'destination' vertex (an arrow from 'source' to 'destination')
    public Edge getEdge(int source, int destination) {
        Edge targetEdge = new Edge(source, destination, 0); // putting a dummy value for weight
        return adjacencyMap.get(source).find(targetEdge);
    }

    public boolean isEdge(int source, int dest) {
        Edge targetEdge = new Edge(source, dest, 0);
        return adjacencyMap.get(source).contains(targetEdge);
    }

    public Iterator<Edge> edgeIterator() {
        return edges.iterator();
    }

    public Iterator<Edge> edgeIterator(int source) {
        return adjacencyMap.get(source).iterator();
    }

    public int degree(){ // finds degree of the graph
        int degree = 0;
        for(int i = 0; i < vertexCount; i++)
            degree = Math.max(degree(i), degree);
        return degree;
    }

    public int degree(int source){ // finds degree of a node
        return adjacencyMap.get(source).size();
    }
}
