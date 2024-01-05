import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
//     백준 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] distances = new int[N - 1];
    for (int i = 0; i < distances.length; i++) {
      distances[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    int[] cities = new int[N];
    for (int i = 0; i < cities.length; i++) {
      cities[i] = Integer.parseInt(st.nextToken());
    }

    // 최소 기름값인 도시의 인덱스와 기름값을 담을 배열
    // 초기화
    int[] min = {0, cities[0]};

    int total = 0;
    int distance = 0;

    // 도시 기름값 배열을 순회한다.
    for (int i = 1; i < cities.length; i++) {
      // 만약 다음 도시의 기름값이 최소 기름값 보다 작다면 || i가 마지막 인덱스라면
      if (cities[i] < min[1] || i == cities.length - 1) {
        // 그 도시까지의 거리 * 기존 최소 기름값
        for (int j = min[0]; j < i; j++) {
          distance += distances[j];
        }
        total += distance * min[1];

        // 거리 초기화
        distance = 0;
        // min 갱신
        min = new int[]{i, cities[i]};
      }
    }

    System.out.println(total);
  }
}