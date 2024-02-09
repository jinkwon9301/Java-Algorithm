import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N, M, result;
  static StringTokenizer st;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 그래프 생성
    graph = new ArrayList[N + 1];
    
    for (int i = 0; i < N + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    // 그래프 초기화
    for (int i = 0; i < M; i++) {
      // 두 정점을 이어준다.
      st = new StringTokenizer(br.readLine(), " ");
      int vertex1 = Integer.parseInt(st.nextToken());
      int vertex2 = Integer.parseInt(st.nextToken());
      graph[vertex1].add(vertex2);
      graph[vertex2].add(vertex1);
    }

    // visited 초기화
    visited = new boolean[N + 1];

    for (int i = 1; i < N + 1; i++) {
      // 만약 해당 정점과 이어진 간선이 있고 && 그 정점을 방문하지 않았다면 탐색한다.
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }

    System.out.println(result);
  }

  private static void dfs(int vertex) {
    // 종료조건 (정점이 이미 방문했으면 종료)
    if (visited[vertex]) {
      return;
    }

    // 정점을 방문한다.
    visited[vertex] = true;

    // 정점과 연결된 정점들을 탐색하고 방문표시 한다.
    ArrayList<Integer> list = graph[vertex];
    for (Integer vertex2 : list) {
      if (!visited[vertex2]) {
        dfs(vertex2);
      }
    }
  }
}

