# [Gold III] 텀 프로젝트 - 9466 

[문제 링크](https://www.acmicpc.net/problem/9466) 

### 성능 요약

메모리: 304832 KB, 시간: 1192 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 2월 21일 14:09:58

### 문제 설명

<p>이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다. 프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다. 프로젝트 팀을 구성하기 위해, 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택해야 한다. (단, 단 한 명만 선택할 수 있다.) 혼자 하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.</p>

<p>학생들이(s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>r</sub>)이라 할 때, r=1이고 s<sub>1</sub>이 s<sub>1</sub>을 선택하는 경우나, s<sub>1</sub>이 s<sub>2</sub>를 선택하고, s<sub>2</sub>가 s<sub>3</sub>를 선택하고,..., s<sub>r-1</sub>이 s<sub>r</sub>을 선택하고, s<sub>r</sub>이 s<sub>1</sub>을 선택하는 경우에만 한 팀이 될 수 있다.</p>

<p>예를 들어, 한 반에 7명의 학생이 있다고 하자. 학생들을 1번부터 7번으로 표현할 때, 선택의 결과는 다음과 같다.</p>

<table class="table table-bordered" style="width:30%">
	<thead>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>3</td>
			<td>1</td>
			<td>3</td>
			<td>7</td>
			<td>3</td>
			<td>4</td>
			<td>6</td>
		</tr>
	</tbody>
</table>

<p>위의 결과를 통해 (3)과 (4, 7, 6)이 팀을 이룰 수 있다. 1, 2, 5는 어느 팀에도 속하지 않는다.</p>

<p>주어진 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫 줄에는 학생의 수가 정수 n (2 ≤ n ≤ 100,000)으로 주어진다. 각 테스트 케이스의 둘째 줄에는 선택된 학생들의 번호가 주어진다. (모든 학생들은 1부터 n까지 번호가 부여된다.)</p>

### 출력 

 <p>각 테스트 케이스마다 한 줄에 출력하고, 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수를 나타내면 된다.</p>

---

<img width="990" alt="Screenshot 2024-02-20 at 12 58 23 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/a16e5fcf-95b5-4460-8868-d4782140b0aa">
<img width="981" alt="Screenshot 2024-02-20 at 12 58 47 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/d1f4305e-43e6-4d28-8449-a9f3c96dbb47">
<img width="986" alt="Screenshot 2024-02-20 at 12 58 59 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/ff87c111-165b-400b-95d6-ca3f25b255d9">

```java
import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/9466
 
class Main {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int tc = stoi(br.readLine());
 
        for(int t=0; t<tc; t++) {
            n = stoi(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;
 
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<n+1; i++) 
                arr[i] = stoi(st.nextToken());
 
            for(int i=1; i<n+1; i++)
                dfs(i);
 
            System.out.println(n - count);
        }
    }
 
    static void dfs(int now) { 
        if(visited[now])
            return;
 
        visited[now] = true;
        int next = arr[now];
 
        if(visited[next] != true)
            dfs(next);
        else {
            if(finished[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }
 
        // 모든 작업이 끝나서 더이상 사용하지 않음
        finished[now] = true;
    }
}

```

시간초과가 났던 나의 풀이

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int T, N;
  static StringTokenizer st;
  static int[] students;
  static boolean[] visited;
  static List<Integer> team;
  static int teamCount;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    // 테스트케이스 만큼 시행한다.
    for (int i = 0; i < T; i++) {

      // students 초기화
      N = Integer.parseInt(br.readLine());
      students = new int[N + 1];
      visited = new boolean[N + 1];

      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j < N + 1; j++) {
        students[j] = Integer.parseInt(st.nextToken());
      }
      // ->
      // idx = [0,1,2,3,4,5,6,7]
      // stu = [0,3,1,3,7,3,4,6]

      // list, team 초기화
      team = new ArrayList<>();
      teamCount = 0;

      for (int j = 1; j < N + 1; j++) {
        if (!visited[j]) {
          dfs(j, j);
        }
      }

      // 팀을 이루지 못한 학생들 출력
      System.out.println(N - teamCount);
    }

  }

  private static void dfs(int student, int target) {
    // 만약 학생들이 서로를 선택할 때 사이클을 이루면 팀이 될 수 있다.
    if (visited[student] && student == target) {
      // 팀을 이룬 학생들을 list에 넣는다.
      teamCount += team.size();
      // 팀을 초기화한다.
      team = new ArrayList<>();
      return;
    }

    // 만약 서로를 선택한 학생들이 사이클을 이루지 않는다면
    if (visited[student]) {
     // visited 초기화
      for (Integer stu : team) {
        visited[stu] = false;
      }
      // team 초기화
      team = new ArrayList<>();
      return;
    }

    // 서로 선택한 경우를 탐색한다.
    visited[student] = true;
    team.add(student);
    dfs(students[student], target);
  }
}

```

출처 :[https://www.acmicpc.net/problem/9466](https://bcp0109.tistory.com/32)
