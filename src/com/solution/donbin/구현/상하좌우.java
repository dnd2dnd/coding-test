package com.solution.donbin.구현;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.구현
 * fileName       : 상하좌우
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class 상하좌우 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String[] plans = sc.nextLine().split(" ");

		int x = 1;
		int y = 1;

		for(String plan : plans) {
			int dx=x;
			int dy=y;
			switch (plan) {
				case "L":
					dy-=1;
					break;
				case "R":
					dy+=1;
					break;
				case "U":
					dx-=1;
					break;
				case "D":
					dx+=1;
					break;
			}

			if (dx<=0 || dy<=0 || dx>n || dy>n) {
				continue;
			} else {
				x=dx;
				y=dy;
			}
		}
		System.out.println(x+" "+y);
	}
}
