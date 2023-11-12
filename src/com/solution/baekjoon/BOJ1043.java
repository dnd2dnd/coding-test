package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1043 {
	static int n, m;
	static boolean[] trueCheck;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trueCheck = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		if(x!=0) {
			for(int i=1; i<=x; i++) {
				int w = Integer.parseInt(st.nextToken());
				trueCheck[w] = true;
			}
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}


		// boolean[] copyCheck;
		for(int i=1; i<=m; i++) {
			// copyCheck = copyCheck();
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			for(int j=1; j<=q; j++) {
				int w = Integer.parseInt(st.nextToken());
				list.get(q).add(w);
			}
		}

		int cnt = 0;
		for(int i=list.size()-1; i>0; i--) {
			if(list.get(i).size() == 0) continue;

			for(int j=0; j<list.get(i).size(); j+=i) {
				boolean c = false;
				for(int k=j; k<j+i; k++) {
					if(trueCheck[list.get(i).get(k)]) {
						c = true;
						break;
					}
				}

				if(c) {
					for(int k=j; k<j+i; k++) {
						trueCheck[list.get(i).get(k)] = true;
					}
				} else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	public static boolean[] copyCheck() {
		boolean[] copy = new boolean[n+1];
		for(int i=0; i<n+1; i++) {
			copy[i] = trueCheck[i];
		}
		return copy;
	}
}
