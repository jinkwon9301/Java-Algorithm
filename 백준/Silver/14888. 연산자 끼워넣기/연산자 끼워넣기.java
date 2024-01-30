import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int[] arr;
  static int[] operator;
  static int max = -1000000000;
  static int min = 1000000000;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // 숫자배열 초기화
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 연산자 개수 배열 초기화
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    operator = new int[4];
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st2.nextToken());
    }

//    N = 2;
//    arr = new int[]{5, 6};
//    operator = new int[]{0, 0, 1, 0};
//
//    N = 3;
//    arr = new int[]{3, 4, 5};
//    operator = new int[]{1, 0, 1, 0};
//
//    N = 6;
//    arr = new int[]{1, 2, 3, 4, 5, 6};
//    operator = new int[]{2, 1, 1, 1};

    dfs(0, arr[0]);

    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(int idx, int result) {
    // 종료 조건
    if (idx == N - 1) {
      min = Math.min(min, result);
      max = Math.max(max, result);
      return;
    }

    // 연산자의 개수가 남아 있다면 더하기, 빼기, 곱하기, 나누기 실행
    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) {
        // 연산자 개수를 하나 감소시킨다.
        operator[i]--;
        // +
        if (i == 0) dfs(idx + 1, result + arr[idx + 1]);
        // -
        else if (i == 1) dfs(idx + 1, result - arr[idx + 1]);
        // *
        else if (i == 2) dfs(idx + 1, result * arr[idx + 1]);
        // /
        else if (i == 3) dfs(idx + 1, result / arr[idx + 1]);
        // 탐색을 마치고 연산자 개수를 증가시켜 준다.
        operator[i]++;
      }
    }
  }
}