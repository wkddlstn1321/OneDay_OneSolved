### 양궁 대회
[문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/92343)

# 해결과정

왼쪽 노드를 탐색을 먼저 끝내는 경우인 DFS와 왼쪽과 오른쪽을 번갈아 방문하는 BFS, 두가지 경우 모두 고려 해줘야하기 때문에 일반적인 DFS, BFS 접근하기에는 까다롭다고 판단했었다.

하지만 visit과 조건문을 잘 활용해주면 DFS로도 충분히 풀이가 가능했다.

1. 간선을 모두 돌면서 현재 위치에서 갈 수 있으면 방문 체크 후 다시 dfs
2. 갈 수 있는 조건은 간선의 첫자리가 true 이면서 두번째 자리가 false인 경우

`visit[globalEdges[i][0]] == true && visit[globalEdges[i][1]] == false`

이렇게 하면 정답이 나오긴 하지만 중복이 많아지는 특정 케이스로 테스트 할 시 시간초과가 나는 경우가 있다고 한다.

이건 나중에 해결해 보겠다.