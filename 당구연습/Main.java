package 당구연습;

import java.util.*;

class Solution {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];
		for (int i = 0 ; i < balls.length ; i++) {
			int xDis = getXDistance(startX, startY, balls[i][0], balls[i][1], n);
			int yDis = getYDistance(startX, startY, balls[i][0], balls[i][1], m);
			int cornerDis = getCornerDistance(startX, startY, balls[i][0], balls[i][1], m, n);
			int dis = xDis > yDis ? yDis : xDis;
			answer[i] = dis > cornerDis ? cornerDis : dis;
		}
		return answer;
	}

	public int getXDistance(int startX, int startY, int ballX, int ballY, int hei) {
		if (startX == ballX) {
			if (startY < ballY) {
				return (int)(Math.pow(startY + ballY, 2));
			} else {
				return (int)(Math.pow(hei * 2 - startY - ballY , 2));
			}
		}
		int xLine = Math.abs(startX - ballX);
		int upLine = startY + ballY;
		int downLine = hei * 2 - startY - ballY;
		int yLine = upLine > downLine ? downLine : upLine;
		return (int)(Math.pow(xLine, 2) + Math.pow(yLine, 2));
	}

	public int getYDistance(int startX, int startY, int ballX, int ballY, int wid) {
		if (startY == ballY) {
			if (startX < ballX) {
				return (int)(Math.pow(startX + ballX, 2));
			} else
				return (int)(Math.pow(wid * 2 - startX - ballX, 2));
		}
		int yLine = Math.abs(startY - ballY);
		int leftLine = startX + ballX;
		int rightLine = wid * 2 - startX - ballX;
		int xLine = leftLine > rightLine ? rightLine : leftLine;
		return (int)(Math.pow(xLine, 2) + Math.pow(yLine, 2));
	}

	public int getCornerDistance(int startX, int startY, int ballX, int ballY, int wid, int hei) {
		if (startX * ballY != startY * ballX)
			return Integer.MAX_VALUE;
		int xLine;
		int yLine;
		if (startX < ballX) {
			xLine = startX + ballX;
			if (startY < ballY) {
				yLine = startY + ballY;
			} else {
				yLine = hei * 2 - startY - ballY;
			}
		} else {
			xLine = wid * 2 - startX - ballX;
			if (startY < ballY) {
				yLine = startY + ballY;
			} else {
				yLine = hei * 2 - startY - ballY;
			}
		}
		return (int)(Math.pow(xLine, 2) + Math.pow(yLine, 2));
	}
}

public class Main {
	public static void main(String args[]) {
		Solution sol = new Solution();
		int[][] balls = { { 5, 8 } };
		System.out.println(Arrays.toString(sol.solution(10, 10, 5, 9, balls)));
	}
}

// x축 중간 2군데
// y축 중간 2군데
// 대각선 가능할 때 4군데
// 밑변^2 + 높이^2 = 대각^2

// x, y축은 동일하지 않다면 가능한것으로 간주
// 대각선은 a.세로 * b.가로 == a.가로 * b.세로 조건을 만족하고 머쓱이의 공이 앞서 있으면 가능한것으로 간주

// 모서리 조건
// a.x * b.y == a.y * b.x 조건을 성립한다.
// 왼쪽 상단 모서리 : x, y 둘다 작다.
// 왼쪽 하단 모서리 : x는 작고 y는 크다.
// 오른쪽 상단 모서리 : x는 크고 y는 작다
// 오른쪽 하단 모서리 : x, y 둘다 크다.