package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * 백준 1011, Fly me to the Alpha Centauri, 골드 5
 */
public class BOJ1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s= y-x;
			int j = (int)Math.sqrt(s);

			if(j*j == s) {
				System.out.println(2*j-1);
			} else if(j*j+j >= s) {
				System.out.println(2*j);
			} else {
				System.out.println(2*j+1);
			}
		}
	}
}
