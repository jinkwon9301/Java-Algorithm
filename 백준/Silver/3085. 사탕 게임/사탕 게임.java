import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static int max = 1;
  static char tmp = ' ';

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    char[][] arr = new char[N][N];

    // 배열 초기화
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = line.charAt(j);
      }
    }

    getMaxNum(arr, N);

    // 행을 돌면서 target을 바꾼다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        // target1, target2 를 바꾼다.
        tmp = arr[i][j];
        arr[i][j] = arr[i][j + 1];
        arr[i][j + 1] = tmp;

        // getMaxNum()
        getMaxNum(arr, N);

        // target1, target2 를 다시 바꾼다.
        tmp = arr[i][j];
        arr[i][j] = arr[i][j + 1];
        arr[i][j + 1] = tmp;
      }
    }

    // 열을 돌면서 target을 바꾼다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        tmp = arr[j][i];
        arr[j][i] = arr[j + 1][i];
        arr[j + 1][i] = tmp;

        getMaxNum(arr, N);

        tmp = arr[j][i];
        arr[j][i] = arr[j + 1][i];
        arr[j + 1][i] = tmp;
      }
    }

    bw.write(max + "\n");
    bw.flush();
  }

  // 연속된 색깔의 최대 개수를 구하는 함수
  static void getMaxNum(char[][] arr, int N) {

    char prev = ' ';
    char cur = ' ';
    int count = 1;

    // 각 행을 돌면서 최대 이어진 개수를 구한다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        cur = arr[i][j];
        // 만약 전 색깔이랑 지금 색깔이랑 다르면
        if (cur != prev) {
          max = Math.max(max, count);
          count = 1;
          prev = cur;
        // 만약 전 색깔이랑 지금 색깔이랑 같으면
        } else {
          count++;
          prev = cur;
        }
      }
      // 행 바뀌기 전 count max랑 비교하고 count, prev 초기화
      max = Math.max(max, count);
      count = 1;
      prev = ' ';
    }

    prev = ' ';
    cur = ' ';
    count = 1;

    // 각 열을 돌면서 최대 이어진 개수를 구한다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        cur = arr[j][i];
        if (cur != prev) {
          max = Math.max(max, count);
          count = 1;
          prev = cur;
        } else {
          count++;
          prev = cur;
        }
      }
      max = Math.max(max, count);
      count = 1;
      prev = ' ';
    }
  }
}