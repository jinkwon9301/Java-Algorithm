import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, height, maxHeight, count, maxCount;
  static int[][] map;
  static boolean[][] visited;
  static StringTokenizer st;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 초기화 작업
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        height = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, height);
        map[i][j] = height;
      }
    }

    // maxCount를 구한다.
    for (int i = 0; i < maxHeight; i++) {
      // visited, count 초기화
      visited = new boolean[N][N];
      count = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          // 아직 방문하지 않았고 높이가 수심보다 높으면 방문해서 탐색한다.
          if (!visited[j][k] && map[j][k] > i) {
            count++;
            dfs(j, k, i);
          }
        }
      }
      maxCount = Math.max(maxCount, count);
    }

    System.out.println(maxCount);
  }

  private static void dfs(int x, int y, int water) {
    // 종료 조건 (지역의 높이가 수심보다 작거나 같으면 종료)
    if (map[x][y] <= water) {
      return;
    }

    // 현재 지역을 방문한다.
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      // 새롭게 탐색할 곳이 map의 범위 내에 있으며 && 지역의 높이가 수심보다 높고 && 아직 미방문 상태라면 탐색
      if (validBound(nx, ny) && map[nx][ny] > water && !visited[nx][ny]) {
        dfs(nx, ny, water);
      }
    }
  }

  private static boolean validBound(int nx, int ny) {
    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
      return true;
    }
    return false;
  }
}
