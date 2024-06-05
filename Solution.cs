
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;

    public string BetterCompression(string compressed)
    {
        int[] frequency = CreateArrayFrequency(compressed.ToCharArray());
        return CreateBetterCompression(frequency);
    }

    private int[] CreateArrayFrequency(char[] compressed)
    {
        int[] frequency = new int[ALPHABET_SIZE];
        for (int i = 0; i < compressed.Length; ++i)
        {
            int compression = 0;
            char letter = compressed[i];
            while (++i < compressed.Length && char.IsDigit(compressed[i]))
            {
                compression = compression * 10 + (compressed[i] - '0');
            }
            frequency[letter - 'a'] += compression;
            --i;
        }
        return frequency;
    }

    private String CreateBetterCompression(int[] frequency)
    {
        StringBuilder betterCompression = new StringBuilder();
        for (int letter = 0; letter < ALPHABET_SIZE; ++letter)
        {
            if (frequency[letter] > 0)
            {
                betterCompression.Append((char)(letter + 'a'));
                betterCompression.Append(frequency[letter]);
            }
        }
        return betterCompression.ToString();
    }
}
