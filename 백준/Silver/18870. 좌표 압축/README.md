# [Silver II] 좌표 압축 - 18870 

[문제 링크](https://www.acmicpc.net/problem/18870) 

### 성능 요약

메모리: 235976 KB, 시간: 2104 ms

### 분류

값 / 좌표 압축, 정렬

### 제출 일자

2024년 8월 3일 19:36:14

### 문제 설명

<p>수직선 위에 N개의 좌표 X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.</p>

<p>X<sub>i</sub>를 좌표 압축한 결과 X'<sub>i</sub>의 값은 X<sub>i</sub> > X<sub>j</sub>를 만족하는 서로 다른 좌표 X<sub>j</sub>의 개수와 같아야 한다.</p>

<p>X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>에 좌표 압축을 적용한 결과 X'<sub>1</sub>, X'<sub>2</sub>, ..., X'<sub>N</sub>를 출력해보자.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다.</p>

<p>둘째 줄에는 공백 한 칸으로 구분된 X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>이 주어진다.</p>

### 출력 

 <p>첫째 줄에 X'<sub>1</sub>, X'<sub>2</sub>, ..., X'<sub>N</sub>을 공백 한 칸으로 구분해서 출력한다.</p>

---
문제는 `정렬 & distinct → 바이너리서치` 로 풀이 가능하지만 coordinate Compression (좌표압축)에 대한 개념을 다음 블로그에서 볼 수 있다. <br />
참고 :[Stranger's Lab](https://st-lab.tistory.com/279) <br />

```java
int[] origin = new int[N];	// 원본 배열
int[] sorted = new int[N];	// 정렬 할 배열
HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	// rank를 매길 HashMap
 
// 정렬 할 배열에 대해 정렬을 수행해준다.
sort(sorted);
		
		
// 정렬 된 배열을 순회하면서 map에 넣어준다.
int rank = 0;
for(int v : sorted) {
	/*
	 *  이 때 만약 앞선 원소가 이미 순위가 매겨졌다면
	 *  중복되면 안되므로, 원소가 중복되지 않을 때만
	 *  map에 원소와 그에 대응되는 순위를 넣어준다.
	 */
	if(!rankingMap.containsKey(v)) {
		rankingMap.put(v, rank);
		rank++;		// map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더해준다.
	}
}
		
// 원본 배열을 차례대로 순회하면서 해당 원소에 대한 rank를 갖고온다.
for(int key : origin) {
	print(rankingMap.get(key));	// 원본 배열 원소(key)에 대한 value(rank)를 갖고온다.
}
```
