package obabic.cipher;

import javax.swing.*;


public class cModel {

	
	public MonoAlphabeticCipher m1;
	public SubstitutionCipher su1;
	public ShiftCipher sh1;
	
	public cModel() {
		this.m1 = new MonoAlphabeticCipher();	
		this.su1 = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		this.sh1 = new ShiftCipher(0);
		this.m1 = this.su1;
	}
	
}
