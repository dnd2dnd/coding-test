package com.solution.donbin.그리디;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.그리디
 * fileName       : 될때까지
 * author         : tkfdk
 * date           : 2023-06-09
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        tkfdk       최초 생성
 */
public class 될때까지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		while(n>1) {
			int t = (n/k)*k;
			ans += (n-t);
			n = t;
			if(n<k) break;
			ans+=1;
			n/=k;
		}
		ans += (n-1);
		System.out.println(ans);
	}
}
