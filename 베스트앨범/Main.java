package 베스트앨범;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		System.out.println(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
	}
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		// 0 재생횟수 top, 1 재생횟수 sec , 2 총합
		HashMap<String, int[]> map = new HashMap<>();
		for (int i = 0 ; i < genres.length ; i++) {
			if (map.containsKey(genres[i])) {
				int[] playList = map.get(genres);
				if (playList[0] < plays[i]) {
					if (playList[1] != 0)
						playList[1] = playList[0];
					playList[0] = plays[i];
				} else if (playList[1] < plays[i]) {
					playList[1] = plays[i];
				}
				playList[2] += plays[i];
				map.put(genres[i], playList);
			} else {
				int []playList = new int[3];
				playList[0] = plays[i];
				playList[1] = 0;
				playList[2] = plays[i];
				map.put(genres[i], playList);
			}
		}
		List<String> KeySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o1)));
		return answer;
	}
}
