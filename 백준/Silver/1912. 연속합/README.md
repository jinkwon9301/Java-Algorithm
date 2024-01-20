# [Silver II] 연속합 - 1912 

[문제 링크](https://www.acmicpc.net/problem/1912) 

### 성능 요약

메모리: 23492 KB, 시간: 292 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2024년 1월 20일 13:36:38

### 문제 설명

<p>n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.</p>

<p>예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.</p>

### 입력 

 <p>첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 답을 출력한다.</p>

---

<img width="898" alt="Screenshot 2024-01-20 at 1 45 09 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/e62ab8d8-6e27-48b7-bcd5-e24e92c72ba3">

<img width="921" alt="Screenshot 2024-01-20 at 1 45 14 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/25351235-c4d1-4f06-9014-58901bf75ec4">

<img width="890" alt="Screenshot 2024-01-20 at 1 45 27 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/a6d30840-6fad-442f-b7f2-f0eba3d51c45">

<img width="859" alt="Screenshot 2024-01-20 at 1 45 32 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/f00493f2-7ace-4872-ab31-e2ca1617ebf6">

1. top-down

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int[] arr;		// 배열 
	static Integer[] dp;	// 메모이제이션 할 dp
	static int max;			// 최댓값 변수 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
		 * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
		 * max또한 첫 번째 원소로 초기화 해준다.
		 */
		dp[0] = arr[0];
		max = arr[0];
		
		// dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색 
		recur(N - 1);
		
		System.out.println(max);
	}
	
	static int recur(int N) {
		
		// 탐색하지 않은 인덱스라면
		if(dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
 
			// 해당 dp[N]과 max 중 큰 값으로 max 갱신 
			max = Math.max(dp[N], max);
		}
		
		return dp[N];
	}
}
```

2. down-top

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
 
		/*
		 * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
		 * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
		 * max또한 첫 번째 원소로 초기화 해준다.
		 */
		dp[0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			// (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장 
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			// 최댓값 갱신 
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
 
	}
}
```

출처 : [[백준] 1912번 : 연속합 - JAVA [자바]](https://st-lab.tistory.com/140)
