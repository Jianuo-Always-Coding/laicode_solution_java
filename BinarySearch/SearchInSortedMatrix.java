public class SearchInSortedMatrix {
    public int[] search(int[][] matrix, int target) {
        // corner case
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }

        int left = 0;
        int right = (matrix.length) * (matrix[0].length) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if (matrix[row][col] == target) {
                return new int[] {row, col};
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}

// TC : O(logmn)
// SC : O(1)