package com.solution.baekjoon.dfsbfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 16953번 A->B, 실버 2
 */
public class BOJ16953 {
	static Long a, b;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextLong();
		b = sc.nextLong();

		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(a);
		while(!q.isEmpty()) {
			int size = q.size();

			for(int i=0; i<size; i++) {
				long t = q.poll();
				if(t==b) {
					return cnt+1;
				}

				if(2*t<=b) q.add(2*t);
				if(t*10+1<=b) q.add(t*10+1);
			}
			cnt++;
		}
		return -1;
	}
}
