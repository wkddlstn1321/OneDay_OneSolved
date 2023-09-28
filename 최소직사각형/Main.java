package 최소직사각형;

public class Main {
	public static void main(String args[]) {
		int sizes[][] = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
	}
	public static int solution(int[][] sizes) {
		int xMax, yMax, longSide, shortSide;
		xMax = 0;
		yMax = 0;
		for (int i = 0 ; i < sizes.length ; i++) {
			longSide = Math.max(sizes[i][0], sizes[i][1]);
			shortSide = Math.min(sizes[i][0], sizes[i][1]);
			xMax = Math.max(xMax, longSide);
			yMax = Math.max(yMax, shortSide);
		}
		return xMax * yMax;
	}
}
