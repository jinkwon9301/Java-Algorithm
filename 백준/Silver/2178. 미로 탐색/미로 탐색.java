import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static StringTokenizer st;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int min = 1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 초기화
    map = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    bfs(0, 0, 1);

    System.out.println(min);
  }

  private static void bfs(int x, int y, int count) {
    LinkedList<Integer[]> queue = new LinkedList<>();

    queue.add(new Integer[]{x, y, count});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Integer[] location = queue.poll();
      x = location[0];
      y = location[1];
      count = location[2];

      if (x == N - 1 && y == M - 1) {
        min = count;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (validBound(nx, ny) && !visited[nx][ny] && map[nx][ny] == '1') {
          queue.add(new Integer[]{nx, ny, count + 1});
          visited[nx][ny] = true;
        }
      }
    }
  }

  private static boolean validBound(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < M) {
      return true;
    }
    return false;
  }
}

