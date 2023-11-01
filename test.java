
import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        String[] input = new String[] {"helloo", "he-loo", "-ell-o", "hell-o"};
        findResult(input, "helloo", result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }        
    }

    private static void findResult(String[] array, String template, List<String> result) {
        for (String s : array) {
            if (s.length() == template.length()) {
                check(s, template, result);
            } 
        }
    }

    private static void check(String a, String b, List<String> result) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '-' && a.contains(String.valueOf(b.charAt(i)))) {
                continue;
            } else if (a.charAt(i) == '-') {
                return ;
            } else if (a.charAt(i) != b.charAt(i)) {
                return ;
            }
        }
        result.add(a);

    }
    
}

