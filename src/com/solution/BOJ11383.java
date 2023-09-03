package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11383, 뚊, 브론즈 1
 */
public class BOJ11383 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] word = new char[n][m];
		for(int i=0; i<n; i++) {
			word[i] = br.readLine().toCharArray();
		}
		String x;
		String answer = "Eyfa";
		for(int i=0; i<n; i++) {
			x = br.readLine();
			StringBuffer sb = new StringBuffer();
			for(int j=0; j< word[i].length; j++) {
				sb.append(word[i][j]);
				sb.append(word[i][j]);
			}
			if(!sb.toString().equals(x)) {
				answer = "Not Eyfa";
				break;
			}
		}
		System.out.println(answer);
	}
}
