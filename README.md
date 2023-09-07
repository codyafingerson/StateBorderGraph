# State Border Graph

This Java program utilizes an undirected graph data structure to represent the common borders between states. The program reads input from the file [in.txt](./resources/in.txt), which contains pairs of states that share a common border. Each state is represented as a vertex in the graph, and an edge is added between two states if they share a border.

# Input data
This [file](./resources/in.txt) provides a list of state pairs that have common borders. By parsing this input, the program constructs a graph that accurately represents the bordering relationships between states.

# Graph Representation
The graph used in this program is undirected, meaning that if State A shares a border with State B, then State B also shares a border with State A. Each state is mapped to an integer vertex within the graph, creating a comprehensive representation of the connectivity between states.

# Output
The program generates an output that lists each state along with the states it shares a border with. The output format is as follows:
```
Alabama: Florida, Georgia, Mississippi, Mississippi, Tennessee
Arizona: California, Colorado, Nevada, New Mexico, Utah
```
The output is organized alphabetically by state and provides a clear and concise view of the neighboring states for each state in the dataset.