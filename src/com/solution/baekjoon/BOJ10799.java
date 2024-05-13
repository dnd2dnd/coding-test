package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int cnt = 0;
		int barCnt = 0;
		for(int i=0; i<s.length(); i++) {
			char c =s.charAt(i);
			if(c == '(') {
				barCnt++;
			} else {
				barCnt--;
				if(s.charAt(i-1) == '(') {
					cnt += (barCnt);
				} else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
