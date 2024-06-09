import java.util.*;
import java.io.*;

class Main {
  static int N, T, P;
  static int[] sizes = new int[6];
  static int tMin, pMin, pSolo;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < sizes.length; i++) {
      sizes[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    T = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    for (int i = 0; i < sizes.length; i++) {
      tMin += sizes[i] / T;
      if (sizes[i] % T > 0) {
        tMin += 1;
      }
    }

    pMin = N / P;
    pSolo = N % P;

    System.out.println(tMin);
    System.out.println(pMin + " " + pSolo);
  }
}

