### 폰켓몬

# 해결과정

문제를 보자마자 가장 먼저 든 생각이 c++에 set자료구조
java에도 있지 않을까? 검색해보니 hashSet이 있다.
```
HashSet<Integer> set = new HashSet<>();
```
중복이 없이 저장 후 인풋 / 2 둘 중에 작은걸로 리턴하면 끝
