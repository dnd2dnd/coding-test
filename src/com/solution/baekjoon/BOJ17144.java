package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 17144, 미세먼지 안녕!, 골드 4
 */
public class BOJ17144 {
	static int r, c, t;
	static int cleaner;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		cleaner = -1;
		int[][] maps = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if(maps[i][j]==-1 && cleaner == -1) {
					cleaner = i;
				}
			}
		}
		rec(0, maps);
	}
	public static void rec(int s, int[][] maps) {
		if(s==t) {
			int sum = 0;
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(maps[i][j]>=1) {
						sum += maps[i][j];
					}
				}
			}
			System.out.println(sum);
			return;
		}
		int[][] temp = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				int v = maps[i][j];
				if(v==-1) {
					temp[i][j] = v;
					continue;
				}
				int q = v/5;
				int cnt = 0;
				int nx, ny;
				for(int k=0; k<4; k++) {
					nx = i + dx[k];
					ny = j + dy[k];

					if(nx<0 || ny<0 || nx>=r || ny>=c || maps[nx][ny]==-1) continue;

					cnt++;
					temp[nx][ny] += q;
				}
				temp[i][j] += (v - q*cnt);
			}
		}

		rec(s+1, airClear(temp));
	}
	public static int[][] airClear(int[][] temp) {
		int x = cleaner;

		for(int i=x-1; i>0; i--) {
			temp[i][0] = temp[i-1][0];
		}
		for(int i=0; i<c-1; i++) {
			temp[0][i] = temp[0][i+1];
		}
		for(int i=0; i<x; i++) {
			temp[i][c-1] = temp[i+1][c-1];
		}
		for(int i=c-1; i>1; i--) {
			temp[x][i] = temp[x][i-1];
		}
		temp[x][1] = 0;

		for(int i=x+2; i<r-1; i++) {
			temp[i][0] = temp[i+1][0];
		}
		for(int i=0; i<c-1; i++) {
			temp[r-1][i] = temp[r-1][i+1];
		}
		for(int i=r-1; i>x+1; i--) {
			temp[i][c-1] = temp[i-1][c-1];
		}
		for(int i=c-1; i>1; i--)
			temp[x+1][i] = temp[x+1][i-1];
		temp[x+1][1] = 0;


		return temp;
	}
}
