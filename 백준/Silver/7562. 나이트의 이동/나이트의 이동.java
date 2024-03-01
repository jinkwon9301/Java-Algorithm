import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int T, N, count, x1, y1, x2, y2;
  static StringTokenizer st;
  static boolean[][] visited;
  // 나이트 이동을 위한 사방탐색 배열
  static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());
    // 테스트 케이스만큼 순환
    for (int i = 0; i < T; i++) {
      // 체스판 한 변의 길이
      N = Integer.parseInt(br.readLine());

      //  체스판 초기화
      visited = new boolean[N][N];

      // count 초기화
      count = 0;

      // 시작점 설정
      st = new StringTokenizer(br.readLine(), " ");
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());

      // 도착점 설정
      st = new StringTokenizer(br.readLine(), " ");
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());

      // dfs보다 bfs로 가까운 것 부터 찾는 것이 빠를 것 같다.
      bfs(x1, y1);

      System.out.println(count);
    }
  }

  private static void bfs(int x, int y) {
    visited[x][y] = true;
    LinkedList<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[]{x, y, 0});

    while (!queue.isEmpty()) {
      Integer[] location = queue.poll();
      x = location[0];
      y = location[1];
      count = location[2];

      // 도착지점에 도달하면 종료
      if (x == x2 && y == y2) {
        return;
      }

      for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (validBound(nx, ny) && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new Integer[]{nx, ny, count + 1});
        }
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

