
class SudokuSolver
{
    public static boolean isOK(int[][] table,
                               int row, int col,
                               int num)
    {
        for (int i = 0; i < table.length; i++)
        {

            if (table[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < table.length; i++)
        {
            if (table[i][col] == num)
            {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(table.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int i = boxRowStart;
             i < boxRowStart + sqrt; i++)
        {
            for (int j = boxColStart;
                 j < boxColStart + sqrt; j++)
            {
                if (table[i][j] == num)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(
            int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty)
        {
            return true;
        }

        for (int num = 1; num <= n; num++)
        {
            if (isOK(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(
            int[][] board, int n)
    {

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((i + 1) % (int)Math.sqrt(n) == 0)
            {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;

        if (solveSudoku(board, N))
        {
            print(board, N);
        }
        else {
            System.out.println("No solution for the given sudoku table");
        }
    }
}


