import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int T;
  static int M;
  static int N;
  static int K;
  static StringTokenizer st;
  static int[][] map;
  // 사방탐색을 위한 배열
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int bugs = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    // 테스트케이스만큼 반복
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      // map 초기화
      map = new int[M][N];
      // bugs 초기화
      bugs = 0;

      // 배추 위치 초기화
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
      }

      for (int j = 0; j < M; j++) {
        for (int k = 0; k < N; k++) {
          if (map[j][k] == 1){
            bugs++;
            dfs(j, k);
          }
        }
      }

      System.out.println(bugs);
    }
  }

  private static void dfs(int x, int y) {
    // 종료 조건
    if (map[x][y] == 0) {
      return;
    }

    map[x][y] = 0;
    
    // 사방 탐색
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (validBound(nx, ny)) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean validBound(int x, int y) {
    if (x < 0 || M <= x || y < 0 || N <= y) {
      return false;
    }

    return true;
  }
}

