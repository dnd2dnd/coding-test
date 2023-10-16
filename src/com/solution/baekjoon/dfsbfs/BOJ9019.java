package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 9019, DSLR, 골드 4
 */
public class BOJ9019 {
	static int n;
	public static class Node {
		int number;
		String sb;

		public Node(int number, String sb) {
			this.number = number;
			this.sb = sb;
		}

		int D() {
			return (number * 2) % 10000;
		}

		int S() {
			return number == 0 ? 9999 : number - 1;
		}

		int L() {
			return number % 1000 * 10 + number / 1000;
		}

		int R() {
			return number % 10 * 1000 + number / 10;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(a, ""));
			boolean[] visited = new boolean[10000];
			visited[a] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.number == b) {
					System.out.println(node.sb);
					break;
				}

				if (!visited[node.D()]) {
					queue.add(new Node(node.D(), node.sb + "D"));
					visited[node.D()] = true;
				}
				if (!visited[node.S()]) {
					queue.add(new Node(node.S(), node.sb + "S"));
					visited[node.S()] = true;
				}
				if (!visited[node.L()]) {
					queue.add(new Node(node.L(), node.sb + "L"));
					visited[node.L()] = true;
				}
				if (!visited[node.R()]) {
					queue.add(new Node(node.R(), node.sb + "R"));
					visited[node.R()] = true;
				}
			}
		}
	}
}
