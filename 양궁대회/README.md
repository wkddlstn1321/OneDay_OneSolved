### 양궁 대회
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/92342)

# 해결과정

과녁이 10 ~ 0 점 사이값으로 고정이 되어 있기 때문에 n의 길이와 상관없이 동일한 시간복잡도를 갖게 된다.

처음에는 10점 부터 순회하며 어피치 보다 하나 더 맞추거나 하나도 안 맞추고 넘어가거나 이지선다로 풀려고 했으나

그렇게는 잡을 수 없는 경우가 있기 때문에 dfs로 모든 경우를 완전 탐색했다.

1. 어피치보다 한발 더 맞출 수 있다면 맞춘다.
2. 안 맞추고 넘어간다.

```
// dfs 함수 일부 내용
	...
		for (int i = 0; i < 2; i++) {
			int curPoint = 10 - idx;
			if (i == 0 && n > info[idx]) {
				Lscore += curPoint;
				n -= info[idx] + 1;
				newScoreBoard[idx] = info[idx] + 1;
				dfs(idx + 1, info, n);
				n += info[idx] + 1;
				Lscore -= curPoint;
			} else {
				if (info[idx] != 0)
					AScore += curPoint;
				newScoreBoard[idx] = 0;
				dfs(idx + 1, info, n);
				if (info[idx] != 0)
					AScore -= curPoint;
			}
		}
	...

```
위 두가지 경우를 모든 인덱스에서 확인했고 마지막 인덱스에 도달했을 때 점수가 더 높으면 갱신

구현 자체는 어렵지 않았지만 두 가지 고려사항을 놓쳐서 오래걸렸다.

- 점수 비교
    
    라이언이 얻을 수 있는 최고 점수를 구하는 문제가 아니다.
    
    라이언과 어피치의 최고 점수차를 구하는 문제!
    
    최고 점수를 기준으로 answer을 갱신해서 맞왜틀!!! 을 시전해버렸다. 
    
- 동일 점수일때 갱신
    
    최고 점수차가 동일하다면 가장 낮은 점수를 더 많이 맞춘 케이스를 업데이트 해야하는데
    
    해당 점수 비교하는 부분을 실수했다.  이건 비교적 빠르게 해결한 문제