package n더하기1카드게임;

//규칙
//1. 시작 소유 카드는 n/3장
//2. 라운드 시작시 카드 2장식 뽑고 동전을 소모해 얻거나 버림
//3. 카드 2장의 합이 n + 1 이면 사용하고 다음 라운드로 진행 가능
//4. 카드를 더 이상 뽑을 수 없으면 종료
//5. n+1을 만들 수 없으면 종료

// 그리디 가능?

// 2장을 소모하는 것이기 때문에 지금 만들 수 있으면 바로 내버리는게 이득
// 뽑은 카드를 소유 할지 말지를 정하는게 포인트

// 뽑은 카드를 버리지 않고 소유할 근거를 어떻게 찾을까?
// 소유할 이유를 찾을 필요가 있을까?
// 실제로 버리지 않고 계속 keep해 놓고 필요할 때마다 사서 쓰는 식으로

// 문제점

// 더 적은 코인으로 완성할 수 있는걸 찾아야 함
// 라운드당 제출할 수 있는 방법이 없을때만 코인을 사용하자
// 코인을 쓰는 경우
// 리스트에서 하나 찾기
// 리스트에서 두 개 찾기

import java.util.*;

class Solution {
	int curIdx;
	int gCoin;
	ArrayList<Integer> userCards;
	ArrayList<Integer> cardStore;
	public int solution(int coin, int[] cards) {
		int answer = 0;
		int n = cards.length;
		gCoin = coin;
		curIdx = n / 3;
		userCards = new ArrayList<>();
		cardStore = new ArrayList<>();
		for (int i = 0; i < curIdx; i++) {
			userCards.add(cards[i]);
		}
		while (true) {
			answer++;
			if (curIdx + 2 > n)
				break;
			for (int i = curIdx; i < curIdx + 2; i++) {
				cardStore.add(cards[i]);
			}
			if (!isExistTarget(n + 1)) {
				break;
			}
			curIdx += 2;
		}
		return answer;
	}

	public boolean isExistTarget(int target) {
		// 코인을 안쓰는 경우
		boolean oneCoinCase = false;
		int sCardTemp = 0;
		for (int i : userCards) {
			int complement = target - i;
			if (userCards.contains(complement)) {
				userCards.remove(userCards.indexOf(i));
				userCards.remove(userCards.indexOf(complement));
				return true;
			}
			if (cardStore.contains(complement)) {
				oneCoinCase = true;
				sCardTemp = complement;
			}
		}
		// 한 장만 사도 되는 경우
		if (gCoin < 1)
			return false;
		if (oneCoinCase) {
			cardStore.remove(cardStore.indexOf(sCardTemp));
			userCards.remove(userCards.indexOf(target - sCardTemp));
			gCoin--;
			return true;
		}

		// 두 장을 사야 하는 경우
		if (gCoin < 2)
			return false;
		for (int i : cardStore) {
			int complement = target - i;
			if (cardStore.contains(complement)) {
				cardStore.remove(cardStore.indexOf(i));
				cardStore.remove(cardStore.indexOf(complement));
				gCoin -= 2;
				return true;
			}
		}
		return false;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int coin = 2;
		int[] card = { 5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7 };
		System.out.println(sol.solution(coin, card));
	}
}
