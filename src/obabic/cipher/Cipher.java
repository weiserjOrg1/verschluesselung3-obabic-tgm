package obabic.cipher;
/**
 * This class implements the 2 Strings encrypt and decrypt.
 * @author BABO
 * @version 11.10.2018
 */
public interface Cipher {

	public String encrypt(String text);
	public String decrypt(String text);
}