package 주차요금계산;

import java.util.*;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		int[] cars = new int[10000];
		boolean[] carExist = new boolean[10000];
		int maxTime = 23 * 60 + 59;
		for (int i = 0; i < records.length; i++) {
			String[] spl = records[i].split(" ");
			int number = Integer.parseInt(spl[1]);
			int time = convertTime(spl[0]);
			if (spl[2].equals("IN")) {
				cars[number] -= time;
				carExist[number] = true;
			} else {
				cars[number] += time;
				carExist[number] = false;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			if (cars[i] == 0 && !carExist[i])
				continue;
			if (carExist[i])
				cars[i] += maxTime;
			cars[i] -= fees[0];
			int mo = cars[i] % fees[2] > 0 ? 1 : 0;
			int addTime = (cars[i] / fees[2] + mo)* fees[3];
			cars[i] = addTime > 0 ? addTime + fees[1] : fees[1];
			ans.add(cars[i]);
		}
		int[] answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}

	public int convertTime(String str) {
		int hourTime = Integer.parseInt(str.substring(0, 2));
		int minTime = Integer.parseInt(str.substring(3, 5));
		int time = hourTime * 60 + minTime;
		return time;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		System.out.println(Arrays.toString(sol.solution(fees, records)));
	}
}

// 기억해야 하는 것 IN OUT에 대한 처리
// List 생성
// IN 이면 차량 번호, 입고 시간 저장
// OUT 이면 해당하는 차량번호 찾아서 주차요금 계산 후 List에서 삭제

// List 타입은?
// 기억해야 할 것
// 1. 차량 번호
// 2. 입고 시간
// 3. 입출고 여부
// 마지막에 출고가 안되어있으면 요금정산을 해야함

// 부가 서비스
// 인풋값 (시간, 차량번호, 입출고) 로 split.
// 시간 변환 앞자리 곱하기 * 60 + 뒷자리
// maxTime = 23 * 60 + 59;

// 시간을 전부 계산
// 인풋값 순회 이후 리스트 순회하며 마무리