package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  백준 4963, 섬의 개수, 실버 2
 */
public class BOJ4963 {
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if(w==0 && h==0) break;

			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int nx, ny;
			for(int i=0; i<8; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if(nx<0 || ny<0 || nx>=h || ny>=w) continue;

				if(!visited[nx][ny] && map[nx][ny] == 1) {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}

// import java.io.BufferedReader;
// 	import java.io.IOException;
// 	import java.io.InputStreamReader;
// 	import java.util.LinkedList;
// 	import java.util.Queue;
// 	import java.util.StringTokenizer;
//
// public class Main {
// 	public static class Node {
// 		int x, y;
//
// 		public Node(int x, int y) {
// 			this.x = x;
// 			this.y = y;
// 		}
// 	}
// 	static int w, h;
// 	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
// 	static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
// 	static int[][] map;
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		while(true) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			w = Integer.parseInt(st.nextToken());
// 			h = Integer.parseInt(st.nextToken());
//
// 			if(w==0 && h==0) break;
//
// 			map = new int[h][w];
//
// 			for(int i=0; i<h; i++) {
// 				st = new StringTokenizer(br.readLine());
// 				for(int j=0; j<w; j++) {
// 					map[i][j] = Integer.parseInt(st.nextToken());
// 				}
// 			}
//
// 			int sum = 0;
// 			for(int i=0; i<h; i++) {
// 				for(int j=0; j<w; j++) {
// 					if(map[i][j]==1) {
// 						map[i][j]=0;
// 						dfs(i, j);
// 						sum++;
// 					}
// 				}
// 			}
// 			System.out.println(sum);
// 		}
// 	}
//
// 	public static void dfs(int x, int y) {
// 		int nx, ny;
// 		for(int i=0; i<8; i++) {
// 			nx = x + dx[i];
// 			ny = y + dy[i];
//
// 			if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny]==0) continue;
//
// 			map[nx][ny]=0;
// 			dfs(nx, ny);
// 		}
// 	}
// }
