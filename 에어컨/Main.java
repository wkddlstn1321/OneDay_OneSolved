package 에어컨;

// 1. 에어컨을 꺼도 적정온도가 유지되는 시간
// 		에어컨 희망온도는 temperature가 양수일때는 t1 , 음수일때는 t2를 기준으로 트는게 이득
// 		승객이 없어질때까지 걸리는 시간 < 현재 온도 -t1(or t2)
// 꺼도 문제없어질때까지 켜논다.
// 끈다.

// 2. 큐를 이용한 완전탐색
// on, off, 현재온도 유지 3가지 조건을 전부 확인
// 그냥하면 3^1000 적절한 제거 조건을 추가해주어야한다.
// 적절한 제거 조건
//	1. 에어컨을 계속 틀어도 손님이 오기전까지 적정온도를 맞추지 못하는 경우
//  2. 온도가 높고 비용도 높은 경우 큐에서 제거 (온도가 t1 보다 낮은 경우도 큐에서 제거)
// 큐를 순회하며 최소값을 찾는다.

// 전원을 끄면 온도가 올라가게 하고 싶다
// -25이고  10~15 또는 -5~10
// 5이고 10~15 또는 -5~10

// 25이고  10~15 또는 -5~10
// 실외온도가 음수인 경우

import java.util.*;

class Pair {
	private int temp;
	private int cost;

	public static Pair makePair(int temp, int cost) {
		Pair pair = new Pair(temp, cost);
		return pair;
	}

	public Pair(int temp, int cost) {
		this.temp = temp;
		this.cost = cost;
	}

	public int getTemperature() {
		return this.temp;
	}

	public int getCost() {
		return this.cost;
	}
}

class Solution {
	public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
		int answer = Integer.MAX_VALUE;
		if (t1 <= temperature && temperature <= t2)
			return 0;
		ArrayList<Integer> passengerList = new ArrayList<>();
		for (int i = 0; i < onboard.length; i++) {
			if (onboard[i] == 1) {
				passengerList.add(i);
			}
		}
		// 외부,내부 온도 영상으로 변경
		if (temperature < t1) {
			temperature = t2 + t1 - temperature;
		}
		if (t1 < 0) {
			temperature -= t1;
			t2 -= t1;
			t1 -= t1;
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(temperature, 0));
		for (int i = 0; i < onboard.length; i++) {
			// 승객리스트 다음 위치로 이동
			if (i == passengerList.get(0))
				passengerList.remove(0);
			// 남은 승객이 없다.
			if (passengerList.isEmpty()) {
				break;
			}
			int size = q.size();
			HashMap<Integer, Integer> m = new HashMap<>();
			for (int j = 0; j < size; j++) {
				Pair curr = q.poll();
				int currTemperature = curr.getTemperature();
				int currCost = curr.getCost();
				// 이미 같은 온도가 있을 때 현재 비용이 같거나 높다면 볼 필요가 없다.
				if (m.containsKey(currTemperature)) {
					if (m.get(currTemperature) <= currCost)
						continue;
				}
				m.put(currTemperature, currCost);
				// 전원을 끄면 안되는 상황은 무시
				if (currTemperature - t2 < passengerList.get(0) - i) {
					if (currTemperature == t2) {
						if (currTemperature - t2 + 1 < passengerList.get(0) - i) {
							if (currTemperature + 1 > temperature)
								q.add(Pair.makePair(currTemperature, currCost));
							else
								q.add(Pair.makePair(currTemperature + 1, currCost));
						}
					} else {
						if (currTemperature + 1 > temperature)
							q.add(Pair.makePair(currTemperature, currCost));
						else
							q.add(Pair.makePair(currTemperature + 1, currCost));
					}
				}
				// 현재온도 - 목표온도 < 남은시간
				if (currTemperature - t2 < passengerList.get(0) - i) {
					if (t1 <= currTemperature || currTemperature <= t2)
						q.add(Pair.makePair(currTemperature, currCost + b));
				}
				// 과하게 내릴 필요는 없다
				if (currTemperature > t2 - 1) {
					q.add(Pair.makePair(currTemperature - 1, currCost + a));
				}
			}
		}
		for (Pair i : q) {
			int cost = i.getCost();
			int ondo = i.getTemperature();
			if (answer > cost && ondo >= t1 && ondo <= t2 ) {
				answer = cost;
			}
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] onboard = {0, 0, 0, 0, 0, 1, 0 };
		System.out.println(sol.solution(15, 0, 10, 5, 1, onboard));
	}
}
