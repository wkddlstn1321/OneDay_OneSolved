package 기능개발;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(solution(progresses, speeds)[0]);
	}

	public static int solvedDay(int progresses, int speeds) {
		int remaining = 100 - progresses;
		int div = remaining / speeds;
		return remaining % speeds == 0 ? div : div + 1;
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] dayArray = new int[progresses.length];
		for (int i = 0 ; i < progresses.length ; i++) {
			dayArray[i] = solvedDay(progresses[i], speeds[i]);
		}
		int day = dayArray[0];
		int cnt = 1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0 ; i < dayArray.length ; i++) {
			if (i == dayArray.length - 1) {
				list.add(cnt);
				break ;
			}
			if (day < dayArray[i])
				day = dayArray[i];
			if (dayArray[i] < dayArray[i + 1] && day < dayArray[i + 1]) {
				list.add(cnt);
				cnt = 1;
			} else {
				cnt++;
			}
		}
		int i = 0;
		answer = new int[list.size()];
		for (Integer item: list) {
			answer[i] = item;
			i++;
		}
		return answer;
	}
}
// 20 1 20 1 3 4 5