package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int l, c;
	static String[] alpha;
	static boolean[] visited;
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		alpha = br.readLine().split(" ");
		visited = new boolean[26];

		dfs(0, 0);
		Collections.sort(list);
		for (String s : list) {
			System.out.println(s);
		}
	}
	public static void dfs(int x, int d) {
		if(d==l) {
			int m=0, n=0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					if(i==0 || i==4 || i==8 || i==14 || i==20) {
						m++;
					} else {
						n++;
					}
					sb.append((char) (i+97));
				}
			}
			if(m>=1 && n>=2) {
				list.add(sb.toString());
			}
			return;
		}

		for(int i=x; i<c; i++) {
			if(!visited[alpha[i].charAt(0)-'a']) {
				visited[alpha[i].charAt(0)-'a'] = true;
				dfs(i+1, d+1);
				visited[alpha[i].charAt(0)-'a'] = false;
			}
		}
	}
}
