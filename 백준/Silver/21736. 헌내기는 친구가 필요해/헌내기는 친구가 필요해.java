// 알고리즘 : DFS
import java.util.*;
import java.io.*;

class Main {
  static int N, M, num, startX, startY;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static char[][] map;
  static StringTokenizer st;
//  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'I') {
          startX = i;
          startY = j;
        }
      }
    }

    dfs(startX, startY);

    if (num == 0) System.out.println("TT");
    else System.out.println(num);
  }

  private static void dfs(int x, int y) {
    // point를 방문한다.
    if (map[x][y] == 'P') {
      num++;
    }
    map[x][y] = 'X';

    // 사방탐색
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (checkBounds(nx, ny) && map[nx][ny] != 'X') {
        dfs(nx, ny);
      }
    }
  }

  private static boolean checkBounds(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < M) {
      return true;
    }
    return false;
  }
}
