package com.solution.donbin.탐색;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : 음료수얼려먹기
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class 음료수얼려먹기 {
	public static int[][] iceTools = new int[1000][1000];
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();

		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j<m; j++) {
				iceTools[i][j] = str.charAt(j) - '0';
			}
		}
		int cnt =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i, j)) {
					cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}

	public static boolean dfs(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=m) {
			return false;
		}

		if (iceTools[x][y] == 0) {
			iceTools[x][y] = 1;
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);

			return true;
		}
		return false;
	}
}
