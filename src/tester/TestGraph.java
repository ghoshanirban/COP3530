package tester;

import graph.*;
import java.util.*;

public class TestGraph {
    public static void playWithFriendShipGraph(){
        HashMap<String,Integer> vertexToIDMap = new HashMap<>(); // Needed to assign integers to non-integer vertex names
        TreeMap<Integer,String> iDToVertexMap = new TreeMap<>(); // Needed to find non-integer vertex names using their integer ids

        vertexToIDMap.put("Alice",0);
        vertexToIDMap.put("Jim",1);
        vertexToIDMap.put("Bob",2);
        vertexToIDMap.put("Eva",3);
        vertexToIDMap.put("Eric",4);
        vertexToIDMap.put("Pat",5);

        iDToVertexMap.put(0,"Alice");
        iDToVertexMap.put(1, "Jim");
        iDToVertexMap.put(2,"Bob");
        iDToVertexMap.put(3, "Eva");
        iDToVertexMap.put(4, "Eric");
        iDToVertexMap.put(5, "Pat");

        Graph friendShipGraph = new Graph(6, false); // create a new undirected graph with 10 vertices
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Alice"),vertexToIDMap.get("Jim")));
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Jim"),vertexToIDMap.get("Bob")));
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Alice"),vertexToIDMap.get("Eva")));
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Jim"),vertexToIDMap.get("Eric")));
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Bob"),vertexToIDMap.get("Eva")));
        friendShipGraph.addEdge(new Edge(vertexToIDMap.get("Eva"),vertexToIDMap.get("Pat")));

        System.out.println("Number of vertices in the friendship graph: " + friendShipGraph.getVertexCount());
        System.out.println("Number of edges in the friendship graph: " + friendShipGraph.getEdgeCount());
        System.out.println("Is friendship graph directed? " + friendShipGraph.isDirected());
        System.out.println("Degree of the friendship graph: " + friendShipGraph.degree());

        System.out.println("\nThe vertices of the graph are:");
        for( Map.Entry<Integer, String> record : iDToVertexMap.entrySet() )
            System.out.println(record.getKey() + ":" + record.getValue());

        System.out.println("\nThe edges of the graph are:");
        Iterator<Edge> it = friendShipGraph.edgeIterator();
        while (it.hasNext()) {
            Edge e = it.next();
            String source = iDToVertexMap.get(e.getSource()), dest = iDToVertexMap.get(e.getDestination());
            System.out.println(source + " -- " + dest);
        }

        System.out.print("\nThe friends of Jim are: ");
        Iterator<Edge> itForJim = friendShipGraph.edgeIterator( vertexToIDMap.get("Jim"));
        while (itForJim.hasNext()) {
            Edge e = itForJim.next();
            System.out.print(iDToVertexMap.get(e.getDestination()) + " ");
        }

        System.out.println("\nAre Jim and Eric friends? " + friendShipGraph.isEdge( vertexToIDMap.get("Jim"),vertexToIDMap.get("Eric")));
        System.out.println("The edge between Jim and Eric: " + friendShipGraph.getEdge( vertexToIDMap.get("Jim"),vertexToIDMap.get("Eric")));

    }

    public static void main(String[] args) {
        playWithFriendShipGraph();
    }
}
