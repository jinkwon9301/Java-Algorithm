import java.io.*;
import java.util.*;

public class Main {
  static int M, N, K, count;
  static boolean[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static List<Integer> list;
  static StringTokenizer st;
  static String result = "";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 일단 map의 모든 영역을 true로 표기한다.
    map = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = true;
      }
    }

    // visited 배열과 분리된 영역의 크기를 담을 list 초기화
    visited = new boolean[M][N];
    list = new ArrayList<>();

    // 직사각형 영역들을 false로 바꿔준다.
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      for (int j = x1; j < x2; j++) {
        for (int k = y1; k < y2; k++) {
          map[j][k] = false;
        }
      }
    }

    // dfs 탐색
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        count = 0;
        if (!visited[i][j] && map[i][j]) {
          bfs(i, j);
          list.add(count);
        }
      }
    }

    // 정렬
    Collections.sort(list);

    // 출력
    System.out.println(list.size());
    for (Integer apartments : list) {
      result += apartments + " ";
    }
    System.out.println(result.substring(0, result.length() - 1));
  }

  private static void bfs(int x, int y) {
    visited[x][y] = true;
    count++;

    LinkedList<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[]{x, y});

    while (!queue.isEmpty()) {
      Integer[] loacation = queue.poll();
      x = loacation[0];
      y = loacation[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (validBound(nx, ny) && !visited[nx][ny] && map[nx][ny]) {
          queue.add(new Integer[]{nx, ny});
          visited[nx][ny] = true;
          count++;
        }
      }
    }
  }

  private static boolean validBound(int nx, int ny) {
    if (0 <= nx && nx < M && 0 <= ny && ny < N) {
      return true;
    }
    return false;
  }
}