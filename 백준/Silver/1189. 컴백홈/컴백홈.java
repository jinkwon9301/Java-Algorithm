import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int R = 0;
  static int C = 0;
  static int K = 0;
  static char[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int distance = 0;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 초기화
    arr = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        arr[i][j] = row.charAt(j);
      }
    }

//    R = 3;
//    C = 4;
//    K = 6;
//    arr = new char[R][C];
//    visited = new boolean[R][C];
//
//    arr = new char[][] {
//        {'.','.','.','.'},
//        {'.','T','.','.'},
//        {'.','.','.','.'}
//    };

    visited[R - 1][0] = true;
    dfs(1, R - 1, 0);

    System.out.println(count);
  }

  private static void dfs(int distance, int x, int y) {
    // 만약 거리가 K라면 return;
    if (distance == K) {
      // 오른쪽 끝이 맞다면 count++
      if (x == 0 && y == C - 1) {
        count++;
      }
      return;
    }


    // 상하좌우로 이동
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      // 이동할 곳이 범위 내에 있고 && T가 아니며 && 방문한적이 없는지 확인한다.
      if (isValidRange(nx, ny) && arr[nx][ny] != 'T' && !visited[nx][ny]) {
        visited[nx][ny] = true;
        dfs(distance + 1, nx, ny);
        visited[nx][ny] = false;
      }
    }
  }

  private static boolean isValidRange(int nx, int ny) {
    if (0 <= nx && nx < R && 0 <= ny && ny < C) {
      return true;
    }

    return false;
  }
}