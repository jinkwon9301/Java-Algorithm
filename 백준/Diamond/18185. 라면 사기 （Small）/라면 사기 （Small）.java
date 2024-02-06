import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static StringTokenizer st;
  static int[] arr;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");

    // 초기화
    arr = new int[N + 2];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

//    N = 3;
//    arr = new int[]{1, 0, 1};
//
//    N = 5;
//    arr = new int[]{1, 1, 1, 0, 2};
//
//    // 44
//    N = 10;
//    arr = new int[]{1, 2, 1, 2, 3, 1, 0, 1, 5, 1};
//
//    // 715
//    N = 5;
//    arr = new int[]{3, 3, 100, 100, 100};
//
//    // 5717
//    N = 8;
//    arr = new int[]{3, 3, 100, 100, 100, 1000, 1000, 1};

//    // 19 -> 그리디로 풀면 안된다.
//    N = 4;
//    arr = new int[]{2, 3, 2, 1};

//    // 38 -> 그리디로 풀면 안된다.
//    N = 7;
//    arr = new int[]{2, 3, 2, 3, 3, 2, 1};

    for (int i = 0; i < N; i++) {
      // [2, 3, 2, 1] 의 경우
      // 즉, (i + 1) > (i + 2)인 경우 (arr[i + 1] - arr[i + 2])와 arr[i]의 최소값 만큼 앞의 2개 공장에서 먼저 라면을 산다.
      // 가능한 arr[i + 1]과 arr[i + 2]의 개수를 먼저 맞춰주는게 최대를 구할 수 있는 경우인 것이다.
      if (arr[i + 1] > arr[i + 2]) {
        int two = Math.min((arr[i + 1] - arr[i + 2]), arr[i]);
        answer += two * 5;
        arr[i] -= two;
        arr[i + 1] -= two;

        int three = Math.min(Math.min(arr[i], arr[i + 1]), arr[i + 2]);
        answer += three * 7;
        arr[i] -= three;
        arr[i + 1] -= three;
        arr[i + 2] -= three;
      } else {
        int three = Math.min(Math.min(arr[i], arr[i + 1]), arr[i + 2]);
        answer += three * 7;
        arr[i] -= three;
        arr[i + 1] -= three;
        arr[i + 2] -= three;

        int two = Math.min((arr[i]), arr[i + 1]);
        answer += two * 5;
        arr[i] -= two;
        arr[i + 1] -= two;
      }

      answer += arr[i] * 3;
    }

    System.out.println(answer);
  }
}
