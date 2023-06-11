package com.solution.donbin.그리디;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.그리디
 * fileName       : 큰수의법칙
 * author         : tkfdk
 * date           : 2023-06-09
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        tkfdk       최초 생성
 */
public class 큰수의법칙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int first = arr[n - 1];
		int second = arr[n - 2];

		int cnt = (m / (k + 1)) * k;
		cnt += m % (k + 1);

		int result = 0;
		result += cnt * first;
		result += (m - cnt) * second;

		System.out.println(result);

	}
}
