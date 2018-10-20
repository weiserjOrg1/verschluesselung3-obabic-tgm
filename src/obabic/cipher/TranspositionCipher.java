package obabic.cipher;

public class TranspositionCipher implements Cipher{
	
	private int transpositionLevel;

	public TranspositionCipher(int transpositionLevel) {
		this.transpositionLevel = transpositionLevel;
	}

	public void setTranspositionLevel(int transpositionLevel) {
		if (transpositionLevel >= 1)
			this.transpositionLevel = transpositionLevel;
	}
	public String encrypt(String text) {
		text = text.toLowerCase();
		String filteredText = "";
		for (int i = 0; i < text.length(); i++) { // Filter out anything not a letter
			char currentLetter = text.charAt(i);
			switch (currentLetter) {
			case '�':
			case '�':
			case '�':
			case '�':
				filteredText += currentLetter;
				break;
			default:
				if (currentLetter >= 97 && currentLetter <= 122)
					filteredText += currentLetter;
			}
		}
		String output = "";
		char[][] array = new char[this.transpositionLevel + 1][filteredText.length()];
		boolean up = false;
		int k = 0;
		for (int i = 0; i < filteredText.length(); i++) {
			array[k][i] = filteredText.charAt(i);
			if (!up)
				k++;
			if (up)
				k--;
			if (k == this.transpositionLevel)
				up = true;
			if (k == 0)
				up = false;
		}
		int used = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					output += array[i][j];
					used++;
				}
			}
			if (used >= filteredText.length())
				break;
			if (i != array.length - 1)
				output += ' ';
		}
		return output;
	}

	public String decrypt(String text) {
		text = text.toLowerCase();
		if (text.indexOf(' ') == -1)
			return text;
		String[] pieces = new String[this.transpositionLevel + 1];
		int spaceAmount = 0;
		// Check if structure fits to level
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ')
				spaceAmount++;
			if (i == text.length() - 1 && spaceAmount != this.transpositionLevel)
				return text;
		}
		int lastSpaceIndex = 0;
		int longestPiece = 0;
		for (int i = 0; i < this.transpositionLevel + 1; i++) {
			if (i != this.transpositionLevel) {
				pieces[i] = text.substring(lastSpaceIndex, text.indexOf(' ', lastSpaceIndex));
				if (pieces[i].length() > longestPiece)
					longestPiece = pieces[i].length();
			} else {
				pieces[i] = text.substring(lastSpaceIndex);
				if (pieces[i].length() > longestPiece)
					longestPiece = pieces[i].length();
			}
			lastSpaceIndex = text.indexOf(' ', lastSpaceIndex) + 1;
		}
		int pieceLengthTotal = 0;
		// Length of all pieces together
		for (int i = 0; i < pieces.length; i++) {
			pieceLengthTotal += pieces[i].length();
		}
		String output = "";
		int firstPieceIndex = 0, lastPieceIndex = 0, lettersUsed = 0;
		if (this.transpositionLevel > 1) {
			xyz: for (int i = 0; i < longestPiece; i++) {
				if (i % 2 == 0) {
					for (int j = (i == 0) ? 0 : 1; j < pieces.length; j++) {
						if (j == 0) {
							output += pieces[j].charAt(firstPieceIndex);
							firstPieceIndex++;
							lettersUsed++;
						} else if (j == pieces.length - 1) {
							output += pieces[j].charAt(lastPieceIndex);
							lastPieceIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							output += pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLengthTotal) {
							break xyz;
						}
					}
				} else {
					for (int j = pieces.length - 2; j > -1; j--) {
						if (j == 0) {
							output += pieces[j].charAt(firstPieceIndex);
							firstPieceIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							output += pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLengthTotal) {
							break xyz;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < longestPiece; i++) {
				if (i == longestPiece - 1 && pieces[0].length() != pieces[1].length()) {
					output += pieces[0].charAt(i);
				} else {
					output += pieces[0].charAt(i) + "" + pieces[1].charAt(i);
				}

			}
		}
		return output;
	}
}