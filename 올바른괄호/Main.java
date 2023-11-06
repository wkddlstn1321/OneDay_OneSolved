package 올바른괄호;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		System.out.println(solution("()()"));
	}

	public static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0 ; i < s.length() ; i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if (!stack.isEmpty())
			answer = false;
		return answer;
	}
}
