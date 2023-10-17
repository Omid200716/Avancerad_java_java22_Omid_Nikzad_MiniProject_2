package algorithm;

import board.Board;

public class MinMax {

    public static int[] bestMove(Board board, char player) {
        char opponent = (player == 'X') ? 'O' : 'X';
        int bestScore = (player == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = {-1, -1};

        char[][] currentGrid = board.getGrid();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentGrid[i][j] == ' ') {
                    currentGrid[i][j] = player;
                    int currentScore = minimax(currentGrid, 0, player != 'X', player);
                    currentGrid[i][j] = ' ';  // Reset the move

                    if (player == 'X' && currentScore > bestScore) {
                        bestScore = currentScore;
                        bestMove = new int[]{i, j};
                    } else if (player == 'O' && currentScore < bestScore) {
                        bestScore = currentScore;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }
        return bestMove;
    }

    private static int minimax(char[][] grid, int depth, boolean isMaximizing, char player) {
        char opponent = (player == 'X') ? 'O' : 'X';

        if (checkWin(grid, player)) {
            return (player == 'X') ? 10 - depth : depth - 10;
        } else if (checkDraw(grid)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == ' ') {
                        grid[i][j] = opponent; // Opponent's move
                        int currentScore = minimax(grid, depth + 1, false, player);
                        grid[i][j] = ' '; // Reset the position
                        bestScore = Math.max(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == ' ') {
                        grid[i][j] = player; // Player's move
                        int currentScore = minimax(grid, depth + 1, true, player);
                        grid[i][j] = ' '; // Reset the position
                        bestScore = Math.min(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private static boolean checkDraw(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { 
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char[][] grid, char player) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                return true;
            }
        }
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }
        return false;
    }
}
