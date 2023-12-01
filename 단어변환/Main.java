package 단어변환;

import java.util.*;

class Pair {
	String str;
	int cnt;

	Pair(String str, int cnt) {
		this.str = str;
		this.cnt = cnt;
	}
}

class Solution {
	public boolean isOneDiff(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				cnt++;
			if (cnt > 1)
				return false;
		}
		return true;
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean[] visit = new boolean[words.length];
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
		return answer;
	}
}

public class Main {
	public static void main(String args[]) {
		Solution sol = new Solution();
		System.out.println(sol.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
	}
}

// 변환 순서가 크게 중요하지 않다.
// 최종 목표에 방문할 수 있는지가 중요
// bfs로 접근
// 1. begin에서 한 글자만 다른 words를 큐에 넣는다 (넣기 전에 방문 체크 및 target과 같은지 확인)
// 		queue에 넣을 때 현재 이동횟수를 같이 넣는다.
// 		target을 찾는 순간이 가장 적은 이동회수이다
// 2. 큐에서 하나제거 후 1번 반복
// 3. 큐가 비면 종료

// 시간복잡도 : O(N^2) (N : words의 길이)
// Words길이는 50이하 단어의 길이는 10이하
// 최악의 경우 50*50*10 = 25000

// 필요한 것
// 1. 한글자만 다른지 확인하는 함수
// 2. visit관리
