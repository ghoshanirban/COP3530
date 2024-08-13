package graph;

import java.util.Iterator;

public interface GraphADT {
    int getVertexCount(); // Returns the number of vertices in the graph
    int getEdgeCount(); // Returns the number of edges in the graph
    boolean isDirected(); // Returns an indicator of whether the graph is directed
    void addEdge(Edge e); // Inserts a new edge into the graph
    Edge getEdge(int source, int destination); // Gets the edge between two vertices
    boolean isEdge(int source, int destination); // Determines whether an edge exists from vertex source to destination
    Iterator<Edge> edgeIterator(int source); //Returns an iterator to the edges that originate from a given vertex
}
