package 전력망을둘로나누기;

import java.util.*;
import java.awt.Point;

public class Main {
	public static void main(String[] args) {
		int n = 9;
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		System.out.println(solution(n, wires));
	}

	public static ArrayList<Integer[]> makeList(int[][]wires, int idx){
		ArrayList<Integer[]> list = new ArrayList<>();
		for (int i = 0 ; i < wires.length ; i++) {
			if (i == idx) continue;
			list.add(new Integer[] {wires[i][0], wires[i][1]});
		}
		return list;
	}

	public static int bfs(ArrayList<Integer[]> list, int[][] visit) {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
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

	public static int solution(int n, int[][] wires) {
		int answer = -1;
		answer = Integer.MAX_VALUE;
		// 한개씩 빠진 트리 리스트를 만듬
		ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
		for (int i = 0 ; i < wires.length ; i++) {
			list.add(makeList(wires, i));
		}
		// 각 트리에대해서 bfs를 돌린 결과가 cnt1
		// visit이 체크되어있짖 않은 나머지 트리에 대해서 dfs돌린 결과가 cn2
		// 두개의 차이가 answer보다 작으면 answer에 저장
		for (int i = 0 ; i < list.size() ; i++) {
			int cnt1 = 0;
			int cnt2 = 0;
			int [][]visit = new int[n + 1][n + 1];
			cnt1 = bfs(list.get(i), visit);
			cnt2 = bfs(list.get(i), visit);
			answer = Math.abs(cnt1 - cnt2) < answer ? Math.abs(cnt1 - cnt2) : answer;
		}
		return answer;
	}
}

// [0, 0][2, 3][3, 4][4, 5][4, 6][4, 7][7, 8][7, 9]