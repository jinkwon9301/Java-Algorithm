import java.util.*;
import java.io.*;

class Main {
  static int T, M, N, x, y;
  static int[] arrX, arrY;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      /*
        10  12  3  9
        M   N   x  y

        1  :  1
        2  :  2
        3  :  3

        ...

        10 : 10
        1  : 11
        2  : 12
        3  :  1

        x인 3이 등장하는 시기는
        3, 10 + 3, 20 + 3, ... 110 + 3
        y인 9가 등장하는 시기는
        9, 12 + 9, 24 + 9, ... 108 + 9

        즉,
        x 등장 인덱스
        { M*0 + x, M*1 + x, M*2 + x, ... M*(N-1) + x }
        y 등장 인덱스
        { N*0 + y, N*1 + y, N*2 + y, ... N*(M-1) + y }
      */

      arrX = new int[N];
      arrY = new int[M];

      for (int j = 0; j < N; j++) {
        arrX[j] = M * j + x;
      }

      for (int j = 0; j < M; j++) {
        arrY[j] = N * j + y;
      }

      int idxX = 0;
      int idxY = 0;
      int answer = -1;

      while (idxX < N && idxY < M) {
        if (arrX[idxX] == arrY[idxY]) {
          answer = arrX[idxX];
          break;
        } else if (arrX[idxX] > arrY[idxY]) {
          idxY++;
        } else {
          idxX++;
        }
      }

      sb.append(answer + "\n");
    }

    System.out.println(sb.toString());
  }
}
