package 마법의엘리베이터;
// 11
// 6789  17 10
// 1 2 3 4 5    6 7 8 9

class Solution {
	public int solution(int storey) {
		int answer = 0;
		while (storey > 0) {
			int n = storey % 10;
			if (n > 5) {
				storey += 10 - n;
				answer += 10 - n;
			}
			else if (n == 5 && (storey / 10) % 10 >= 5) {
				storey += 10 - n;
				answer += 10 - n;
			}
			else {
				answer += n;
			}
			storey /= 10;
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int storey = 16;
		System.out.println(sol.solution(storey));
	}
}
