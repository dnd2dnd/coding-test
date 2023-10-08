package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 15683, 감시, 골드 4
 */
public class BOJ15683 {
	public static class CCTV {
		int i, j, n;

		public CCTV(int i, int j, int n) {
			this.i = i;
			this.j = j;
			this.n = n;
		}

	}
	static int N, M, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		ArrayList<CCTV> cctvArrayList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {
					cctvArrayList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}

		dfs(0, map, cctvArrayList);
		System.out.println(min);
	}
	public static void dfs(int cnt, int[][] map, ArrayList<CCTV> cctvs) {
		if(cnt == cctvs.size()) {
			min = Math.min(min, checkBlock(map));
			return;
		}

		CCTV cctv = cctvs.get(cnt);
		int x = cctv.i;
		int y = cctv.j;
		int v = cctv.n;
		int[][] tmp;
		switch (v) {
			case 1:
				tmp = deepCopyMap(map);
				leftCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				rightCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				upCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				downCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);
				break;
			case 2:
				tmp = deepCopyMap(map);
				leftCheck(x, y, tmp);
				rightCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				upCheck(x, y, tmp);
				downCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);
				break;
			case 3:
				tmp = deepCopyMap(map);
				upCheck(x, y, tmp);
				rightCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				rightCheck(x, y, tmp);
				downCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				downCheck(x, y, tmp);
				leftCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				leftCheck(x, y, tmp);
				upCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);
				break;
			case 4:
				tmp = deepCopyMap(map);
				leftCheck(x, y, tmp);
				upCheck(x, y, tmp);
				rightCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				upCheck(x, y, tmp);
				rightCheck(x, y, tmp);
				downCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				rightCheck(x, y, tmp);
				downCheck(x, y, tmp);
				leftCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);

				tmp = deepCopyMap(map);
				downCheck(x, y, tmp);
				leftCheck(x, y, tmp);
				upCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);
				break;
			case 5:
				tmp = deepCopyMap(map);
				leftCheck(x, y, tmp);
				upCheck(x, y, tmp);
				rightCheck(x, y, tmp);
				downCheck(x, y, tmp);
				dfs(cnt+1, tmp, cctvs);
				break;
		}
	}

	public static void leftCheck(int x, int y, int[][] tmp) {
		for(int i=y-1; i>=0; i--) {
			if(tmp[x][i]==6) {
				break;
			} else if(tmp[x][i]==0) {
				tmp[x][i] = -1;
			}
		}
	}

	public static void rightCheck(int x, int y, int[][] tmp) {
		for(int i=y+1; i<M; i++) {
			if(tmp[x][i]==6) {
				break;
			} else if(tmp[x][i]==0) {
				tmp[x][i] = -1;
			}
		}
	}

	public static void upCheck(int x, int y, int[][] tmp) {
		for(int i=x-1; i>=0; i--) {
			if(tmp[i][y]==6) {
				break;
			} else if(tmp[i][y]==0) {
				tmp[i][y] = -1;
			}
		}
	}

	public static void downCheck(int x, int y, int[][] tmp) {
		for(int i=x+1; i<N; i++) {
			if(tmp[i][y]==6) {
				break;
			} else if(tmp[i][y]==0) {
				tmp[i][y] = -1;
			}
		}
	}

	public static int[][] deepCopyMap(int[][] map) {
		int[][]tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	public static int checkBlock(int[][] tmp) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tmp[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
