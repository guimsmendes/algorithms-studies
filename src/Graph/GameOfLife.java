package Graph;

import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
        public static void gameOfLife(int[][] board) {
            int numberRows = board.length;
            int numberColumns = board[0].length;

            int newBoard[][] = new int[numberRows][numberColumns];


            for(int i = 0; i<numberRows;i++){
                for(int j = 0; j<numberColumns; j++){
                    newBoard[i][j]=checkHealth(board, i, j);
                }
            }
            System.out.println(board);
        }

        public static int checkHealth(int[][] board, int i, int j) {
            int count = 0;

            count+=explore(board, i+1, j);
            count+=explore(board, i-1, j);
            count+=explore(board, i+1, j+1);
            count+=explore(board, i-1, j+1);
            count+=explore(board, i+1, j-1);
            count+=explore(board, i-1, j-1);
            count+=explore(board, i, j+1);
            count+=explore(board, i, j-1);

            int response = 0;

            if((board[i][j] == 0 && count == 3) ||
                    (board[i][j] == 1 && (2<=count  || count<=3))){
                response = 1;
            } else if(board[i][j] == 1 && (count >3 || count<2)){
                response = 0;
            }

            return response;

        }

        public static int explore(int[][] board, int i, int j){
            if(i<0 || j<0 || i>=board.length || j>=board[0].length) return 0;
            return board[i][j];
        }

        public static void main(String []args){
            int arr[][] = new int[4][3];
            arr[0][0] = 0;
            arr[0][1] = 1;
            arr[0][2] = 0;
            arr[1][0] = 0;
            arr[1][1] = 0;
            arr[1][2] = 1;
            arr[2][0] = 1;
            arr[2][1] = 1;
            arr[2][2] = 1;
            arr[3][0] = 0;
            arr[3][1] = 0;
            arr[3][2] = 0;
            gameOfLife(arr);
        }


}
