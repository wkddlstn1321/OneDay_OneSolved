### 게임 맵 최단거리
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/1844)

# 해결과정

미로찾기 문제로 전형적인 BFS 문제로 보여진다.

방문 체크할 visit 배열과 각 위치를 담아줄 queue를 생성
이때 x,y 축을 저장할 수 있는 Point 클래스를 queue 타입으로 지정해줬다.

queue에서 좌표를 하나 제거후 해당 좌표 4방향에 대해서 체크 후 유효한 경우에만 visit체크 후 다음 좌표 정보를 queue에 다시 삽입하는 반복문 실행
이때 visit 배열을 체크할 때 이전 visit인덱스 + 1 값을 저장한다. 이게 이동한 칸 개수
```
public static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int visit[][] = new int[n][m];
		int dirX[] = {1, -1, 0, 0};
		int dirY[] = {0, 0, 1, -1};
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0,0));
		visit[0][0] = 1; //시작하자 마자 한칸
		while(!q.isEmpty()) {
			Point xy = q.poll();
			for (int i = 0 ; i < 4 ; i++) {
				int x = xy.x + dirX[i];
				int y = xy.y + dirY[i];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (visit[x][y] == 0 && maps[x][y] != 0) {
						q.offer(new Point(x,y));
						visit[x][y] = visit[xy.x][xy.y] + 1;
					}
				}
			}
		}
		int answer = visit[n - 1][m - 1] > 0 ? visit[n -1][m - 1] : -1;
		return answer;
	}
```

BFS 미로찾기 문제는 비슷한 문제를 풀어본 경험이 많아서 이번 문제는 쉽게 풀었다.