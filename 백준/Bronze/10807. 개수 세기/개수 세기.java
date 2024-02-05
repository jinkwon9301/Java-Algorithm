import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int K = Integer.parseInt(br.readLine());

    int result = 0;

    for (int i : arr) {
      if (i == K) result++;
    }

    System.out.println(result);
  }
}
