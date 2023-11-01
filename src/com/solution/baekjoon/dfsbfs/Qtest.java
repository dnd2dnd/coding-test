package com.solution.baekjoon.dfsbfs;

import java.util.Arrays;

/**
 * description    :
 * packageName    : com.solution.baekjoon.dfsbfs
 * fileName       : Qtest
 * author         : tkfdk
 * date           : 2023-10-31
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-31        tkfdk       최초 생성
 */
public class Qtest {
	public static void main(String[] args) {
		int[][] array = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		generateCombinations(array, 0, 0, new int[array.length]);
	}

	// 재귀 함수를 이용하여 배열의 조합 생성
	private static void generateCombinations(int[][] array, int row, int col, int[] selectedRows) {
		int numRows = array.length;

		if (row == numRows) {
			// 선택된 행의 조합 출력
			printCombination(array, selectedRows);
			return;
		}

		// 현재 행을 선택하는 경우
		selectedRows[row] = col;
		generateCombinations(array, row + 1, col + 1, selectedRows);

		// 현재 행을 선택하지 않는 경우
		generateCombinations(array, row + 1, col, selectedRows);
	}

	// 선택된 행의 조합 출력
	private static void printCombination(int[][] array, int[] selectedRows) {
		for (int i = 0; i < selectedRows.length; i++) {
			int row = selectedRows[i];
			for (int j = 0; j < array[row].length; j++) {
				System.out.print(array[row][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
}
