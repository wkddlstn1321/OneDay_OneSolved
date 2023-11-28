package 조이스틱;

import java.util.*;
import java.awt.Point;

public class Main {
	public static int leftRightMove;

	public static void main(String args[]) {
		System.out.println(solution("BBBAAAAA"));
	}

	public static int getLeftMove(int curIdx, int destIdx, int listSize) {
		int move = 0;
		if (curIdx >= destIdx)
			move = curIdx - destIdx;
		else
			move = curIdx + listSize - destIdx;
		return move;
	}

	public static int getRightMove(int curIdx, int destIdx, int listSize) {
		int move = 0;
		if (curIdx <= destIdx)
			move = destIdx - curIdx;
		else
			move = destIdx + listSize - curIdx;
		return move;
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
		ArrayList<Integer> targetIdxList = new ArrayList<>();
		upDownMove = getUpDownMove(targetIdxList, name);
		leftRightMove = Integer.MAX_VALUE;
		int listSize = targetIdxList.size();
		int nameSize = name.length();
		for (int start = 0; start < listSize; start++) {
			int curIdx = 0;
			int startFirst = 0;
			int lastFirst = 0;
			for (int i = 0; i < start; i++) {
				startFirst += getRightMove(curIdx, targetIdxList.get(i), nameSize);
				curIdx = targetIdxList.get(i);
			}
			for (int i = listSize - 1; i >= start; i--) {
				startFirst += getLeftMove(curIdx, targetIdxList.get(i), nameSize);
				curIdx = targetIdxList.get(i);
			}
			curIdx = 0;
			for (int i = listSize - 1; i >= start; i--) {
				lastFirst += getLeftMove(curIdx, targetIdxList.get(i), nameSize);
				curIdx = targetIdxList.get(i);
			}
			for (int i = 0; i < start; i++) {
				lastFirst += getRightMove(curIdx, targetIdxList.get(i), nameSize);
				curIdx = targetIdxList.get(i);
			}
			leftRightMove = Math.min(leftRightMove, Math.min(startFirst, lastFirst));
		}
		int curIdx = 0;
		int lastCase = 0;
		for (int i = 0; i < listSize ; i++) {
			lastCase += getRightMove(curIdx, targetIdxList.get(i), nameSize);
			curIdx = targetIdxList.get(i);
		}
		leftRightMove = Math.min(leftRightMove, lastCase);
		if (leftRightMove == Integer.MAX_VALUE)
			leftRightMove = 0;
		answer = upDownMove + leftRightMove;
		return answer;
	}
}
