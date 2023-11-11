### 의상

# 해결과정

의상을 조합할 수 있는 경우의 수를 구하는 문제

경우의 수를 구하는 문제이기 때문에 의상의 이름은 중요하지 않고 부위별 개수만 파악하면 된다.

의상의 이름이 중복되지 않기 때문에 HashMap을 사용하면 각 부위별 의상의 개수를 쉽게 파악할 수 있다.

부위별 개수를 구했으면 각각 + 1 (안입은 경우 포함하기 위해)을 한뒤 전부 곱한다.
최소 하나의 옷은 입어야하기 때문에 모든 부위를 입지 않은 경우는 포함하지 않아야 한다 곱한 결과에서 1을 빼주자.

```
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0 ; i < clothes.length ; i++) {
			if (map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			else
				map.put(clothes[i][1], 1);
		}
		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
        return answer - 1;
```

