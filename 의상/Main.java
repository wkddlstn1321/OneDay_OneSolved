package 의상;

import java.util.*;

public class Main {
	public void main(String args[]) {
		String clothes[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}

	public int solution(String[][] clothes) {
        int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0 ; i < clothes.length ; i++) {
			if (map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			else
				map.put(clothes[i][1], 1);
		}
		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
        return answer - 1;
    }
}
