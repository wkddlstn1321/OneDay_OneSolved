package 사라지는발판;

// 완전탐색
// 둘 다 최선의 플레이를 한다면 가장 작은 이동횟수가 나온다.
// A가 이기면서 이동횟수가 가장 적은 경우
// B가 이기면서 이동횟수가 가장 많은 경우

// A가 지는 조건
// B가 지는 조건
// 도망치는가 끝내는가

//종료 조건
// 내 현재 위치가 0이다
// 4방향에 1이 없다

class Solution {
	public int solution(int[][] board, int[] aloc, int[] bloc) {
		int answer = -1;
		return answer;
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
