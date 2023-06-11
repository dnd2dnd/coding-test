package com.solution.donbin.그리디;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.그리디
 * fileName       : 숫자카드게임
 * author         : tkfdk
 * date           : 2023-06-09
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        tkfdk       최초 생성
 */
public class 숫자카드게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int mV = Integer.MAX_VALUE;
			for(int j=0; j<m; j++) {
				int x = sc.nextInt();
				mV = Math.min(x, mV);
			}
			ans = Math.max(ans, mV);
		}
		System.out.println(ans);
	}
}
