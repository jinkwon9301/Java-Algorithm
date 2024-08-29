import java.util.*;
import java.io.*;

class Main {
  static int N, M, answer;
  static String S;
  static char[] IOIOI;
  static int[] IOIOIcount = new int[1000001];
  static int startIdx;
  static boolean isCounting;
//   static StringTokenizer st;
   static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    IOIOI = br.readLine().toCharArray();

    /*
      I가 나오면 카운트 시작 (startIdx)
      IOIOI를 순환하다가 현재 문자가 prevChar와 같으면 현재 idx - startIdx

      idx - startIdx → 홀수일 경우 : II 중복
      countIOIOI[(idx - startIdx) / 2]++;

      ex. IOIOII
      345678 : 8-3 → 5
      5/2 → 2 (IOIOI)

      idx - startIdx → 짝수일 경우 : OO 중복
      countIOIOI[(idx - startIdx) / 2 - 1]++;

      ex. IOIOO
      12345 : 5-1 → 4
      4/2-1 → 1 (IOI)

      만약 idx == IOIOI.length - 1
      IOIOIcount[(idx - startIdx) / 2]++;
     */

    for (int i = 0; i < M; i++) {
      if (!isCounting && IOIOI[i] == 'I') {
        startIdx = i;
        isCounting = true;
      } else if (isCounting && IOIOI[i] == IOIOI[i - 1]) {
        if ((i - startIdx) % 2 == 1) {
          IOIOIcount[(i - startIdx) / 2]++;
          i--;
        } else {
          IOIOIcount[(i - startIdx) / 2 - 1]++;
        }
        isCounting = false;
      } else if (isCounting && i == M - 1) {
          IOIOIcount[(i - startIdx) / 2]++;
      }
    }

    for (int i = N; i <= M; i++) {
      if (IOIOIcount[i] > 0) {
        answer += (i - N + 1) * IOIOIcount[i];
      }
    }

    System.out.println(answer);
  }
}
