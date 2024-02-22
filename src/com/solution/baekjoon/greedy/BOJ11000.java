package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 11000, 강의실 배정 골드 5
 */
public class BOJ11000 {
	public static class Lesson implements Comparable<Lesson>{
		int s, t;

		public Lesson(int s, int t) {
			this.s = s;
			this.t = t;
		}

		@Override
		public int compareTo(Lesson lesson) {
			if(this.s == lesson.s) {
				return this.t - lesson.t;
			}
			return this.s - lesson.s;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Lesson[] lessons = new Lesson[n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lessons[i] = new Lesson(a, b);
		}
		Arrays.sort(lessons);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lessons[0].t);
		for(int i=1; i<n; i++) {
			if(lessons[i].s >= pq.peek()) {
				pq.poll();
			}
			pq.add(lessons[i].t);
		}
		System.out.println(pq.size());
	}
}
