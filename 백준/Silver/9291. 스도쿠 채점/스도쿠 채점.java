import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int T;
  static StringTokenizer st;
  static int[][] sudoku;
  static boolean[] visited;
  static boolean isCorrect;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {

      sudoku = new int[9][9];
      isCorrect = true;

      // 스도쿠판 만들기
      for (int j = 0; j < 9; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int k = 0; k < 9; k++) {
          sudoku[j][k] = Integer.parseInt(st.nextToken());
        }
      }
      br.readLine();

      // 스도쿠 검증
      validSudoku();

      // 출력
      System.out.println("Case " + (i + 1) + ": " + ((isCorrect) ? "CORRECT" : "INCORRECT"));
    }
  }

  private static void validSudoku() {
    // 가로 검증
    for (int i = 0; i < 9; i++) {
      visited = new boolean[10];
      for (int j = 0; j < 9; j++) {
        // 이미 방문한 숫자면 "INCORRECT" -> return;
        if (visited[sudoku[i][j]]) {
          isCorrect = false;
          return;
        }
        // 방문하지 않았다면 방문체크하고 for문 순환한다.
        visited[sudoku[i][j]] = true;
      }
    }

    // 세로 검증
    for (int i = 0; i < 9; i++) {
      visited = new boolean[10];
      for (int j = 0; j < 9; j++) {
        // 이미 방문한 숫자면 "INCORRECT" -> return;
        if (visited[sudoku[j][i]]) {
          isCorrect = false;
          return;
        }
        // 방문하지 않았다면 방문체크하고 for문 순환한다.
        visited[sudoku[j][i]] = true;
      }
    }

    // 3X3 검증
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        visited = new boolean[10];
        for (int k = i; k < 3 + i; k++) {
          for (int l = j; l < 3 + j; l++) {
            // 이미 방문한 숫자면 "INCORRECT" -> return;
            if (visited[sudoku[k][l]]) {
              isCorrect = false;
              return;
            }
            // 방문하지 않았다면 방문체크하고 for문 순환한다.
            visited[sudoku[k][l]] = true;
          }
        }
      }
    }

  }
}

