import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
//     백준 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    BigInteger[] distances = new BigInteger[N - 1];
    for (int i = 0; i < distances.length; i++) {
      distances[i] = new BigInteger(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    BigInteger[] oil = new BigInteger[N];
    for (int i = 0; i < oil.length; i++) {
      oil[i] = new BigInteger(st.nextToken());
    }

    BigInteger total = oil[0].multiply(distances[0]);
    BigInteger minPrice = oil[0];

    for (int i = 1; i < oil.length - 1; i++) {
      if (oil[i].compareTo(minPrice) < 0) {
        total = total.add(distances[i].multiply(oil[i]));
        minPrice = oil[i];
      } else {
        total = total.add(distances[i].multiply(minPrice));
      }
    }

    System.out.println(total);
  }
}
