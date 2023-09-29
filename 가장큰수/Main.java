import java.util.*;

public class Main {
	public static void main(String args[]) {
		int numbers[] = {6, 10, 2};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0 ; i < numbers.length ; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
		for (int i = 0 ; i < numbers.length ; i++) {
			answer += list.get(i);
		}
		if (answer.charAt(0) == '0') {
			answer = "0";
		}
		return answer;
	}
}
