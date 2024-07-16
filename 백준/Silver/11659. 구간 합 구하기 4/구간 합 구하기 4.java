import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[] arr;
  static StringTokenizer st;
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N + 1];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i < N + 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      sb.append(arr[to] - arr[from - 1] + "\n");
    }

    System.out.println(sb.toString());
  }
}
