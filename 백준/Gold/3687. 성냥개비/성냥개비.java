import java.io.*;
import java.util.*;

public class Main {

  static int N = 0;
  static String[] dp;
  static Map<Integer, String> map;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // map 초기화 (key : 사용하는 성냥 개수 - value : 만들 수 있는 최소 숫자)
    map = new HashMap<>();
    map.put(2, "1");
    map.put(3, "7");
    map.put(4, "4");
    map.put(5, "2");
    map.put(6, "0");
    map.put(7, "8");

    // DP 배열 초기화 (dp index 성냥개비 개수로 구성할 수 있는 최소 숫자 DP)
    dp = new String[101];
    // 나중에 최소값으로 갱신하기 위해 최대값으로 초기화
    Arrays.fill(dp, Long.MAX_VALUE + "");
    dp[2] = "1";
    dp[3] = "7";
    dp[4] = "4";
    dp[5] = "2";
    dp[6] = "6";
    dp[7] = "8";
    dp[8] = "10";

    for (int i = 9; i < 101; i++) {
      fillDp(i);
    }

    // 가보자
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      // 최대는 홀수, 짝수로 나눌 수 있다.
      if (num % 2 == 1) {
        String one = "";
        for (int j = 0; j < num / 2 - 1; j++) {
          one += "1";
        }
        String max = "7" + one;
        System.out.println(dp[num] + " " + max);
      } else {
        String one = "";
        for (int j = 0; j < num / 2; j++) {
          one += "1";
        }
        String max = one;
        System.out.println(dp[num] + " " + max);
      }
    }
  }

  private static void fillDp(int num) {
    // dp에 저장된 기존 최소숫자들에 2~7 까지 더해서 최소를 구해본다.
    for (int i = 2; i <= 7; i++) {
      // dp에 저장된 기존 최소 숫자
      String s1 = dp[num - i];
      // i로 만들 수 있는 최소 숫자
      String s2 = map.get(i);

      // 두 수를 더하고 정렬해서 최소를 만든다.
      String s3 = s1 + s2;
      char[] chars = s3.toCharArray();
      Arrays.sort(chars);
      String result = new String(chars);

      // 만약 앞자리가 0일 경우 0이 아닌 숫자와 자리 바꿔준다.
      if (result.charAt(0) == '0') {
        StringBuffer sb = new StringBuffer(result);

        // 순회하며 0이 아닌 수를 찾고 제일 앞에 넣어준다.
        for (int j = 0; j < sb.length(); j++) {
          if (sb.charAt(j) != '0') {
            char k = sb.charAt(j);
            sb.deleteCharAt(j);
            sb.insert(0, k);
            break;
          }
        }

        result = sb.toString();
      }

      dp[num] = Math.min(Long.parseLong(dp[num]), Long.parseLong(result)) + "";
    }
  }
}