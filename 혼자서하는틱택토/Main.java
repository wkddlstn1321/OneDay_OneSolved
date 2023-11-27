package 혼자서하는틱택토;

public class Main {
	public static void main(String args[]) {
		String[] board = { "OXO", "XOO", "XXO" };
		System.out.println(solution(board));
	}

	public static int finishCheck(String[] board, char target) {
		int finishCnt = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target)
				finishCnt++;
			if (board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target)
				finishCnt++;
		}
		if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target)
			finishCnt++;
		if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target)
			finishCnt++;
		return finishCnt;
	}

	public static int solution(String[] board) {
		int answer = 1;
		int Ocnt = 0;
		int Xcnt = 0;
		int oWin = 0;
		int xWin = 0;
		for (int i = 0 ; i < board.length; i++) {
			for (int j = 0 ; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'O')
					Ocnt++;
				else if (board[i].charAt(j) == 'X')
					Xcnt++;
			}
		}
		oWin = finishCheck(board, 'O');
		xWin = finishCheck(board, 'X');
		if (Ocnt < Xcnt || Ocnt > Xcnt + 1 || (oWin > 0 && xWin > 0) || (oWin > 0 && Ocnt != Xcnt + 1) || (xWin > 0 && Ocnt != Xcnt))
			answer = 0;
		return answer;
	}
}
// X가 O보다 많은 경우
// O가 X보다 2개 이상 많은 경우
// O가 이겼는데 X도 이긴 경우
// O가 이겼는데 X보다 하나 더 많지 않은 경우
// X가 이겼는데 O와 개수가 같지 않은 경우

//o o o
//x x x
//x x x