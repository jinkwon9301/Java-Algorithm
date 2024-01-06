import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    String PH = br.readLine();
    
    // PH 길이의 배열을 만든다.
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      // 햄버거가 있으면 1
      if (PH.charAt(i) == 'H') {
        arr[i] = 1;
      } else {
        arr[i] = 0;
      }
    }

    int count = 0;

    for (int i = 0; i < N; i++) {
      // 만약 P면
      if (PH.charAt(i) == 'P') {
        // 가장 좌측부터 조사 (K거리만큼)
        for (int j = i - K; j <= i + K; j++) {
          // 유효성 검사 (K만큼 벗어나도 배열 인덱스 범위 내에 있어야 함)
          if (0 <= j && j < N) {
            if (arr[j] == 1) {
              arr[j] = 0;
              count++;
              break;
            }
          }
        }
      }
    }

    System.out.println(count);
  }
}
