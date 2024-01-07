import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    String A = st.nextToken();
    String B = st.nextToken();

    int count = 1;
    while (!A.equals(B)) {
      if (B.charAt(B.length() - 1) == '1') {
        B = B.substring(0, B.length() - 1);
      } else {
        if (Integer.parseInt(B) % 2 == 0) {
          B = Integer.parseInt(B) / 2 + "";
        } else {
          if (A != B) {
            System.out.println(-1);
            return;
          }
        }
      }
      count++;
      if (Integer.parseInt(A) > Integer.parseInt(B)) {
        System.out.println(-1);
        return;
      }
    }

    System.out.println(count);
  }
}