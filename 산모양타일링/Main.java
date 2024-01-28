package 산모양타일링;

class Solution {
	public int solution(int n, int[] tops) {
		int tileCnt = 2 * n + 1;
		int[] dp = new int[tileCnt + 1];
		int answer = 0;
		// n 까지를 저장하는 dp를 만들고
		// 삼각형이 튀어나온곳을 배제하고 dp를 구한다.

		dp[1] = 1;
		if (tops[0] == 0) {
			dp[2] = 2;
		}
		else {
			dp[2] = 3;
		}
		for (int i = 3; i < tileCnt + 1; i++) {
			int isTop = 1;
			if (i % 2 == 0 && tops[(i / 2) - 1] == 1) {
				isTop = 2;
			}
			dp[i] = ((dp[i - 1] * isTop) + dp[i - 2]) % 10007;
		}
		answer = dp[tileCnt];
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 4;
		int[] tops = { 1, 1, 0, 1 };
		System.out.println(sol.solution(n, tops));
	}

}
