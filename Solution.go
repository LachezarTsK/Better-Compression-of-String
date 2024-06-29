
package main

import (
	"fmt"
	"strings"
	"unicode"
)

const ALPHABET_SIZE = 26

func betterCompression(compressed string) string {
	var frequency = createArrayFrequency(&compressed)
	return createBetterCompression(&frequency)
}

func createArrayFrequency(compressed *string) [ALPHABET_SIZE]int {
	frequency := [ALPHABET_SIZE]int{}

	for i := 0; i < len(*compressed); i++ {

		compression := 0
		letter := (*compressed)[i]
		i++
		for i < len(*compressed) && unicode.IsDigit(rune((*compressed)[i])) {
			compression = compression*10 + int(((*compressed)[i])-'0')
			i++
		}
		i--
		frequency[int(letter-'a')] += compression
	}
	return frequency
}

func createBetterCompression(frequency *[ALPHABET_SIZE]int) string {
	betterCompression := strings.Builder{}

	for letter := 0; letter < ALPHABET_SIZE; letter++ {
		if (*frequency)[letter] > 0 {
			betterCompression.WriteRune(rune(letter + 'a'))
			betterCompression.WriteString(fmt.Sprint((*frequency)[letter]))
		}
	}
	return betterCompression.String()
}
