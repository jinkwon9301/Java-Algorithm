import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int[] tmp = new int[2];
      tmp[0] = Integer.parseInt(st.nextToken());
      tmp[1] = Integer.parseInt(st.nextToken()); 
      arr[i] = tmp;
    }
      
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    
    int count = 1;
    int endTime = arr[0][1];

    for (int i = 1; i < N; i++) {
      int startTime = arr[i][0];
      if (startTime >= endTime) {
        count++;
        endTime = arr[i][1];
      }
    }

    System.out.println(count);
  }
}
