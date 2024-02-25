import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static StringTokenizer st;
  static int gcd, lcm;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    int num1 = Integer.parseInt(st.nextToken());
    int num2 = Integer.parseInt(st.nextToken());

    // 유클리드 호제법을 활용하여 최대공약수, 최소공배수 구한다.
    if (num1 >= num2) {
      gcd = gcd(num1, num2);
      lcm = lcm(num1, num2);
    } else {
      gcd = gcd(num2, num1);
      lcm = lcm(num2, num1);
    }

    System.out.println(gcd);
    System.out.println(lcm);
  }

  // 최대공약수
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  // 최소공배수
  public static int lcm(int a, int b) {
    int gcd = gcd(a, b);
    return (a * b) / gcd;
  }
}

