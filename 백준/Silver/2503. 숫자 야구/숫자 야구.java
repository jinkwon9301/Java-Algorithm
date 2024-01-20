import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 후보로 가능한 세자리수를 모두 리스트에 담는다.
    List<String> list = new ArrayList<>();
    String candidate = "";

    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        if (i == j) continue;
        for (int k = 1; k < 10; k++) {
          if (j == k || i == k) continue;
          candidate = "" + i + j + k;
          list.add(candidate);
          candidate = "";
        }
      }
    }
    
    // 게임을 담는다.
    int[][] games = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int num = Integer.parseInt(st.nextToken());
      int strike = Integer.parseInt(st.nextToken());
      int ball = Integer.parseInt(st.nextToken());

      int[] game = new int[3];
      game[0] = num;
      game[1] = strike;
      game[2] = ball;

      games[i] = game;
    }

    // 리스트를 순회하면서 가능한 경우인지 체크하고 모두 일치한다면 count++
    int count = 0;
    boolean isTrue = false;

    for (String candi : list) {
      isTrue = true;
      for (int i = 0; i < N; i++) {
        String num = games[i][0] + "";
        int strike = games[i][1];
        int ball = games[i][2];

        // 만약 조건이 맞지 않으면 break;
        if (!validate(candi, num, strike, ball)) {
          isTrue = false;
          break;
        }
      }
      if (isTrue) count++;
    }

    bw.write(count + "\n");
    bw.flush();

  }

  // 주어진 수가 스트라이크, 볼 개수가 일치하는지 확인하는 함수
  static boolean validate(String candidate, String num, int strike, int ball) {

    int strike2 = 0;
    int ball2 = 0;

    // 후보 숫자와 언급된 숫자를 비교해서 스크라이크 개수를 구한다.
    for (int i = 0; i < 3; i++) {
      if (candidate.charAt(i) == num.charAt(i)) strike2++;
    }

    // 후보 숫자와 언급된 숫자를 비교해서 볼 개수를 구한다.
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (candidate.charAt(i) == num.charAt(j) && i != j) ball2++;
      }
    }

    // 일치하면 true 아니면 false
    if (strike == strike2 && ball == ball2) return true;
    return false;
  }
}