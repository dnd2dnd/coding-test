package com.solution.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 백준 11279, 최대 힙, 실버 2
 * https://www.acmicpc.net/problem/11279
 */
public class BOJ11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(queue.peek() == null) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(x);
			}
		}
	}
}

