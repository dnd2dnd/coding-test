package com.solution.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 1927, 최소 힙, 실버 2
 * https://www.acmicpc.net/problem/1927
 */
public class BOJ1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i =0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(queue.peek() != null) {
					System.out.println(queue.poll());
				} else {
					System.out.println(0);
				}
			} else {
				queue.add(x);
			}
		}
	}
}
