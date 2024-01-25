import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int[][] arr;
  static int min = 20000;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visited = new boolean[N][N];

    // 화단 초기화
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dfs(0, i, j, 0);
      }
    }
    
    bw.write(min + "\n");
    bw.flush();
    
  }

  static void dfs(int count, int x, int y, int money) {

    // 씨앗을 3개 심으면 종료
    if (count == 3) {
      min = Math.min(min, money);
      return;
    }

    // x,y가 꽃밭을 벗어나는지 확인 && 곂치지 않는지 확인
    if (checkBounds(x, y) && checkVisited(x, y)) {
      // 꽃이 필 5군데를 방문한다.
      visited[x-1][y] = true;
      visited[x][y-1] = true;
      visited[x][y] = true;
      visited[x][y+1] = true;
      visited[x+1][y] = true;
      // 방문한 곳의 땅 값을 모두 더한다.
      int sum = money + arr[x-1][y] + arr[x][y-1] + arr[x][y] + arr[x][y+1] + arr[x+1][y];

      // 이어서 심는다.
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          dfs(count + 1, i, j, sum);
        }
      }

      // 5군데를 방문해체한다.
      visited[x-1][y] = false;
      visited[x][y-1] = false;
      visited[x][y] = false;
      visited[x][y+1] = false;
      visited[x+1][y] = false;
    }
  }

  static boolean checkBounds(int x, int y) {
    // 바운더리를 벗어나면
    if (x < 1 || y < 1 || x >= N - 1 || y >= N - 1) {
      return false;
    }

    return true;
  }

  static boolean checkVisited(int x, int y) {
    // 만약 꽃이 피기로 예정된 영역이면
    if (visited[x-1][y] || visited[x][y-1] || visited[x][y] || visited[x][y+1] || visited[x+1][y]) {
      return false;
    }

    return true;
  }
}