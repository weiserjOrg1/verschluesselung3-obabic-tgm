package obabic.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{

	private String keyWord;
	private String nAlph;
	
	public KeywordCipher(String keyWord) {
		super();
		this.nAlph = "";
		this.setKeyWord(keyWord);
		this.makeAlph();
	}

	private void makeAlph() {
		String secretAlph = "";
		String help1 = "";
		this.keyWord = this.keyWord.toLowerCase();
		
		while(true) {
			if(checkDuplicateChars(this.keyWord)) break;
		}
		secretAlph = this.keyWord + this.changedAlph();
		super.setSecretAlphabet(secretAlph);
	}

	private String changedAlph() {
		return null;
	}

	public String getNAlph() {
		return nAlph;
	}

	public void setNAlph(String nAlph) {
		this.nAlph = nAlph;
	}

	public String getKeyWord() {
		return keyWord;
	}

	private void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public static boolean checkDuplicateChars(CharSequence g) {
	    for (int i = 0; i < g.length(); i++) {
	        for (int j = i + 1; j < g.length(); j++) {
	            if (g.charAt(i) == g.charAt(j)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
