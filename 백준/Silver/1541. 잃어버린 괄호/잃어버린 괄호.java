import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String expression = br.readLine();

    String[] arrExpression = expression.split("-");
    int sum = 0;

    String[] idx1 = arrExpression[0].split("\\+");
    for (int i = 0; i < idx1.length; i++) {
      sum += Integer.parseInt(idx1[i]);
    }

    for (int i = 1; i < arrExpression.length; i++) {
      String[] idx = arrExpression[i].split("\\+");
      for (int j = 0; j < idx.length; j++) {
        sum -= Integer.parseInt(idx[j]);
      }
    }

    System.out.println(sum);
  }
}
