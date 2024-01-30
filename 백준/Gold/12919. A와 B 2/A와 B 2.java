import java.io.*;

public class Main {

  static StringBuffer S;
  static StringBuffer T;
  static boolean isPossible = false;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    S = new StringBuffer(br.readLine());
    T = new StringBuffer(br.readLine());

//    S = new StringBuffer("A");
//    T = new StringBuffer("BABA");

//    S = new StringBuffer("BAAAAABAA");
//    T = new StringBuffer("BAABAAAAAB");

//    S = new StringBuffer("A");
//    T = new StringBuffer("ABBA");

//    S = new StringBuffer("A");
//    T = new StringBuffer("B");

    dfs(T);

    if (isPossible) {
      System.out.println(1);
      return;
    }

    System.out.println(0);
  }

  static void dfs(StringBuffer sb) {
    // str의 길이가 T의 길이가 되면 종료
    if (sb.length() == S.length()) {
      if (sb.toString().equals(S.toString())) isPossible = true;
      return;
    }

    // 마지막 문자가 A이면 A를 뺀다.
    if (sb.charAt(sb.length() - 1) == 'A') {
      sb.deleteCharAt(sb.length() - 1);
      dfs(sb);
      sb.append("A");
    }

    // 첫문자가 B이면 뒤집고 B를 뺀다.
    if (sb.charAt(0) == 'B') {
      sb.reverse().deleteCharAt(sb.length() - 1);
      dfs(sb);
      sb.append("B").reverse();
    }
  }
}