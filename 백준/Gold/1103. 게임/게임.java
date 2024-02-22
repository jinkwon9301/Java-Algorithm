import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static StringTokenizer st;
  static char[][] map;
  static boolean[][] visited;
  static int[][] dp;
  static int max;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 초기화
    map = new char[N][M];
    visited = new boolean[N][M];
    dp = new int[N][M];

    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = row.charAt(j);
      }
    }

    visited[0][0] = true;
    dfs(0, 0, 1);

    System.out.println(max);
  }

  private static void dfs(int x, int y, int count) {
    // 최대 횟수 갱신
    dp[x][y] = count;
    max = Math.max(max, count);

    int distance = map[x][y] - '0';

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i] * distance;
      int ny = y + dy[i] * distance;

      // 종료 조건 (탐색할 곳이 범위를 벗어나거나 구멍이면 종료)
      if (!validBound(nx, ny) || map[nx][ny] == 'H') {
        continue;
      }

      // 종료 조건 (이미 방문했으면 -> 사이클을 이룬다는 소리니까 return -1;)
      if (visited[nx][ny]) {
        System.out.println(-1);
        System.exit(0);
      }

      // 종료조건 (이미 다음 지점까지 가기 위해 게임한 횟수가 현재 지점에서 한번 더 한 것보다 크면 어차피 작으므로 할 이유 없다.)
      if(count < dp[nx][ny]) {
        continue;
      }

      visited[nx][ny] = true;
      dfs(nx, ny, count + 1);
      visited[nx][ny] = false;
    }
  }

  private static boolean validBound(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < M) {
      return true;
    }
    return false;
  }
}

