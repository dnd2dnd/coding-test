package com.solution.baekjoon.dfsbfs;

/**
 * 백준 2636 지츠, 골드 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
	static int m, n;
	static int[][] space;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int X, Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		space = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j]==0){
					X=i;
					Y=j;
				}
			}
		}
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		while(true) {
			int cheese = 0;
			if(!airBfs(X, Y)){
				break;
			}
			boolean[][] check = new boolean[m][n];

			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(!check[i][j]) {
						cheese+=cheeseDfs(i, j, check);
					}
				}
			}
			list.add(cheese);
			// System.out.println();
			cnt++;
		}
		System.out.println(cnt-1);
		System.out.println(list.get(list.size()-2));
	}

	public static int cheeseDfs(int x, int y, boolean[][] check) {
		check[x][y] = true;
		int sx, sy;
		int cheese = 0;
		for(int i=0; i<4; i++) {
			sx = x + dx[i];
			sy = y + dy[i];

			if(sx<0 || sy<0 || sx>=m || sy>=n) continue;

			if(space[x][y]==1 && space[sx][sy]==2) {
				cheese++;
				space[x][y] = 0;
			}

			// if(!check[sx][sy]) {
			// 	check[sx][sy]=true;
			// }
		}
		return cheese;
	}

	public static boolean airBfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		boolean[][] check = new boolean[m][n];
		boolean b = false;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int sx, sy;
			for (int i=0; i<4; i++) {
				sx = node.x + dx[i];
				sy = node.y + dy[i];

				if(sx<0 || sy<0 || sx>=m || sy>=n) continue;

				if(!check[sx][sy] & space[sx][sy]!=1) {
					queue.add(new Node(sx, sy));
					check[sx][sy]=true;
					if(space[sx][sy]==0) {
						space[sx][sy] = 2;
						b = true;
					}
				}
			}
		}
		// for(int i=0; i<m; i++) {
		//    for(int j=0; j<n; j++) {
		//       System.out.print(space[i][j]+" ");
		//    }
		//    System.out.println();
		// }
		// System.out.println();
		return b;

	}
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void cheeseBfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		boolean[][] check = new boolean[m][n];
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int sx, sy;
			boolean b = false;
			for(int i=0; i<4; i++) {
				sx = node.x + dx[i];
				sy = node.y + dy[i];

				if(sx<0 || sy<0 || sx>=m || sy>=n) continue;

				if(space[node.x][node.y]==1 && space[sx][sy]==2) {
					b = true;
				}

				if(!check[sx][sy]) {
					queue.add(new Node(sx, sy));
					check[sx][sy]=true;
				}
			}
			if(b) {
				space[node.x][node.y] = 0;
				X = node.x;
				Y = node.y;
			}

		}
		// for(int i=0; i<m; i++) {
		// 	for(int j=0; j<n; j++) {
		// 		System.out.print(space[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }
	}
}