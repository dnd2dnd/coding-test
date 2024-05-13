package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int m = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(x, 0)).append(" ");
		}
		System.out.println(sb);
	}
}
