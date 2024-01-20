import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 부분합 → '투포인터'로 해결해보자 : start, end
    int start = 0;
    int end = 0;
    int sum = arr[0];
    int max = sum;

    for (int i = 1; i < N; i++) {
      end = arr[i];
      sum += end;
      max = Math.max(max, sum);

      // 부분합이 - 일때
      if (sum < 0) {
        while (true) {

          if (i >= N - 1) {
            for (int j = 0; j < N; j++) {
              max = Math.max(max, arr[j]);
            }
            break;
          }

          if (arr[++i] > 0) {
            start = i;
            end = i;
            sum = arr[start];
            break;
          }
        }
      }
    }

    bw.write(max + "\n");
    bw.flush();
  }
}