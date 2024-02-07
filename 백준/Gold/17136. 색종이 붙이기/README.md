# [Gold II] 색종이 붙이기 - 17136 

[문제 링크](https://www.acmicpc.net/problem/17136) 

### 성능 요약

메모리: 24608 KB, 시간: 300 ms

### 분류

백트래킹, 브루트포스 알고리즘

### 제출 일자

2024년 2월 7일 18:42:24

### 문제 설명

<p><그림 1>과 같이 정사각형 모양을 한 다섯 종류의 색종이가 있다. 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩 가지고 있다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/496452ae-ce36-4d77-93f7-19d7f3f9ce28/-/preview/" style="width: 972px; height: 302px;"></p>

<p style="text-align: center;"><그림 1></p>

<p>색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다. 1이 적힌 칸은 모두 색종이로 덮여져야 한다. 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고, 겹쳐도 안 된다. 또, 칸의 경계와 일치하게 붙여야 한다. 0이 적힌 칸에는 색종이가 있으면 안 된다.</p>

<p>종이가 주어졌을 때, 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 구해보자.</p>

### 입력 

 <p>총 10개의 줄에 종이의 각 칸에 적힌 수가 주어진다.</p>

### 출력 

 <p>모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.</p>

---

![Screenshot 2024-02-07 at 10 06 08 AM](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/1bec34df-2c59-41ce-a66d-7e490038d0bd)

![Screenshot 2024-02-07 at 10 06 18 AM](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/566e28e3-780b-4f4a-8935-52b485ce1af4)

![Screenshot 2024-02-07 at 10 06 28 AM](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/99efb593-3233-4009-81d6-92dae8b33801)

풀이

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] map;
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        map = new int[10][10];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        DFS(0, 0, 0);
 
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
 
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
    
    // DFS + 백트래킹
    public static void DFS(int x, int y, int cnt) {
        // 맨 끝점에 도달하였을 경우, ans와 cnt 비교하고 종료.
        if (x >= 9 && y > 9) {
            ans = Math.min(ans, cnt);
            return;
        }
 
        // 최솟값을 구해야하는데 ans보다 cnt가 커지는 순간
        // 더 이상 탐색할 필요가 없어짐.
        if (ans <= cnt) {
            return;
        }
 
        // 아래 줄로 이동.
        if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }
 
        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0); // 색종이를 붙임.
                    paper[i]--;
                    DFS(x, y + 1, cnt + 1);
                    attach(x, y, i, 1); // 색종이를 다시 뗌.
                    paper[i]++;
                }
            }
        } else { // 오른쪽으로 이동.
            DFS(x, y + 1, cnt);
        }
    }
 
    // 색종이를 붙이는 함수.
    public static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
 
    // 색종이를 붙일 수 있는지 확인.
    public static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
 
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
 
}
```
풀이를 이해하고 다시 입력해본 풀이

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[] paper = {0, 5, 5, 5, 5, 5};
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    map = new int[10][10];
    for (int i = 0; i < map.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

//    map = new int[][] {
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//    };

    DFS(0, 0, 0);

    if (min == Integer.MAX_VALUE) {
      min = -1;
    }

    bw.write(min + "\n");
    bw.close();
    br.close();
  }

  public static void DFS(int x, int y, int cnt) {

    // 종료 조건 (끝에 map 끝에 다다르면 종료한다.)
    if (x == 9 && y == 10) {
      min = Math.min(Main.min, cnt);
      return;
    }

    // 만약 cnt가 min보다 크거나 같아도 종료 (더하는건 의미가 없기 때문)
    if (min <= cnt) {
      return;
    }

    // 오른쪽 끝까지 갔다면 아래로 한칸 이동한다.
    if (y == 10) {
      DFS(x + 1, 0, cnt);
      // 한칸 내려줄 때는 return 해줘야지 아니면 끝까지 탐색한 후에 y == 10인 상태로 계속 진행되서 map[][10]되서 ArrayIndexOutOfBound 에러 터짐
      return;
    }

    if (map[x][y] == 1) {
      for (int i = 1; i <= 5; i++) {
        // 색종이가 남아있으며 && 색종이를 붙일 수 있으면 (map범위를 벗어나지 않으면)
        if (paper[i] > 0 && isAttach(x, y, i)) {
          // 색종이를 붙인다.
          attach(x, y, i, 0);
          paper[i]--;
          // 오른쪽으로 한칸 이동해서 다음을 탐색한다.
          DFS(x, y + 1, cnt + 1);
          // 탐색을 마치면 색종이를 뗀다.
          attach(x, y, i, 1);
          paper[i]++;
        }
      }
    }
    // map[x][y] == 0 이라면 오른쪽으로 한칸 이동해서 탐색
    else {
      DFS(x, y + 1, cnt);
    }
  }

  private static void attach(int x, int y, int length, int state) {
    for (int i = x; i < x + length; i++) {
      for (int j = y; j < y + length; j++) {
        map[i][j] = state;
      }
    }
  }

  private static boolean isAttach(int x, int y, int length) {
    for (int i = x; i < x + length; i++) {
      for (int j = y; j < y + length; j++) {
        if (i >= 10 || j >= 10 || map[i][j] == 0) return false;
      }
    }
    return true;
  }
}
```

크기가 1인 색종이부터 붙여도 속도의 차이가 없다. (그리디 문제가 아니었던 것)

출처 : [[BOJ] 백준 17136번 : 색종이 붙이기 (JAVA)](https://steady-coding.tistory.com/43)
