package com.solution.baekjoon.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 19598, 최소 회의실 개수, 골드 5
 */
public class BOJ19598 {
	public static class Node implements Comparable<Node> {
		int startTime;
		int endTime;

		public Node(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Node o) {
			if(this.startTime == o.startTime)
				return this.endTime - o.endTime;

			return this.startTime - o.startTime;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n];
		StringTokenizer st;

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(a, b);
		}

		Arrays.sort(nodes);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(nodes[0].endTime);

		for(int i=1; i<n; i++) {
			if(pq.peek() <= nodes[i].startTime) {
				pq.poll();
			}
			pq.add(nodes[i].endTime);
		}
		System.out.println(pq.size());
	}
}
