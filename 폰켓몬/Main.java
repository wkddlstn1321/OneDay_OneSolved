//HashSet 을 이용하면 간단하게 해결 가능
package 폰켓몬;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		System.out.println(solution(new int[] {3, 1, 2, 3}));
	}
	public static int solution(int[] nums) {
        int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0 ; i < nums.length ; i++) {
			set.add(nums[i]);
		}
		if (set.size() > nums.length / 2)
			answer = nums.length / 2;
		else
			answer = set.size();
        return answer;
    }
}
