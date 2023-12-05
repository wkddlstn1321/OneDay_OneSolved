package 택배배달과수거하기;

class Solution {
	long deliSave = 0;
	long pickSave = 0;

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		for (int i = deliveries.length - 1; i >= 0; i--) {
			System.out.println("delSave: " + deliSave + " deliver: " + deliveries[i]);
			deliveries[i] = updateBox(deliveries[i], 1);
			pickups[i] = updateBox(pickups[i], 2);
			System.out.println("delSave: " + deliSave + " deliver: " + deliveries[i]);
			if (deliveries[i] == 0 && pickups[i] == 0)
				continue;
			long max = Math.max(deliveries[i], pickups[i]);
			long move = max % cap == 0 ? max / cap : max / cap + 1;
			long boxCnt = move * cap;
			deliSave += boxCnt - deliveries[i];
			pickSave += boxCnt - pickups[i];
			answer += (i + 1) * 2 * move;
		}
		return answer;
	}

	public int updateBox(int box, int check) {
		if (check == 1) {
			if (box > deliSave) {
				box -= deliSave;
				deliSave = 0;
			}
			else {
				deliSave -= box;
				box = 0;
			}
		} else {
			if (box > pickSave) {
				box -= pickSave;
				pickSave = 0;
			}
			else {
				pickSave -= box;
				box = 0;
			}
		}
		return box;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		// long answer = sol.solution(2, 3, new int[] { 4, 2, 1 }, new int[] { 0, 0, 0});
		// System.out.println(answer);
		System.out.println(sol.solution(2, 3, new int[] { 4, 2, 1 }, new int[] { 0, 4, 1 }) + " " + 16);
	}
}

