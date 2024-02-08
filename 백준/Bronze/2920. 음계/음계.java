import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static StringTokenizer st;
  static int[] arr = new int[8];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 8; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if (Arrays.equals(arr, new int[]{1, 2, 3, 4, 5, 6, 7, 8})) {
      System.out.println("ascending");
    } else if (Arrays.equals(arr, new int[]{8, 7, 6, 5, 4, 3, 2, 1})) {
      System.out.println("descending");
    } else {
      System.out.println("mixed");
    }
  }
}

