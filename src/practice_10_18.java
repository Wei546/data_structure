import java.util.*;
public class practice_10_18 {
    public static void main(String[] args) {
        int numRows = 5; // Number of rows in the maze
        int numCols = 5; // Number of columns in the maze

        char[][] maze = generateMaze(numRows, numCols);

        // Display the maze
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
    }
    public static char[][] generateMaze(int numRows, int numCols) {
        char[][] maze = new char[numRows][numCols];

        // Initialize the maze with walls
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                maze[row][col] = '#';
            }
        }

        Stack<int[]> stack = new Stack<>();
        Random random = new Random();

        int startRow = 0;
        int startCol = 0;
        maze[startRow][startCol] = 'S';
        stack.push(new int[] { startRow, startCol });

        while (!stack.isEmpty()) {
            int[] currentIndex = stack.pop();
            int currentRow = currentIndex[0];
            int currentCol = currentIndex[1];

            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            boolean hasUnvisitedNeighbors = false;

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0] * 2;
                int newCol = currentCol + direction[1] * 2;

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                    if (maze[newRow][newCol] == '#') {
                        hasUnvisitedNeighbors = true;
                        maze[newRow][newCol] = '*';
                        maze[newRow - direction[0]][newCol - direction[1]] = '*';
                        stack.push(new int[] { newRow, newCol });

                        // Add some randomness in choosing neighbors
                        while (random.nextDouble() < 0.5 && hasUnvisitedNeighbors) {
                            hasUnvisitedNeighbors = false;
                            for (int[] dir : directions) {
                                int r = newRow + dir[0] * 2;
                                int c = newCol + dir[1] * 2;
                                if (r >= 0 && r < numRows && c >= 0 && c < numCols && maze[r][c] == '#') {
                                    hasUnvisitedNeighbors = true;
                                    newRow = r;
                                    newCol = c;
                                    maze[newRow][newCol] = '*';
                                    maze[newRow - dir[0]][newCol - dir[1]] = '*';
                                    stack.push(new int[] { newRow, newCol });
                                }
                            }
                        }
                    }
                }
            }
        }
        return maze;
    }
}
