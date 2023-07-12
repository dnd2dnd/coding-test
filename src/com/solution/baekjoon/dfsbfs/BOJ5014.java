package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 5014번, 실버 1
 */
public class BOJ5014 {
	static int F, S, G, U, D;
	static int[] floor;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		floor = new int[F+1];
		floor[S] = 1;
		System.out.println(recur(S));
	}
	public static String recur(int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(c);

		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x==G){
				return String.valueOf(floor[G]-1);
			}

			if((x+U)<=F) {
				if(floor[x+U]==0) {
					floor[x+U] = floor[x]+1;
					queue.add(x + U);
				}
			}
			if((x-D)>=1) {
				if(floor[x-D]==0) {
					floor[x-D] = floor[x]+1;
					queue.add(x-D);
				}
			}
		}
		return "use the stairs";
	}
}
