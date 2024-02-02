import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int M = 0;
  static int K = 0;
  static int[][] arr;
  static int[][] rotations;
  static int min = 5000;
  static int sum = 0;
  static boolean[] visited;
  static ArrayList<int[]> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 초기화
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st2.nextToken());
      }
    }

    visited = new boolean[K];
    rotations = new int[K][3];
    for (int i = 0; i < K; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 3; j++) {
        rotations[i][j] = Integer.parseInt(st3.nextToken());
      }
    }

//    N = 5;
//    M = 6;
//    K = 2;
//
//    arr = new int[][]{
//        {1, 2, 3, 2, 5, 6},
//        {3, 8, 7, 2, 1, 3},
//        {8, 2, 3, 1, 4, 5},
//        {3, 4, 5, 1, 1, 1},
//        {9, 3, 2, 1, 4, 3},
//    };
//
//    rotations = new int[][]{
//        {3, 4, 2},
//        {4, 2, 1},
//    };

    visited = new boolean[K];

    // 회전 정보를 permutation한다.
    permutateRotation(arr, rotations, list);

    System.out.println(min);
  }

  private static void getMin(int[][] arr) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sum += arr[i][j];
      }
      min = Math.min(min, sum);
      sum = 0;
    }
  }

  // 배열을 시계방향으로 돌리는 함수
  static void rotateArr(int[][] arr, int[] rotationInfo) {
    int x1 = rotationInfo[0];
    int y1 = rotationInfo[1];
    int x2 = rotationInfo[2];
    int y2 = rotationInfo[3];

    // x1 == x2 && y1 == y2 → 종료
    if (x1 == x2 && y1 == y2) return;

    // arr[x1][y1]의 값은 임시로 저장
    int tmp = arr[x1][y1];

    // 시계방향으로 로테이션 돌린다.
    // 좌측 상단방향 회전
    for (int i = x1; i < x2; i++) {
      arr[i][y1] = arr[i + 1][y1];
    }
    // 하단 좌측방향 회전
    for (int i = y1; i < y2; i++) {
      arr[x2][i] = arr[x2][i + 1];
    }
    // 우측 하단방향 회전
    for (int i = x2; i > x1; i--) {
      arr[i][y2] = arr[i - 1][y2];
    }
    // 상단 우측방향 회전
    for (int i = y2; i > y1 + 1; i--) {
      arr[x1][i] = arr[x1][i - 1];
    }

    // 임시로 저장했던 tmp를 넣어준다.
    arr[x1][y1 + 1] = tmp;

    // 안쪽의 테투리를 로테이션 시킨다. DFS
    int[] nRotaionInfo = new int[]{x1 + 1, y1 + 1, x2 - 1, y2 - 1};
    rotateArr(arr, nRotaionInfo);
  }

  static int[] getRotationInfo(int[] rotation) {
    int x1 = rotation[0] - rotation[2] - 1;
    int y1 = rotation[1] - rotation[2] - 1;
    int x2 = rotation[0] + rotation[2] - 1;
    int y2 = rotation[1] + rotation[2] - 1;

    return new int[]{x1, y1, x2, y2};
  }

  // 2차원 배열을 복사하는 함수
  static int[][] copyArr(int[][] arr) {
    int[][] nArr = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        nArr[i][j] = arr[i][j];
      }
    }

    return nArr;
  }

  // 로테이션을 permutation하는 함수
  static void permutateRotation(int[][] arr, int[][] rotations, ArrayList<int[]> list) {
    // 종료조건
    if (list.size() == K) {
      int[][] nArr = copyArr(arr);

      // permutation 완료된 배열의 순서대로 배열을 회전시킨다.
      for (int[] rotation : list) {
        rotateArr(nArr, getRotationInfo(rotation));
      }
      getMin(nArr);
      return;
    }

    for (int i = 0; i < K; i++) {
      if (!visited[i]) {
        visited[i] = true;
        list.add(rotations[i]);
        permutateRotation(arr, rotations, list);
        visited[i] = false;
        list.remove(rotations[i]);
      }
    }
  }
}