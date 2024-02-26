import java.io.*;
import java.util.*;

public class Main {
  static int N, M, V;
  static StringTokenizer st;
  static StringBuilder dfs = new StringBuilder();
  static StringBuilder bfs = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    // 그래프를 생성한다.
    Graph graph = new Graph(N + 1);

    // 간선을 이어준다.
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.addEdge(v, w);
      graph.addEdge(w, v);
    }

    // 간선의 순서를 정렬한다.(?)
    graph.sortEdge();

    // DFS, BFS 탐색한다.
    graph.DFS(V, new boolean[graph.V]);
    graph.BFS(V);
    System.out.println(dfs.toString().substring(0, dfs.toString().length() - 1));
    System.out.println(bfs.toString().substring(0, bfs.toString().length() - 1));
  }

  static class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      for (int i = 0; i < v; ++i)
        adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) { adj[v].add(w); }

    void sortEdge() {
      for (int i = 0; i < V; i++) {
        Collections.sort(adj[i]);
      }
    }

    void BFS(int s) {
      boolean visited[] = new boolean[V];
      LinkedList<Integer> queue = new LinkedList<Integer>();

      visited[s] = true;
      queue.add(s);

      while (queue.size() != 0) {
        s = queue.poll();
        bfs.append(s + " ");

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          if (!visited[n]) {
            visited[n] = true;
            queue.add(n);
          }
        }
      }
    }

    void DFS(int s, boolean[] visited) {
      visited[s] = true;
      dfs.append(s + " ");

      ListIterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        Integer n = i.next();
        if (!visited[n]) {
          DFS(n, visited);
        }
      }
    }
  }
}

