import java.util.*;
import java.io.*;

class Main {
  static int N;
  static Integer[] arr;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new Integer[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Integer[] uniqueSortedArr = Arrays.stream(arr)
        .distinct()
        .sorted()
        .toArray(Integer[]::new);

    for (int i = 0; i < N; i++) {
      Integer num = arr[i];
      int value = Arrays.binarySearch(uniqueSortedArr, num);
      sb.append(value + " ");
    }

    System.out.println(sb.toString());
  }
}
