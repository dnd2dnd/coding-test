package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();

			boolean check = true;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == '(') {
					stack.push('(');
				} else if (c == ')') {
					if(stack.size() > 0) {
						if(stack.peek() == '(') {
							stack.pop();
						}
					} else {
						check = false;
						break;
					}
				}
			}
			if(check && stack.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}