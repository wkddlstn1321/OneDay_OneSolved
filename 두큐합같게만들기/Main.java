package 두큐합같게만들기;

import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long totalSum = 0;
		long sum1 = 0;
		long sum2 = 0;
		int maxSize = queue1.length * 4;
		Queue<Integer> leftQ = new LinkedList<>();
		Queue<Integer> rightQ = new LinkedList<>();
		for (int i = 0 ; i < queue1.length ; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];
			leftQ.offer(queue1[i]);
			rightQ.offer(queue2[i]);
		}
		totalSum = sum1 + sum2;
		if (totalSum % 2 != 0)
			return -1;
		while (sum1 != sum2) {
			if (leftQ.isEmpty() || rightQ.isEmpty())
				return -1;
			if (sum1 > sum2) {
				int value = leftQ.poll();
				sum1 -= value;
				sum2 += value;
				rightQ.offer(value);
			} else {
				int value = rightQ.poll();
				sum1 += value;
				sum2 -= value;
				leftQ.offer(value);
			}
			answer++;
			if (answer >= maxSize)
				return -1;
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 2, 2 }, new int[] { 8, 2 });
		System.out.println(answer);
	}
}

// 각 큐의 전체 합 구하기
// 2로 나누어떨어지지 않으면 -1 리턴
// 큰 쪽에서 작은 쪽으로 이동
// 3 3 1
// 2 4 3

// 12
// 2 4 3
// 3 3 1
// 한바퀴를 돌았는데 답이 안나오면 -1 리턴 (무한반복)
