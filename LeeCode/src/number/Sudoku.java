package number;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

	public static void main(String[] args) {
		System.out.println((int) '.');

	}

	public boolean isValidSudoku(char[][] board) {

		return checkRow(board) && checkColumn(board) && checkSubSquares(board);
	}

	private static boolean checkRow(char[][] board) {
		boolean isDuplicate = false;
		for (int i = 0; i < 9; i++) {
			List<Character> nums = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					isDuplicate = checkDuplicated(nums, board[i][j]);
					nums.add(board[i][j]);
				}

				if (isDuplicate == true) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkColumn(char[][] board) {
		boolean isDuplicate = false;
		for (int i = 0; i < 9; i++) {
			List<Character> nums = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					isDuplicate = checkDuplicated(nums, board[j][i]);
					nums.add(board[j][i]);
				}

				if (isDuplicate == true) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkSubSquares(char[][] board) {
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (checkSubSquare(board, i, j) == false) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean checkSubSquare(char[][] board, int chackI, int chackJ) {
		List<Character> nums = new ArrayList<>();
		boolean isDuplicate = false;

		for (int i = chackI; i < chackI + 3; i++) {
			for (int j = chackJ; j < chackJ + 3; j++) {
				if (board[i][j] != '.') {
					isDuplicate = checkDuplicated(nums, board[i][j]);
					nums.add(board[i][j]);
					if (isDuplicate == true) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean checkDuplicated(List<Character> nums, char num) {

		for (int i = 0; i < nums.size(); i++) {
			if (num == nums.get(i)) {
				return true;
			}
		}

		return false;
	}
}
