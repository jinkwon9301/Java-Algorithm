import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 원생을 담을 배열
    int[] students = new int[N];
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      students[i] = Integer.parseInt(st2.nextToken());
    }
    
    // 키차이 총합 변수
    int sum = 0;
    
    // 원생의 키차이를 저장할 배열
    Integer[] diffs = new Integer[N - 1];
    for (int i = 1; i < N; i++) {
      int diff = students[i] - students[i - 1];
      sum += diff;
      diffs[i - 1] = diff;
    }
    
    // 키차이 배열 내림차순 정렬
    Arrays.sort(diffs, Collections.reverseOrder());
    
    // 키차이 총합에서 K-1 개수의 키차이를 뺀다. 
    for (int i = 0; i < K - 1; i++) {
      sum -= diffs[i];
    }

    bw.write(sum + "\n");
    bw.flush();
  }
}
