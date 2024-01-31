import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int[][] arr;
  static int max = 0;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // 초기화 (빌딩 위치와 높이를 좌표에 저장)
    arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      arr[i] = new int[]{i + 1, Integer.parseInt(st.nextToken())};
    }

//    N = 15;
//    arr = new int[][] {
//        {1, 1},
//        {2, 5},
//        {3, 3},
//        {4, 2},
//        {5, 6},
//        {6, 3},
//        {7, 2},
//        {8, 6},
//        {9, 4},
//        {10, 2},
//        {11, 5},
//        {12, 7},
//        {13, 3},
//        {14, 1},
//        {15, 5},
//    };
//
//    N = 1;
//    arr = new int[][] {
//        {1, 10},
//    };
//
//    N = 4;
//    arr = new int[][] {
//        {1, 5},
//        {2, 5},
//        {3, 5},
//        {4, 5},
//    };
//
//    N = 5;
//    arr = new int[][] {
//        {1, 1},
//        {2, 2},
//        {3, 7},
//        {4, 3},
//        {5, 2},
//    };
////
//    N = 10;
//    arr = new int[][] {
//        {1, 1000000000},
//        {2, 999999999},
//        {3, 999999998},
//        {4, 999999997},
//        {5, 999999996},
//        {6, 1},
//        {7, 2},
//        {8, 3},
//        {9, 4},
//        {10, 5},
//    };

    for (int i = 0; i < N; i++) {
      max = Math.max(max, countVisible(i));
    }

    System.out.println(max);
  }

  // 빌딩 x1에서 빌딩 x2를 바라봤을 때 보이는지 확인하는 메서드
  static boolean isVisible(int[] x1, int[] x2) {
    // 빌딩 x1과 빌딩 x2의 기울기를 구한다.
    // 빌딩 x1과 빌딩 x2사이에 있는 빌딩 x3들과 빌딩 x2 사이의 기울기를 구한다.
    // x3와 x2 사이의 기울기가 더 x1과 x2 사이의 기울기 보다 작거나 같다면 return false;
    double inclination = 0;
    double nInclination = 0;
    // x1 < x2
    if (x1[0] < x2[0]) {
      inclination = (double) (x2[1] - x1[1]) / (x2[0] - x1[0]);
      for (int i = x1[0] + 1; i < x2[0]; i++) {
        int[] x3 = arr[i - 1];
        if (x2[1] - x3[1] == 0) nInclination = 0;
        else nInclination = (double) (x2[1] - x3[1]) / (x2[0] - x3[0]);
        if (nInclination <= inclination) return false;
      }
    }
    // x1 > x2
    else {
      inclination = (double) (x1[1] - x2[1]) / (x1[0] - x2[0]);
      for (int i = x2[0] + 1; i < x1[0]; i++) {
        int[] x3 = arr[i - 1];
        if (x1[1] - x3[1] == 0) nInclination = 0;
        else nInclination = (double) (x1[1] - x3[1]) / (x1[0] - x3[0]);
        if (nInclination <= inclination) return false;
      }
    }

    return true;
  }

  // 빌딩이 몇개 보이는지 확인하는 메서드
  static int countVisible(int i) {

    int count = 0;

    // 자신을 제외한 모든 빌딩을 순회하며 보이는지 확인한다.
    for (int j = 0; j < N; j++) {
      if (i != j) {
        if (isVisible(arr[i], arr[j])) {
          count++;
        }
      }
    }
    return count;
  }
}