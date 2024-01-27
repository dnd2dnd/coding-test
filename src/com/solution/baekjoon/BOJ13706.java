package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ13706 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(br.readLine());

		BigInteger left = new BigInteger("1");
		BigInteger right = n;
		BigInteger mid;
		while(true) {
			mid = left.add(right);
			mid = mid.divide(new BigInteger("2"));

			int result = (mid.multiply(mid)).compareTo(n);
			if(result == 0) {
				break;
			}else if(result == 1) {
				right = mid.subtract(new BigInteger("1"));
			} else {
				left = mid.add(new BigInteger("1"));
			}
		}
		System.out.println(mid);
	}
}
