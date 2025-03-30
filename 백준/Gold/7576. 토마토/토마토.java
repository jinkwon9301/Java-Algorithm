import java.util.*;
import java.io.*;

class Main {
  static int N, M, days;
  static int[][] tomato;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static StringTokenizer st;
  // static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    tomato = new int[M][N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // BFS 탐색
    bfs();
    if (checkAllClear()) {
      System.out.println(days);
    } else {
      System.out.println(-1);
    }
  }

  private static void bfs() {
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (tomato[i][j] == 1) {
          queue.offer(new int[]{i, j, 0});  // x, y, day
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int day = current[2];

      days = Math.max(days, day);  // 현재까지의 최대 일수

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (checkValid(nx, ny) && tomato[nx][ny] == 0) {
          tomato[nx][ny] = 1;
          queue.offer(new int[]{nx, ny, day + 1});
        }
      }
    }
  }

  private static boolean checkAllClear() {
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (tomato[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean checkValid(int x, int y) {
    if (x < 0 || x >= M || y < 0 || y >= N) {
      return false;
    }
    return true;
  }
}
