import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    Integer[] arr = new Integer[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    double sum = arr[N - 1];
    for (int i = 0; i < N - 1; i++) {
      sum += arr[i] / 2.0;
    }
      
    System.out.println(sum);
  }
}
