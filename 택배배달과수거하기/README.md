### 전력망을 둘로 나누기

[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/150369)

# 해결과정

그리디로 설계를 잘하면 쉽게 구현할 수 있다.

뒤에서부터 왕복을 하면서 박스를 나르면 최단 이동 회수가 나온다.

이때 포인트는 왕복 도중에 **배달과 픽업에 손실이 없게** 해야된다는 것

반복문 한번에 계산을 끝내기 위해서 배달과 픽업을 추가로 할 수 있는 값을 저장하는 변수 두개를 선언해서 관리했다	

`deliSave`  `pickSave`

위 두 변수는 왕복할 때 운반할 수 있는 최대 개수에서 현재 인덱스를 뺀 값을 저장한다.

예를 들어 cap = 2 이고 , 현재 인덱스의 값이 배달 = 5 / 픽업 = 3 이라면 

왕복은 3번이고 최대 개수는 6, 6 이다 따라서  `deliSave = 1` `pickSave = 3` 이 된다.

다음 인덱스에 값이 배달 = 1, 픽업 = 3 이라면 `deliSave = 0` `pickSave = 0` 이 되고 이동횟수를 카운트하지 않아도 된다.

흐름

1. 추가 배달 또는 픽업 변수를 통해서 현재 인덱스에 값을 갱신 해준다.
2. 현재 인덱스에서 배달과 픽업중 더 큰 값을 찾는다. (둘 다 0, 0 이면 continue)
3. 큰 값을 기준으로 왕복 횟수를 구하고 추가 배달, 추가 픽업 변수 갱신
4. 이동횟수를 계산해서 answer에 더해준다.  

그리디로 풀어야겠다고 결심한 후 설계는 금방 나왔다.

이모티콘 할인행사 문제를 풀다가(어제임) 빈약한 설계로 고생했던 경험이 있어서 문제가 발생할만한 부분이 없는지 확실하게 체크했다.

문제가 없어보였고 실제로 설계에는 문제가 없었는데 구현이 오래걸렸다.

아래 코드에서 주석 부분을 실수로 구현을 안한 탓인데

```java
//updateBox 함수 중 일부
if (check == 1) {
			if (box > deliSave) {
				box -= deliSave;
				// deliSave = 0; 추가배달 변수관리 하는 중요한 부분 이부분을 빼먹었음
			}
}
```

우연히도 예제 케이스를 다 맞춰 버려서 실수를 발견하지 못하고 오랜 시간을 잡아먹었다.

맞는데 왜 틀리지? 를 반복하다 우연히 반례를 발견, 문제를 찾아서 해결하기 까지 2시간 소요…

설계를 잘했으면 구현하면서 실수는 없는지 꼭 체크해보자 

**실수로 빠트린 1분이 2시간이 되는수가 있더라**