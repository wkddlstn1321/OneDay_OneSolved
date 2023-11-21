package 공원산책;

public class Main {
	public static void main(String[] args) {

	}

	public static int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		int posX = 0, posY = 0;
		char target;
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				target = park[i].charAt(j);
				if (target == 'S') {
					posX = j;
					posY = i;
					break;
				}
			}
		}

		for (int i = 0; i < routes.length; i++) {
			char dir = routes[i].charAt(0);
			int dis = routes[i].charAt(2) - 48;
			if (dir == 'N') {
				if (posY - dis < 0)
					continue;
				boolean check = false;
				for (int j = posY - dis; j <= posY; j++) {
					target = park[j].charAt(posX);
					if (target == 'X') {
						check = true;
						break;
					}
				}
				if (check)
					continue;
				posY -= dis;
			} else if (dir == 'S') {
				if (posY + dis >= park.length)
					continue;
				boolean check = false;
				for (int j = posY; j <= posY + dis; j++) {
					target = park[j].charAt(posX);
					if (target == 'X') {
						check = true;
						break;
					}
				}
				if (check)
					continue;
				posY += dis;
			} else if (dir == 'E') {
				if (posX + dis >= park[0].length())
					continue;
				int idx = park[posY].indexOf('X', posX);
				if (idx != -1 && idx <= posX + dis)
					continue;
				posX += dis;
			} else {
				if (posX - dis < 0)
					continue;
				int idx = park[posY].indexOf('X', posX - dis);
				if (idx != -1 && idx <= posX)
					continue;
				posX -= dis;
			}
		}

		answer[0] = posY;
		answer[1] = posX;
		return answer;
	}
}
