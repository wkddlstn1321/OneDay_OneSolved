package 빛의경로사이클;

import java.util.*;

class Solution {
	int[][][] visited;
	int rowLength;
	int colLength;
	int[] dirY = { 1, 0, -1, 0 };
	int[] dirX = { 0, 1, 0, -1 };
	ArrayList<Integer> arr = new ArrayList<>();

	public int[] solution(String[] grid) {
		rowLength = grid.length;
		colLength = grid[0].length();
		visited = new int[rowLength][colLength][4];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				for (int k = 0; k < 4; k++) {
					getCycleCnt(grid, i, j, k);
				}
			}
		}
		Collections.sort(arr);
		int[] answer = new int[arr.size()];
		for (int i = 0 ; i < arr.size() ; i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}

	public void getCycleCnt(String[] grid, int i, int j, int k) {
		if (visited[i][j][k] == 1)
			return;
		int cnt = 0;
		while (true) {
			if (visited[i][j][k] == 1) {
				arr.add(cnt);
				return;
			}
			visited[i][j][k] = 1;
			cnt++;
			k = getDir(grid[i].charAt(j), k);
			i = (i + dirX[k] + rowLength) % rowLength;
			j = (j + dirY[k] + colLength) % colLength;
		}
	}

	public int getDir(char c, int k) {
		if (c == 'R') {
			k = (k + 1 + 4) % 4;
		} else if (c == 'L') {
			k = (k - 1 + 4) % 4;
		}
		return k;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] grid = { "S" };
		System.out.println(Arrays.toString(sol.solution(grid)));
	}
}
// 500 by 500 총 발사 지점 2000개
// 규칙에 맞게 발사 카운트 셈
// 출발 좌표와 -> 도착 좌표를 visit으로 체크
// 이미 visit인 경우를 만나면 거기서 종료
// 문제는 visit체크가 까다로운 것과 중복인 경로는 제외해야하는것

// start와 없는 값이면 스타트 지역으로

// 0 1 2
// 1
// 2
// 00 -> 00
// 01 -> 00
// 00 -> 00
// 10 -> 00