package com.solution.donbin.그리디;

/**
 * description    :
 * packageName    : com.solution.donbin.그리디
 * fileName       : 거스름돈
 * author         : tkfdk
 * date           : 2023-06-09
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        tkfdk       최초 생성
 */
public class 거스름돈 {
	public static void main(String[] args) {
		int n = 1260;
		int[] money = {500, 100, 50, 10};
		int cnt = 0;
		for (int i=0; i<money.length; i++) {
			cnt += n/money[i];
			n %= money[i];
		}
		System.out.println(cnt);
	}
}
