public class Experiment {

    public void startTests() {

        Graph graph10 = buildGraph(10);
        Graph graph30 = buildGraph(30);
        Graph graph100 = buildGraph(100);

        System.out.println("SMALL GRAPH");
        graph10.showGraph();
        execute(graph10);

        System.out.println();

        System.out.println("MEDIUM GRAPH");
        execute(graph30);

        System.out.println();

        System.out.println("LARGE GRAPH");
        execute(graph100);
    }

    private void execute(Graph graph) {

        System.out.println("Vertices: " +
                graph.totalVertices());

        System.out.println("Edges: " +
                graph.totalEdges());

        if (graph.totalVertices() == 10) {

            graph.bfs(0);

            graph.dfs(0);
        }

        long bfsStart = System.nanoTime();

        graph.bfsTest(0);

        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();

        graph.dfsTest(0);

        long dfsEnd = System.nanoTime();

        System.out.println("BFS execution: "
                + (bfsEnd - bfsStart) + " ns");

        System.out.println("DFS execution: "
                + (dfsEnd - dfsStart) + " ns");
    }

    private Graph buildGraph(int size) {

        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {

            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {

            graph.addEdge(i, i + 1);
        }

        for (int i = 0; i < size - 3; i += 3) {

            graph.addEdge(i, i + 3);
        }

        if (size >= 10) {

            graph.addEdge(0, 5);
            graph.addEdge(2, 7);
            graph.addEdge(4, 9);
        }

        return graph;
    }

    public void finish() {

        System.out.println();

        System.out.println("Testing finished.");
    }
}