package 주사위고르기;

// 10개의 주사위중 5개를 고르는 경우의 수는 252
// 5개의 주사위로 나올 경우의수 7776

// 모든 경우의 수를 전부 비교하자니 시간초과가 확실해보임
// 그럼 어떻게 해야겄노

// 주사위 선택하는 모든 경우의 수 구하기
// 	선택한 주사위로 조합할 수 있는 모든 정수 저장
// 		정수를 저장할 때 2분탐색을 통해 오름차순으로 정렬해서 저장
// 	현재 answer과 비교해서 승이 더 많으면 갱신
// 		비교할 때는 모든 값을 하나씩 비교할 필요없다.
//		이분탐색으로 자기 보다 작은 값을 찾는다 해당 인덱스가 승리 수

import java.util.*;

class Solution {
	public int[][] gDice;
	public int diceLength;
	public ArrayList<Integer> answerList = null;
	public ArrayList<Integer> currList;
	public int maxWinCnt = 0;
	public int scoreBoardLength = 0;

	public int[] solution(int[][] dice) {
		diceLength = dice.length;
		int[] answer = new int[diceLength / 2];
		gDice = dice;
		currList = new ArrayList<>();
		dfs(0);
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i) + 1;
		}
		return answer;
	}

	// 주사위 선택하는 모든 경우의 수 구하기
	public void dfs(int idx) {
		if (currList.size() == diceLength / 2) {
			ArrayList<Integer> currScoreBoard = new ArrayList<>();
			HashSet<Integer> includedElements = new HashSet<>(currList);
			ArrayList<Integer> remainingScoreboard = new ArrayList<>();
			ArrayList<Integer> remainingList = new ArrayList<>();
			for (int i = 0 ; i < diceLength ; i++) {
				if (!includedElements.contains(i)) {
					remainingList.add(i);
				}
			}
			// 선택한 주사위로 조합할 수 있는 모든 정수 저장
			scoreBoardUpdate(0, 0, currScoreBoard, currList);
			// 나머지 주사위로 조합할 수 있는 모든 정수 저장
			scoreBoardUpdate(0, 0, remainingScoreboard, remainingList);
			if (scoreBoardLength == 0) {
				scoreBoardLength = currScoreBoard.size();
			}
			// 나머지 경우와 비교 후 갱신
			answerUpdate(currScoreBoard, remainingScoreboard);
			return;
		}
		for (int i = idx; i < diceLength; i++) {
			currList.add(i);
			dfs(i + 1);
			currList.remove(currList.indexOf(i));
		}
	}

	// 스코어보드 갱신
	public void scoreBoardUpdate(int sum, int idx, ArrayList<Integer> currScoreBoard, ArrayList<Integer> diceList) {
		if (idx == diceLength / 2) {
			addScoreBoard(currScoreBoard, sum);
			return;
		}
		for (int i = 0; i < 6; i++) {
			sum += gDice[diceList.get(idx)][i];
			scoreBoardUpdate(sum, idx + 1, currScoreBoard, diceList);
			sum -= gDice[diceList.get(idx)][i];
		}
	}

	// 승이 패보다 더 많으면 리스트 갱신
	public void answerUpdate(ArrayList<Integer> currScoreBoard, ArrayList<Integer> remainingScoreboard) {
		if (answerList == null) {
			answerList = new ArrayList<>(currList);
		}
		int winCnt = 0;
		for (int i : currScoreBoard) {
			int idx = binarySearchMinIndex(remainingScoreboard, i);
			winCnt += idx;
		}
		if (winCnt > maxWinCnt) {
			maxWinCnt = winCnt;
			Collections.copy(answerList, currList);
		}
	}

	// 2진 탐색으로 값 정렬하면서 삽입
	public void addScoreBoard(ArrayList<Integer> currScoreBoard, int sum) {
		if (currScoreBoard.size() == 0) {
			currScoreBoard.add(sum);
			return;
		}
		int idx = binarySearchMinIndex(currScoreBoard, sum);
		currScoreBoard.add(idx, sum);
	}

	public int binarySearchMinIndex(ArrayList<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target <= list.get(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] dice = { {1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
		System.out.println(Arrays.toString(sol.solution(dice)));
	}
}
