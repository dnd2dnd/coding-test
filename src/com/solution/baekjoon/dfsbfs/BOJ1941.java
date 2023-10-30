package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 1941, 소문난 칠공주, 골드 3
 */
public class BOJ1941 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static String[][] map = new String[5][5];
	static boolean[] checked = new boolean[25];
	static int[] selected = new int[7];
	static int ans = 0;
	static public class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			String[] strs = br.readLine().split("");
			for(int j=0; j<5; j++) {
				map[i][j] = strs[j];
			}
		}

		com(0, 0);
		System.out.println(ans);
	}

	public static void com(int s, int d) {
		if(d==7) {
			if(bfs()) {
				ans++;
			}
			return;
		}

		for(int i=s; i<25; i++) {
			if(!checked[i]) {
				selected[d] = i;
				checked[i] = true;
				com(i+1, d+1);
				checked[i] = false;
			}
		}
	}

	public static boolean bfs() {
		int sc = 0;
		for (int i : selected) {
			if(map[i/5][i%5].equals("S")) sc++;
		}

		if(sc<4) {
			return false;
		}

		boolean[] temp = new boolean[25];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(selected[0]);
		int cnt = 1;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			temp[a] = true;
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = a/5 + dx[i];
				ny = a%5 + dy[i];

				if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;

				if(!temp[5*nx+ny] && checked[5*nx+ny]) {
					temp[5*nx+ny] = true;
					queue.add(5*nx+ny);
					cnt++;
				}
			}
		}
		return cnt == 7;
	}
}
