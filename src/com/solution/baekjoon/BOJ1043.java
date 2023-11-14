package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1043, 거짓말, 골드 4
 */
public class BOJ1043 {
	static int[] parent;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}

		check = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		if(A>0) {
			for(int i=0; i<A; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0; j<a; j++) {
				int k = Integer.parseInt(st.nextToken());
				list.get(i).add(k);
				temp.add(k);
			}

			for(int j=0; j < temp.size()-1; j++) {
				union(temp.get(j), temp.get(j+1));
			}
		}

		for(int i=1; i<=n; i++) {
			if(check[i]) {
				check[find(i)] = true;
			}
		}

		int cnt = 0;
		for(int i=0; i<m; i++) {
			boolean b = false;
			for (Integer j : list.get(i)) {
				if(check[find(j)]) {
					b = true;
					break;
				}
			}
			if(!b) cnt++;
		}

		System.out.println(cnt);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x==y) return;
		parent[y] = x;

	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}
