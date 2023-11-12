package HIndex;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		int[] citations = { 1, 2, 22, 23, 24, 25, 26 };
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		citations = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
				.toArray();
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > answer)
				answer++;
			else
				break;
		}
		return answer;
	}
}
// 1 1 1 10 10 10, 3
// 0 1 3 5 6, 3
// 7, 1
// 0, 0
// 1 2 22 23 24 25 26, 5