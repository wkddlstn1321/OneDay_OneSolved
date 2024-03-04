package 뒤에있는큰수찾기;

import java.util.*;

class Solution {
	public int[] solution(int[] numbers) {
		// 1. 스택을 이용한 풀이
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				// 2. 현재 스택의 값보다 큰 값이 나오면 스택의 값을 pop 하고 해당 인덱스에 현재 값을 넣는다.
				answer[stack.pop()] = numbers[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		return answer;
	}
}

// 1 2 4 0 3
// 4 3 2 1 0
// 0 1 2 3 4

// 2 3 5 1 4
// 5 4 3 2 1
// 1 2 3 4 5
public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] numbers = { 4, 1, 2, 5 };
		System.out.println(Arrays.toString(sol.solution(numbers)));
	}
}
