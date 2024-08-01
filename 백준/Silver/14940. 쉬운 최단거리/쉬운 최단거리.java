import java.util.*;
import java.io.*;

class Main {
  static int n, m;
  static int[][] arr, dMap;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int[] target;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    dMap = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 타겟의 위치를 구한다.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 2) {
          target = new int[]{i, j};
          break;
        }
      }
    }

    // 타겟에서 출발하여 미방문한 곳을 사방탐색한다. (BFS)
    bfs(target[0], target[1], 0);

    // 0이 아닌데 dMap이 0인 곳은 갈 수 없는 곳이기 때문에 -1로 변경
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] != 0 && dMap[i][j] == 0) {
          dMap[i][j] = -1;
        }
      }
    }

    // 타겟은 다시 0으로 바꿔준다.
    dMap[target[0]][target[1]] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(dMap[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }

  private static void bfs(int y ,int x, int distance) {
    LinkedList<int[]> queue = new LinkedList<>();

    // 타겟 거리 계산 → 0, 타겟 방문 true 처리
    dMap[y][x] = distance;
    visited[y][x] = true;
    // 타겟을 큐에 넣고 bfs 시작
    queue.add(new int[]{y, x, distance});

    while (!queue.isEmpty()) {
      int[] point = queue.poll();
      y = point[0];
      x = point[1];
      distance = point[2];

      // 사방에 해당하는 좌표를 큐에 넣는다.
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 만약 arr 범위를 벗어나지 않고 && 아직 방문하지 않았으며 && 방문할 수 있으면 → 방문
        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
          if (!visited[ny][nx]) {
            if (arr[ny][nx] == 1) {
              dMap[ny][nx] = distance + 1;
              visited[ny][nx] = true;
              queue.add(new int[]{ny, nx, distance + 1});
            }
          }
        }
      }
    }
  }
}
