import java.io.*;
import java.util.Arrays;

public class Main {
  static int k, n, T;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    map = new int[15][15];
    // 0층의 i호에는 i명이 산다.
    for (int i = 0; i < 15; i++) {
      map[0][i] = i;
    }

    for (int i = 1; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        // 각 층의 0호는 0명이 산다.
        if (j == 0) {
          map[i][j] = 0;
          continue;
        }

        map[i][j] = map[i - 1][j] + map[i][j - 1];
      }
    }

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      k = Integer.parseInt(br.readLine());
      n = Integer.parseInt(br.readLine());

      System.out.println(map[k][n]);
    }
  }
}