package obabic.cipher;

/**
 * This is the parent class of SubstitutionCipher and it encrypts and decrypts a text.
 * It also implements Chipher!
 * @author BABO
 * @version 11.10.2018
 */
public class MonoAlphabeticCipher implements Cipher{

	private String secretAlphabet;
	
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	
	protected boolean setSecretAlphabet(String secretAlphabet) {
		String help = exceptMaster(secretAlphabet);
		if(help == null) return false;
		this.secretAlphabet = exceptMaster(secretAlphabet);
		return true;
	}
	
	public String encrypt(String text) {
		String encryptedText = "";
		String defaultAlph = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int place = defaultAlph.indexOf(c);
			if(place == -1) {
				encryptedText = encryptedText + c;
			}else {
				encryptedText = encryptedText + this.secretAlphabet.charAt(place);
			}
		}
		return encryptedText;
	}
	
	public String decrypt(String text) {
		String decryptedText = "";
		String defaultAlph = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int place = this.secretAlphabet.indexOf(c);
			if(place == -1) {
				decryptedText = decryptedText + c;
			}else {
				decryptedText = decryptedText + defaultAlph.charAt(place);
			}
		}
		return decryptedText;
	}
	
	public String exceptMaster(String secretAlphabet) {
		secretAlphabet = secretAlphabet.toLowerCase();
		//criteria 
		//30
		if(secretAlphabet.length() !=30) {
			 return null;
		}
		
		//1x character
		for(int i = 0; i < secretAlphabet.length(); i++) {
			char c = secretAlphabet.charAt(i);
			if(secretAlphabet.indexOf(c) == secretAlphabet.lastIndexOf(c)) {
				
			}else {
				return null;
			}
		}
		
		//invalid characters
		for(int i = 0; i < secretAlphabet.length(); i++) {
            char c = secretAlphabet.charAt(i);
            if(c >= 97 && c <= 122 || c == 246 || c == 228 || c == 252 || c == 223) {
            }else {
            	return null;
            }
        }
		return secretAlphabet;
	}
}