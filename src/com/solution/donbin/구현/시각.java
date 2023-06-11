package com.solution.donbin.구현;

import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.구현
 * fileName       : 시각
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class 시각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt=0;
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					if((i+""+j+""+k).contains("3")) {
						cnt+=1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
