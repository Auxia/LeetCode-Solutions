//Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?

public class IsUnique {
    public static void main(String[] args) {
        String str = "abcdee";
        System.out.println(isUnique(str));
    }

    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}


// How to run java program from command line
// javac IsUnique.java
// java IsUnique
