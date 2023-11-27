package 조이스틱;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		System.out.println(solution("BBBAAAABA"));
	}

	public static int getLeftRightMove(ArrayList<Integer> targetIdx, int size) {
		int sum = 0;
		int start = 0;
		int end = 0;
		int diff = 0;
		for (int i = 0 ; i < targetIdx.size() - 1; i++) {
			if (diff < targetIdx.get(i + 1) - targetIdx.get(i)) {
				diff = targetIdx.get(i + 1) - targetIdx.get(i);
				start = targetIdx.get(i) + 1;
				end = targetIdx.get(i + 1) - 1;
			}
		}
		return sum;
	}

	public static int getUpDownMove(ArrayList<Integer> targetIdxList, String name) {
		int move = 0;
		for (int i = 0; i < name.length(); i++) {
			int target = name.charAt(i) - 'A';
			if (target > 13)
				target = 26 - target;
			move += target;
			if (target != 0)
				targetIdxList.add(i);
		}
		return move;
	}

	public static int solution(String name) {
		int answer = 0;
		int upDownMove = 0;
		int leftRightMove = 0;
		ArrayList<Integer> targetIdxList = new ArrayList<>();
		upDownMove = getUpDownMove(targetIdxList, name);
		leftRightMove = getLeftRightMove(targetIdxList, name.length() - 1);
		System.out.println("move: " + leftRightMove);
		answer = upDownMove + leftRightMove;
		return answer;
	}
}
