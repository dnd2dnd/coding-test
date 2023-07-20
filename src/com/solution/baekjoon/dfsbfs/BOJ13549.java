package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 13459 숨바꼭질 3, 골드 5
 */
public class BOJ13549 {
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(n, 0));

		boolean[] check = new boolean[100001];
		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			check[node.x] = true;
			if(node.x == k) {
				min = Math.min(min, node.d);
			}

			int a = node.x-1;
			int b = node.x+1;
			int c = 2*node.x;

			if(checkNumber(a)) {
				if(!check[a]) {
					queue.add(new Node(a, node.d+1));
				}
			}

			if(checkNumber(b)) {
				if(!check[b]) {
					queue.add(new Node(b, node.d+1));
				}
			}

			if(checkNumber(c)) {
				if(!check[c]) {
					queue.add(new Node(c, node.d));
				}
			}
		}
		System.out.println(min);
	}

	public static boolean checkNumber(int n) {
		return n >= 0 && n <= 100000;
	}

	public static class Node {
		int x, d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}

