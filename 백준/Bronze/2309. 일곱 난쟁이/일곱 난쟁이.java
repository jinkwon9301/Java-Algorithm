import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[9];
    int total = 0;
    int targetNum = 0;
    int[] answer = new int[7];
    int idx = 0;
    boolean isEnd = false;

    for (int i = 0; i < 9; i++) {
      int num = Integer.parseInt(br.readLine());
      total += num;
      arr[i] = num;
    }

    targetNum = total - 100;

    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {

        int sum = arr[i] + arr[j];
        if (targetNum == sum) {
          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              answer[idx++] = arr[k];
            }
          }
          isEnd = true;
          break;
        }

      }
      if (isEnd) break;
    }

    Arrays.sort(answer);
    for (int num : answer) {
      bw.write(num + "\n");
    }
    bw.flush();
  }
}
