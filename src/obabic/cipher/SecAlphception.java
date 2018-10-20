package obabic.cipher;
/**
 * This class contains all the exceptions.
 * @author BABO
 * @version 11.10.2018
 */
public class SecAlphception extends Exception{

	public SecAlphception() {
		super("The criteria for the secret alphabet was not fulfilled");
		//standard error message!
	}
	
	public SecAlphception(String errormessage) {
		super(errormessage);
		//custom error message!
	}
}