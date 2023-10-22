package com.solution.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 11000, 강의실 배정, 골드 5
 */
public class BOJ11000 {
	public static class Node implements Comparable<Node>{
		int st, et;

		public Node(int st, int et) {
			this.st = st;
			this.et = et;
		}

		@Override
		public int compareTo(Node o) {
			if(this.st == o.st) {
				return this.et - o.et;
			}
			return this.st - o.st;
		}
	}

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		int a, b;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(a, b);
		}

		Arrays.sort(nodes);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(nodes[0].et);

		for(int i=1; i<N; i++) {
			if(nodes[i].st >= pq.peek()) {
				pq.poll();
			}
			pq.add(nodes[i].et);
		}
		System.out.println(pq.size());
	}
}
