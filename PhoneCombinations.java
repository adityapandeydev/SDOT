//LETTER COMBINATION OF PHONE NUMBER
package Questions;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static final Map<Character, String> PHONE_MAP = new HashMap<>();
    
    static {
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        generateCombinations(digits, 0, new StringBuilder(), result);
        Collections.sort(result); // Sort lexicographically
        return result;
    }

    // ✅ Backtracking function
    private static void generateCombinations(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: when we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = PHONE_MAP.get(digit);

        // For each character that digit maps to, append and recurse
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            generateCombinations(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine().trim();
        
        List<String> combinations = letterCombinations(digits);
        System.out.println(String.join(" ", combinations));
    }
}
