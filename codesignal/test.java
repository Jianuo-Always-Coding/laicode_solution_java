

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int result = countSimilarPairs(nums);
        System.out.println("Number of pairs with exactly one differing digit: " + result);

    }


    public static int countSimilarPairs(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (theSameDigtals(array[i], array[j]) && validDiff(array[i], array[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean theSameDigtals(int a, int b) {
        int countA = 0;
        while (a != 0) {
            a = a / 10;
            countA++;
        }

        int countB = 0;
        while (b != 0) {
            b = b / 10;
            countB++;
        }

        if (countA == countB) {
            return true;
        }
        return false;
    }

    private static boolean validDiff(int a, int b) {
        int diff = Math.abs(a - b);
        while (diff != 0) {
            int onesDigit = diff % 10;
            if (onesDigit != 0 && diff > 10) {
                return false;
            } else if (onesDigit != 0 && diff < 10) {
                return true;
            } else {
                diff /= 10;
            }
        }
        // diff = 0
        return false;
    }
}


