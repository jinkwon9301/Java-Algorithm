import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[] visited = new boolean[31];
    for (int i = 0; i < 28; i++) {
      int num = Integer.parseInt(br.readLine());
      visited[num] = true;
    }

    for (int i = 1; i < 31; i++) {
      if (!visited[i]) System.out.println(i);
    }
  }
}
