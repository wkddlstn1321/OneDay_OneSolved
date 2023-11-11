### 달리기경주
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/178871)

java와 친해질 겸 오랜만에 알고리즘 감도 찾을겸 풀어본 프로그래머스 1단계 문제

# 해결과정
선수 배열 길이 players 50,000
선수 이름 길이 players[i] 10
순위 변경 횟수 callings 1,000,000

이거 그냥 문자열 배열로 쉽게 접근하면 최악의 경우 500000000000번 비교를 해야한다.
가장 먼저 떠오르는 방법은 해쉬맵 
이름이 중복되는 경우가 없어서 적용하기 쉽고
1등이 호출되는 경우도 없어서 예외처리 할 것도 딱히 없어 보인다.

HashMap을 <이름, 등수> 구조로 만들고 선수가 불릴때마다
선수 배열을 -1 인덱스와 스왑하고
HashMap을 갱신해주면 해결되는 쉬운 문제였다.
```
	public static String[] solution(String[] players, String[] callings) {
		HashMap<String, Integer>rank = new HashMap<String, Integer>();
		for (int i = 0 ; i < players.length ; i++) {
			rank.put(players[i], i);
		}
		for (int i = 0 ; i < callings.length ; i++) {
			int ranking = rank.get(callings[i]);
			String temp = players[ranking];
			players[ranking] = players[ranking - 1];
			players[ranking - 1] = temp;
			rank.put(players[ranking], ranking);
			rank.put(players[ranking - 1], ranking - 1);
		}
		return players;
	}
```
