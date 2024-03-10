import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, K, top, bottom;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    top = 1;
    bottom = 1;

    while (K >= 1) {
      top *= N--;
      bottom *= K--;
    }

    System.out.println(top / bottom);
  }
}