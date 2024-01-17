import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] arr_WB = new char[N][M];

    for (int i = 0; i < N; i++) {
      String WB = br.readLine();
      for (int j = 0; j < M; j++) {
        arr_WB[i][j] = WB.charAt(j);
      }
    }

    // WBWBWBWB
    int[][] board_1 = new int[N][M];
    // BWBWBWBW
    int[][] board_2 = new int[N][M];

    char color = ' ';

    // board_1 초기화
    color = 'W';
    for (int i = 0; i < N; i++) {
      if (M % 2 == 0) color = (color == 'W') ? 'B' : 'W';
      for (int j = 0; j < M; j++) {
        board_1[i][j] = (arr_WB[i][j] != color) ? 1 : 0;
        color = (color == 'W') ? 'B' : 'W';
      }
    }
    // board_2 초기화
    color = 'B';
    for (int i = 0; i < N; i++) {
      if (M % 2 == 0) color = (color == 'W') ? 'B' : 'W';
      for (int j = 0; j < M; j++) {
        board_2[i][j] = (arr_WB[i][j] != color) ? 1 : 0;
        color = (color == 'W') ? 'B' : 'W';
      }
    }

    int min = 64;
    int sum = 0;

    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        sum = 0;
        for (int k = i; k < i + 8; k++) {
          for (int l = j; l < j + 8; l++) {
            sum += board_1[k][l];
          }
        }
        min = Math.min(min, sum);
      }
    }

    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        sum = 0;
        for (int k = i; k < i + 8; k++) {
          for (int l = j; l < j + 8; l++) {
            sum += board_2[k][l];
          }
        }
        min = Math.min(min, sum);
      }
    }

    System.out.println(min);
  }
}
