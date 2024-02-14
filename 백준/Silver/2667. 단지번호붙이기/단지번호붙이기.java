import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, count;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static List<Integer> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 초기화
    map = new char[N][N];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = row.charAt(j);
      }
    }

    visited = new boolean[N][N];
    list = new ArrayList<>();

    // dfs 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        count = 0;
        if (!visited[i][j] && map[i][j] == '1') {
          dfs(i, j);
          list.add(count);
        }
      }
    }
    Collections.sort(list);
    System.out.println(list.size());
    for (Integer apartments : list) {
      System.out.println(apartments);
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (validBound(nx, ny) && !visited[nx][ny] && map[nx][ny] == '1') {
        dfs(nx, ny);
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
