/*
 * @author: Sevval MEHDER
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

    // Depth First Search
    public void depthFirstSearch(Graph graph, int startV){

        // All vertices are not visited
        boolean[] visited = new boolean[graph.numV];
        for(int i = 0; i < graph.numV; ++i){
            visited[i] = false;
        }

        // Keep stack for backtrack
        Stack<Integer> vStack = new Stack<Integer>();
        vStack.push(graph.vertices.get(startV));

        while(!vStack.empty()){
            // Pop element in the stack
            int vertex = vStack.peek();
            vStack.pop();

            // Is this vertex visited?
            // If not, visit it and set as true
            if(!visited[vertex - 1]){
                System.out.println(vertex + " ");
                visited[vertex - 1] = true;
            }

            // Then search all of the edges for finding adjacent vertices
            for(int i = 0; i < graph.edges.size(); ++i){

                // If the adjacent is not visited, push to stack
                if(graph.edges.get(i).getSrc() == vertex &&
                        !visited[graph.edges.get(i).getDest() - 1])
                    vStack.push(graph.edges.get(i).getDest());
            }

        }
    }

    // Breadth First Search
    public void breadthFirstSearch(Graph graph, int startV){

        // All vertices are not visited
        boolean[] visited = new boolean[graph.numV];
        for(int i = 0; i < graph.numV; ++i){
            visited[i] = false;
        }

        Queue<Integer> vQueue = new LinkedList<>();
        // Add first element to queue and mark as visited
        vQueue.add(graph.vertices.get(startV));
        visited[graph.vertices.get(startV) - 1] = true;

        while(!vQueue.isEmpty()){
            int vertex = vQueue.poll();
            System.out.println(vertex + " ");

            // Then search all of the edges for finding adjacent vertices
            for(int i = 0; i < graph.edges.size(); ++i){

                // If the adjacent is not visited, add to queue
                // then mark as visited
                if(graph.edges.get(i).getSrc() == vertex &&
                        !visited[graph.edges.get(i).getDest() - 1]) {
                    vQueue.add(graph.edges.get(i).getDest());
                    visited[graph.edges.get(i).getDest() - 1] =true;
                }
            }

        }
    }
}
