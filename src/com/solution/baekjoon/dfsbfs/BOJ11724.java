package com.solution.baekjoon.dfsbfs;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 백준 2667 연결 요소 개수, 실버 2
 */
public class BOJ11724 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] d = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
			d[i]=0;
		}

		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list.get(u).add(v);
			list.get(v).add(u);
		}

		int cnt=0;
		for(int i=1; i<=n; i++) {
			if(d[i]==0) {
				dfs(i);
				cnt+=1;
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int x) {
		d[x] = 1;
		for (Integer integer : list.get(x)) {
			if(d[integer]==0){
				dfs(integer);
			}
		}
	}
}
