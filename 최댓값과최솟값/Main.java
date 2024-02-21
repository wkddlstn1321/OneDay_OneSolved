package 최댓값과최솟값;

class Solution {
	public String solution(String s) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		String[] arr = s.split(" ");
		for (int i = 0 ; i < arr.length ; i++) {
			int num = Integer.parseInt(arr[i]);
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		String answer = min + " " + max;
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "1 2 3 4";
		System.out.println(sol.solution(s));
	}
}