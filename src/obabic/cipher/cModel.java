package obabic.cipher;

import javax.swing.*;


public class cModel {

	
	public MonoAlphabeticCipher m1;
	public SubstitutionCipher su1;
	public ShiftCipher sh1;
	public TranspositionCipher ts1;
	public KeywordCipher k1;
	
	public cModel(){
		this.m1 = new MonoAlphabeticCipher();	
		this.su1 = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		this.sh1 = new ShiftCipher(0);
		this.ts1 = new TranspositionCipher(0);
		this.k1 = new KeywordCipher("");
		this.m1 = this.su1;
	}
	
}
