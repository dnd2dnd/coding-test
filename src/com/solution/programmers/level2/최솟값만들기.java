package com.solution.programmers.level2;

import java.util.Arrays;

/**
 * 프로그래머스, 최솟값 만들기, Level2
 */
public class 최솟값만들기 {
	class Solution
	{
		public int solution(int []A, int []B)
		{
			int answer = 0;
			Arrays.sort(A);
			Arrays.sort(B);

			for(int i=0; i<A.length; i++) {
				answer += (A[i]*B[A.length-i-1]);
			}
			return answer;
		}
	}
}
