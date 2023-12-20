package 표현가능한이진트리;

import java.util.*;

//111
//11
class Solution {
	boolean falseCheck;
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];
		int[] isAvailLeng = new int[64];
		isAvailLeng[1] = 1;
		isAvailLeng[3] = 1;
		isAvailLeng[7] = 1;
		isAvailLeng[15] = 1;
		isAvailLeng[31] = 1;
		isAvailLeng[63] = 1;
		for (int i = 0; i < numbers.length; i++) {
			ArrayList<Integer> bList = new ArrayList<>();
			long target = numbers[i];
			while (target > 0) {
				bList.add((int)target % 2);
				target /= 2;
			}
			int size = bList.size();
			while (isAvailLeng[size] != 1) {
				bList.add(0);
				size++;
			}
			Collections.reverse(bList);
			falseCheck = false;
			dfs(0, size - 1, bList.get(size / 2), bList);
			if (falseCheck)
				answer[i] = 0;
			else
				answer[i] = 1;
		}
		return answer;
	}

	public void dfs(int start, int end, int par, ArrayList<Integer> bList) {
		int mid = (start + end) / 2;
		int curPar = bList.get(mid);
		if (par == 0 && curPar == 1) {
			falseCheck = true;
			return;
		}
		if (start != end) {
			dfs(start, mid - 1, curPar, bList);
			dfs(mid + 1, end, curPar, bList);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new long[] { 0, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512 })));
	}
}

// 부모가 0인데 자식이 1인 경우만 찾으면 됨

// 0001110
// 0001111
// 0010000
// 0000000100000001000000010000000
// 0000000100000001000000010000000 1 0000000100000001000000010000000
// 000000010000001
// 100000010000000