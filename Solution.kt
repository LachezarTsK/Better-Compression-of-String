
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun betterCompression(compressed: String): String {
        val frequency = createArrayFrequency(compressed.toCharArray());
        return createBetterCompression(frequency);
    }

    private fun createArrayFrequency(compressed: CharArray): IntArray {
        val frequency = IntArray(ALPHABET_SIZE)
        var index = 0

        while (index < compressed.size) {

            var compression = 0;
            val letter = compressed[index];
            while (++index < compressed.size && Character.isDigit(compressed[index])) {
                compression = compression * 10 + (compressed[index] - '0');
            }
            println(letter)
            frequency[letter - 'a'] += compression;
        }
        return frequency;
    }

    private fun createBetterCompression(frequency: IntArray): String {
        val betterCompression = StringBuilder()
        for (letter in 0..<ALPHABET_SIZE) {
            if (frequency[letter] > 0) {
                betterCompression.append((letter + 'a'.code).toChar());
                betterCompression.append(frequency[letter]);
            }
        }
        return betterCompression.toString()
    }
}
