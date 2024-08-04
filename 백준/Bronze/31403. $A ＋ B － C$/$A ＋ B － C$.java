import java.util.*;
import java.io.*;

class Main {
  static int A, B, C;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    A = Integer.parseInt(br.readLine());
    B = Integer.parseInt(br.readLine());
    C = Integer.parseInt(br.readLine());

    System.out.println(A + B - C);
    System.out.println(Integer.parseInt(A + "" + B) - C);
  }
}
