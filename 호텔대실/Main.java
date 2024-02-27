package 호텔대실;

import java.util.*;

class Solution {
	public int solution(String[][] book_time) {
		int answer = 1;
		ArrayList<Integer[]> list = new ArrayList<>();
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1] - o2[1];
			}
		});
		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < book_time.length; i++) {
			String[] time = book_time[i];
			int startTime = Integer.parseInt(time[0].split(":")[0]) * 60 + Integer.parseInt(time[0].split(":")[1]);
			int endTime = Integer.parseInt(time[1].split(":")[0]) * 60 + Integer.parseInt(time[1].split(":")[1]);
			list.add(new Integer[] { startTime, endTime + 10 });
		}
		// 끝을 기준으로 정렬
		Collections.sort(list, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < list.size(); i++) {
			if (pq.isEmpty()) {
				pq.add(list.get(i));
				continue;
			}
			Integer[] cur = pq.peek();
			int curStart = cur[0];
			int curEnd = cur[1];
			if (curEnd <= list.get(i)[0]) {
				pq.poll();
			}
			pq.add(list.get(i));
			answer = Math.max(answer, pq.size());
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String book_time = "10:00 10:10";
		System.out.println(sol.solution(new String[][] { { "10:00", "10:10" } }));
	}

	public static void print(int a, int b) {
		if (a == b) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
}
