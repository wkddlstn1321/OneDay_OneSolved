package 금과은운반하기;

public class Main {
	public static void main(String args[]) {
		System.out.println(solution(10, 10, new int[] { 100 }, new int[] { 100 }, new int[] { 7 }, new int[] { 10 }));
	}

	public static boolean isAvailable(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
		boolean available = false;
		long gold = 0;
		long silver = 0;
		long total = 0;
		for (int i = 0; i < g.length; i++) {
			long cnt = time / t[i] * 2;
			if (time % (t[i] * 2) >= t[i])
				cnt++;
			long temp = Math.min(cnt * w[i], g[i] + s[i]);
			total += temp;
			gold += Math.min(temp, g[i]);
			silver += Math.min(temp, s[i]);
		}
		if (gold >= a && silver >= b && total >= a + b)
			available = true;
		return available;
	}

	public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
		long answer = -1;
		long Maxtime = (long) Math.pow(10, 9) * 2 * (long) Math.pow(10, 5) * 2;
		long mid;
		long start = 0;
		while (start + 1 < Maxtime) {
			mid = (start + Maxtime) / 2;
			if (isAvailable(mid, a, b, g, s, w, t))
				Maxtime = mid;
			else
				start = mid;
		}
		answer = Maxtime;
		return answer;
	}
}

// 시간이 주어졌을 때 해당 시간안에 운반이 가능한지 구하는 로직
// 1.골드에 개수
// 2.실버에 개수
// 3.골드에 운반할 수 있는 무게
// 4.실버에 운반할 수 있는 무게
// 5.골드에 운반하는데 걸리는 시간
// 6.실버에 운반하는데 걸리는 시간