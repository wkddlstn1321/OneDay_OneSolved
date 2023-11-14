### N으로 표현
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/12946)

# 해결과정

재귀를 이용한 문제다. 

풀이 흐름은 이렇다.
n - 1 을 2번째 기둥으로 옮긴다.
n 을 3번째 기둥으로 옮긴다.
n - 1을 3번째 기둥으로 옮긴다.

```
	dfs(n, 1, 2, 3);

	public static void dfs(int n, int start, int mid, int dest) {
		if (n == 1) {
			Integer []arr = {start, dest};
			ans.add(arr);
		} else {
			dfs(n - 1, start, dest, mid);
			Integer []arr = {start, dest};
			ans.add(arr);
			dfs(n - 1, mid, start, dest);
		}
	}
```

구현 자체는 몇 줄 안나오지만 규칙을 찾고 식을 성립하는게 어려웠다.
처음에는 각 위치별 홀수일 때 가야할 곳 짝수 일 때 가야할 곳, 큰 원판이동 규칙
이런걸 작성하고 있었는데 너무 복잡하고 답이 없어서 다 지우고 위에 풀이 흐름 처럼
간단한 규칙으로 지정해서 구현하니 허탈하게도 너무 쉽게 구현이 되었다.

재귀 쪽은 구현보다 설계가 어렵다...