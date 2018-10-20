package obabic.cipher;

public class ShiftCipher extends MonoAlphabeticCipher{

	public ShiftCipher(int value) {
		this.setShiftValue(value);
	}
	
	public void setShiftValue(int value) {
		String sAlph = "abcdefghijklmnopqrstuvwxyzäöüß";
		String nAlph = "";
		value %= 30;
		if(value ==0) return;
		if(value > 0) {
			nAlph = sAlph.substring(value);
			nAlph += sAlph.substring(0, value);
			super.setSecretAlphabet(nAlph);
		}else {
			nAlph = sAlph.substring(29+value);
			nAlph = sAlph.substring(0, 29+value);
			super.setSecretAlphabet(nAlph);
		}
	}
}