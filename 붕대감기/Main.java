package 붕대감기;

// 몬스터 공격을 우선 확인
// 공격이 있으면 회복 로직은 스킵 (연속 성공 초기화)
// 공격이 없으면 회복 로직을 확인

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int maxTurn = attacks[attacks.length - 1][0];
		int maxHealth = health;
		int continRecover = 0;
		int j = 0;
		for (int i = 1 ; i <= maxTurn ; i++) {
			int currentAttack = attacks[j][0];
			if (i == currentAttack) {
				health -= attacks[j][1];
				if (health <= 0)
					return -1;
				continRecover = 0;
				j++;
			} else {
				continRecover++;
				health += bandage[1];
				if (continRecover == bandage[0]) {
					health += bandage[2];
					continRecover = 0;
				}
				if (health > maxHealth)
					health = maxHealth;
			}
		}
		return health;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] bandage = { 5, 1, 5 };
		int health = 30;
		int[][] attacks = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } };
		System.out.println(sol.solution(bandage, health, attacks));
	}
}
