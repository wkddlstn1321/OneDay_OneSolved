package 양과늑대;

class Solution {
	boolean[] visit;
	int maxSheepCnt = 0;
	int[] globalInfo;
	int[][] globalEdges;

	public int solution(int[] info, int[][] edges) {
		visit = new boolean[info.length];
		globalInfo = info;
		globalEdges = edges;
		visit[0] = true;
		dfs(1, 0);
		return maxSheepCnt;
	}

	public void dfs(int sheepCnt, int wolfCnt) {
		if (sheepCnt <= wolfCnt) {
			return;
		}
		if (maxSheepCnt < sheepCnt) {
			maxSheepCnt = sheepCnt;
		}
		for (int i = 0 ; i < globalEdges.length ; i++) {
			if (visit[globalEdges[i][0]] == true && visit[globalEdges[i][1]] == false) {
				visit[globalEdges[i][1]] = true;
				if (globalInfo[globalEdges[i][1]] == 0)
					dfs(sheepCnt + 1, wolfCnt);
				else
					dfs(sheepCnt, wolfCnt + 1);
				visit[globalEdges[i][1]] = false;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
				{ 4, 6 }, { 8, 9 } };
		System.out.println(sol.solution(info, edges));
	}
}
