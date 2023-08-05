package com.solution.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17609, 회문, 골드 5
 */
public class BOJ17609 {
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i=0; i<t;i++) {
			str = br.readLine();
			int left = 0;
			int right = str.length()-1;
			if (check(left, right)) {
				System.out.println(0);
				continue;
			}

			if(checkS(left, right)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}

	public static boolean check(int left, int right) {
		while(left<=right) {
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean checkS(int left, int right) {
		while(left<=right) {
			if (str.charAt(left)!=str.charAt(right)) {
				boolean a = check(left+1, right);
				boolean b = check(left, right-1);
				if (!a && !b) {
					return false;
				} else return true;
			}
			left++;
			right--;
		}
		return true;
	}
}

