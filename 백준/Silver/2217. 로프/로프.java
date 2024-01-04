import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Integer[] arr = new Integer[N];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr, Collections.reverseOrder());
    int max = arr[0];

    for (int i = 0; i < arr.length; i++) {
      int nMax = arr[i] * (i + 1);
      max = Math.max(nMax, max);
    }

    System.out.println(max);
  }
}
