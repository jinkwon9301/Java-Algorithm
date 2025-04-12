// 참고: https://kwanik.tistory.com/34
import java.io.*;

class Main {
  static int N, count;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    nQueen(0);
    System.out.println(count);
  }

  private static void nQueen(int row) {
    // 종료 조건
    if (row == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      // 열에 퀸을 놓을 수 있는지 확인
      boolean isValid = true;
      for (int j = 0; j < row; j++) {
        // 같은 열에 퀸이 있는지 확인 || 대각선에 퀸이 있는지 확인
        if (arr[j] == i || Math.abs(arr[j] - i) == Math.abs(j - row)) {
          isValid = false;
          break;
        }
      }
      // 퀸을 놓을 수 있는 경우
      if (isValid) {
        arr[row] = i; // 퀸을 놓음
        nQueen(row + 1); // 다음 행으로 이동
      }
    }
  }
}
