import java.io.*;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    ArrayList<Integer> list = new ArrayList<>();
    int idx = 1;
    int element = 1;

    while (element <= 1000) {
      list.add(element);
      idx++;
      element = (idx * (idx + 1)) / 2;
    }

    for (int i = 0; i < T; i++) {
      int K = Integer.parseInt(br.readLine());
      boolean isTrue = false;
      
      for (Integer num1 : list) {
        for (Integer num2 : list) {
          for (Integer num3 : list) {
            if (num1 + num2 + num3 == K) {
              isTrue = true;
            }
            if (isTrue || num1 + num2 + num3 > K) break;
          }
          if (isTrue || num1 + num2 > K) break;
        }
        if (isTrue || num1 > K) break;
      }
      
      if (isTrue) {
        bw.write(1 + "\n");
        bw.flush();
      } else {
        bw.write(0 + "\n");
        bw.flush();
      }
    }
  }
}
