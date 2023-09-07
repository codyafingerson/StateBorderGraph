// Portions of this code were taken from Algorithms 4th edition by Robert Sedgewick & Kevin Wayne

/**
 * This class represents an undirected graph that takes in a specified number of
 * vertices and allows for inserting edges more than once, and only once.
 * The underlying data-structure of this graph is an array of bags.
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author Cody Fingerson
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V; // number of vertexes
    private int E; // number of edges
    private Bag<Integer>[] adj; // bag of adjacent edges

    /**
     * Create a new Graph with a specified size
     * @param V the number of vertices
     */
    public Graph(int V) {
        this.V = V; // Assign the number of vertexes to the specified number (V)
        this.E = 0; // Stare with zero edges
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Get the total amount of vertices in the graph
     * @return the number of vertices in the graph
     */
    public int V() {
        return V;
    }

    /**
     * Get the total amount of edges
     * @return the number of edges in the graph
     */
    public int E() {
        return E;
    }

    /**
     * Validate that the vertex is between 0 & the number of specified vertices when creating the graph
     * @param v
     */
    private void validateVertex(int v) {
        // If the vertex is less than zero OR greater than the initial amount, do not allow for addition into the graph
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Add an edge to the graph.
     *  @param v the vertex
     *  @param w the other vertex
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Add an edge only once to the graph
     * @param v the vertex
     * @param w the other vertex
     */
    public void addEdgeOnce(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
     * Returns a string of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
