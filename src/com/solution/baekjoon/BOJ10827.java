package com.solution.baekjoon;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *  백준 10827, a^b, 골드5
 */
public class BOJ10827 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		BigDecimal a = s.nextBigDecimal();
		int b = s.nextInt();

		System.out.println(a.pow(b).toPlainString());
	}
}
