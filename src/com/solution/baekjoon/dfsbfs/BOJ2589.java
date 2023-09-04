package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2589, 보물섬, 골드5
 */
public class BOJ2589 {
	public static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	static String[][] map;
	static int l, w;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new String[l][w];

		for(int i=0; i<l; i++) {
			String[] strs = br.readLine().split("");
			for(int j=0; j<w; j++) {
				map[i][j] = strs[j];
			}
		}

		visited = new boolean[l][w];

		for(int i=0; i<l; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j].equals("L") && !visited[i][j]) {
					max = Math.max(max, bfs(i, j, 0));
					visited = new boolean[l][w];
				}
			}
		}
		System.out.println(max);
	}
	public static int bfs(int x, int y, int d) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, d));
		visited[x][y] = true;
		int answer = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(answer< node.d) {
				answer = node.d;
			}
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if(nx<0 || ny<0 || nx>=l || ny>=w) continue;

				if(map[nx][ny].equals("L") && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, node.d+1));
				}
			}
		}
		return answer;
	}

}

