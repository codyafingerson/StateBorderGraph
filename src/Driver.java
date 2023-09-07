import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("resources/in.txt"); // Import in the file containing the states and their borders
        Scanner scn = new Scanner(file); // read the data file

        int noVerts = Integer.parseInt(scn.nextLine()); // Get the number of vertices
        int noEdges = Integer.parseInt(scn.nextLine()); // Get the number of edges
        Graph graph = new Graph(noVerts); // Create a new graph with 48 vertices in our case

        States states = new States(noVerts); // Instantiate a new States class with 48 states

        // Loop over the file to get the states
        for(int i = 0; i < noEdges; i++) {
            String[] lines = scn.nextLine().split(" "); // Split the states at a space, since the input contains the states that border
            String state1 = lines[0]; // First state
            int index1 = states.add(state1); // The hash value of the state to use as an index

            String state2 = lines[1]; // Second state
            int index2 = states.add(state2); // The hash value of the state to use as an index in the graph

            graph.addEdgeOnce(index1, index2); // Add the edge only once (see the graph class)
        }

        // view the graph (for testing only)
        // System.out.println(graph.toString());

        for(int i = 0; i < noVerts; i++) {
            System.out.printf("%-15s",states.get(i)); // Print out the state that has borders
            System.out.print(":");
            // Print out the respective states bordering states
            for(Integer x : graph.adj(i)) {
                System.out.print(" " + states.get(x));
            }
            System.out.println();
        }

    }
}