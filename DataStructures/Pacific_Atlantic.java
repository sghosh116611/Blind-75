package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pacific_Atlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<Pair> pQueue = new LinkedList<>();
        Queue<Pair> aQueue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pQueue.add(new Pair(0, i));
            aQueue.add(new Pair(m - 1, i));
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }

        for (int i = 0; i < m; i++) {
            pQueue.add(new Pair(i, 0));
            aQueue.add(new Pair(i, n - 1));
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> resultRow = new ArrayList<>();
                    resultRow.add(i);
                    resultRow.add(j);

                    result.add(resultRow);
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<Pair> queue, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentRow = current.i;
            int currentColumn = current.j;

            for (int[] distance : dist) {
                int nextRow = currentRow + distance[0];
                int nextColumn = currentColumn + distance[1];

                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || visited[nextRow][nextColumn]
                        || heights[nextRow][nextColumn] < heights[currentRow][currentColumn]) {
                    continue;
                }

                queue.add(new Pair(nextRow, nextColumn));
                visited[nextRow][nextColumn] = true;
            }
        }
    }
}

// Note
// 1. We need to find out the paths that connect from the two oceans
// 2. We perform BFS(the path should be increasing) to find out the paths from
// the two ocean 's starting point