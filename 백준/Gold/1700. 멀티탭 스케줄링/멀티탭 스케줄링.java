import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int K = 0;
  static StringTokenizer st;
  static int[] order;
  static boolean[] use;
  static int useCount;
  static int answer;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 초기화
    order = new int[K];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < K; i++) {
      order[i] = Integer.parseInt(st.nextToken());
    }
    use = new boolean[101];

    for (int i = 0; i < K; i++) {
      int cord = order[i];

      if (!use[cord]) {
        if (useCount < N) {
          use[cord] = true;
          useCount++;
        } 
        
        else {
          ArrayList<Integer> list = new ArrayList<>();
          for (int j = i + 1; j < K; j++) {
            int nCord = order[j];
            if (use[nCord] && !list.contains(nCord)) {
              list.add(nCord);
            }
          }
          
          if (list.size() != N) {
            for (int j = 0; j < use.length; j++) {
              if (use[j] && !list.contains(j)) {
                use[j] = false;
                break;
              }
            }    
          } 
          
          else {
            Integer remove = list.get(list.size() - 1);
            use[remove] = false;
          }

          use[cord] = true;
          answer++;
        }
      }
    }

    System.out.println(answer);
  }
}
