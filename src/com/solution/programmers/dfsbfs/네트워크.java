package com.solution.programmers.dfsbfs;

public class 네트워크 {
    class Solution {
        static int[] nums;
        static int t;
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            nums = numbers;
            t = target;

            dfs(0, 0);
            return answer;
        }

        public void dfs(int i, int sum) {
            if(nums.length == i) {
                if(sum == t) {
                    answer++;
                }
                return;
            }
            dfs(i+1, sum+nums[i]);
            dfs(i+1, sum-nums[i]);
        }
    }
}
