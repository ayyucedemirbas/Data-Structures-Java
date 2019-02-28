/*
 * @author: Sevval MEHDER
 */
public class Main {

    public static void main(String[] args) {

        // Create a Graph object
        Graph graph = new Graph(6, false);

        // Add edges according to above graph
        /*
         *     1 ------ 2
         *     |      / |
         *     |     6  |
         *     4        3 ---- 5
         */
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,5);

        // Create a GraphSearch object
        GraphSearch search = new GraphSearch();

        // Test for depth first search
        System.out.println("Depth First Search testing..");
        search.depthFirstSearch(graph, 0);

        // Test for breadth first search
        System.out.println("Breadth First Search testing..");
        search.breadthFirstSearch(graph,0);
    }

}
