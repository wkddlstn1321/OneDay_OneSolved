package 징검다리;

import java.util.*;

class Solution {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		ArrayList<Integer> sortRocks = new ArrayList<>();
		ArrayList<Integer> disList = new ArrayList<>();
		sortRocks.add(0);
		sortRocks.add(distance);
		for (int i : rocks) {
			sortRocks.add(binarySearchMinIndex(sortRocks, i), i);
		}
		for (int i = 1; i < sortRocks.size(); i++) {
			disList.add(sortRocks.get(i) - sortRocks.get(i - 1));
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			int minIdx = findMinIndex(disList);
			System.out.println("currValue: " + disList.get(minIdx));
			int size = disList.size();
			if (minIdx == 0) {
				disList.set(1, disList.get(1) + disList.get(0));
				disList.remove(minIdx);
			} else if (minIdx == size - 1) {
				disList.set(minIdx - 1, disList.get(minIdx - 1) + disList.get(minIdx));
				disList.remove(minIdx);
			} else { // (disList.get(minIdx) == disList.get(minIdx + 1)) {
				disList.set(minIdx, disList.get(minIdx) + disList.get(minIdx + 1));
				disList.remove(minIdx + 1);
			} 
			// else {
			// 	disList.set(minIdx - 1, disList.get(minIdx - 1) + disList.get(minIdx));
			// 	disList.remove(minIdx);
			// }
		}
		for (int i : disList) {
			System.out.println(i);
		}
		System.out.println();
		answer = disList.get(findMinIndex(disList));
		return answer;
	}

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

	public static int findMinIndex(ArrayList<Integer> list) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.addAll(list);
		int minIdx = list.indexOf(pq.poll());
		return minIdx;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] rocks = { 2, 14, 11, 21, 17};
		System.out.println(sol.solution(25, rocks, 2));
	}
}
