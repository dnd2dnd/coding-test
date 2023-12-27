package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 12101, 1, 2, 3 더하기 2, 실버 1
 * https://www.acmicpc.net/problem/11279
 */
public class BOJ12101 {
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		rec(0, n, "");
		if(k-1 > list.size()) {
			System.out.println(-1);
		} else {
			String ans = list.get(k-1);
			System.out.println(ans.substring(1));
		}
	}
	public static void rec(int x, int n, String s) {
		if(x==n) {
			list.add(s);
		}

		for(int i=1; i<=3; i++) {
			if(x+i<=n) {
				rec(x+i, n, s+"+"+i);
			}
		}
	}
}
