import java.util.*;

public class Graph {

    private HashMap<Integer, Vertex> vertexMap;
    private HashMap<Integer, ArrayList<Integer>> adjList;
    private ArrayList<Edge> edgeList;

    public Graph() {

        vertexMap = new HashMap<>();
        adjList = new HashMap<>();
        edgeList = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {

        vertexMap.put(vertex.getValue(), vertex);

        adjList.put(vertex.getValue(), new ArrayList<>());
    }

    public void addEdge(int first, int second) {

        if (!vertexMap.containsKey(first) ||
                !vertexMap.containsKey(second)) {

            return;
        }

        adjList.get(first).add(second);
        adjList.get(second).add(first);

        Edge edge = new Edge(vertexMap.get(first),
                vertexMap.get(second));

        edgeList.add(edge);
    }

    public void showGraph() {

        for (int key : adjList.keySet()) {

            System.out.print(key + ": ");

            ArrayList<Integer> list = adjList.get(key);

            for (int node : list) {
                System.out.print(node + " ");
            }

            System.out.println();
        }
    }

    public void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        HashSet<Integer> visited = new HashSet<>();

        queue.add(start);

        visited.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int next : adjList.get(current)) {

                if (!visited.contains(next)) {

                    visited.add(next);

                    queue.add(next);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {

        HashSet<Integer> visited = new HashSet<>();

        System.out.print("DFS: ");

        dfsRecursive(start, visited);

        System.out.println();
    }

    private void dfsRecursive(int current, HashSet<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (int next : adjList.get(current)) {

            if (!visited.contains(next)) {

                dfsRecursive(next, visited);
            }
        }
    }

    public void bfsTest(int start) {

        Queue<Integer> queue = new LinkedList<>();

        HashSet<Integer> visited = new HashSet<>();

        queue.add(start);

        visited.add(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next : adjList.get(current)) {

                if (!visited.contains(next)) {

                    visited.add(next);

                    queue.add(next);
                }
            }
        }
    }

    public void dfsTest(int start) {

        HashSet<Integer> visited = new HashSet<>();

        dfsTestHelper(start, visited);
    }

    private void dfsTestHelper(int current, HashSet<Integer> visited) {

        visited.add(current);

        for (int next : adjList.get(current)) {

            if (!visited.contains(next)) {

                dfsTestHelper(next, visited);
            }
        }
    }

    public int totalVertices() {
        return vertexMap.size();
    }

    public int totalEdges() {
        return edgeList.size();
    }
}