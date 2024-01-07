import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int[] arr = new int[N];
      for (int j = 0; j < N; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      long sum = 0;
      int idx = N - 1;
      // 뒤집어 놓고 생각하기
      for (int j = N - 2; j >= 0; j--) {
        if (arr[j] > arr[idx]) {
          for (int k = idx - 1; k > j; k--) {
            sum += arr[idx] - arr[k];
          }
          idx = j;
        }

        if (j == 0) {
          for (int k = idx - 1; k >= 0; k--) {
            sum += arr[idx] - arr[k];
          }
        }
      }

      System.out.println(sum);
    }
  }
}
