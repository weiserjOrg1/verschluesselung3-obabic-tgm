package obabic.cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cController implements ActionListener{

	private cModel m1;
	private cView v1;
	private int help;
	
	public cController() {
		this.m1 = new cModel();
		this.v1 = new cView(this, this.m1);
		this.help = 0; // 0 = SubstitutionC, 1 = ShiftC, 2->Infinity = "Other"
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.v1.isSubCipher(e)) {
			//Substitution Cipher 
			this.v1.activateSubC();
			this.help = 0;
		}
		if(this.v1.isShiftCipher(e)) {
			//Shift Cipher 
			this.v1.activateShiftC();
			this.help = 1;
		}
		if(this.v1.isTransCipher(e)) {
			//Transposition Cipher 
			this.v1.activateTransC();
			this.help = 0;
		}
		if(this.v1.isKeyCipher(e)) {
			//Keyword Cipher 
			this.v1.activateKeyC();
			this.help = 2;
		}
		if(this.v1.isApply(e)) {
			//applies
			if(this.help == 0) {
				this.m1.m1.setSecretAlphabet(this.v1.getSubAlph());
			}
			if(this.help == 1) {
				this.m1.sh1.setShiftValue(Integer.parseInt(this.v1.getShiftAlph()));
			}
			if(this.help == 2) {
				this.m1.k1.newAlph(this.v1.getKeyAlph());
			}
		}
		if(this.v1.isDecrypt(e)) {
			//decrypts
			if(this.v1.isTrans()) {

				this.v1.setOutput(this.m1.ts1.decrypt(this.v1.getText()));
			}else {
				this.v1.setOutput(this.m1.m1.decrypt(this.v1.getText()));
			}
		}
		if(this.v1.isEncrypt(e)) {
			//encrypts
			if(this.v1.isTrans()) {
				this.v1.setOutput(this.m1.ts1.encrypt(this.v1.getText()));
			}else {
				this.v1.setOutput(this.m1.m1.encrypt(this.v1.getText()));
			}
		}

	}
}
