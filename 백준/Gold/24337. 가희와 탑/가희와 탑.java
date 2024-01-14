import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    if (a + b - 1 > N) {
      System.out.println(-1);
      return;
    }

    ArrayList<Integer> list = new ArrayList<>();
    int max = Math.max(a, b);

    if (max == a) {

      for (int i = 1; i <= a; i++) {
        list.add(i);
      }

      for (int i = b - 1; i >= 1; i--) {
        list.add(i);
      }

    } else {

      for (int i = 1; i <= a - 1; i++) {
        list.add(i);
      }

      for (int i = b; i >= 1; i--) {
        list.add(i);
      }

    }

    int reserveCount = N - (a + b - 1);

    for (int i = 0; i < reserveCount; i++) {
      list.add(1, 1);
    }

    for (Integer i : list) {
      System.out.print(i + " ");
    }
  }
}
