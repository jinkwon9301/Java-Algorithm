import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Integer[] coins = new Integer[N];
    for (int i = N - 1; i >= 0 ; i--) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int money = K;
    int count = 0;

    // coins 배열을 순회한다.
    for (int i = 0; i < coins.length; i++) {
      // 남은 돈이 동전보다 크다면
      if (money >= coins[i]) {
        // 남은 돈을 동전으로 나눈 몫을 count에 더한다.
        count += money / coins[i];
        money = money % coins[i];
        if (money == 0) break;
      } else {
        continue;
      }
    }

    System.out.println(count);
  }
}
