import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] arr = new int[N];
    int total = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      total += arr[i];
    }

    int max = 0;
    int tmp = 0;
    int partialSum = arr[0];

    for (int i = 1; i < N - 1; i++) {
      // 좌측으로 가는 경우
      tmp = total - (arr[N - 1] + arr[i])
          + partialSum;
      max = Math.max(max, tmp);
      tmp = 0;
      // 우측으로 가는 경우
      partialSum += arr[i];
      tmp = total - (arr[0] + arr[i])
          + total - partialSum;
      max = Math.max(max, tmp);
      tmp = 0;
      // 가운데로 가는 경우
      tmp = total - (arr[0] + arr[N - 1])
          + arr[i];
      max = Math.max(max, tmp);
    }
    System.out.println(max);
  }
}