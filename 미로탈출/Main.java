package 미로탈출;

import java.util.*;

class Pair {
	int x, y, z, cnt;
	Pair(int x, int y, int z, int cnt) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.cnt = cnt;
	}
}

class Solution {
	Queue<Pair> q = new LinkedList<>();
	int[] dirX = {-1, 1, 0, 0};
	int[] dirY = {0, 0, -1, 1};
	int[][][] visit;
	public int solution(String[] maps) {
		int answer = -1;
		visit = new int[maps.length][maps[0].length()][2];
		for (int i = 0 ; i < maps.length ; i++) {
			for (int j = 0 ; j < maps[i].length() ; j++) {
				if (maps[i].charAt(j) == 'S') {
					q.add(new Pair(i, j, 0, 0));
					break;
				}
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0 ; i < 4 ; i++) {
				int x = p.x + dirX[i];
				int y = p.y + dirY[i];
				int z = p.z;
				int cnt = p.cnt + 1;
				if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length() || maps[x].charAt(y) == 'X')
					continue;
				if (maps[x].charAt(y) == 'L') {
					z = 1;
				}
				if (visit[x][y][z] != 0)
					continue;
				if (maps[x].charAt(y) == 'E' && z == 1) {
					return cnt;
				}
				visit[x][y][z] = 1;
				q.add(new Pair(x, y, z, cnt));
			}
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] maps = {"SOOOO", "OOOLE" }; //, "OOOOO", "OOOOO", "OOOLE"};
		System.out.println(sol.solution(maps));
	}
}
