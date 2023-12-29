### K진수에서 소수 개수 구하기
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/92335)

# 해결과정

짬뽕같은 문제였다. 

진법도 다루고 파싱도 하고 소수 판별도 하고, 하나하나 귀찮긴하지만 어려운 문제는 아니였다.

1. 문자열로 진법 변환 (진법)
```
	//진법 변환
	public String convertK(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.insert(0, n % k);
			n /= k;
		}
		return sb.toString();
	}
```

2. 문자열을 0을 기준으로 스플릿 후 결과를 다시 정수로 변환  (파싱)
```
	//진법 변환된 문자열 정수로 파싱
	public ArrayList<Long> getNumbers(String kN) {
		String[] numberSplit = kN.split("0");
		int size = numberSplit.length;
		ArrayList<Long> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (numberSplit[i].equals(""))
			continue;
			numbers.add(Long.parseLong(numberSplit[i]));
		}
		return numbers;
	}
```

3. 변환된 정수 배열을 순회하며 소수인지 판별 (소수 판별)
```
	//소수 판별
	public boolean isPrime(Long nb) {
		long i = 2;
		if (nb == 1)
			return false;
		while (i * i <= nb) {
			if (nb % i == 0)
				return false;
			i++;
		}
		return true;
	}
```

사실 소수 찾는 방법으로 에라토스테네스의 체 를 써보고 싶었는데,

나올 수 있는 가장 큰 소수 값이 몇인지 예측이 안되서 그냥 하나씩 판별해 줬다.

아쉬운 부분이다.