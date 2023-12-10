package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *  백준 2493, 탑, 골드 5
 *  https://www.acmicpc.net/problem/2493
 */
public class BOJ2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int v = Integer.parseInt(st.nextToken());

			while (true) {
				if(!stack.isEmpty()) {
					int top = stack.peek();
					if(top > v) {

						System.out.println(top + " " + v);
						System.out.print(index.peek()+1 + " ");
						stack.push(v);
						index.push(i);
						break;
					} else {
						stack.pop();
						index.pop();
					}
				} else {
					System.out.print(0 + " ");
					stack.push(v);
					index.push(i);
					break;
				}
			}
		}
	}
}
