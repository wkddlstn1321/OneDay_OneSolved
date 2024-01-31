package 유사칸토어비트열;

class Solution {
	// l r 은 5의 20승 O(N)만 해도 시간초과
	// 일정한 패턴이 생기니까 수학적인 방법으로 알아낼 수 있을지도...;
	// n은 사실 상관이 없다 뭐가 나오던 l ~ r 안에 수가 달라지지 않는다.
	// 1
	// 1 1 0 1 1
	// 11011 11011 00000 11011 11011
	// 1101111011000001101111011 1101111011000001101111011 0000000000000000000000000 1101111011000001101111011 1101111011000001101111011
	// 11011 11011
	public int solution(int n, long l, long r) {
		int answer = 0;
		long size = (long) Math.pow(5, n);
		long partition = size / 5;
		for (long i = l; i <= r; i++) {
			answer += dfs(partition, i);
		}
		return answer;
	}

	public int dfs(long partition, long num) {
		if (partition * 2 < num && num <= partition * 3)
			return 0;
		if (partition == 1) {
			return 1;
		}
		return dfs(partition / 5, num % partition);
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(2, 4, 17));
	}
}