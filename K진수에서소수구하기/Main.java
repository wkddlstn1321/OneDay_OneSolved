package K진수에서소수구하기;

import java.util.*;

// 1. 진법 변환기 만들기
// 2. 0을 기준으로 스플릿
// 3. 소수 찾기
//  소수 찾는 2가지 방법
//	1. 에라토스테네스의 체
//  2. 하나씩 직접 검증
class Solution {
	public int solution(int n, int k) {
		int answer = 0;
		String kN = convertK(n, k);
		ArrayList<Long> numbers = getNumbers(kN);
		for (int i = 0; i < numbers.size(); i++) {
			if (isPrime(numbers.get(i)))
				answer++;
		}
		return answer;
	}

	//진법 변환
	public String convertK(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.insert(0, n % k);
			n /= k;
		}
		return sb.toString();
	}
	
	//진법 변환된 문자열 정수로 파싱
	public ArrayList<Long> getNumbers(String kN) {
		String[] numberSplit = kN.split("0");
		int size = numberSplit.length;
		ArrayList<Long> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (numberSplit[i].equals(""))
			continue;
			numbers.add(Long.parseLong(numberSplit[i]));
		}
		return numbers;
	}

	//소수 판별
	public boolean isPrime(Long nb) {
		long i = 2;
		if (nb == 1)
			return false;
		while (i * i <= nb) {
			if (nb % i == 0)
				return false;
			i++;
		}
		return true;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 110011;
		int k = 10;
		System.out.println(sol.solution(n, k));
	}
}
