import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  static int N;
  static String[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr);
    Arrays.sort(arr, (a, b) -> a.length() - b.length());

    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String str = arr[i];
      if (!list.contains(str)) {
        list.add(str);
      }
    }
    
    for (String str : list) {
      bw.write(str + "\n");  
    }
    bw.flush();
    bw.close();
    br.close();
  }
}

