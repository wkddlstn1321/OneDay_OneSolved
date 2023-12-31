package 이차원동전뒤집기;

import java.util.*;

class Solution {
	int rowLength;
	int colLength;

	public int solution(int[][] beginning, int[][] target) {
		int answer = 0;
		rowLength = beginning.length;
		colLength = beginning[0].length;
		int[][] rowSpin = deepCopy(beginning);
		int[][] colSpin = deepCopy(beginning);
		rowSpin = spinBoard(rowSpin, true);
		colSpin = spinBoard(colSpin, false);
		int[][] bothSpin = deepCopy(rowSpin);
		bothSpin = spinBoard(bothSpin, false);
		answer = getDiffCnt(beginning, target);
		int cnt = getDiffCnt(rowSpin, target) + 1;
		answer = answer > cnt ? cnt : answer;
		cnt = getDiffCnt(colSpin, target) + 1;
		answer = answer > cnt ? cnt : answer;
		cnt = getDiffCnt(bothSpin, target) + 2;
		answer = answer > cnt ? cnt : answer;
		if (diffBoard(beginning, target))
			answer = -1;
		return answer;
	}

	//1행 또는 1열 돌리기
	public int[][] spinBoard(int[][] board, boolean row) {
		if (row) {
			for (int i = 0; i < rowLength; i++) {
				board[i][0] = board[i][0] == 1 ? 0 : 1;
			}
		} else {
			for (int i = 0; i < colLength; i++) {
				board[0][i] = board[0][i] == 1 ? 0 : 1;
			}
		}
		return board;
	}

	//바꿔야 하는 경우 카운트
	public int getDiffCnt(int[][] beginning, int[][] target) {
		int cnt = 0;
		for (int i = 0; i < rowLength; i++) {
			if (beginning[i][0] != target[i][0]) {
				cnt++;
				for (int j = 0; j < colLength; j++) {
					beginning[i][j] = beginning[i][j] == 1 ? 0 : 1;
				}
			}
		}
		for (int i = 0; i < colLength; i++) {
			if (beginning[0][i] != target[0][i]) {
				cnt++;
				for (int j = 0; j < rowLength; j++) {
					beginning[j][i] = beginning[j][i] == 1 ? 0 : 1;
				}
			}
		}
		return cnt;
	}

	//판이 일치하는지 확인
	public boolean diffBoard(int[][] beginning, int[][] target) {
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (beginning[i][j] != target[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	//배열 깊은 복사
	public int[][] deepCopy(int[][] beginning) {
		int[][] cloneBegin = beginning.clone();
		for (int i = 0; i < beginning.length; i++) {
			cloneBegin[i] = beginning[i].clone();
		}
		return cloneBegin;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] beginning = { { 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1 }, { 0, 1, 1, 1, 0 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 1, 0 } };
		int[][] target = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(sol.solution(beginning, target));
	}
}

// 조건 1
// 1행과 1열만 똑같게 일치 시켜주면 된다.
// 나머지 모든 행열이 1행과 1열에 연결되어있다
// 1행 1열이 일치할 때 전체가 일치하지 않는다면 불가능한 케이스.

// 조건 1이 성립한다면 해당 문제는 가장 적은 케이스로 1행 1열을 일치시키는 문제
// 그럼 문제가 쉬워진다.
