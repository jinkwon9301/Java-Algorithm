import java.util.*;
import java.io.*;

class Main {
  static int N;
  static Integer[][] arr;
  static StringTokenizer st;
  static StringBuilder sb;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new Integer[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      arr[i] = new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    Arrays.sort(arr, new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[0] - o2[0];
      }
    });

    Arrays.sort(arr, new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[1] - o2[1];
      }
    });

    // System.out.println(Arrays.deepToString(arr));

    sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(arr[i][0] + " " + arr[i][1] + "\n");
    }

    System.out.println(sb.toString());
  }
}
