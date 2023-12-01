### 단어변환
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/43163)

java와 친해질 겸 오랜만에 알고리즘 감도 찾을겸 풀어본 프로그래머스 1단계 문제

# 해결과정
begin을 이용해서 최적의 경로로 한단어씩 바꿔가며 target을 찾아야 한다.

한 글자만 바꿀 수 있다는 조건과 최소변환 횟수 때문에 어렵게 느껴질 수 있지만 잠시 생각해보니  

최단경로 미로 탐색 문제와 다를게 없었다.

Queue 를 잘 사용하면 최종 목표까지 도착하는 순간 최소변환 횟수는 자동으로 구해지기 때문에 변환 순서는 중요하지 않다.

단어 하나를 queue에서 제거할 때 변환가능한 모든 단어와 현재 변환횟수 + 1 을 Pair로 queue에 삽입

target을 찾으면 그 때에 변환횟수가 최소 변환횟수이다.

String을 비교하는 터라 시간이 많이걸릴까 우려됐지만
단어길이 10 글자 이하 단어 배열 50 이하 = 50 * 50 * 10 으로 최악의 경우에도 무난하게 통과할 수 있을거 같았다.

```
class Pair {
	String str;
	int cnt;
}
...

	Queue<Pair> q = new LinkedList<>();
	q.add(new Pair(begin, 0));
	while (!q.isEmpty()) {
		Pair cur = q.poll();
		if (cur.str.equals(target))
			return cur.cnt;
		for (int i = 0 ; i < words.length ; i++) {
			if (visit[i])
				continue;
			if (isOneDiff(cur.str, words[i])) {
				visit[i] = true;
				q.add(new Pair(words[i], cur.cnt + 1));
			}
		}
	}
```
