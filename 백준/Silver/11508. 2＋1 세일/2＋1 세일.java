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
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!(i % 3 == 2)) {
        sum += arr[i];
      }
    }

    System.out.println(sum);
  }
}