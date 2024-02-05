import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr;
  static StringTokenizer st;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    // 초기화
    arr = new int[N][M];

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int k = 0; k < M; k++) {
          arr[j][k] += Integer.parseInt(st.nextToken());
        }
      }
    }

    for (int i = 0; i < N; i++) {
      String row = "";
      for (int j = 0; j < M; j++) {
        row += arr[i][j] + " ";
      }
      System.out.println(row.substring(0, row.length() - 1));
    }
  }
}
