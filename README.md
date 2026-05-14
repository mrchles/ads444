# Graph Traversal System

## Project Overview

This project implements a graph traversal system in Java. A graph consists of vertices and edges, where vertices represent nodes and edges represent connections between them. The implementation uses a directed graph, meaning each edge has a specific direction. For example, `7 -> 9` means you can move from vertex 7 to vertex 9, but not necessarily from 9 back to 7.

The graph is represented using an adjacency list, where each vertex stores a list of its directly connected neighbors.

The project implements two fundamental graph traversal algorithms:
- **Breadth-First Search (BFS)**
- **Depth-First Search (DFS)**

Three graph sizes are tested to compare performance:
- **Small graph:** 10 vertices, 15 edges
- **Medium graph:** 30 vertices, 41 edges
- **Large graph:** 100 vertices, 135 edges

For the small graph, the program prints the full graph structure and traversal order. For medium and large graphs, only execution time is displayed to maintain readable output.

## Project Structure

### Vertex Class
Represents a single node in the graph with:
- Unique identifier `id`
- Constructor and getter methods
- `toString()` method for displaying vertex information

### Edge Class
Represents a directed connection between two vertices with:
- Source vertex (starting point)
- Destination vertex (ending point)
- Constructor and getter methods
- `toString()` method for displaying edge information (e.g., `1 -> 4`)

### Graph Class
Stores and manages the graph structure using:
- `Map<Integer, Vertex>` for vertex storage
- `Map<Integer, List<Integer>>` for adjacency list representation
- `List<Edge>` for edge storage

Key methods:
- `addVertex(Vertex v)` — adds a vertex to the graph
- `addEdge(int from, int to)` — adds a directed edge
- `printGraph()` — displays the adjacency list
- `bfs(int start)` — performs Breadth-First Search
- `dfs(int start)` — performs Depth-First Search
- `bfsWithoutPrint()` / `dfsWithoutPrint()` — traversal without console output for performance testing

### Experiment Class
Manages graph creation and testing:
- Creates three graphs of varying sizes
- Runs BFS and DFS traversals on each graph
- Measures execution time using `System.nanoTime()`
- Displays organized results

### Main Class
Entry point of the program that initializes the experiment and runs all tests.

## Algorithm Details

### Breadth-First Search (BFS)
Visits vertices level by level, exploring all immediate neighbors before moving deeper.

**Process:**
1. Start from the selected vertex and mark it as visited
2. Add it to a queue
3. Remove the first vertex from the queue and visit all its unvisited neighbors
4. Add those neighbors to the queue
5. Repeat until the queue is empty

**Time Complexity:** O(V + E)
- V = number of vertices
- E = number of edges

**Use Cases:** Finding shortest paths in unweighted graphs, level-order exploration

### Depth-First Search (DFS)
Explores as deep as possible along each branch before backtracking.

**Process:**
1. Start from the selected vertex and mark it as visited
2. Visit the first unvisited neighbor
3. Continue deeper recursively
4. When no unvisited neighbors remain, backtrack
5. Repeat until all reachable vertices are visited

**Time Complexity:** O(V + E)
- V = number of vertices
- E = number of edges

**Use Cases:** Path exploration, connectivity checking, cycle detection, finding connected components

## Experimental Results

### Graph Structure (Small Graph - 10 vertices, 15 edges)
0: 1 3 5

1: 0 2

2: 1 3 7

3: 2 4 0 6

4: 3 5 9

5: 4 6 0

6: 5 7 3 9

7: 6 8 2

8: 7 9

9: 8 6 4

### Traversal Orders (Small Graph)
- **BFS Order:** 0 1 3 5 2 4 6 7 9 8
- **DFS Order:** 0 1 2 3 4 5 6 7 8 9

### Performance Comparison

| Graph Size | Vertices | Edges | BFS Time (ns) | DFS Time (ns) |
|------------|----------|-------|---------------|---------------|
| Small      | 10       | 15    | 30,600        | 16,500        |
| Medium     | 30       | 41    | 100,700       | 42,600        |
| Large      | 100      | 135   | 209,000       | 132,700       |

## Observations

1. **Graph size impact:** As the number of vertices and edges increases, execution time grows proportionally for both BFS and DFS, consistent with O(V + E) complexity.

2. **Performance comparison:** DFS consistently performed faster than BFS across all graph sizes in these experiments. This is likely due to BFS queue operations introducing small overhead compared to DFS recursion.

3. **Traversal order:** BFS explores level by level (horizontal exploration), while DFS goes deep first (vertical exploration), resulting in distinctly different traversal sequences even on the same graph.

4. **Complexity verification:** The results align with the expected O(V + E) time complexity — as vertices and edges increase, processing time increases correspondingly.

## Analysis Questions

**Q: How does graph size affect BFS and DFS performance?**
A: Performance degrades linearly with graph size. More vertices and edges require more processing time, following O(V + E) complexity.

**Q: Which traversal is faster?**
A: In these experiments, DFS was consistently faster than BFS for all graph sizes, though both have the same theoretical complexity.

**Q: Do results match expected complexity O(V + E)?**
A: Yes, execution time increases proportionally with the growth of vertices and edges.

**Q: How does graph structure affect traversal order?**
A: Graph structure directly determines traversal order. BFS explores by levels using a queue, while DFS explores depth-first using recursion, producing different sequences.

**Q: When is BFS preferred over DFS?**
A: BFS is preferred for finding shortest paths in unweighted graphs and when level-by-level exploration is needed.

**Q: What are the limitations of DFS?**
A: DFS may explore very deep paths before finding solutions, doesn't guarantee shortest paths, and can cause stack overflow in very large or deep graphs when using recursion.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE or command-line compiler

### Running the Program
1. Clone the repository
2. Compile the Java files: `javac *.java`
3. Run the main class: `java Main`

## Reflection

This project provided hands-on experience with graph data structures and traversal algorithms. Key learnings include:

- Implementing adjacency list representation for efficient graph storage
- Understanding the fundamental differences between BFS (level-by-level) and DFS (depth-first) traversal
- Using `visited` sets to prevent infinite loops in cyclic graphs
- Measuring algorithm performance with `System.nanoTime()` for practical complexity analysis
- Observing that while both algorithms share O(V + E) complexity, implementation details (queue vs. recursion) can affect actual runtime

The main challenges involved understanding how visited vertex tracking works and generating graphs of different sizes for meaningful performance comparison. This project demonstrates practical graph algorithm implementation and performance analysis techniques.
