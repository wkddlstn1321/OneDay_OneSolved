package 가장많이받은선물;

import java.util.*;

// 선물을 주고 받은 관계표
// friends List 정렬
// gifts 선물 준 사람 기준으로 정렬
// friends List 

// Hash로 문자열 비교해서 선물 관계표 갱신

// 선물 지수표 생성
// 선물 관계도 생성
// 선물 관계도가 높으면 ++, 만약 0이다? 지수표를 보고 더 높으면 ++

class Solution {
	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		int friendsLength = friends.length;
		int[] giftIdx = new int[friendsLength];
		int[][] giftRelationship = new int[friendsLength][friendsLength];
		Arrays.sort(friends);
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < friendsLength; i++) {
			map.put(friends[i], i);
		}

		for (int i = 0; i < gifts.length; i++) {
			String[] giftList = gifts[i].split(" ");
			int give = map.get(giftList[0]);
			int take = map.get(giftList[1]);
			giftIdx[give]++;
			giftIdx[take]--;
			giftRelationship[give][take]++;
		}

		for (int i = 0; i < friendsLength ; i++) {
			int giftCnt = 0;
			for (int j = 0 ; j < friendsLength ; j++) {
				if (i == j)
					continue ;
				if (giftRelationship[i][j] > giftRelationship[j][i])
					giftCnt++;
				else if (giftRelationship[i][j] == giftRelationship[j][i]) {
					if (giftIdx[i] > giftIdx[j])
						giftCnt++;
				}
			}
			if (giftCnt > answer)
				answer = giftCnt;
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };
		System.out.println(sol.solution(friends, gifts));
	}
}
