import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      // 대문자는 소문자로 바꿔서 추가
      if (Character.isUpperCase(str.charAt(i))) {
        result += Character.toLowerCase(str.charAt(i));
      }
      // 소문자는 대문자로 바꿔서 추가
      else {
        result += Character.toUpperCase(str.charAt(i));
      }
    }

    System.out.println(result);
  }
}
