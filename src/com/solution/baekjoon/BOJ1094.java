package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int cnt = 0;
		String s = Integer.toBinaryString(x);
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) - '0' == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}