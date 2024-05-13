package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		com(0, 0, new int[m]);
		System.out.println(sb);
	}
	public static void com(int x, int d, int[] temp) {
		if(d==m) {
			for(Integer i : temp) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0; i< arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[d] = arr[i];
				com(i+1, d+1, temp);
				visited[i] = false;
			}
		}
	}
}
