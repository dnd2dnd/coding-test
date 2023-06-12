package com.solution.baekjoon.dfsbfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 7576 토마토, 골드 5
 */
public class BOJ7576 {
	static int[][] map = null;
	static int[] sx = {1, -1, 0, 0};
	static int[] sy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		ArrayList<Integer> list = new ArrayList<>();
		int v;
		int zeroCnt=0;
		for(int i=0; i<n; i++) {
			String[] str = sc.nextLine().split(" ");
			for(int j=0; j<m; j++) {
				v = Integer.parseInt(str[j]);
				map[i][j] = v;
				if(v == 1) {
					list.add(i);
					list.add(j);
				}
				if(v==0){
					zeroCnt++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<list.size(); i+=2) {
			q.add(list.get(i));
			q.add(list.get(i+1));
			map[list.get(i)][list.get(i+1)]=1;
		}
		int cnt=0;
		while(!q.isEmpty()) {
			boolean b = false;
			int size = q.size();
			for(int s=0; s<size; s+=2) {
				int y = q.poll();
				int x = q.poll();

				for(int i=0; i<4; i++) {
					int dy = y + sy[i];
					int dx = x + sx[i];

					if(dx<0 || dy<0 || dx>=m || dy>=n ) continue;

					if(map[dy][dx]==0) {
						q.add(dy);
						q.add(dx);
						map[dy][dx] = 1;
						b = true;
						zeroCnt--;
					}
				}
			}
			if(b) cnt+=1;
		}

		if(zeroCnt>0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}
}
