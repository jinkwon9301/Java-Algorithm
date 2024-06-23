import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[] arr = new int[21];
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      String line = br.readLine();
      if (line.equals("all")) {
        for (int i = 0; i < arr.length; i++) {
          arr[i] = 1;
        }
      } else if (line.equals("empty")) {
        for (int i = 0; i < arr.length; i++) {
          arr[i] = 0;
        }
      } else {
        st = new StringTokenizer(line, " ");
        String command = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        if (command.equals("add")) {
          arr[num] = 1;
        } else if (command.equals("remove")) {
          arr[num] = 0;
        } else if (command.equals("check")) {
          if (arr[num] == 1) {
            sb.append(1 + "\n");
          } else {
            sb.append(0 + "\n");
          }
        } else if (command.equals("toggle")) {
          arr[num] = (arr[num] == 1) ? 0 : 1;
        }
      }
    }

    System.out.println(sb.toString());
  }
}

