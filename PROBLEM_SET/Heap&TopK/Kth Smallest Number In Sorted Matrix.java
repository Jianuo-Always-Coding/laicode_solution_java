package Heap&TopK;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val)
                    return 0;
                return c1.val < c2.val ? -1 : 1;
            }
        });

        Cell node = new Cell(0, 0, matrix[0][0]);
        minHeap.offer(node);
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        visited[0][0] = true;

        for (int i = 1; i < k; i++) {
            Cell cur = minHeap.poll();

            if (cur.row < rowNum - 1 && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col < colNum - 1 && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        node = minHeap.poll();
        return matrix[node.row][node.col];
    }

    static class Cell {
        int row;
        int col;
        int val;

        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}

// TC : O(klogk)
// SC : O(k)
