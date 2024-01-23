package com.solution.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 주사위고르기 {
	class Solution {
		static int[][] dice;
		static List<Integer> scoreA;
		static List<Integer> scoreB;
		static double max = -1;
		static int[] answer;
		public int[] solution(int[][] dice) {
			this.dice = dice;
			this.answer = new int[dice.length/2];
			choiceDice(0, 0, dice.length/2, new int[dice.length/2]);
			return answer;
		}
		public void sumDice(int[] diceA, int d, int sum, List<Integer> list) {
			if(d==diceA.length) {
				list.add(sum);
				return;
			}
			for(int num : dice[diceA[d]]) {
				sumDice(diceA, d+1, sum+num, list);
			}

		}

		public void choiceDice(int s, int d, int count, int[] select) {
			if(d==count) {
				List<Integer> list = Arrays.stream(select)
					.boxed().collect(Collectors.toList());
				int[] diceA = select;
				int[] diceB = new int[count];
				int k = 0;
				for(int i=0; i<count*2; i++) {
					if(!list.contains(i)) {
						diceB[k] = i;
						k++;
					}
				}
				scoreA = new ArrayList<>();
				scoreB = new ArrayList<>();
				sumDice(diceA, 0, 0, scoreA);
				sumDice(diceB, 0, 0, scoreB);
				Collections.sort(scoreA);
				Collections.sort(scoreB);
				int win = 0;
				int lose = 0;
				for(Integer num : scoreA) {
					int left = 0;
					int right = scoreB.size();

					while(left<right) {
						int mid = (left+right)/2;

						if(num > scoreB.get(mid)) {
							left = mid+1;
						} else {
							right = mid;
						}
					}
					win += left;
					lose += scoreB.size()-left;
				}
				double result = (double) win/(win+lose);

				if(max < result) {
					max = result;
					for(int i=0; i<select.length; i++) {
						answer[i] = select[i]+1;
					}
				}

				return;
			} else {
				for(int i=s; i<count*2; i++) {
					select[d] = i;
					choiceDice(i+1, d+1, count, select);
				}
			}
		}
	}
}
