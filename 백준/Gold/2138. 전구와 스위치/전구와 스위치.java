import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    char[] bulb = br.readLine().toCharArray();
    char[] target = br.readLine().toCharArray();

    int count = 0;
    int min = N+1;

    if (Arrays.equals(bulb, target)) {
      bw.write(count + "\n");
      bw.flush();
      return;
    }

    char[] bulbClone = bulb.clone();
    // 첫번째 전구 스위치를 누르는 경우
    bulbClone[0] = (bulbClone[0] == '1') ? '0' : '1';
    bulbClone[1] = (bulbClone[1] == '1') ? '0' : '1';
    count++;

    // 2부터 N-1까지 기존 전구의 i-1이 타겟전구의 i-1과 다르다면 바꿔준다.
    for (int i = 1; i < N; i++) {
      if (bulbClone[i - 1] != target[i - 1]) {
        bulbClone[i - 1] = (bulbClone[i - 1] == '1') ? '0' : '1';
        bulbClone[i] = (bulbClone[i] == '1') ? '0' : '1';
        if (i + 1 < N) bulbClone[i + 1] = (bulbClone[i + 1] == '1') ? '0' : '1';
        count++;
      }
    }

    if (Arrays.equals(bulbClone, target)) {
      min = Math.min(min, count);
    }

    // 첫번째 전구 스위치를 누르지 않는 경우
    count = 0;

    for (int i = 1; i < N; i++) {
      if (bulb[i - 1] != target[i - 1]) {
        bulb[i - 1] = (bulb[i - 1] == '1') ? '0' : '1';
        bulb[i] = (bulb[i] == '1') ? '0' : '1';
        if (i + 1 < N) bulb[i + 1] = (bulb[i + 1] == '1') ? '0' : '1';
        count++;
      }
    }
    if (Arrays.equals(bulb, target)) {
      min = Math.min(min, count);
    }

    if (min == N+1) {
      bw.write(-1 + "\n");
    } else {
      bw.write(min + "\n");
    }
    bw.flush();

  }
}
