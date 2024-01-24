package 쿠키구입;

// 총합을 반절로 나눈다.

// 인덱스 조절로 찾는다.

// 0부터 갈지
// max값 부터 갈지를 정해야한다.

// 0  ~  max
// 맨 앞, 맨 뒤
// 중간값이 될때까지 더하기

// MAX 값으로 부터 하나씩 줄이는 방법은 10초이상걸린다.

// 1. maxValue를 넘긴다.
// 2. maxValue가 가능한지 확인하다.
// 3. maxValue가 가능하면 거기서 끝 아니면 0이 될때까지 하나씩 뺀다.

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
		//100 100 100 100 100 100
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
				// } else {
				// 	return false;
				// }
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
