package 아방가르드타일링;

class Solution {
	public int solution(int n) {
		int answer = 0;
		int []dp = new int[100001];
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 10;
		dp[4] = 21;
		dp[5] = 42;
		for (int i = 4 ; i <= n ; i++) {
			// dp[i] = ???
		}
		answer = dp[n];
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(2));
		System.out.println(sol.solution(3));
	}
}

// DP인건 확실하다
// dp[1] = 1;
// dp[2] = 2;