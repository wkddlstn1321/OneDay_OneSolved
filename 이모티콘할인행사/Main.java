package 이모티콘할인행사;

import java.util.*;

class Solution {
	public int subscriber = 0;
	public int amount = 0;
	public int[] sales = {1,2,3,4};
	public int[] curSaleState;
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2];
		curSaleState = new int[emoticons.length];
		dfs(users, emoticons, 0);
		answer[0] = subscriber;
		answer[1] = amount;
		return answer;
	}

	public void dfs(int[][] users, int[] emoticons, int idx) {
		if (idx == emoticons.length) {
			cal(users, emoticons);
			return ;
		}
		for (int sale : sales) {
			int temp = emoticons[idx];
			emoticons[idx] -= emoticons[idx] / 10 * sale;
			curSaleState[idx] = sale * 10;
			dfs(users, emoticons, idx + 1);
			emoticons[idx] = temp;
		}
	}

	public void cal(int[][] users, int[] emoticons) {
		int sum = 0;
		int sub = 0;
		for (int i = 0 ; i < users.length ; i++) {
			int pay = 0;
			for (int j = 0 ; j < emoticons.length ; j++) {
				if (users[i][0] <= curSaleState[j]) {
					pay += emoticons[j];
				}
			}
			if (pay >= users[i][1])
				sub++;
			else
				sum += pay;
		}
		if (sub >= subscriber) {
			if (sub == subscriber)
			amount = amount > sum ? amount : sum;
			else {
				subscriber = sub;
				amount = sum;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		// int[][] users = {{40, 10000}, {25, 10000}};
		int[][] users = { { 40, 2900} , { 23, 10000} , { 11, 5200} , { 5, 5900} , { 40, 3100} , { 27, 9200} , { 32, 6900} }; 
		// int[] emoticons = {7000, 9000};
		int[] emoticons = {1300, 1500, 1600, 4900};
		int[] sol = s.solution(users, emoticons);
		System.out.println(sol[0] + " " + sol[1]);
	}
}
// 10 10 / 10 20 / 10 30 / 10 40
// 20 10 / 20 20 / 20 30 / 20 40
// 30 10 /30 20 / 30 30 / 30 40 
// 40 10 /40 20 / 40 30 / 40 40
// 1순위 이모티콘 플로스 가입자가 가장 높은 경우를 찾는다
// 2순위 가입자가 같은 경우 매출액이 높은 경우를 초이스

// 재귀
// 할인률 경우의 수를 전부 구하면 됨
// 할인률 경우의 수를 전부 구하는 방법
// 
// 완탐 4^7 * 100 * 7