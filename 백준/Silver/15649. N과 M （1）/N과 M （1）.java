import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[] arr;
  static boolean[] visited;
  static StringTokenizer st;
//  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    visited = new boolean[N];

    dfs(0);
  }

  private static void dfs(int depth) {
    // 종료 조건
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    // 재귀 호출
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i + 1;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}
