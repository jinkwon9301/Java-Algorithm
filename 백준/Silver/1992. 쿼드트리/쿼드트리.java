import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static char[][] arr;
  static String result = "";

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    arr = new char[N][N];

    // 배열 초기화
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = row.charAt(j);
      }
    }

//    N = 8;
//    arr = new char[][] {
//        {'1','1','1','1','0','0','0','0'},
//        {'1','1','1','1','0','0','0','0'},
//        {'0','0','0','1','1','1','0','0'},
//        {'0','0','0','1','1','1','0','0'},
//        {'1','1','1','1','0','0','0','0'},
//        {'1','1','1','1','0','0','0','0'},
//        {'1','1','1','1','0','0','1','1'},
//        {'1','1','1','1','0','0','1','1'},
//    };

    dfs(0, 0, N - 1, N - 1);

    System.out.println(result);
  }

  private static void dfs(int x1, int y1, int x2, int y2) {
    // 배열 전체를 탐색한다.
    // 만약 전체가 0이나 1로 모두 같은 원소이면 result에 값을 추가하고 종료한다.
    if (checkAllSame(x1, y1, x2, y2)) {
      result += arr[x1][y1];
      return;
    }
    
    // 배열 전체가 같지 않다면 배열을 4분할하고 각각에 배열을 재귀함수로 탐색한다.
    result += "(";
    // 1 사분면
    dfs(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
    // 2 사분면
    dfs(x1, (y1 + y2) / 2 + 1, (x1 + x2) / 2, y2);
    // 3 사분면
    dfs((x1 + x2) / 2 + 1, y1, x2, (y1 + y2) / 2);
    // 4 사분면
    dfs((x1 + x2) / 2 + 1, (y1 + y2) / 2 + 1, x2, y2);
    result += ")";
  }

  private static boolean checkAllSame(int x1, int y1, int x2, int y2) {
    char element = arr[x1][y1];
    
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (arr[i][j] != element) {
          return false;
        }
      }
    }
    
    return true;
  }
}