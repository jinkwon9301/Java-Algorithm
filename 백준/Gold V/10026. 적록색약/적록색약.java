import java.io.*;

public class Main {
  static int N;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int normal;
  static int abnormal;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    visited = new boolean[N][N];

    // 정상인 map 초기화
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = row.charAt(j);
      }
    }

    // 정상인 구역 개수 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i, j, map[i][j]);
          normal++;
        }
      }
    }

    // 적록색약 map 초기화
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = (map[i][j] == 'B') ? 'B' : 'R';
      }
    }

    visited = new boolean[N][N];

    // 적록색약 구역 개수 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i, j, map[i][j]);
          abnormal++;
        }
      }
    }

    System.out.println(normal + " " + abnormal);
  }

  private static void dfs(int x, int y, char color) {

    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (validBound(nx, ny) && !visited[nx][ny] && map[nx][ny] == color) {
        dfs(nx, ny, color);
      }
    }
  }

  private static boolean validBound(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < N) {
      return true;
    }
    return false;
  }
}
