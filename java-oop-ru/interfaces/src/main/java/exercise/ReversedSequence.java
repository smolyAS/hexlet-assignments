package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String original;

    public ReversedSequence(String original) {
        this.original = original;
    }

    @Override
    public int length() {
        return original.length();
    }

    @Override
    public char charAt(int index) {
        return original.charAt(length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String sub = original.substring(length() - end, length() - start);
        return new ReversedSequence(sub);
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder(original);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        CharSequence text = new ReversedSequence("abcdef");

        System.out.println(text.toString());             // "fedcba"
        System.out.println(text.charAt(1));               // 'e'
        System.out.println(text.length());                // 6
        System.out.println(text.subSequence(1, 4).toString());  // "edc"
    }
}
// END
