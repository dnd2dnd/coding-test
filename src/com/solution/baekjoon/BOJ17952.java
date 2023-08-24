package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 */
public class BOJ17952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Project> stack = new Stack<>();

		StringTokenizer st;
		int sum = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(x==1) {
				int p = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				if(m==1) {
					sum += p;
				} else {
					stack.add(new Project(p, m-1));
				}
			} else {
				if(!stack.isEmpty()) {
					Project p = stack.pop();
					if(p.min==1) {
						sum += p.point;
					} else {
						stack.add(new Project(p.point, p.min-1));
					}
				}
			}
		}
		System.out.println(sum);
	}

	public static class Project {
		int point;
		int min;

		public Project(int point, int min) {
			this.point = point;
			this.min = min;
		}
	}
}
