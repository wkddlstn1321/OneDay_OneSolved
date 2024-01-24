### 쿠키 구입
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/49995)

# 해결과정
투포인터를 이용한 누적합을 이용하는 문제인거 같지만, 가능한 최대값에서 하나씩 빼면서 확인해도 조건만 잘짜면 시간초과는 안나올거같아서 2번째 방법으로 진행했다.

흐름

1. 쿠키의 총합 / 2 로 Max값을 찾는다.
2. Max값이 가능한 경우인지 확인한다.
3. 가능하면 해당 값 리턴, 불가능하면 Max 값에서 1을 빼고 반복

위의 방법대로 진행하면 값이 큰경우는 빠르게 찾을 수 있지만 정확히 나눌 수 있는 케이스가 없는 최악의 경우 모든 값을 확인해야해서 비효율적이다.

루프를 도는중에 적절한 탈출문을 넣어줘서 모든 경우를 끝까지 확인하지 않도록 해줬다.

그럼에도 투포인터로 접근하는 방법이 더 빠른 방식임을 부정할 수 는 없다.

그래도 답이 정해져있는건 아니기때문에 감행 !
```java
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
```