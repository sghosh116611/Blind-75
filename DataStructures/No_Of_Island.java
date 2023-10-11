package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class No_Of_Island{
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] flag = new int[m][n];
        int island = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0;j < n; j++){
                if(flag[i][j] == 0 && grid[i][j] == '1'){
                    island++;
                    bfs(i,j,m,n,grid,flag);
                }
            }
        }

        return island;
    }

    private void bfs(int i, int j, int m, int n, char[][] grid, int[][]flag){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.i;
            int column = pair.j;
            
            if(column + 1 < n && grid[row][column + 1] == '1'){
                if(flag[row][column + 1] == 0){
                    flag[row][column + 1] = 1;
                    queue.add(new Pair(row,column + 1));
                }
            }
            if(column - 1 >= 0 && grid[row][column - 1] == '1'){
                if(flag[row][column - 1] == 0){
                    flag[row][column - 1] = 1;
                    queue.add(new Pair(row,column - 1));
                }
            }
            if(row + 1 < m && grid[row + 1][column] == '1' ){
                if(flag[row + 1][column] == 0){
                    flag[row + 1][column] = 1;
                    queue.add(new Pair(row + 1,column));
                }
            }

            if(row - 1 >= 0 && grid[row - 1][column] == '1'){
                if(flag[row - 1][column] == 0){
                    flag[row - 1][column] = 1;
                    queue.add(new Pair(row - 1,column));
                }
            }

            if(row + 1 < m && column + 1 < n){
                if((grid[row][column + 1] == '1' || grid[row + 1][column] == '1') && grid[row + 1][column + 1] == '1'){
                    if(flag[row + 1][column + 1] == 0){
                        flag[row + 1][column + 1] = 1;
                        queue.add(new Pair(row + 1,column + 1));
                    }
                }
            }

            if(row - 1 >= 0 && column - 1 >= 0){
                if((grid[row][column - 1] == '1' || grid[row - 1][column] == '1') && grid[row - 1][column - 1] == '1'){
                    if(flag[row - 1][column - 1] == 0){
                        flag[row - 1][column - 1] = 1;
                        queue.add(new Pair(row - 1,column - 1));
                    }
                }
            }
        }
    }
}

class Pair{
    int i;
    int j;

    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}