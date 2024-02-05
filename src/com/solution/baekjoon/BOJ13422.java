package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			int cnt = 0;
			int[] home = new int[2*N+1];
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				home[n] = Integer.parseInt(st.nextToken());
				home[n+N] = home[n];
			}

			long sum = 0;
			for(int i=0; i<M; i++) {
				sum += home[i];
			}
			if(sum < K) {
				cnt++;
			}

			if(N!=M) {
				for(int i=1; i<N; i++) {
					sum-=home[i-1];
					sum+=home[i+M-1];
					if(sum < K) {
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}
