package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {
	public static class Jewel implements Comparable<Jewel>{
		int m, v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if(this.m == o.m) {
				return this.v - o.v;
			}
			return this.m - o.m;
		}

		@Override
		public String toString() {
			return "Jewel{" +
				"m=" + m +
				", v=" + v +
				'}';
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Jewel[] jewels = new Jewel[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			jewels[i] = new Jewel(a, b);
		}

		int[] bag = new int[k];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(jewels);
		Arrays.sort(bag);
		// System.out.println(Arrays.toString(jewels));
		// System.out.println(Arrays.toString(bag));
		long sum = 0;
		int j = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<k; i++) {
			while(j<n && jewels[j].m <= bag[i]) {
				pq.add(jewels[j++].v);
			}
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}

		System.out.println(sum);
	}
}
