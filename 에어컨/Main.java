package 에어컨;

// 1. 에어컨을 꺼도 적정온도가 유지되는 시간
// 		에어컨 희망온도는 temperature가 양수일때는 t1 , 음수일때는 t2를 기준으로 트는게 이득
// 		승객이 없어질때까지 걸리는 시간 < 현재 온도 -t1(or t2)
// 꺼도 문제없어질때까지 켜논다.
// 끈다.

// 2. 큐를 이용한 완전탐색
// on, off 결과를 둘 다 저장
// 그냥하면 2^1000 적절한 제거 조건을 추가해주어야한다.
// 적절한 제거 조건
//  1. 온도가 똑같고 더 적은 비용이 있는 경우 큐에서 제거
//	2. 에어컨을 계속 틀어도 손님이 오기전까지 적정온도를 맞추지 못하는 경우
// 큐를 순회하며 최소값을 찾는다.

import java.util.*;

class Solution {
	public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
		int answer = Integer.MAX_VALUE;
		int maxOffTime = t2 - t1;
		int target = temperature > 0 ? t1 : t2;
		ArrayList<Integer> passenger = new ArrayList<>();
		for (int i = 0 ; i < onboard.length ; i++) {
			if (onboard[i] == 1) {
				System.out.println(i);
				passenger.add(i);
			}
		}
		
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int []onboard = {0, 0, 1, 1, 1, 1, 1};
		System.out.println(sol.solution(28, 18, 26, 10, 8, onboard));
	}
}
