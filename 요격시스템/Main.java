import java.util.Arrays;

public class Main{
	public static void main(String args[]) {
		int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		System.out.println(solution(targets));
	}
	public static int solution(int[][] targets) {
		Arrays.sort(targets, (o1, o2) -> {
			return o1[1]-o2[1];
		});
		int e = targets[0][1];
		int answer = 1;
		for (int i = 1 ; i < targets.length ; i++) {
			if (targets[i][0] >= e) {
				answer++;
				e = targets[i][1];
			}
		}
		return answer;
	}
}


// 1 4 1
// 4 5 2
// 3 7 2
// 4 8 2
// 5 12 3
// 11 13 3
// 10 14 3





// 1 2 1
// 1 3 1
// 2 3 2
// 2 3 2
// 3 4 3
// 1 4 1
// 1 5 1
// 2 5 2
// 끝나는 시간을 기준으로 정렬
// 시작 시간을 기준으로 정렬
// 끝나는 시간 보다 시작 시간이 작은 녀석들 다 제거
// 반복
