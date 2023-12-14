package 양궁대회;

import java.util.*;

class Solution {
	public int maxScore = 0;
	public int Lscore = 0;
	public int AScore = 0;
	int[] curScoreBoard;
	int[] newScoreBoard = new int[11];

	public int[] solution(int n, int[] info) {
		dfs(0, info, n);
		if (maxScore == 0)
			return new int[] { -1 };
		return curScoreBoard;
	}

	public void dfs(int idx, int[] info, int n) {
		if (idx == 10) {
			newScoreBoard[10] = n;
			if (Lscore > AScore && Lscore - AScore >= maxScore) {
				if (Lscore - AScore == maxScore) {
					for (int i = 10; i >= 0; i--) {
						if (newScoreBoard[i] < curScoreBoard[i]) {
							break;
						} else if (newScoreBoard[i] > curScoreBoard[i]) {
							curScoreBoard = newScoreBoard.clone();
							break;
						}
					}
				} else {
					curScoreBoard = newScoreBoard.clone();
					maxScore = Lscore - AScore;
				}
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			int curPoint = 10 - idx;
			if (i == 0 && n > info[idx]) {
				Lscore += curPoint;
				n -= info[idx] + 1;
				newScoreBoard[idx] = info[idx] + 1;
				dfs(idx + 1, info, n);
				n += info[idx] + 1;
				Lscore -= curPoint;
			} else {
				if (info[idx] != 0)
					AScore += curPoint;
				newScoreBoard[idx] = 0;
				dfs(idx + 1, info, n);
				if (info[idx] != 0)
					AScore -= curPoint;
			}
		}
	}
}

public class Main {
	public static void main(String args[]) {
		Solution sol = new Solution();
		int n = 3;
		int[] info = { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(sol.solution(n, info)));
	}
}

// dfs
// 10점부터 시작해서 하나 더 맟추거나 안 맞추고 넘어가는 경우 모두 계산
// 최종점수를 본다. 높거나 같으면 갱신

// 점수차이가 큰 걸 찾아야 한다.
// 점수가 큰게 아니라
// 10 9 5 = 24 - 21 = 3
// 10 8 = 19 - 11 = 7