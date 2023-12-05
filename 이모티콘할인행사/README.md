### 전력망을 둘로 나누기

[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/150368)

# 해결과정

우선순위로 이모티콘 플러스 가입자가 가장 많은 경우를 찾아야 한다

4(할인률)^7(이모티콘 개수) * 100(유저수) * 7(상품 구입)= **1146600** 

대충 계산할 결과 인풋에 제한사항이 크지 않아서 완전탐색이 가능하다.

1. 각 이모티콘에 할인률을 적용할 수 있는 모든 경우의 수를 구한다.
2. 적용된 값을 바탕으로 계산하여 가입자 수가 가장 많은 경우를 찾는다.
3. 가입자 수가 같은 경우 더 판매 금액이 많은 것을 고른다.

완탐이 가능하다고 결론 내렸기에 문제를 해결하기 위한 알고리즘 설계는 빨리 끝났다.

근데 구현은 오래걸렸다.
```
	public int[] sales = {1,2,3,4};
	public int[] curSaleState;
	public void dfs(int[][] users, int[] emoticons, int idx) {
		if (idx == emoticons.length) {
			//서비스 가입자 판매액 계산 함수
			cal(users, emoticons);
			return ;
		}
		for (int sale : sales) {
			int temp = emoticons[idx];
			emoticons[idx] -= emoticons[idx] / 10 * sale;
			curSaleState[idx] = sale * 10;
			dfs(users, emoticons, idx + 1);
			emoticons[idx] = temp;
		}
	}
```
위 간단한 재귀를 구현하는게 무엇이 그렇게 어려웠는가?

이미티콘이 할인률이 적용된 값을 어디에 저장?

각 이미티콘 별 몇퍼 할인률이 적용됐는지는 어디에 저장?

구현에 들어갔는데 실시간으로 문제가 발생되면 도중에 그만 손을 떼고 정신을 잃고 마는것이다.

구현에 들어가기 전 더 세밀한 설계와 문제의 단순화를 할 필요가 있음을 느끼며 마무리