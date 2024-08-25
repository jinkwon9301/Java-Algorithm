// 알고리즘 : 투 포인터, 참고 → https://jinny8.tistory.com/33
import java.util.*;
import java.io.*;

class Main {
  static int N, left, right, max;
  static int[] arr;
  static int[] tanghuru = new int[10];
   static StringTokenizer st;
//   static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    while (right < N) {
      // 오른쪽으로 한칸 이동
      /*
       * 증감연산자 (전위 | 후위) 주의 사항 ⚠️
           - right가 5였다고 가정하자
           - arr[right++]는 arr[5] 값을 사용한다.
           - 이후 right는 6으로 증가한다.
           - tanghuru[arr[5]]++가 실행되어 tanghuru 배열의 arr[5] 위치의 값이 1 증가한다.
       */
      tanghuru[arr[right++]]++;
      // 탕후루의 종류가 2가지 초과하면 2가지 이하로 집계될 때 까지 왼쪽으로 이동
      while (count() > 2) {
        tanghuru[arr[left++]]--;
      }
      max = (max < right - left) ? right - left : max;
    }

    System.out.println(max);
  }

  private static int count() {
    int num = 0;
    for (int i : tanghuru) {
      if (i > 0) num++;
    }
    return num;
  }
}
