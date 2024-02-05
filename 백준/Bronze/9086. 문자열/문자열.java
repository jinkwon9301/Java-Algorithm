import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
    }
  }
}
