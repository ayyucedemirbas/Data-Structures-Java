/*
 * @author: Sevval MEHDER
 */

import java.util.ArrayList;
import java.util.Stack;

public class Graph {

    class Edge {

        // Source of the edge
        private int src;

        // Destination of the edge
        private int dest;

        // Constructor
        public Edge(int source, int destination){
            this.src = source;
            this.dest = destination;
        }

        public int getSrc(){
            return src;
        }
        public int getDest(){
            return dest;
        }
    }

    // Number of vertices
    public int numV;

    // Directer graph or not
    public boolean isDirected;

    // List of edges
    public ArrayList<Edge> edges;

    public ArrayList<Integer> vertices;

    public Graph(int numV, boolean directed){
        this.numV = numV;
        this.isDirected = directed;

        edges = new ArrayList<Edge>();
        vertices = new ArrayList<Integer>();

        for(int i = 0; i <= numV; ++i)
            vertices.add(i+1);
    }

    // Add Edge
    public void addEdge(int src, int dest){
        edges.add(new Edge(src, dest));

        // If this graph is not directed add (dest, src)
        if(!isDirected)
            edges.add(new Edge(dest, src));
    }

}
