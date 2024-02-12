package 교점에별만들기;

// 수학이 필요한 문제

// 기울기를 계산하여 겹치는 점을 찾기

// 교점이 존재한다면 아래 공식을 통해 x, y를 구할 수 있다.
// Ax + By + E = 0
// Cx + Dy + F = 0

// x = (BF - ED) / (AD - BC)
// y = (EC - AF) / (AD - BC)
// AD - BC가 0이면 교점이 존재하지 않는다.

// 교점이 존재하는 경우에는 x, y를 구한 후 x, y가 정수인지 확인한다.
// x, y가 정수인 경우에는 교점이 존재하는 것이므로 해당 좌표를 저장한다.

// 모든 교점을 구한 후에는 x축 최소값, y축 최소값을 구한뒤 해당 값을 기준으로 좌표를 이동.
// 이동한 좌표를 기준으로 그림을 그려주된다.

//pair class
import java.util.*;

class Pair {
	long x;
	long y;

	Pair(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	public String[] solution(int[][] line) {
		String[] answer;
		List<Pair> list = new ArrayList<>();
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				long A = line[i][0];
				long B = line[i][1];
				long C = line[j][0];
				long D = line[j][1];
                long E = line[i][2];
				long F = line[j][2];
				long bunmo = A * D - B * C;
                if (bunmo == 0)
					continue;
                long bunjaX = B * F - E * D;
                long bunjaY = E * C - A * F;
                if (bunjaX % bunmo != 0 || bunjaY % bunmo != 0)
                    continue;
				long x = bunjaX / bunmo;
				long y = bunjaY / bunmo;
				if (x < minX)
					minX = x;
				if (x > maxX)
					maxX = x;
				if (y < minY)
					minY = y;
				if (y > maxY)
					maxY = y;
				list.add(new Pair(x, y));
			}
		}
		minX *= -1;
		minY *= -1;
		maxX = maxX + minX;
		maxY = maxY + minY;
		// answer 모든 값 .으로 초기화
		answer = new String[(int)maxY + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = "";
			for (int j = 0; j <= maxX; j++) {
				answer[i] += ".";
			}
		}
		for (int i = 0; i < list.size(); i++) {
			long x = list.get(i).x + minX;
			long y = maxY - list.get(i).y - minY;
			System.out.println(x + " " + y);
			answer[(int)y] = answer[(int)y].substring(0, (int)x) + "*" + answer[(int)y].substring((int)x + 1);
		}
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] line = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } };
		System.out.println(Arrays.toString(sol.solution(line)));
	}
}
