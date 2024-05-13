package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ15723 {
	static boolean find = false;
	static boolean[] visited = new boolean[27];
	static Map<String, List<String>> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<=26; i++) {
			map.put(String.valueOf((char) (97+i)), new ArrayList<>());
		}

		for(int i=0; i<n; i++) {
			String[] strs = br.readLine().split(" ");
			map.get(strs[0]).add(strs[2]);
		}

		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			String[] strs = br.readLine().split(" ");
			find(strs[0], strs[2]);
			if(find) {
				System.out.println("T");
			} else {
				System.out.println("F");
			}
			find = false;
		}

	}
	public static void find(String start, String end) {
		if(start.equals(end)) {
			find = true;
			return;
		}

		for (String s : map.get(start)) {
			int x = (int)s.charAt(0) - 97;
			if(!visited[x]) {
				visited[x] = true;
				find(s, end);
				visited[x] = false;
			}
		}
	}
}
