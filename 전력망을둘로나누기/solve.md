### 전력망을 둘로 나누기

[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/86971)

# 해결과정

int[][] 두 개중 하나만 일치해도 연결되는 트리 구조하고 머리속에 그림을 그리니 BFS로 연결된 노드들의 개수를 계산할 수 있을거 같았다.

흐름은 아래와같다.

1. 우선 연결이 한군데씩 끊긴 모든 경우를 만들고
2. 각 경우들에 대해서 bfs를 두번씩 돌린다.
3. 첫번째와 두번째 결과를 빼면서 최솟값을 구한다.

1번

```
	public static int solution(int n, int[][] wires) {
		ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
		for (int i = 0 ; i < wires.length ; i++) {
			list.add(makeList(wires, i));
		}
		//일부 생략
	}

	public static ArrayList<Integer[]> makeList(int[][]wires, int idx){
		ArrayList<Integer[]> list = new ArrayList<>();
		for (int i = 0 ; i < wires.length ; i++) {
			if (i == idx) continue;
			list.add(new Integer[] {wires[i][0], wires[i][1]});
		}
		return list;
	}
```

2번, 3번
```
	public static int solution(int n, int[][] wires) {
		//일부 생략
		for (int i = 0 ; i < list.size() ; i++) {
			int cnt1 = 0;
			int cnt2 = 0;
			int [][]visit = new int[n + 1][n + 1];
			cnt1 = bfs(list.get(i), visit);
			cnt2 = bfs(list.get(i), visit);
			answer = Math.abs(cnt1 - cnt2) < answer ? Math.abs(cnt1 - cnt2) : answer;
		}
	}

	public static int bfs(ArrayList<Integer[]> list, int[][] visit) {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		//두번째 돌릴경우를 고려해서 한번 돌았던 노드들은 pass 한다.
		for (int i = 0 ; i < list.size() ; i++) {
			if (visit[list.get(i)[0]][list.get(i)[1]] == 0) {
				q.add(new Point(list.get(i)[0], list.get(i)[1]));
				visit[list.get(i)[0]][list.get(i)[1]] = 1;
				visit[list.get(i)[1]][list.get(i)[0]] = 1;
				cnt++;
				break;
			}
		}
		while (!q.isEmpty()) {
			Point xy = q.poll();
			for (int i = 0 ; i < list.size() ; i++) {
				if (visit[list.get(i)[0]][list.get(i)[1]] == 0 && (
					xy.x == list.get(i)[0] ||
					xy.x == list.get(i)[1] ||
					xy.y == list.get(i)[0] ||
					xy.y == list.get(i)[1])) {
					q.add(new Point(list.get(i)[0], list.get(i)[1]));
					visit[list.get(i)[0]][list.get(i)[1]] = 1;
					visit[list.get(i)[1]][list.get(i)[0]] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}
```

2번의 경우 bfs를 생각없이 두번 돌리면 둘 다 결과가 똑같기 때문에 한번 들린 노드는 무시하는 케이스를 추가하느라 코드가 길어졌다.
넣을수있는 첫번째 노드만 넣고 겹치는거 추가하면서 cnt 더해주면 끝