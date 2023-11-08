package 모음사전;

public class Main {
	public static int cnt = 0;
	public static String[] words = {"A", "E", "I", "O", "U"};
	public static Boolean flag = false;
	public static void main(String args[]) {
		System.out.println(solution("AAAAE"));
	}

	public static void dfs(String word, String str) {
		if (word.equals(str)) {
			flag = true;
			return ;
		}
		if (flag)
			return ;
		if (str.length() == 5) {
			cnt++;
			return ;
		}
		cnt++;
		for (int i = 0 ; i < words.length ; i++) {
			dfs(word, str + words[i]);
		}
	}

	public static int solution(String word) {
		int answer = 0;
		dfs(word, "");
		answer = cnt;
		return answer;
	}
}
