//import java.util.*;
//public class Maze {
//    void findPath(){
//        Stack<Cell> chunk = new Stack<>();
//        Cell start = new Cell(1,1);
//        Cell end = new Cell(3,4);
//        chunk.push(start);
//        while(!chunk.isEmpty()){
//            Cell current = chunk.pop();
//            int row = current.row;
//            int col = current.column;
//            //向右
//            if(){
//                chunk.push(new Cell(row,col+1));
//            }
//            //向左
//            if(){
//                chunk.push(new Cell(row,col-1));
//            }
//            //向上
//            if(){
//                chunk.push(new Cell(row-1,col));
//            }
//            //向下
//            if(){
//                chunk.push(new Cell(row+1,col));
//            }
//        }
//    }
//
//}
//class Map{
//    int [][] map = {
//            {1,1,1,1,1},
//            {1,0,0,0,1},
//            {1,1,0,1,1},
//            {1,0,0,0,1},
//            {1,1,1,0,1}
//    };
//    int mapRow = map.length;
//    int mapCol = map[0].length;
//}
//class Cell{
//    int row;
//    int column;
//    Cell(int row,int column){
//        this.row=row;
//        this.column=column;
//    }
//}