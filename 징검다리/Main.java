package 징검다리;

import java.util.*;

class Solution {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		ArrayList<Integer> sortRocks = new ArrayList<>();
		sortRocks.add(distance);
		for (int i : rocks) {
			sortRocks.add(binarySearchMinIndex(sortRocks, i), i);
		}
		int rockLeng = sortRocks.size();
		int left = 0;
		int right = distance;
		while (left <= right) {
			int mid = (left + right) / 2;
			int start = 0;
			int cnt = 0;
			for (int i = 0 ; i < rockLeng ; i++) {
				if (sortRocks.get(i) - start < mid) {
					cnt++;
				} else {
					start = sortRocks.get(i);
				}
			}
			if (cnt > n) {
				right = mid - 1;
			} else {
				answer = mid;
				left = mid + 1;
			}
		}
		return answer;
	}


	//바위를 정렬할 때 사용하는 이진탐색 Arrays.sort를 사용해도 무방하다.
	public int binarySearchMinIndex(ArrayList<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target <= list.get(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] rocks = { 2, 14, 11, 21, 17};
		System.out.println(sol.solution(25, rocks, 2));
	}
}
