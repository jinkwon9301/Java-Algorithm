# [Gold V] 숫자고르기 - 2668 

[문제 링크](https://www.acmicpc.net/problem/2668) 

### 성능 요약

메모리: 14292 KB, 시간: 124 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 2월 18일 19:51:13

### 문제 설명

<p>세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다. 첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다. 첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다. 이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오. 예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/u5JZnfExdtFXjmR.png" style="width: 262px; height: 61px; "></p>

<p>이 경우에는 첫째 줄에서 1, 3, 5를 뽑는 것이 답이다. 첫째 줄의 1, 3, 5밑에는 각각 3, 1, 5가 있으며 두 집합은 일치한다. 이때 집합의 크기는 3이다. 만약 첫째 줄에서 1과 3을 뽑으면, 이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다. 그러나, 이 경우에 뽑힌 정수의 개수는 최대가 아니므로 답이 될 수 없다.</p>

### 입력 

 <p>첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다. 그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.</p>

### 출력 

 <p>첫째 줄에 뽑힌 정수들의 개수를 출력하고, 그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.</p>

---

<img width="837" alt="Screenshot 2024-02-18 at 7 53 06 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/6a16f97e-43b6-4671-9e1c-faf460d4c5fe">

```java
import java.util.*;
 
public class Main {    
    
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //n개의 정수를 입력받는다.
        int n = scan.nextInt();
        num = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = scan.nextInt();
        }
        
        //순서대로 사이클이 발생하는지 dfs로 확인한다.
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list); //작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }    
    
    public static void dfs(int start, int target) {
        if(visited[num[start]] == false) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        if(num[start] == target) list.add(target); //사이클 발생시 해당 숫자를 list에 담아준다.
    }
}
```

이미 순환해서 확인한 경우를 다시 확인해야하는 비효율이 있는 것 같아서 나만의 방법으로 다시 해봤다.

```java
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] arr;
  static boolean[] visited;
  static List<Integer> list = new ArrayList<>();
  static List<Integer> tmpList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 초기화
    arr = new int[N + 1];
    // idx = [0,1,2,3,4,5,6,7]
    // arr = [0,3,1,1,5,5,4,6]
    for (int i = 1; i < N + 1; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    visited = new boolean[N + 1];

    for (int i = 1; i < N + 1; i++) {
      if (!visited[i]) {
        dfs(i, i);
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }

  // 사이클을 이루면 두 집합 모두 포함되는 수이다. (ex. 1 -> 3 -> 1)
  private static void dfs(int start, int target) {
    // 순환하는 경우
    if (visited[start] && start == target) {
      for (Integer num : tmpList) {
        list.add(num);
      }
      // tmpList 초기화
      tmpList = new ArrayList<>();
      return;
    }

    // 순환하지 않는 경우 (이미 방문된 곳이라면 -> 사이클을 이루지 않는다.)
    if (visited[start]) {
      // list 초기화, 지금껏 방문한 visited 초기화
      for (Integer num : tmpList) {
        visited[num] = false;
      }
      // tmpList 초기화
      tmpList = new ArrayList<>();
      return;
    }

    visited[start] = true;
    tmpList.add(start);
    dfs(arr[start], target);
  }
}

```

순환하는 경우, 그 숫자들을 리스트에 담고 방문표시 해준다. 방문된 숫자는 다시 방문하지 않는다.

출처 : [백준 : 2668 숫자고르기](https://moonsbeen.tistory.com/176)
