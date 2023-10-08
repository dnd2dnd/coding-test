package com.solution.baekjoon.backtracking;

/**
 * 백준 11729, 하노이 탑 이동 순서, 골드 5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		System.out.println(hanoi(n, 1, 3, 2, 0, sb));
		System.out.println(sb.toString());
	}
	public static int hanoi(int n, int start, int to, int sub, int count, StringBuilder sb) {
		count++;
		if(n==1) {
			sb.append(start).append(" ").append(to).append("\n");
		} else {
			count = hanoi(n-1, start, sub, to, count, sb);
			sb.append(start).append(" ").append(to).append("\n");
			count = hanoi(n-1, sub, to, start, count, sb);
		}
		return count;
	}

}
