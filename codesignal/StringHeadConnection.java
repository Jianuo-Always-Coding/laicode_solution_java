public class test {
    public static void main(String[] args) {
        String[] input = new String[] {"cat", "dog", "bee"};
        String[] result = findResult(input);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static String[] findResult(String[] input) {
        // corner case
        if (input == null || input.length == 0) {
            return new String[] {};
        }
        String[] result = new String[input.length];
        char firstChar = input[0].charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);
        for (int i = 1; i < input.length; i++) {
            sb.append(input[i].charAt(0));
            result[i - 1] = sb.toString();
            sb.deleteCharAt(0);
        }
        sb.append(firstChar);
        result[result.length - 1] = sb.toString();
        return result;
    }
}
