package obabic.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{

	private String keyWord;
	private String nAlph;
	
	public KeywordCipher(String keyWord) {
		super();
		this.nAlph = "";
		this.setKeyWord(keyWord);
		this.newAlph();
	}

	private void newAlph() {
		
	}

	public String getnAlph() {
		return nAlph;
	}

	public void setnAlph(String nAlph) {
		this.nAlph = nAlph;
	}

	public String getKeyWord() {
		return keyWord;
	}

	private void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
}
