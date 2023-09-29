### 가장 큰 수
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/42746)

# 해결과정

주어진 정수들을 이어붙여 만들 수 있는 가장 큰 수를 문자열로 반환해야 한다.
주어진 정수들을 앞자리를 기준으로 정렬한 뒤 문자열로 바꾸면서 이어붙히면 가장 큰 수를 구할 수 있다.
정수상태는 자리수 별로 비교를 해야한다.
만약 1111 1111 같이 모든자리가 같은 경우는 4번이나 비교해야 돼서 비효율적이다
문자열은 사전순으로 비교할 수 있어서 한번에 비교할 수 있다.

단순히 사전순 정렬로는 안되는 케이스가 있었다.
30 3 같은경우 303 330 후자가 높은수기 때문에 정렬기준을 두 문자열을 합한것으로 했다
Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

그럼에도 안되어서 한참 찾았는데
0,0,0,0,0...0 과 같이 0만 존재하는 배열이 인자로 들어오면 0000000이 아니라 0 하나만 반환되어야한다.
반환직전에 문자열에 첫번째 인덱스가 0이면 전체 문자열을 "0" 으로 바꾸는걸로 해결

```
public static String solution(int[] numbers) {
		String answer = "";
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0 ; i < numbers.length ; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
		for (int i = 0 ; i < numbers.length ; i++) {
			answer += list.get(i);
		}
		if (answer.charAt(0) == '0') {
			answer = "0";
		}
		return answer;
	}
```