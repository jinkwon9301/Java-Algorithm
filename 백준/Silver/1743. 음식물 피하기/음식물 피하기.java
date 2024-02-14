import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, M, K, count, maxCount;
  static StringTokenizer st;
  static boolean[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 초기화
    map = new boolean[N][M];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      map[x][y] = true;
    }

    visited = new boolean[N][M];

    // dfs 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        // count 초기화
        count = 0;
        if (!visited[i][j] && map[i][j]) {
          dfs(i, j);
          maxCount = Math.max(maxCount, count);
        }
      }
    }

    System.out.println(maxCount);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (validBound(nx, ny) && !visited[nx][ny] && map[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean validBound(int nx, int ny) {
    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
      return true;
    }
    return false;
  }
}
