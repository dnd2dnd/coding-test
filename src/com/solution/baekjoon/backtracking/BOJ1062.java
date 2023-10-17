package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1062, 가르침, 골드 4
 */
public class BOJ1062 {
	static int N, K, count = 0;
	// static ArrayList<Character> list = new ArrayList<>();
	static String[] words;
	static boolean[] alpha = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		K-=5;

		alpha[0] = true;
		alpha[2] = true;
		alpha[8] = true;
		alpha[13] = true;
		alpha[19] = true;

		words = new String[N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			words[i] = s.substring(4, s.length()-4);
			// s = s.replaceAll("a", "").replaceAll("c", "")
			// 	.replaceAll("n", "").replaceAll("t", "").replaceAll("i", "");
			// for(int j=0; j<s.length(); j++) {
			// 	list.add(s.charAt(j));
			// }
		}
		dfs(0, 0);
		System.out.println(count);
	}
	public static void dfs(int x, int d) {
		if(d==K) {
			int cnt = 0;
			for (String word : words) {
				boolean c = true;
				for(int i=0; i<word.length(); i++) {
					if(!alpha[word.charAt(i) -'a']) {
						c = false;
						break;
					}
				}
				if(c) cnt++;
			}
			count = Math.max(count, cnt);
			return;
		}

		for(int i=x; i<26; i++) {
			if(!alpha[i]) {
				alpha[i] = true;
				dfs(i, d+1);
				alpha[i] = false;
			}
		}
	}
}

// package com.solution.baekjoon.backtracking;
//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;
//
// public class BOJ1062 {
// 	static int N, K, count = 0;
// 	static String[] words;
// 	static boolean[] alpha = new boolean[26];
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		N = Integer.parseInt(st.nextToken());
// 		K = Integer.parseInt(st.nextToken());
// 		K-=5;
//
// 		alpha[0] = true;
// 		alpha[2] = true;
// 		alpha[8] = true;
// 		alpha[13] = true;
// 		alpha[19] = true;
//
// 		words = new String[N];
// 		for(int i=0; i<N; i++) {
// 			String s = br.readLine();
// 			words[i] = s.substring(4, s.length()-4);
// 			words[i] = words[i].replace("a", "").replace("c", "")
// 				.replace("n", "").replace("t", "").replace("i", "");
// 		}
// 		dfs(0);
// 		System.out.println(count);
// 	}
// 	public static void dfs(int d) {
// 		if(d==K) {
// 			int cnt = 0;
// 			for (String word : words) {
// 				boolean c = true;
// 				for(int i=0; i<word.length(); i++) {
// 					if(!alpha[word.charAt(i) -'a']) {
// 						c = false;
// 						break;
// 					}
// 				}
// 				if(c) cnt++;
// 			}
// 			count = Math.max(count, cnt);
// 			return;
// 		}
//
// 		for(int i=0; i<N; i++) {
// 			for(int j=0; j<words[i].length(); j++) {
// 				if(!alpha[words[i].charAt(j) - 'a']) {
// 					alpha[words[i].charAt(j) - 'a'] = true;
// 					dfs(d+1);
// 					alpha[words[i].charAt(j) - 'a'] = false;
// 				}
// 			}
// 		}
// 	}
// }
