package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1707 이분 그래프, 골드 4
 */
public class BOJ1707 {
	static ArrayList<ArrayList<Integer>> list;
	static int[] apex;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int V, E;
		for (int a=0; a<k; a++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());


			apex = new int[V+1];
			list = new ArrayList<>();
			for(int i=0; i<=V; i++) {
				list.add(new ArrayList<>());
			}

			int x, y;
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				list.get(x).add(y);
				list.get(y).add(x);
			}

			for(int i=1; i<=V; i++) {
				if(apex[i]==0) {
					dfs(i, 1);
				}
			}

			boolean check = true;
			for(int i=1; i<=V; i++) {
				for(int z : list.get(i)) {
					if(apex[i]==apex[z]) check = false;
				}
			}

			if (check)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	public static void dfs(int x, int c) {
		apex[x] = c;
		for(int i : list.get(x)) {
			if(apex[i]==0) {
				dfs(i, c*-1);
			}
		}
	}

}

