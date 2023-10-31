package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 12851, 숨바꼭질 2, 골드 4
 */
public class BOJ12851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] map = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == k) {
				cnt++;
				min = map[x];
			}

			if(map[x] > min) continue;

			for(int i=0; i<3; i++) {
				int a;
				if(i==0) {
					a = x-1;
				} else if(i==1) {
					a = x+1;
				} else {
					a = x*2;
				}

				if(a<0 || a>100000) continue;

				// if(a==k) {
				// 	min = map[x];
				// 	cnt++;
				// }

				if(map[a]==0 || map[a] == map[x]+1) {
					queue.add(a);
					map[a] = map[x]+1;
				}
			}
		}
		System.out.println(min);
		System.out.println(cnt);
	}
}
