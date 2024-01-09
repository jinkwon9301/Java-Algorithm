import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String BR = br.readLine();

    char startColor = BR.charAt(0);
    char endColor = BR.charAt(N - 1);
    int startColorCount = 0;
    int endColorCount = 0;

    int countB = 0;
    int countR = 0;
    int min = N - 1;

    // 왼쪽 끝의 볼무더기 개수를 구한다.
    for (int i = 0; i < N; i++) {
      if (BR.charAt(i) != startColor) {
        startColorCount = i;
        break;
      }
    }

    // 오른쪽 끝의 볼무더기 개수를 구한다.
    for (int i = N - 1; i > 0; i--) {
      if (BR.charAt(i) != endColor) {
        endColorCount = N - 1 - i;
        break;
      }
    }

    // B와 R의 총 개수를 구한다.
    for (int i = 0; i < N; i++) {
      if (BR.charAt(i) == 'B') countB++;
      else countR++;
    }

    if (startColor == 'B') {
      min = Math.min(min, countB - startColorCount);
      min = Math.min(min, countR);
    } else {
      min = Math.min(min, countR - startColorCount);
      min = Math.min(min, countB);
    }

    if (endColor == 'B') {
      min = Math.min(min, countB - endColorCount);
    } else {
      min = Math.min(min, countR - endColorCount);
    }

    bw.write(min + "\n");
    bw.flush();
  }
}
