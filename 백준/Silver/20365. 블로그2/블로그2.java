import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String BR = br.readLine();

    char color1 = ' ';
    char color2 = ' ';
    
    color1 = BR.charAt(0);
    if (color1 == 'B') {
      color2 = 'R';
    } else {
      color2 = 'B';
    }
    
    int count = 1;

    for (int i = 0; i < N; i++) {
      if (BR.charAt(i) == color2 && BR.charAt(i-1) == color1) count++;
    }

    System.out.println(count);
  }
}