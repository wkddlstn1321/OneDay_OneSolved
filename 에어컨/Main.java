package 에어컨;

// 1. 에어컨을 꺼도 적정온도가 유지되는 시간
// 		에어컨 희망온도는 temperature가 양수일때는 t1 , 음수일때는 t2를 기준으로 트는게 이득
// 		승객이 없어질때까지 걸리는 시간 < 현재 온도 -t1(or t2)
// 꺼도 문제없어질때까지 켜논다.
// 끈다.

// 2. 큐를 이용한 완전탐색
// on, off 결과를 둘 다 저장
// 그냥하면 2^1000 적절히 제거 조건을 추가해주어야한다.
// 적절한 제거 조건
//	1. 현재 비용과 온도가 똑같은 경우 큐에서 제거
//	2. 적정온도를 유지하지 못하는 경우 큐에서 제거
//	3. 너무 비용이 높으면 제거 (순회중 최소온도 + (b * t2 - t1) < 현재온도)
// 큐를 순회하며 최소값을 찾는다.

import java.util.*;

class airConditional {
	public int currTemperature;
	public int cost;
	public int status;
	// 0 off
	// 1 on
	public airConditional(int temperature) {
		currTemperature = temperature;
		cost = 0;
		status = 0;
	}

	public airConditional (airConditional ac) {
		currTemperature = ac.currTemperature;
		cost = ac.cost;
		status = ac.status;
	}
}

class Solution {
	public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
		int answer = Integer.MAX_VALUE;
		int maxOffTime = t2 - t1;
		int target = temperature > 0 ? t1 : t2;
		Queue<airConditional> q = new LinkedList<>();
		q.add(new airConditional(temperature));
		for (int i : onboard) {
			for (int j = 0 ; j < q.size() ; j ++) {
				airConditional ac = q.poll();
				int minCost = Integer.MAX_VALUE;
				if (i == 1) {
					if (ac.currTemperature < t1 || ac.currTemperature > t2) {
						continue ;
					}
				}
				// 경우의 수를 줄이기 위한 탈출조건
				
				// 꺼져있을 때
				//  온도를 한칸 낮추고 add
				int currTemperature = ac.currTemperature;
				if (currTemperature > temperature) {
					currTemperature--;
				} else if (currTemperature < temperature) {
					currTemperature++;
				}
				q.add(new airConditional(currTemperature));

				// 켜져있을 떼
				//	온도를 희망온도쪽으로 낮추고 희망온도는 (t1 또는 t2)
				//	전력소모량을 올린다.
				if (ac.currTemperature == target) {
					
				}
				if (ac.currTemperature > target) {
					ac.currTemperature++;
				}
			}
		}

		for (airConditional i : q) {
			if (answer > i.cost) {
				answer = i.cost;
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
