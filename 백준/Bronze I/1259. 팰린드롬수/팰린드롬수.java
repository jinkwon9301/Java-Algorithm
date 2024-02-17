import java.io.*;

public class Main {
  static String str;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (!(str = br.readLine()).equals("0")) {

      boolean isPalindrome = true;

      for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
          isPalindrome = false;
          break;
        }
      }

      if (isPalindrome) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }
}
