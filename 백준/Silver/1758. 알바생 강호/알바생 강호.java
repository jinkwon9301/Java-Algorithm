import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Integer[] arr = new Integer[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr, Collections.reverseOrder());
    long total = 0;
    int minus = 0;
    for (int i = 0; i < N; i++) {
      int num = arr[i] - minus;
      if (num < 0) break;
      total += num;
      minus++;
    }

    System.out.println(total);
  }
}