package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};

	public static class Node {
		int z, x, y, cnt;

		public Node(int z, int x, int y, int cnt) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(l==0 && r==0 && c==0) {
				break;
			}

			String[][][] building = new String[l][r][c];


			Queue<Node> queue = new LinkedList<>();
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					String[] s = br.readLine().split("");
					for(int k=0; k<c; k++) {
						building[i][j][k] = s[k];
						if(building[i][j][k].equals("S")) {
							queue.add(new Node(i, j, k, 0));
							building[i][j][k] = "#";
						}
					}
				}
				br.readLine();
			}

			boolean check = false;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				boolean end = false;

				int nz, nx, ny;
				for(int i=0; i<6; i++) {
					nz = node.z + dz[i];
					nx = node.x + dx[i];
					ny = node.y + dy[i];

					if(nz<0 || nx<0 || ny<0 || nz>=l || nx>=r || ny>=c) continue;

					if (building[nz][nx][ny].equals(".")){
						building[nz][nx][ny] = "#";
						queue.add(new Node(nz, nx, ny, node.cnt+1));
					} else if (building[nz][nx][ny].equals("E")) {
						check = true;
						end = true;
						System.out.println("Escaped in "+ (node.cnt+1) +" minute(s).");
						break;
					}
				}
				if(end) {
					break;
				}
			}
			if(!check) {
				System.out.println("Trapped!");
			}
		}
	}
}
