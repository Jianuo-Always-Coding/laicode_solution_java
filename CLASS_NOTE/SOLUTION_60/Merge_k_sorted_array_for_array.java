public class Solution {
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(arrayOfArrays.length, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return c1.val < c2.val ? -1 : 1;
            }
        });
        int sum = 0;

        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                Cell newCell = new Cell(i, 0, arrayOfArrays[i][0]);
                minHeap.offer(newCell);
                sum += arrayOfArrays[i].length;
            }
        }

        int[] result = new int[sum];
        int index = 0;
        List<Integer> temp = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            Cell cur = minHeap.poll();
            result[index++] = cur.val;
            int curRow = cur.row;
            int curCol = cur.col;

            if (curCol < arrayOfArrays[curRow].length - 1) {
                Cell newCell = new Cell(cur.row, cur.col + 1, arrayOfArrays[cur.row][cur.col + 1]);
                minHeap.offer(newCell);
            }
        }

        return result;
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

// TC : O(nklogk)
// SC : O(k)