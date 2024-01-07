import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String MK = br.readLine();

    StringBuffer sb = new StringBuffer();
    int countM = 0;
    // 최대를 구하는 경우
    for (int i = 0; i < MK.length(); i++) {
      if (MK.charAt(i) == 'M') {
        countM++;
        if (i == MK.length() - 1) {
          while (countM > 0) {
            sb.append(1);
            countM--;
          }
        }
      } else if (MK.charAt(i) == 'K') {
        sb.append(5);
        while (countM > 0) {
          sb.append(0);
          countM--;
        }
      }
    }
    System.out.println(sb.toString());
    // 최소를 구하는 경우
    sb.setLength(0);
    for (int i = 0; i < MK.length(); i++) {
      if (MK.charAt(i) == 'M') {
        countM++;
        if (i == MK.length() - 1) {
          sb.append(1);
          countM--;
          while (countM > 0) {
            sb.append(0);
            countM--;
          }
        }
      } else if (MK.charAt(i) == 'K') {
        if (countM != 0) {
          sb.append(1);
          countM--;
          while (countM > 0) {
            sb.append(0);
            countM--;
          }
        }
        sb.append(5);
      }
    }
    System.out.println(sb.toString());
  }
}