// Given two strings, write a method to decide if one is a permutation of the
// other.


public class CheckPermutations {
    public static void main(String[] args) {
        String str1 = "abcdee";
        String str2 = "acbdef";
        System.out.println(isPermutation(str1, str2));
    }

    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];
        char[] s_array = str1.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}