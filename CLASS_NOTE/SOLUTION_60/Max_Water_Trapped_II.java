public class Solution {
  public int maxTrapped(int[][] matrix) {
    // Write your solution here
    // corner case
    if (matrix.length <= 2 || matrix[0].length <= 2) {
      return 0;
    }

    int sum = 0;
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();

    // put left and right boder
    for (int i = 0; i < matrix.length; i++) {
      minHeap.offer(new Pair(i, 0, matrix[i][0]));
      minHeap.offer(new Pair(i, matrix[0].length - 1, matrix[i][matrix[0].length - 1]));
      visited[i][0] = true;
      visited[i][matrix[0].length - 1] = true;
    }
    // put top and bottom boder
    for (int i = 1; i < matrix[0].length - 1; i++) {
      minHeap.offer(new Pair(0, i, matrix[0][i]));
      minHeap.offer(new Pair(matrix.length - 1, i, matrix[matrix.length - 1][i]));
      visited[0][i] = true;
      visited[matrix.length - 1][i] = true;
    }

    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      
      List<Pair> neighbors = getNeighbors(matrix, cur);
      for (Pair nei : neighbors) {
        if (visited[nei.x][nei.y]) {
          continue;
        }
        visited[nei.x][nei.y] = true;
        sum += Math.max(0, cur.height - nei.height);
        nei.height = Math.max(cur.height, nei.height);
        minHeap.offer(nei);
      }
    }
    return sum;
  }

  private List<Pair> getNeighbors(int[][] matrix, Pair cur) {
    List<Pair> neighbors = new ArrayList<>();
    // up
    int row = cur.x;
    int col = cur.y;
    if (row > 0) {
      neighbors.add(new Pair(row - 1, col, matrix[row - 1][col]));
    }
    // down
    if (row < matrix.length - 1) {
      neighbors.add(new Pair(row + 1, col, matrix[row + 1][col]));
    }

    // left
    if (col > 0) {
      neighbors.add(new Pair(row, col - 1, matrix[row][col - 1]));
    }
    // right
    if (col < matrix[0].length - 1) {
      neighbors.add(new Pair(row, col + 1, matrix[row][col + 1]));
    }
    return neighbors;
  }

  static class Pair implements Comparable<Pair> {
    int x;
    int y;
    int height;
    Pair(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }

    @Override
    public int compareTo(Pair another) {
      if (this.height == another.height) {
        return 0;
      }
      return this.height < another.height ? -1 : 1;
    }
  }
}

// TC : O(mnlog(m+n))
// SC : O(mn)