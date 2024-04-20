package com.solution.inflearn.시뮬레이션;

import java.util.Arrays;

public class INF2 {
	static int[] sx = {1, 0, -1, 0};
	static int[] sy = {0, 1, 0, -1};
	static int cx = 0, cy = 0, d = 0;
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2];

		for(int i=0; i<k; i++) {
			dfs(cx, cy, board);
		}

		answer[0] = cy;
		answer[1] = cx;
		return answer;
	}

	public void dfs(int x, int y, int[][] board) {
		int n = board.length;
		int dx = x + sx[d];
		int dy = y + sy[d];

		if (dx<0 || dy<0 || dx>=n || dy>=n || board[dy][dx]==1) {
			d = (d+1)%4;
		} else {
			cx = dx;
			cy = dy;
		}

	}

	public static void main(String[] args){
		INF2 T = new INF2();
		// int[][] arr1 = {{0, 0, 0, 0, 0},
		// 	{0, 1, 1, 0, 0},
		// 	{0, 0, 0, 0, 0},
		// 	{1, 0, 1, 0, 1},
		// 	{0, 0, 0, 0, 0}};
		// System.out.println(Arrays.toString(T.solution(arr1, 10)));
		// int[][] arr2 = {{0, 0, 0, 1, 0, 1},
		// 	{0, 0, 0, 0, 0, 0},
		// 	{0, 0, 0, 0, 0, 1},
		// 	{1, 1, 0, 0, 1, 0},
		// 	{0, 0, 0, 0, 0, 0},
		// 	{0, 0, 0, 0, 0, 0}};
		// System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0},
			{0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}
