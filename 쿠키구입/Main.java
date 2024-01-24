package 쿠키구입;

class Solution {
	int maxSum;

	public int solution(int[] cookie) {
		int answer = 0;
		maxSum = 0;
		for (int i : cookie) {
			maxSum += i;
		}
		int maxValue = maxSum / 2;
		while (maxValue > 0) {
			if (isAvailableValue(cookie, maxValue)) {
				answer = maxValue;
				break;
			}
			maxValue--;
		}
		return answer;
	}

	public boolean isAvailableValue(int[] cookie, int maxValue) {
		int sum = 0;
		int startIdx = 0;
		int currIdx = 0;
		int passValue = 0;
		int cookieLength = cookie.length;
		while (true) {
			// 합이 남아있는 값을 넘긴 경우
			if (maxSum - (sum + passValue) < maxValue) {
				return false;
			}
			// 합이 타겟과 같아지면
			if (sum == maxValue) {
				int sum2 = 0;
				// 둘째도 가능한지 확인
				for (int i = currIdx; i < cookieLength; i++) {
					sum2 += cookie[i];
					if (sum2 >= sum)
						break;
				}
				if (sum == sum2)
					return true;
			}
			// 합이 target보다 커진 경우
			if (sum > maxValue) {
				sum -= cookie[startIdx];
				passValue += cookie[startIdx];
				startIdx++;
			} else {
				sum += cookie[currIdx];
				currIdx++;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] cookie = { 1, 1, 2, 3 };
		System.out.println(sol.solution(cookie));
	}
}
