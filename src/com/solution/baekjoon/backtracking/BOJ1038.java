package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 1038, 감소하는 수, 골드 5
 */
public class BOJ1038 {
	static ArrayList<Long> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		if(N<=10) {
			System.out.println(N);
		}
		else if(N > 1022) System.out.println("-1");
		else {
			for(int i=0; i<10; i++) {
				checkNumber(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(N));
		}
	}

	public static void checkNumber(long x, int n) {
		if(n>10) {
			return;
		}
		list.add(x);
		for(int i=0; i<(x%10); i++) {
			checkNumber(x*10 + i, n+1);
		}
	}

	// static int cnt = 0;
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	int N = Integer.parseInt(br.readLine());
	// 	if(N==0) {
	// 		System.out.println(0);
	// 		System.exit();
	// 	}
	// 	boolean end = true;
	// 	for(int i=1; i<=1000000; i++) {
	// 		checkNumber(i/10, i%10);
	// 		if(cnt==N) {
	// 			System.out.println(i);
	// 			end = false;
	// 			break;
	// 		}
	// 	}
	// 	if(end) {
	// 		System.out.println(-1);
	// 	}
	// }
	// public static void checkNumber(int x, int v) {
	// 	if(x==0) {
	// 		cnt++;
	// 	}
	//
	// 	int y = x%10;
	// 	if(v<y) {
	// 		checkNumber(x/10, y);
	// 	}
	// }
}
