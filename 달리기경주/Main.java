import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		String[] answer = solution(players, callings);
		for (int i = 0 ; i < answer.length ; i++) {
			System.out.println(answer[i]);
		}
	}
	public static String[] solution(String[] players, String[] callings) {
		HashMap<String, Integer>rank = new HashMap<String, Integer>();
		for (int i = 0 ; i < players.length ; i++) {
			rank.put(players[i], i);
		}
		for (int i = 0 ; i < callings.length ; i++) {
			int ranking = rank.get(callings[i]);
			String temp = players[ranking];
			players[ranking] = players[ranking - 1];
			players[ranking - 1] = temp;
			rank.put(players[ranking], ranking);
			rank.put(players[ranking - 1], ranking - 1);
		}
		return players;
	}
}
