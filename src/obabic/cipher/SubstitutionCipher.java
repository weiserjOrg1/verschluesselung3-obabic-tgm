package obabic.cipher;

import obabic.cipher.MonoAlphabeticCipher;

/**
 * This class is the child class of MonoAlphabeticCipher and it sets the secret Alphabet.
 * @author BABO
 * @version 11.10.2018
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{

	public SubstitutionCipher(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
	
	public boolean setSecretAlphabet(String secretAlphabet){
		return super.setSecretAlphabet(secretAlphabet);
	}
}