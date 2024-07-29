import java.util.*;
import java.io.*;

class Main {
  static int N, max;
  static int[][] arr;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < i + 1; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          arr[i][j] += arr[i - 1][j];
        } else if (j == i) {
          arr[i][j] += arr[i - 1][j - 1];
        } else {
          arr[i][j] = (arr[i - 1][j] >= arr[i - 1][j - 1]) ? arr[i][j] + arr[i - 1][j] : arr[i][j] + arr[i - 1][j - 1];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      max = Math.max(max, arr[N - 1][i]);
    }

    System.out.println(max);
  }
}
