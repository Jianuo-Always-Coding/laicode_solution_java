// Java program to implement the
// above approach
import java.util.*;

class test{

    public static int findNum(int[] array) {
        // corner case
        if (array == null || array.length <= 2) {
            return 0;
        }
        int count = 0;
        int[] prefix = new int[array.length];
        int val = 0;
        for (int i = 0; i < array.length; i++) {
            val = val ^ array[i];
            prefix[i] = val;
        }

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                int mid = prefix[j] ^ prefix[i];
                int head = array[i] ^ array[j + 1];
                if (mid == head) {
                    count++;
                }
            }
        }
        return count % (1000000007);
    }
    // Driver Code
    public static void main(String args[])
    {

    }
}

// This code is contributed by SURENDRA_GANGWAR

