import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
    if (N == 1) {
      bw.write(0 + "\n");
      bw.flush();
      return;
    }

    // 센서 배열, 오름차순 정렬
    Integer[] sensors = new Integer[N];
    for (int i = 0; i < N; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(sensors);
    
    // 센서 간격차이를 담을 배열, 내림차순 정렬
    Integer[] diffs = new Integer[N - 1];
    int sum = 0;
    for (int i = 0; i < N - 1; i++) {
      int diff = sensors[i + 1] - sensors[i];
      sum += diff;
      diffs[i] = diff;
    }

    Arrays.sort(diffs, Collections.reverseOrder());
    for (int i = 0; i < K - 1; i++) {
      sum -= diffs[i];
    }
    
    bw.write(sum + "\n");
    bw.flush();
  }
}
