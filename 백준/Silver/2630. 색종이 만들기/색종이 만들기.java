import java.util.*;
import java.io.*;

class Main {
  static int N, blue, white;
  static int[][] arr;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, N, N);
    System.out.println(white);
    System.out.println(blue);
  }

  private static void dfs(int x1, int y1, int x2, int y2) {
    if (isAllSame(x1, y1, x2, y2)) {
      return;
    }

    dfs(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
    dfs((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
    dfs(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
    dfs((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
  }

  private static boolean isAllSame(int x1, int y1, int x2, int y2) {
    int firstNum = arr[y1][x1];

    for (int i = y1; i < y2; i++) {
      for (int j = x1; j < x2; j++) {
        if (arr[i][j] != firstNum) return false;
      }
    }

    if (firstNum == 0) white++;
    else blue++;
    return true;
  }
}
