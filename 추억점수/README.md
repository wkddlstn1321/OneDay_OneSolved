### 추억점수
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/176963)

# 해결과정
문자열 배열을 다루는 문제이다.
name은 중복이 없다는게 보장이 되기에 hashmap 으로 처리가 가능, 따라서 name원소의 길이는 신경쓰지 않아도 된다.
name과 yearning의 길이는 똑같다
name에 최대 길이는 100 yearning의 최대 value도 100으로 총점은 int 범위안에서 처리 가능
name과 yearning의 길이는 똑같다. 그런데 문제설명에 점수가 없을 경우에 대한 내용이 있다.
안전하게 Hashmap 삽입은 yearning 길이를 기준으로 하고 containsKey함수를 통해서 키가 있을때만 총점을 더했다.
이제 photo를 한번만 순회하면 점수 배열을 완성할 수 있다.

```
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		HashMap<String, Integer> score = new HashMap<String, Integer>();
		int[] answer = new int[photo.length];
		for (int i = 0 ; i < yearning.length ; i++) {
			score.put(name[i], yearning[i]);
		}
		for (int i = 0 ; i < photo.length ; i++) {
			int sum = 0;
			for (int j = 0 ; j < photo[i].length ; j++) {
				if (score.containsKey(photo[i][j])) {
					sum += score.get(photo[i][j]);
				}
			}
			answer[i] = sum;
		}
		return answer;
	}
```

중복없는 문자열은 HashMap이 최고다