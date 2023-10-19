package GraphSearchIBFS;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 */

public class Solution {
    public int[][] wallsAndGates(int[][] rooms) {
        // corner case

        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return rooms;
        }
        Queue<Integer[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Integer[] { i, j });
                }
            }
        }
        int number = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                // look up
                if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                    queue.offer(new Integer[] { row - 1, col });
                    rooms[row - 1][col] = number;
                }
                // look down
                if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                    queue.offer(new Integer[] { row + 1, col });
                    rooms[row + 1][col] = number;
                }
                // look left
                if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                    queue.offer(new Integer[] { row, col - 1 });
                    rooms[row][col - 1] = number;
                }
                // look right
                if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                    queue.offer(new Integer[] { row, col + 1 });
                    rooms[row][col + 1] = number;
                }
            }
            number++;
        }
        return rooms;
    }
}

// TC : O(mn)
// SC : O(mn)