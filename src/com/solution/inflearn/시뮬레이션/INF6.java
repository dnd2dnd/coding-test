package com.solution.inflearn.시뮬레이션;

public class INF6 {

	public class Node {
		int index, value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public int getValue() {
			return value;
		}
	}
	public Node getMin(int[] fruit) {
		int index = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < fruit.length; i++) {
			if(min > fruit[i]) {
				min = Math.min(min, fruit[i]);
				index = i;
			}
		}
		return new Node(index, min);
	}

	public int findMin(int[] fruit) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, fruit[i]);
		}

		return min;
	}

	public int solution(int[][] fruit){
		int answer = 0;
		int n = fruit.length;
		boolean[] check = new boolean[n];
		for(int i=0; i<n; i++) {
			Node user = getMin(fruit[i]);
			if(check[i]) continue;

			for(int j=i+1; j<n; j++) {
				Node friend = getMin(fruit[j]);
				if(check[j]) continue;

				if(user.index != friend.index && user.value > 0 && friend.value > 0) {
					if (fruit[i][user.index] + 1 <= fruit[i][friend.index] - 1 && fruit[j][friend.index] + 1 <= fruit[j][user.index] - 1) {
						fruit[i][user.index]++;
						fruit[i][friend.index]--;

						fruit[j][friend.index]++;
						fruit[j][user.index]--;

						check[i] = true;
						check[j] = true;
						break;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			answer += findMin(fruit[i]);
		}

		return answer;
	}

	public static void main(String[] args){
		INF6 T = new INF6();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}