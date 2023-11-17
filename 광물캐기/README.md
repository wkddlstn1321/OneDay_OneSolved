### 광물 캐기

[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=java)

# 해결과정

곡괭이 개수가 최대 15개고 배열의 길이도 50이라 완전탐색을 돌릴려다가 모든 경우의 수를 생각하려니 비효율적이고 시간초과가 날 수도 있을거 같아서 그리디로 접근했다.

다이아 철 돌 순으로 피로도가 높은곳 먼저 캐면 된다.
피로도가 높은 곳은 어떻게 알 수 있을까?

광물은 5개 단위로 묶어서 팔 수 있게되어 있긴 때문에 대략적으로 피로도 순위를 정할 수 있다.

```
		ArrayList<Integer> weightList = new ArrayList<>();
        maxPicks = maxPicks > minerals.length ? minerals.length : maxPicks;
        int sum = 0;
        int cnt = 0;
        for (int i = 0 ; i < maxPicks ; i++) {
            if (minerals[i].equals("diamond"))
                sum += 25;
            else if (minerals[i].equals("iron"))
                sum += 5;
            else
                sum += 1;
            cnt++;
            if (cnt == 5) {
                weightList.add(sum);
                sum = 0;
                cnt = 0;
            }
        }
		if (sum != 0)
            weightList.add(sum);
```

5개씩 묶어서 다이아일때는 25, 철일때는 5, 돌일때는 1 씩 더해 리스트에 추가하는식으로 가중치리스트를 구했다.
가중치 더하는 기준은 대략적으로 정한건데 처음에는 다이아 5, 철 1, 돌 0 을 더했더니 통과하지 못했다.
그래서 명확하게 25, 5, 1 로 5배 차이씩으로 정해줬다.

이제 다이아, 철, 돌 곡괭이 순으로 해당 리스트를 참고하여 가중치가 가장 높은곳부터 캐면 된다.

```
	int[][] pickWeight = { {1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
	int listSize = weightList.size();
	for (int i = 0 ; i < listSize ; i++) {
			int idx = getMaxWeightIndex(weightList);
			weightList.set(idx, -1);
			int j = 0;
			for (j = 0 ; j < 3 ; j++) {
				if (picks[j] != 0) {
					picks[j] -= 1;
					break ;
				}
			}
			int mineralIdx = idx * 5;
			for (int k = mineralIdx ; k < mineralIdx + 5 ; k++) {
				if (minerals[k].equals("diamond")) {
					sum += pickWeight[j][0];
				}
				else if (minerals[k].equals("iron")) {
					sum += pickWeight[j][1];
				}
				else {
					sum += pickWeight[j][2];
				}
				if (k + 1 >= minerals.length)
					break;
		}
	}
```
가중치 리스트에서 max값이 담겨있는 인덱스를 구해온 뒤 다이아 곡괭이 부터 없으면 철 없으면 돌 순으로 접근하면서 캐줬다.
5개씩 접근하기 떄문에 마지막 리스트가 5로 나누어 떨어지지 않으면 index를 초과하게 된다. 광물개수보다 인덱스가 커지면 break;

설계와 구현 둘 다 어렵지 않은 문제였다.

근데 구현이 머리로는 쉬운데 몸으로는 좀 어려웠다.
코딩테스트를 대비하여 IDE없이 프로그래머스 화면으로만 문제를 풀어봤기 때문에.
함수를 따로 분할하기도 힘들어서 코드도 지저분해지고 평소 자연스럽게 사용하던 자동완성 기능이 없으니 응애가 된 기분 너무 힘들었다.
IDE 쓰게 해주면 안되나 vsCode 사랑해
