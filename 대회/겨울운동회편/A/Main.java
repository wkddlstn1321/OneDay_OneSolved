package 대회.겨울운동회편.A;

import java.util.*;

public class Main {
	static int maxValue = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n == 1 && m == 1) {
			System.out.println(1);
			return;
		}

		int maxSize = n * m;
		int cnt = maxSize / 3;
		int tCnt = maxSize % 3 == 2 ? 1 : 0;
		boolean check = maxSize % 3 == 1;
		int happy = 1;
		if (check) {
			cnt--;
			tCnt++;
		}
		for (int i = 0; i < cnt; i++) {
			happy *= 3;
			if (happy > maxValue)
				happy %= maxValue;
		}
		for (int i = 0; i < tCnt; i++) {
			happy *= 2;
			if (happy > maxValue)
				happy %= maxValue;
		}
		System.out.println(happy);
	}
}
