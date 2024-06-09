import java.io.*;

class Main {
  static int N, idx;
  static int[] arr = new int[10001];
  static StringBuilder sb = new StringBuilder();;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[Integer.parseInt(br.readLine())]++;
    }

    for (int i = 1; i < 10001; i++) {
      if (arr[i] > 0) {
        for (int j = 0; j < arr[i]; j++) {
          sb.append(i + "\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}

