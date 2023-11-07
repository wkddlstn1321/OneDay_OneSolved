### 피로도

[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/87946#)

# 해결과정

배열의 길이가 최대 8이라서 완전탐색으로 처리가 가능한 문제다.
처음에는 소모피로도순으로 정렬 후 갈 수 있을때까지 가면되지 않을까 했는데
[[100, 20], [80, 10]] 이런 경우는 통과하지 못할거 같아서 급하게 수정했다.

던전배열의 길이를 n으로 잡고 0 ~ n 까지 정렬할 수 있는 모든 경우의 수를 구했다.
```
	public static void jeagui(ArrayList<Integer> input, int index, ArrayList<ArrayList<Integer>> list) {
		if (index == input.size()) {
			list.add(new ArrayList<>(input));
			return ;
		}
		for (int i = index ; i < input.size() ; i++) {
			Collections.swap(input, index, i);
			jeagui(input, index + 1, list);
			Collections.swap(input, index, i);
		}
	}

	public static ArrayList<ArrayList<Integer>> dfs(int n) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0 ; i < n ; i++) {
			input.add(i);
		}
		jeagui(input, 0, list);
		return list;
	}
```

그 뒤 모든 배열에 대해서 던전에 갈 수 있는 cnt를 구해서 그중 최대 cnt를 리턴했다.
```
		ArrayList<ArrayList<Integer>> list = dfs(dungeons.length);
		for (int i = 0 ; i < list.size() ; i++) {
			int temp = k;
			int cnt = 0;
			for (int j = 0 ; j < list.get(i).size() ; j++) {
				if (temp < dungeons[list.get(i).get(j)][0]) {
					break ;
				}
				temp -= dungeons[list.get(i).get(j)][1];
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
```

오랜만에 bfs를 푸는거라 모든 경우의 수를 구할 때 머리가 좀 아팠다.
코드도 너무 길게 작성된거 같아서 다른 사람들 풀이를 구경했는데 많이 반성하게 된다.
bfs 태그만 골라서 복습 겸 마스터하러 가고 싶어지는 문제였다.