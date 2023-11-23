package com.solution.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *  백준 9935, 문자열 폭발, 골드 4
 */
public class BOJ9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String b = br.readLine();

		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
			if(stack.size()>=b.length()) {
				int k=0;
				boolean check = true;
				for(int j=b.length()-1; j>=0; j--) {
					k++;
					if(b.charAt(j) != stack.get(stack.size()-k)) {
						check = false;
						break;
					}
				}
				if(check) {
					for(int j=0; j<b.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (char ch : stack){
			stringBuilder.append(ch);
		}

		if(stringBuilder.length()==0) {
			System.out.println("FRULA");
		} else {
			System.out.println(stringBuilder);
		}
	}
}
