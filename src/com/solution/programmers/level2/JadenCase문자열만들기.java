package com.solution.programmers.level2;

/**
 * 프로그래머스, 최대값과최솟값, Level2
 */
public class JadenCase문자열만들기 {
	class Solution {
		public String solution(String s) {

			String[] str = s.split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< str.length; i++) {
				String[] st = str[i].split("");
				for(int k=0; k<st.length; k++) {
					if(k==0) {
						sb.append(st[k].toUpperCase());
					} else {
						sb.append(st[k].toLowerCase());
					}
				}
				sb.append(" ");
			}

			if(s.substring(s.length()-1, s.length()).equals(" ")) {
				return sb.toString();
			}

			return sb.toString().trim();
		}
	}
}
