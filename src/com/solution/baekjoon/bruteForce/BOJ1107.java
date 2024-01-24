package com.solution.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1043, 거짓말, 골드 4
 */
public class BOJ1107 {
	static int n, m;
	static List<Integer> breakButton;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		breakButton = new ArrayList<>();
		if(m!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				breakButton.add(Integer.parseInt(st.nextToken()));
			}
		}

		min = Math.min(min, Math.abs(n-100));
		if(!breakButton.contains(0)) {
			min = Math.min(min, Math.abs(n)+1);
		}

		for(int i=1; i<=999999; i++) {
			if(checkButton(i)) {
				min = Math.min(min, Math.abs(n-i)+String.valueOf(i).length());
			}
		}
		System.out.println(min);
	}
	public static boolean checkButton(int x) {
		while(x>0) {
			int num = x%10;
			if(breakButton.contains(num)) {
				return false;
			}
			x/=10;
		}
		return true;
	}
}
