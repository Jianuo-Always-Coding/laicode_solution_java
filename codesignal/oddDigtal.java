public class test {
    public static void main(String[] args) {
        int[] input = new int[] {4, 8098, 9, 34, 90};
        int number = findResult(input);
        System.out.println(number);
    }

    public static int findResult(int[] array) {
        int number = 0;
        int left = 0;
        int right = array.length - 1;

        while (array[0] != -1) {
            left = 0;
            for (int i = 0; i <= right; i++) {
                array[i] /= 10;
            }
            while(left <= right) {
                
                if (array[left] > 0 && array[left] < 10) {
                    array[left] = -1;
                    number++;
                    swap(array, left, right--);
                } else if (array[left] == 0) {
                    array[left] = -1;
                    swap(array, left, right--);
                } else {
                    left++;
                }
            }
            for (int i = 0; i <= right; i++) {
                array[i] /= 10;
            }
        }
        return number;

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
