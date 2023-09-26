package 게임맵최단거리;

import java.util.*;
import java.awt.*;

public class Main {
	public static void main(String args[]) {
		int [][]maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	public static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int visit[][] = new int[n][m];
		int dirX[] = {1, -1, 0, 0};
		int dirY[] = {0, 0, 1, -1};
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0,0));
		visit[0][0] = 1;
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
}
