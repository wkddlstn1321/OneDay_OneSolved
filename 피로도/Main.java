package 피로도;

import java.util.*;

public class Main {
	int cnt = 0;
	public static void main(String args[]) {
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
		System.out.println(solution(80, dungeons));
	}

	public static void jeagui(ArrayList<Integer> input, int index, ArrayList<ArrayList<Integer>> list) {
		if (index == input.size()) {
			list.add(new ArrayList<>(input));
			return ;
		}
		for (int i = index ; i < input.size() ; i++) {
			Collections.swap(input, index, i);
			jeagui(input, index + 1, list);
			Collections.swap(input, index, i);
		}
	}

	public static ArrayList<ArrayList<Integer>> dfs(int n) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0 ; i < n ; i++) {
			input.add(i);
		}
		jeagui(input, 0, list);
		return list;
	}

	public static int solution(int k, int[][] dungeons) {
		int answer = -1;
		ArrayList<ArrayList<Integer>> list = dfs(dungeons.length);
		for (int i = 0 ; i < list.size() ; i++) {
			int temp = k;
			int cnt = 0;
			for (int j = 0 ; j < list.get(i).size() ; j++) {
				if (temp < dungeons[list.get(i).get(j)][0]) {
					break ;
				}
				temp -= dungeons[list.get(i).get(j)][1];
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
}
