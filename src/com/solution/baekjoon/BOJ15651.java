package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	static int n, m;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		com(0, new int[m]);
		System.out.println(sb);
	}
	public static void com(int d, int[] temp) {
		if(d==m) {
			for(Integer i : temp) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=1; i<=n; i++) {
			temp[d] = i;
			com(d+1, temp);
		}
	}
}
