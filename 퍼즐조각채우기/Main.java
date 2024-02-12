package 퍼즐조각채우기;

// 게임보드 저장 식
// 퍼즐조각 개수, 퍼즐 시작 좌표

import java.util.*;
import java.awt.Point;

class Solution {
	int[][] boardVisit;
	int[][] tableVisit;
	int[] dirX = { -1, 1, 0, 0 };
	int[] dirY = { 0, 0, -1, 1 };
	int[] rotatePos = {0, 1, 2};
	int[][] gGameBoard;
	int[][] gTable;
	int[][] table90;
	int[][] table180;
	int[][] table270;
	int[][][] tableRotate;
	int boardLength;
	HashMap<Integer, List<Point>> gameBoardMap = new HashMap<>();
	HashMap<Integer, List<Point>> tableMap = new HashMap<>();

	public int solution(int[][] game_board, int[][] table) {
		int answer = -1;
		boardLength = game_board.length;
		gGameBoard = game_board;
		gTable = table;
		boardVisit = new int[boardLength][boardLength];
		tableVisit = new int[boardLength][boardLength];
		table90 = rotate90(table);
		table180 = rotate90(table90);
		table270 = rotate90(table180);
		tableRotate = new int[][][] { table, table90, table180, table270 };
		ArrayList<Integer> game_boardList = new ArrayList<>();
		ArrayList<Integer> tableList = new ArrayList<>();
		for (int i = 0; i < boardLength; i++) {
			for (int j = 0; j < boardLength; j++) {
				if (game_board[i][j] == 0 && boardVisit[i][j] == 0) {
					int cnt = getPuzzlePieceCnt(0, i, j);
					if (gameBoardMap.containsKey(cnt)) {
						gameBoardMap.get(cnt).add(new Point(i, j));
					} else {
						List<Point> list = new ArrayList<>();
						list.add(new Point(i, j));
						gameBoardMap.put(cnt, list);
					}
				}
				if (table[i][j] == 1 && tableVisit[i][j] == 0) {
					int cnt = getPuzzlePieceCnt(1, i, j);
					if (tableMap.containsKey(cnt)) {
						tableMap.get(cnt).add(new Point(i, j));
					} else {
						List<Point> list = new ArrayList<>();
						list.add(new Point(i, j));
						tableMap.put(cnt, list);
					}
				}
			}
		}
		// tableMap 순회
		for (Map.Entry<Integer, List<Point>> i : tableMap.entrySet()) {
			int key = i.getKey();
			List<Point> points = i.getValue();
			for (Point p : points) {
				answer += puzzleInsert(key, p);
			}
		}
		return answer;
	}

	private int puzzleInsert(int cnt, Point p) {
		if (!gameBoardMap.containsKey(cnt)) {
			return 0;
		}
		for (Point xy : gameBoardMap.get(cnt)) {
			if (isInsertAvail(xy, p)) {
				gameBoardMap.get(cnt).remove(xy);
				if (gameBoardMap.get(cnt).size() == 0) {
					gameBoardMap.remove(cnt);
				}
				return cnt;
			}
		}
		return 0;
	}

	// 퍼즐을 넣을 수 있는지 확인
	// table 시작 좌표와 gameBoard 시작 좌표를 일치시키고 table을 돌리면서 확인
	private boolean isInsertAvail(Point tableP, Point gameBoardP) {
		for (int i = 0 ; i < 4 ; i++) {
			int[][]	table = tableRotate[i];
			for (int j = gameBoardP.x ; j < boardLength ; j++) {
				for (int k = gameBoardP.y ; k < boardLength ; k++) {
					if (table[j - gameBoardP.x][k - gameBoardP.y] == 1) {
						if (gGameBoard[j][k] == 1) {
							return false;
						}
					} else {
						break ;
					}
				}
				
			}
		}
		return false;
	}

	private int getPuzzlePieceCnt(int state, int i, int j) {
		int[][] board = state == 0 ? gGameBoard : gTable;
		int[][] visit = state == 0 ? boardVisit : tableVisit;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		visit[i][j] = 1;
		int cnt = 1;
		while (!q.isEmpty()) {
			Point xy = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = xy.y + dirX[k];
				int y = xy.x + dirY[k];
				if (0 <= x && x < boardLength && 0 <= y && y < boardLength) {
					if (board[y][x] == state && visit[y][x] == 0) {
						cnt++;
						visit[y][x] = 1;
						q.add(new Point(y, x));
					}
				}
			}
		}
		return cnt;
	}

	private int[][] rotate90(int[][] table) {
		int[][] temp = new int[boardLength][boardLength];
		for (int i = 0 ; i < boardLength ; i++) {
			for (int j = 0 ; j < boardLength ; j++) {
				temp[i][j] = table[boardLength - j - 1][i];
			}
		}
		return temp;
	}
}

// 퍼즐을 넣을 때 주변에 빈칸이 있으면 안되기 때문에 퍼즐을 맞추는 순서는 상관이 없다.
// 모든 퍼즐을 대상으로 들어갈 곳이 있는지 확인만 하면 되는 것
// 퍼즐을 끼워맞출 때 방향을 돌리면서 확인한다.
public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		System.out.println(sol.solution(game_board, table));
	}
}
