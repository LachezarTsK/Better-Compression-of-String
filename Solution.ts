
function betterCompression(compressed: string): string {
    this.ALPHABET_SIZE = 26;
    this.ASCII_SMALL_CASE_A = 97;
    this.ASCII_ZERO = 48;

    const frequency = createArrayFrequency(compressed);
    return createBetterCompression(frequency);
};

function createArrayFrequency(compressed: string): number[] {
    const frequency: number[] = new Array(this.ALPHABET_SIZE).fill(0);
    for (let i = 0; i < compressed.length; ++i) {

        let compression = 0;
        let letter = compressed.codePointAt(i);
        while (++i < compressed.length && isDigit(compressed.charAt(i))) {
            compression = compression * 10 + (compressed.codePointAt(i) - this.ASCII_ZERO);
        }
        frequency[letter - this.ASCII_SMALL_CASE_A] += compression;
        --i;
    }
    return frequency;
}

function createBetterCompression(frequency: number[]): string {
    const betterCompression: string[] = new Array();
    for (let letter = 0; letter < this.ALPHABET_SIZE; ++letter) {
        if (frequency[letter] > 0) {
            betterCompression.push(String.fromCodePoint(letter + this.ASCII_SMALL_CASE_A));
            betterCompression.push((frequency[letter]).toString());
        }
    }
    return betterCompression.join('');
}

function isDigit(character: string): boolean {
    return '0' <= character && character <= '9';
}
