package 같은숫자는싫어;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 1, 3, 3, 0, 1, 1 })));
	}

	public static int[] solution(int[] arr) {
		int[] answer = {};
		int size = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0 ; i < arr.length ; i++) {
			if (i == 0)
				list.add(arr[i]);
			else {
				if (list.get(size) != arr[i]) {
					list.add(arr[i]);
					size++;
				}
			} 
		}
		answer = new int[list.size()];
		int j = 0;
		for (Integer i: list) {
			answer[j] = i;
			j++;
		}
		return answer;
	}
}