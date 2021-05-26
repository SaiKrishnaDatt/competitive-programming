package leetcode.daily.challenge.may2021.day22;

/**
 * @author : ssuddhapally
 * @since : 23/05/21, Sun
 **/
class TicTacToe {
  static int[][] grid;

  /**
   * Initialize your data structure here.
   */
  public TicTacToe(int n) {
    grid = new int[n][n];
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either:
   * 0: No one wins.
   * 1: Player 1 wins.
   * 2: Player 2 wins.
   */
  public static int move(int row, int col, int player) {
    grid[row][col] = player;
    int n = grid.length;
    boolean isPlayerWins = true;
    for (int i = 0; i < n; i++) {
      if (grid[i][col] != player) {
        isPlayerWins = false;
        break;
      }
    }
    if (isPlayerWins) return player;
    isPlayerWins = true;
    for (int i = 0; i < n; i++) {
      if (grid[row][i] != player) {
        isPlayerWins = false;
        break;
      }
    }
    if (isPlayerWins) return player;
    //row,col follows in backward diagonal
    if (row == col) {
      isPlayerWins = true;
      for (int i = 0; i < n; i++) {
        if (grid[i][i] != player) {
          isPlayerWins = false;
          break;
        }

      }
    }
    if (isPlayerWins) return player;
    //row,col follows in forward diagonal
    if (row + col == n - 1) {
      isPlayerWins = true;
      for (int i = n - 1, j = 0; i >= 0; --i, j++) {
        if (grid[i][j] != player) {
          isPlayerWins = false;
          break;
        }
      }
    }
    if (isPlayerWins) return player;
    return 0;
  }

  public static void main(String[] args) {
    int[][] arr = {{0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {2, 0, 1}, {1, 0, 2}, {2, 1, 1}};
    //int[][] arr = {{0,3,1},{3,3,2},{3,0,1},{0,0,2},{2,1,1},{2,2,2},{1,2,1}};
    int n = arr.length;
    grid = new int[3][3];
    //grid = new int[4][4];
    for (int i = 0; i < n; i++) {
      System.out.println(move(arr[i][0], arr[i][1], arr[i][2]));
      display();
    }
  }

  private static void display() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

/*
["TicTacToe","move","move","move","move","move","move","move"]
[[4],[0,3,1],[3,3,2],[3,0,1],[0,0,2],[2,1,1],[2,2,2],[1,2,1]]
{{0,3,1},{3,3,2},{3,0,1},{0,0,2},{2,1,1},{2,2,2},{1,2,1}}
 */