package com.solution.baekjoon.dfsbfs;

/**
 * 백준 7562 나이트의 이동, 실버 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
	static int[][] map;
	static int[] sy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] sx = {1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for(int k=0; k<t; k++) {
			int l = Integer.parseInt(br.readLine());
			map = new int[l][l];


			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());


			Queue<Integer> q = new LinkedList<>();
			q.add(x1);
			q.add(y1);

			while(!q.isEmpty()) {
				int x = q.poll();
				int y = q.poll();

				if(y==y2 && x==x2) {
					System.out.println(map[y2][x2]);
					break;
				}

				for(int i=0; i<8; i++) {
					int dy = y + sy[i];
					int dx = x + sx[i];

					if(dx<0 || dy<0 || dx>=l || dy>=l) continue;

					if(map[dy][dx]==0) {
						map[dy][dx] = map[y][x] + 1;
						q.add(dx);
						q.add(dy);
					}
				}
			}
		}
	}
}
