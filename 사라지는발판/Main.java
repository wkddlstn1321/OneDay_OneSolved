package 사라지는발판;

//종료 조건
// 내 현재 위치가 0이다
// 4방향에 1이 없다

class Solution {
	int move = 0;
	int[][] gBoard;
	public int solution(int[][] board, int[] aloc, int[] bloc) {
		int answer = -1;
		gBoard = board;
		dfs(aloc.clone(), bloc.clone(), 0);
		return answer;
	}
	public void dfs(int[] aloc, int[] bloc, int move) {
		
	}

	public boolean miniMax() {
		return true;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] board = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[] aloc = { 1, 0 };
		int[] bloc = { 1, 2 };
		System.out.println(sol.solution(board, aloc, bloc));
	}
}

//A11B111

//A1B
//101
//101

// 누가 이기는지를 알아야 한다
// 누가 이기는지는 알 수가 없다?

//이동 짝수이면 A가 짐
//이동 홀수이면 A가 이김

// 무조건 지는 경우에는 최대값을 리턴

// 모른다 최소값을 리턴
