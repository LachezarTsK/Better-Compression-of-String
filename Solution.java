
public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public String betterCompression(String compressed) {
        int[] frequency = createArrayFrequency(compressed.toCharArray());
        return createBetterCompression(frequency);
    }

    private int[] createArrayFrequency(char[] compressed) {
        int[] frequency = new int[ALPHABET_SIZE];
        for (int i = 0; i < compressed.length; ++i) {

            int compression = 0;
            char letter = compressed[i];
            while (++i < compressed.length && Character.isDigit(compressed[i])) {
                compression = compression * 10 + (compressed[i] - '0');
            }
            frequency[letter - 'a'] += compression;
            --i;
        }
        return frequency;
    }

    private String createBetterCompression(int[] frequency) {
        StringBuilder betterCompression = new StringBuilder();
        for (int letter = 0; letter < ALPHABET_SIZE; ++letter) {
            if (frequency[letter] > 0) {
                betterCompression.append((char) (letter + 'a'));
                betterCompression.append(frequency[letter]);
            }
        }
        return betterCompression.toString();
    }
}
