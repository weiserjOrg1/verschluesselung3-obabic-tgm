package obabic.cipher;

public class TranspositionCipher implements Cipher{

	private String eText;

	
	public String getEText() {
		return this.eText;
	}

	public void setEText(String eText) {
		this.eText = eText;
	}

	@Override
	public String encrypt(String text) {
		String newText = text.replaceAll("\\s", "");
		char[][] tTable = new char[1][newText.length()];
		for(int i = 0; i < 1; i++) {
			for(int j= 0; j < 1; i++) {
				tTable[i][j] = '.';
			}
		}
		return newText;
	}

	@Override
	public String decrypt(String text) {
		return null;
	}
}