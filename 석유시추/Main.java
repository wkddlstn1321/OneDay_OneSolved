package 석유시추;

import java.util.*;
import java.awt.Point;

class Solution {
	int[] dirX = { 1, -1, 0, 0 };
	int[] dirY = { 0, 0, 1, -1 };
	int[] solArr;
	boolean[][] visited;

	public int solution(int[][] land) {
		int answer = 0;
		solArr = new int[land[0].length];
		visited = new boolean[land.length][land[0].length];
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					int[] temp = new int[land[0].length];
					temp[j] = 1;
					bfs(land, i, j, temp);
				}
			}
		}
		for (int i = 0; i < solArr.length; i++) {
			answer = Math.max(answer, solArr[i]);
		}
		return answer;
	}
	private void bfs(int[][] land, int x, int y, int[] temp) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dirX[i];
				int nextY = cur.y + dirY[i];
				if (nextX < 0 || nextY < 0 || nextX >= land.length || nextY >= land[0].length) {
					continue;
				}
				if (land[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					q.add(new Point(nextX, nextY));
					temp[nextY] = 1;
					visited[nextX][nextY] = true;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				solArr[i] += cnt;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] land = { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } };
		System.out.println(sol.solution(land));
	}
}

// bfs 로 석유 개수 확인
// 개수 확인하면서 포함되는 x축 저장
// 총 개수 저장

// 로직
// 0 ~ x 까지 배열 생성
//
//