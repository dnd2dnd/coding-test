package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int z=0;
		int f=0;
		int now = s.charAt(0) - '0';
		if(now == 0) {
			z++;
		} else {
			f++;
		}

		for(int i=1; i<s.length(); i++) {
			int x = s.charAt(i) - '0';
			if(now == 0) {
				if(x != 0) {
					f++;
					now = 1;
				}
			} else {
				if(x != 1) {
					z++;
					now = 0;
				}
			}
		}

		System.out.println(Math.min(z, f));
	}
}
