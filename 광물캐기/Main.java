package 광물캐기;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 2 }, new String[] { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
	}

	public static int getMaxWeightIndex(ArrayList<Integer> weightList) {
		int max = 0;
		int idx = 0;
		for (int i = 0; i < weightList.size(); i++) {
			if (max < weightList.get(i)) {
				max = weightList.get(i);
				idx = i;
			}
		}
		return idx;
	}

	public static int getMaxPicks(int[] picks) {
		int sum = 0;
		for (int i = 0; i < picks.length; i++) {
			sum += picks[i];
		}
		return sum * 5;
	}

	public static int solution(int[] picks, String[] minerals) {
		int answer = 0;
		int maxPicks = getMaxPicks(picks);
		ArrayList<Integer> weightList = new ArrayList<>();
		maxPicks = maxPicks > minerals.length ? minerals.length : maxPicks;
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < maxPicks; i++) {
			if (minerals[i].equals("diamond"))
				sum += 25;
			else if (minerals[i].equals("iron"))
				sum += 5;
			else
				sum += 1;
			cnt++;
			if (cnt == 5) {
				weightList.add(sum);
				sum = 0;
				cnt = 0;
			}
		}
		if (sum != 0)
			weightList.add(sum);
		sum = 0;
		int[][] pickWeight = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };
		int listSize = weightList.size();
		for (int i = 0; i < listSize; i++) {
			int idx = getMaxWeightIndex(weightList);
			weightList.set(idx, -1);
			int j = 0;
			for (j = 0; j < 3; j++) {
				if (picks[j] != 0) {
					picks[j] -= 1;
					break;
				}
			}
			int mineralIdx = idx * 5;
			for (int k = mineralIdx; k < mineralIdx + 5; k++) {
				if (minerals[k].equals("diamond")) {
					sum += pickWeight[j][0];
				} else if (minerals[k].equals("iron")) {
					sum += pickWeight[j][1];
				} else {
					sum += pickWeight[j][2];
				}
				if (k + 1 >= minerals.length)
					break;
			}
		}
		answer = sum;
		return answer;
	}
}
