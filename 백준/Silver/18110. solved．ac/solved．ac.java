import java.util.*;
import java.io.*;

class Main {
  static int N, sum, opinion, lowIdx, highIdx;
  static long except, nonExcept;
  static int[] arr = new int[31];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    except = Math.round(N * 0.15);
    nonExcept = N - (except * 2);

    for (int i = 0; i < N; i++) {
      opinion = Integer.parseInt(br.readLine());
      arr[opinion]++;
      sum += opinion;
    }

    lowIdx = 1;
    highIdx = 30;

    while (except-- > 0) {
      while (arr[lowIdx] == 0) {
        lowIdx++;
      }
      sum -= lowIdx;
      arr[lowIdx]--;

      while (arr[highIdx] == 0) {
        highIdx--;
      }
      sum -= highIdx;
      arr[highIdx]--;
    }

    long answer = Math.round((double) sum / nonExcept);
    System.out.println(answer);
  }
}

