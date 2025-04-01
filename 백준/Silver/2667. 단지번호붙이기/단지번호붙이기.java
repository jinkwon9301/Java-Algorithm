import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[][] field;
  static boolean[][] visited;
  static PriorityQueue<Integer> pq = new PriorityQueue<>();
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    field = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        field[i][j] = line.charAt(j) - '0';
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (field[i][j] == 1 && !visited[i][j]) {
          bfs(new int[] {i, j});
        }
      }
    }

    sb.append(pq.size()).append("\n");
    while (!pq.isEmpty()) {
      sb.append(pq.poll()).append("\n");
    }
    System.out.print(sb.toString());
  }

  private static void bfs(int[] start) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(start);
    visited[start[0]][start[1]] = true;
    int count = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      count++;

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (checkValid(nx, ny) && field[nx][ny] == 1 && !visited[nx][ny]) {
          queue.add(new int[] {nx, ny});
          visited[nx][ny] = true;
        }
      }
    }

    pq.add(count);
  }

  // 범위를 벗어나지 않는지 확인하는 메서드
  private static boolean checkValid(int x, int y) {
    if (x < 0 || x >= N || y < 0 || y >= N) {
      return false;
    }
    return true;
  }
}
