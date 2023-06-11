package com.solution.donbin.탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : 미로탈출
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class 미로탈출 {
	static int n;
	static int m;
	static int[][] map = new int[1000][1000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		int x;
		int y;
		int dx;
		int dy;
		int[] stepX = {1, -1, 0, 0};
		int[] stepY = {0, 0, 1, -1};
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			map[x][y]=0;
			for(int i=0; i<4;i++) {
				dx = x + stepX[i];
				dy = y + stepY[i];

				if (dx<0 || dy<0 || dx>=n || dy>=m || map[dx][dy] == 0) continue;

				if (map[dx][dy] == 1) {
					map[dx][dy] = map[x][y] + 1;
					q.add(dx);
					q.add(dy);
				}
			}
		}
		System.out.println(map[n-1][m-1]);
	}
}
