package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 12904, A와 B, 골드 5
 */
public class BOJ12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder tb = new StringBuilder(br.readLine());

		while(tb.length() > sb.length()) {
			if(tb.charAt(tb.length() - 1) == 'A') {
				tb.deleteCharAt(tb.length() - 1);
			} else {
				tb.deleteCharAt(tb.length()-1);
				tb.reverse();
			}
		}

		System.out.println(sb.toString().equals(tb.toString()) ? 1 : 0);
	}
}
