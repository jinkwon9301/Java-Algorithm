import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static ArrayList<Integer>[] graph;
  static StringTokenizer st;
  static int[][] answer;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 그래프 초기화
    graph = new ArrayList[N];

    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();

      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        if (Integer.parseInt(st.nextToken()) == 1) {
          graph[i].add(j);
        }
      }
    }

    // answer 만들기
    answer = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // visited 초기화
        visited = new boolean[N];
        dfs(i, i, j);
      }
    }

    for (int i = 0; i < N; i++) {
      String row = "";
      for (int j = 0; j < N; j++) {
        row += answer[i][j] + " ";
      }
      System.out.println(row.substring(0, row.length() - 1));
    }
  }

  private static void dfs(int start, int now, int target) {
    // 종료 조건
    if (now == target && visited[start]) {
      answer[start][target] = 1;
      return;
    }

    // 무한 순환의 경우 종료
    if (visited[now]) {
      return;
    }

    // 방문하고 이어서 탐색한다.
    visited[now] = true;
    ArrayList<Integer> list = graph[now];
    for (Integer vertex : list) {
      dfs(start, vertex, target);
    }
  }
}
