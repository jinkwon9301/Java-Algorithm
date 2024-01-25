# [Silver I] 스타트와 링크 - 14889 

[문제 링크](https://www.acmicpc.net/problem/14889) 

### 성능 요약

메모리: 20312 KB, 시간: 360 ms

### 분류

백트래킹, 브루트포스 알고리즘

### 제출 일자

2024년 1월 25일 15:00:11

### 문제 설명

<p>오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.</p>

<p>BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 능력치 S<sub>ij</sub>는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 S<sub>ij</sub>의 합이다. S<sub>ij</sub>는 S<sub>ji</sub>와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 S<sub>ij</sub>와 S<sub>ji</sub>이다.</p>

<p>N=4이고, S가 아래와 같은 경우를 살펴보자.</p>

<table class="table table-bordered" style="width:20%">
	<thead>
		<tr>
			<th>i\j</th>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>1</th>
			<td> </td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr>
			<th>2</th>
			<td>4</td>
			<td> </td>
			<td>5</td>
			<td>6</td>
		</tr>
		<tr>
			<th>3</th>
			<td>7</td>
			<td>1</td>
			<td> </td>
			<td>2</td>
		</tr>
		<tr>
			<th>4</th>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td> </td>
		</tr>
	</tbody>
</table>

<p>예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.</p>

<ul>
	<li>스타트 팀: S<sub>12</sub> + S<sub>21</sub> = 1 + 4 = 5</li>
	<li>링크 팀: S<sub>34</sub> + S<sub>43</sub> = 2 + 5 = 7</li>
</ul>

<p>1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.</p>

<ul>
	<li>스타트 팀: S<sub>13</sub> + S<sub>31</sub> = 2 + 7 = 9</li>
	<li>링크 팀: S<sub>24</sub> + S<sub>42</sub> = 6 + 4 = 10</li>
</ul>

<p>축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.</p>

### 입력 

 <p>첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 S<sub>ij</sub> 이다. S<sub>ii</sub>는 항상 0이고, 나머지 S<sub>ij</sub>는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.</p>

---

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int N;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		map = new int[N][N];
		visit = new boolean[N];
 
 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		combi(0, 0);
		System.out.println(Min);
 
	}
 
	// idx는 인덱스, count는 조합 개수(=재귀 깊이)
	static void combi(int idx, int count) {
		// 팀 조합이 완성될 경우
		if(count == N / 2) {
			/*
			 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
			diff();
			return;
		}
 
		for(int i = idx; i < N; i++) {
			// 방문하지 않았다면?
			if(!visit[i]) {
				visit[i] = true;	// 방문으로 변경
				combi(i + 1, count + 1);	// 재귀 호출
				visit[i] = false;	// 재귀가 끝나면 비방문으로 변경
			}
		}
	}
 
	// 두 팀의 능력치 차이를 계산하는 함수 
	static void diff() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(team_start - team_link);
		
		/*
		  두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		  더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val, Min);
				
	}
 
}
```

출처 : [[백준] 14889번 : 스타트와 링크 - JAVA](https://st-lab.tistory.com/122)
