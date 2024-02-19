import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int R, C;
  static StringTokenizer st;
  static char[][] map;
  static boolean[] visited = new boolean[91];
  static int maxCount;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    // 초기화
    map = new char[R][C];
    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = row.charAt(j);
      }
    }

    // 좌측상단 시작지점을 방문한다.
    visited[map[0][0]] = true;
    // 탐색 시작
    dfs(map[0][0], 0, 0, 1);

    System.out.println(maxCount);
  }

  private static void dfs(char alphabet, int x, int y, int count) {

    maxCount = Math.max(maxCount, count);

    // 알파벳을 방문한다.
    visited[alphabet] = true;

    // 사방탐색
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 범위를 만족하고 새로 탐색할 지역이 아직 미방문한 알파벳이면
      if (validBound(nx, ny) && !visited[map[nx][ny]]) {
        // 탐색한다.
        dfs(map[nx][ny], nx, ny, count + 1);

        visited[map[nx][ny]] = false;
      }
    }
  }

  private static boolean validBound(int x, int y) {
    if (0 <= x && x < R && 0 <= y && y < C) {
      return true;
    }
    return false;
  }
}
