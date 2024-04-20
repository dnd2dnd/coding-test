package com.solution.inflearn.시뮬레이션;


public class INF3 {
	static int[] sy = {-1, 0, 1, 0};
	static int[] sx = {0, 1, 0, -1};
	static int[] hyunSu;
	static int cd = 0, dogd=0, t = 0, cx, cy, dogx, dogy;
	public int solution(int[][] board){
		hyunSu = findUser(board);
		cy = hyunSu[0];
		cx = hyunSu[1];
		dogy = hyunSu[2];
		dogx = hyunSu[3];

		while(true) {
			t++;
			if(cy == dogy && cx == dogx) {
				return t;
			}

			if(t == 10000) {
				return 0;
			}
			dfs(cx, cy, 0, cd, board);
			dfs(dogx, dogy, 1, dogd, board);
		}
	}

	public void dfs(int x, int y, int t, int d, int[][] board) {
		int dy = y + sy[d];
		int dx = x + sx[d];

		if (dx<0 || dy<0 || dx>=10 || dy>=10 || board[dy][dx]==1) {
			if(t==0) {
				cd = (cd+1)%4;
			} else if(t==1) {
				dogd = (dogd+1)%4;
			}
		} else {
			if(t==0) {
				cy = dy;
				cx = dx;
			} else if(t==1) {
				dogy = dy;
				dogx = dx;
			}
		}
	}

	public int[] findUser(int[][] board) {
		int[] f = new int[4];
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if(board[y][x] == 2) {
					f[0] = y;
					f[1] = x;
					return f;
				} else if(board[y][x] == 3) {
					f[3] = y;
					f[4] = x;
				}
			}
		}
		return null;
	}



	public static void main(String[] args){
		INF3 T = new INF3();
		// int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		// 	{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		// 	{0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
		// 	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		// 	{0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
		// 	{1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		// 	{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		// 	{0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
		// 	{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
		// 	{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
		// System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
		System.out.println(T.solution(arr2));
	}
}
