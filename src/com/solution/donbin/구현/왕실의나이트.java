package com.solution.donbin.구현;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.구현
 * fileName       : 왕실의나이트
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class 왕실의나이트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String now = sc.nextLine();
		int x = now.charAt(0) - 96;
		int y = Integer.parseInt(String.valueOf(now.charAt(1)));

		int[] stepX = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] stepY = {-1, -2 ,-2, -1, 1, 2, 2, 1};

		int cnt=0;
		for(int i=0; i<stepX.length; i++) {
			int dx = x + stepX[i];
			int dy = y + stepY[i];

			if(dx<1 || dy<1 || dx>8 || dy>8) continue;
			cnt+=1;
		}
		System.out.println(cnt);
	}
}
