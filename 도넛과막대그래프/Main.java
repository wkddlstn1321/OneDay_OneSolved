package 도넛과막대그래프;

import java.util.*;

class Solution {
	int[] inNode;
	int[] outNode;
	public int[] solution(int[][] edges) {
		int[] answer = new int[4];
		inNode = new int[edges.length + 2];
		outNode = new int[edges.length + 2];
		int rootNode = findRootNode(edges);
		answer[0] = rootNode;

		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = 0 ; i < edges.length ; i++) {
			h.put(edges[i][0], edges[i][1]);
		}
		for (int i = 0 ; i < edges.length ; i++) {
			if (edges[i][0] == rootNode) {
				int startNode = edges[i][1];
				int currNode = startNode;
				while (true) {
					if (outNode[currNode] > 1) {
						answer[3]++;
						break ;
					}
					if (!h.containsKey(currNode)) {
						answer[2]++;
						break;
					}
					int value = h.get(currNode);
					if (value == startNode) {
						answer[1]++;
						break;
					}
					currNode = value;
				}
			}
		}
		return answer;
	}

	public int findRootNode(int[][] edges) {
		int rootNode = 0;
		
		for (int[] i : edges) {
			inNode[i[1]]++;
			outNode[i[0]]++;
		}

		for (int i = 1 ; i < edges.length + 1; i++) {
			if (inNode[i] == 0 && outNode[i] > 1) {
				rootNode = i;
			}
		}
		return rootNode;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int [][]edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8} };
		System.out.println(Arrays.toString(sol.solution(edges)));
	}
}
