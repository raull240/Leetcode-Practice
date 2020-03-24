package Medium;


//289. Game of Life
// https://leetcode.com/problems/game-of-life/
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
                int count = 0;
                count = find(board,i + 1,j) + find(board,i,j + 1) + find(board,i - 1,j) + find(board,i,j - 1) + 
                        find(board,i - 1,j + 1) + find(board,i + 1,j + 1) + find(board,i - 1,j - 1) + 
                        find(board,i + 1,j - 1); 
                if(board[i][j] == 1) {
                    if (count < 2) 
                        board[i][j] = -1;
                    if (count == 2 || count == 3) 
                        board[i][j] = 1;
                    if (count > 3) 
                        board[i][j] = -1;
                } else {
                    if (count == 3) 
                        board[i][j] = 2;
                }
                
            }
        }
        
        for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == -1) board[i][j] = 0;                
            }
        }
    }
    
    public int find(int[][] board,int i,int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == -1) return 1;
            if (board[i][j] == 2) return 0;
            return board[i][j];
        } 
        return 0;
    }
    
    public static void main (String[] args) {
    	int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    	new GameOfLife().gameOfLife(board);
    	for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
            	System.out.println("board value " + board[i][j]);
            }
        }
    }
		

}
