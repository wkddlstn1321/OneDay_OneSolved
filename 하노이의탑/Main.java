package 하노이의탑;

import java.util.*;


public class Main {
	public static ArrayList<Integer[]> ans = new ArrayList<>();
	public static void main(String args[]) {
		int [][]answer = solution(2);
		for (int i = 0 ; i  < answer.length ; i++) {
			System.out.println(answer[i][0] + " " + answer[i][1]);
		}
	}
	
	public static void dfs(int n, int start, int mid, int dest) {
		if (n == 1) {
			Integer []arr = {start, dest};
			ans.add(arr);
		} else {
			dfs(n - 1, start, dest, mid);
			Integer []arr = {start, dest};
			ans.add(arr);
			dfs(n - 1, mid, start, dest);
		}
	}

	public static int[][] solution(int n) {
		int[][] answer = {};
		dfs(n, 1, 2, 3);
		answer = new int[ans.size()][2];
		for (int i = 0 ; i < ans.size() ; i++) {
			answer[i][0] = ans.get(i)[0];
			answer[i][1] = ans.get(i)[1];
		}
		return answer;
	}
}
