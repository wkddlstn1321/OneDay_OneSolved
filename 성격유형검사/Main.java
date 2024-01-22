package 성격유형검사;

// 성격 8개
// RT
// CF
// JM
// AN

// 동의 비동의
// 3 2 1 0 1 2 3

import java.util.*;

class Solution {
	public String solution(String[] survey, int[] choices) {
		String answer = "";
		HashMap<Character, Integer> h = new HashMap<>();
		h.put('R', 0);
		h.put('T', 0);
		h.put('C', 0);
		h.put('F', 0);
		h.put('J', 0);
		h.put('M', 0);
		h.put('A', 0);
		h.put('N', 0);
		for (int i = 0 ; i < survey.length ; i++) {
			char fir = survey[i].charAt(0);
			char sec = survey[i].charAt(1);
			if (choices[i] == 4) {
				continue;
			} else if (choices[i] < 4) {
				// 동의
				h.put(fir, h.get(fir) + 4 - choices[i]);
			} else {
				// 비동의
				h.put(sec, h.get(sec) + choices[i] - 4);
			}
		}
		answer += StringAdd('R', 'T', h);
		answer += StringAdd('C', 'F', h);
		answer += StringAdd('J', 'M', h);
		answer += StringAdd('A', 'N', h);

		return answer;
	}

	public String StringAdd(char fir, char sec, HashMap<Character, Integer> h) {
		if (h.get(fir) < h.get(sec)) {
			return String.valueOf(sec);
		} else {
			return String.valueOf(fir);
		}
	}
}



public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		System.out.println(sol.solution(survey, choices));
	}
}


// 1 ~ 7


// 두개씩 1 ~ 3, 5 ~ 7