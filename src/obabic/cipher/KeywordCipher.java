package obabic.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	
	public KeywordCipher(String keyWord){
		this.newAlph(keyWord);
	}

	public void newAlph(String keyWord){
		keyWord = keyWord.toLowerCase();
		String finishedAlph = "";
		
		for (int i = 0; i < keyWord.length(); i++) {
			boolean used = false;
			for (int j = 0; j < finishedAlph.length(); j++) {
				if (finishedAlph.charAt(j) == keyWord.charAt(i))
					used = true;
			}
			if (!used) {
				switch (keyWord.charAt(i)) {
				case 'ä':
					finishedAlph += 'ä';
					break;
				case 'ö':
					finishedAlph += 'ö';
					break;
				case 'ü':
					finishedAlph += 'ü';
					break;
				case 'ß':
					finishedAlph += 'ß';
					break;
				default:
					if (keyWord.charAt(i) >= 97 && keyWord.charAt(i) <= 122)
						finishedAlph += keyWord.charAt(i);
				}
			}
		}
		int keywordLength = finishedAlph.length();
		for (int i = 0; i < 30; i++) {
			boolean verwendet = false;
			char nextLetter = (char) (97 + i);
			switch (nextLetter) {
			case 123:
				nextLetter = 'ä';
				break;
			case 124:
				nextLetter = 'ö';
				break;
			case 125:
				nextLetter = 'ü';
				break;
			case 126:
				nextLetter = 'ß';
				break;
			}
			for (int j = 0; j < keywordLength; j++) {
				if (nextLetter == finishedAlph.charAt(j))
					verwendet = true;
			}
			if (!verwendet) {
				switch (nextLetter) {
				case 123:
					finishedAlph += 'ä';
					break;
				case 124:
					finishedAlph += 'ö';
					break;
				case 125:
					finishedAlph += 'ü';
					break;
				case 126:
					finishedAlph += 'ß';
					break;
				default:
					finishedAlph += nextLetter;
				}
			}
		}
		super.setSecretAlphabet(finishedAlph);
	}
		
}
