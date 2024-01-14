# [Gold III] 가희와 탑 - 24337 

[문제 링크](https://www.acmicpc.net/problem/24337) 

### 성능 요약

메모리: 38316 KB, 시간: 2260 ms

### 분류

해 구성하기, 그리디 알고리즘

### 제출 일자

2024년 1월 14일 18:24:41

### 문제 설명

<p>일직선으로 다양한 높이의 건물들이 <em>N</em>개 존재합니다. 가희는 건물들의 왼쪽에, 단비는 건물들의 오른쪽에 있습니다. 일직선 상에 가희와 단비, 건물들은 아래와 같은 순서로 배치되어 있습니다.</p>

<ul>
	<li>가희의 오른쪽에는 1번 건물이 있습니다.</li>
	<li><em>x</em>가 1이상 <em>N-1</em>이하의 정수일 때, x번 건물의 오른쪽에는 <em>x+1</em>번 건물이 있습니다.</li>
	<li><em>N</em>번 건물의 오른쪽에는 단비가 있습니다.</li>
</ul>

<p>가희와 단비가 볼 수 있는 건물은 아래와 같습니다.</p>

<ul>
	<li>가희는 1번 건물을 볼 수 있습니다.</li>
	<li><em>k</em>번 건물보다 왼쪽에 있는 건물들이 <strong>모두</strong> <em>k</em>번 건물보다 높이가 낮다면, 가희는 <em>k</em>번 건물을 볼 수 있습니다.</li>
	<li>단비는 <em>N</em>번 건물을 볼 수 있습니다.</li>
	<li><em>k</em>번 건물보다 오른쪽에 있는 건물들이 <strong>모두</strong> <em>k</em>번 건물보다 높이가 낮다면, 단비는 <em>k</em>번 건물을 볼 수 있습니다.</li>
</ul>

<p>예를 들어, <em>N</em>이 3이고, 1번 건물의 높이가 1, 2번 건물의 높이가 3, 3번 건물의 높이가 2라고 하겠습니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/5a6e0313-a6d1-43b4-9997-926cae9b0905/-/preview/"></p>

<p style="text-align: center;"><strong>[그림 1] 가희와 단비, 그리고 건물들의 배치</strong></p>

<p>가희가 볼 수 있는 건물과 단비가 볼 수 있는 건물의 수는 각각 2개입니다. 이를 각각 노란색, 연보라색으로 표시하겠습니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f0583b2b-3237-498e-95cf-af714b52cd15/-/preview/">  <img alt="" src="https://upload.acmicpc.net/777defd0-84a6-40ae-a24f-89154fa6ab8c/-/preview/"></p>

<p style="text-align: center;"><strong>[좌] 가희가 볼 수 있는 건물 [우] 단비가 볼 수 있는 건물</strong></p>

<p>가희가 3번 건물을 볼 수 없는 이유는 3번 건물 왼쪽에 있는 2번 건물의 높이가 3번 건물보다 높기 때문입니다. 그리고, 단비가 1번 건물을 볼 수 없는 이유는 1번 건물보다 오른쪽에 있는 2번 건물과 3번 건물이 1번 건물보다 높기 때문입니다.</p>

<p>가희와 단비 사이에 있는 건물의 개수 <em>N</em>과 가희가 볼 수 있는 건물의 개수 <em>a</em>, 단비가 볼 수 있는 건물의 개수 <em>b</em>가 주어집니다. <strong>사전 순으로 가장 앞서는</strong> <em>N</em>개의 건물 높이 정보를 출력해 주세요.</p>

### 입력 

 <p>첫째 줄에 건물의 개수 <em>N</em>, 가희가 볼 수 있는 건물의 개수 <em>a</em>, 단비가 볼 수 있는 건물의 개수 <em>b</em>가 공백으로 구분해서 주어집니다.</p>

### 출력 

 <p>문제의 조건에 맞는 건물들의 높이 정보가 1개 이상 존재하는 경우 <em>N</em>개의 건물 높이 정보 중 <strong>사전순으로 가장 앞선 것</strong>을 출력해 주세요. 출력 형식은 다음을 만족해야 합니다.</p>

<ul>
	<li>1번 건물, ... , <em>N</em>번 건물의 높이를 <strong>공백으로 구분해서 출력</strong>해 주세요. <strong>출력하는 수들이 모두 다를 필요는 없습니다.</strong></li>
	<li>높이는 <strong>1보다 크거나 같은 정수</strong>여야 합니다.</li>
</ul>

<p>문제의 조건에 맞는 건물들의 높이 정보가 존재하지 않으면 첫 줄에 -1을 출력해 주세요.</p>

---

문제 길이가 너무 길어서 문제 사진은 스킵하고 풀이만 보도록 해보자
먼저 문제 해결을 위해서 이 문제가 정확하게 원하는 답이 무엇인지를 알아보도록 하자

![image](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/c1cbf5eb-6b4c-46d7-bbfd-789494af9534)

 다른 문구는 잘 모르겠지만, 사전순으로 가장 앞선 것을 먼저 출력해달라는 문구는 확실히 눈에 띈다.
 
예를 들어 n=5, a=2, b=3일 때 정답은 1 3 2 1 1 1 1 3 2 1 이 나올 수 있지만, 이 때 사전순으로 더 빠른 1 1 3 2 1 을 정답으로 치겠다는 말이다.

그리고 마지막 줄에 문제의 조건에 맞는 경우의 수가 없다면 -1을 출력하라고 하는데, 내 생각에 답이 나올 수 없는 경우의 수는 건물 개수보다 a+b의 크기가 클 때 밖에 없다고 생각 됐다.

가장 높은 건물은 a와 b 모두 볼 수 있기 때문에 최종 예외처리는 n+1 < a+b 일 경우로 했다.   


다음으로 문제 풀이 방법을 생각해봐야 했다.
먼저 a와b의 기준에 맞는 건물의 순서를 세워주어야 한다. 순서대로 세워주면 사전순으로도 가장 빠를 것이기에 이부분은 쉽다.
예를 들면,

a=3, b=4 
-> 1 2 4 3 2 1
a=5, b=3 
-> 1 2 3 4 5 2 1
a=4, b=4 
-> 1 2 3 4 3 2 1

이런 식이다.

1 ~ a-1 까지 세워주고, 가장 높은 건물은 a와 b 중 더 큰 숫자(Math.max(a,b))를 세워준다. 
그리고 그 뒤에 b-1 ~ 1 까지의 건물을 추가해주면 일단 a와 b의 조건은 만족한 건물 순서가 나온다.     


이제 문제는 이렇게 구한 배열을 사전순으로 가장 빠르게 n개까지 늘려주어야 한다는 것이다.
간단하게 맨 앞에 1을 배열의 길이가 n이 될 때까지 채워주었다. 

예를 들면,

n=10, a=3, b=4 
-> 1 1 1 1 1 2 4 3 2 1

이런식으로 배열 앞에 높이 1짜리 건물들을 채워주었는데, 문제가 생긴 부분이 있었다.

바로 a가 1일 경우이다. 
a가 1인 경우에는 가장 왼쪽 건물이 가장 높아야만 하기 때문이다.
이런 경우, 일단 정렬은 잘 되어 있을것이다.

a=1, b=5 -> 
5 4 3 2 1 

이런식으로 말이다.

여기에서 사전순으로 가장 빠르게 만들려면 되도록 왼쪽에 1을 넣어야 하는데, 그렇게 생각하면 답은 하나밖에 없다.

n=10, a=1, b=5 -> 
5 1 1 1 1 1 4 3 2 1

바로 두번째부터 1을 추가하는 것이다. 생각보다 간단한 해답이었다.


정답 코드
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> tower;
	static int n, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		tower = new ArrayList<>();

		if (a + b > n + 1) {
			System.out.print(-1);
			return;
		}

		for (int i = 1; i < a; i++) {
			tower.add(i);
		}
		tower.add(Math.max(a, b));

		for (int i = b - 1; i >= 1; i--) {
			tower.add(i);
		}

		if (a == 1) {
			while (tower.size() < n) {
				tower.add(1, 1);
			}
		} else {
			while (tower.size() < n) {
				tower.add(0, 1);
			}
		}
		for (int i : tower) {
			System.out.print(i + " ");
		}
	}
}
```

출처 : [백준 #2 - 24337 가희와 탑 (자바)](https://velog.io/@dksekfbs72/%EB%B0%B1%EC%A4%80-24337%EB%B2%88-%EC%9E%90%EB%B0%94-%ED%92%80%EC%9D%B4)

---

| 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tk = null;

	static int N, a, b;
	static List<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		tk = new StringTokenizer(rd.readLine());
		N = Integer.parseInt(tk.nextToken());
		a = Integer.parseInt(tk.nextToken());
		b = Integer.parseInt(tk.nextToken());
		
		if (a + b - 1 > N) {
			System.out.println(-1);
			return;
		}

		for (int i=1; i <= a-1; i++)
			list.add(i);
		
		list.add(Math.max(a, b));
		
		for (int i=b-1; i >= 1; i--)
			list.add(i);
		
		for (int i=0; i < N - (a + b - 1); i++)
			list.add(1, 1);

		for (int n: list)
			sb.append(n).append(' ');
		
		System.out.println(sb);
	}
}
```

메모리 및 시간
메모리: 23232 KB
시간: 240 ms

| 리뷰

처음에 List를 안 쓰고 StringBuilder 만을 이용해서 풀려고 했다가, 1을 추가하는 과정에서 인덱스 관련 문제가 있어 결국...

| 틀린 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tk = null;

	static int N, a, b;
	
	public static void main(String[] args) throws Exception {
		tk = new StringTokenizer(rd.readLine());
		N = Integer.parseInt(tk.nextToken());
		a = Integer.parseInt(tk.nextToken());
		b = Integer.parseInt(tk.nextToken());
		
		if (a + b - 1 > N) {
			System.out.println(-1);
			return;
		}

		for (int i=1; i <= a-1; i++)
			sb.append(i).append(' ');
		
		sb.append(Math.max(a, b)).append(' ');
		
		for (int i=b-1; i >= 1; i--)
			sb.append(i).append(' ');
		
		for (int i=0; i < N - (a + b - 1); i++)
			sb.insert(2, "1 "); // 오류: 첫 번째 빌딩 높이가 한 자리가 아닐 수 있다.

		System.out.println(sb);
	}
}
```

출처 :[백준 24337 '가희와 탑'](https://velog.io/@doubledeltas/boj-24337)
