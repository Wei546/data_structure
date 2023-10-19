import javax.swing.*;
import java.awt.*;

public class VisualMazeGenerator {
    public static void main(String[] args) {
        int numRows = 5; // 迷宮的行數
        int numCols = 5; // 迷宮的列數

        char[][] maze = generateMaze(numRows, numCols);

        // 創建迷宮視覺化視窗
        JFrame frame = new JFrame("迷宮生成器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().add(new MazePanel(maze));
        frame.setVisible(true);
    }

    // 生成一個簡單的迷宮
    public static char[][] generateMaze(int numRows, int numCols) {
        // ...（與前一個示例相同）
        char[][] maze = new char[numRows][numCols];

        // 初始化迷宮，將所有格子設為牆壁
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                maze[row][col] = '#';
            }
        }

        // 隨機挖掉一些牆壁，創建通道
        for (int row = 1; row < numRows - 1; row += 2) {
            for (int col = 1; col < numCols - 1; col += 2) {
                maze[row][col] = ' ';

                // 隨機選擇一個相鄰的牆壁打通
                int direction = (int) (Math.random() * 4);
                switch (direction) {
                    case 0: // 上
                        maze[row - 1][col] = ' ';
                        break;
                    case 1: // 右
                        maze[row][col + 1] = ' ';
                        break;
                    case 2: // 下
                        maze[row + 1][col] = ' ';
                        break;
                    case 3: // 左
                        maze[row][col - 1] = ' ';
                        break;
                }
            }
        }
        return maze;
    }
}


class MazePanel extends JPanel {
    private char[][] maze;

    public MazePanel(char[][] maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 30; // 每個格子的大小
        int numRows = maze.length;
        int numCols = maze[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                char cell = maze[row][col];
                int x = col * cellSize;
                int y = row * cellSize;

                if (cell == '#') {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, cellSize, cellSize);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, cellSize, cellSize);
                }
            }
        }
    }

}
