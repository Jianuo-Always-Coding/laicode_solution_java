public class test {
    public static void main(String[] args) {
        int a = 99;
        int b = 99;
        int result = findResult(a, b);
        System.out.println(result);
    }

    public static int findResult(int a, int b) {
        int aVal = 0;

        while (a != 0) {
            int temp = a % 10;
            aVal += temp;
            a = a / 10;
        }

        int bVal = 0;
        while (b != 0) {
            int temp = b % 10;
            bVal += temp;
            b = b / 10;
        }

        int tempb = bVal;
        int factor = 1;
        while (tempb != 0) {
            factor = factor * 10;
            tempb = tempb / 10;
        }
        return aVal * factor + bVal;
    }
}
