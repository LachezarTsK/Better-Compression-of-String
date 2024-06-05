
#include <span>
#include <array>
#include <string>
#include <string_view>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;

public:
    string betterCompression(const string& compressed) const {
        array<int, ALPHABET_SIZE> frequency = createArrayFrequency(compressed);
        return createBetterCompression(frequency);
    }

private:
    array<int, ALPHABET_SIZE> createArrayFrequency(string_view compressed) const {
        array<int, ALPHABET_SIZE> frequency{};
        for (size_t i = 0; i < compressed.length(); ++i) {

            int compression = 0;
            char letter = compressed[i];
            while (++i < compressed.length() && isdigit(compressed[i])) {
                compression = compression * 10 + (compressed[i] - '0');
            }
            frequency[letter - 'a'] += compression;
            --i;
        }
        return frequency;
    }

    string createBetterCompression(span<const int> frequency) const {
        string betterCompression;
        for (size_t letter = 0; letter < ALPHABET_SIZE; ++letter) {
            if (frequency[letter] > 0) {
                betterCompression.push_back(static_cast<char>(letter + 'a'));
                betterCompression.append(to_string(frequency[letter]));
            }
        }
        return betterCompression;
    }
};
