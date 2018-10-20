package obabic.cipher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

	public class cView extends JFrame{
		
		private cModel m1;
		private cController c1;
		
		private JPanel select;
		private JPanel alphBox;
		private JPanel inOutputBox;
		
		private JRadioButton subCipher;
		private JRadioButton shiftCipher;
		private JRadioButton transCipher;
		private JRadioButton keyCipher;
		private ButtonGroup radioGroup;
		
		private JTextField inputShift;
		private JTextField inputSub;
		private JTextField inputTrans;
		private JTextField inputKey;
		private JLabel shiftLabel;
		private JLabel subLabel;
		private JLabel transLabel;
		private JLabel keyLabel;
		private JPanel inputShiftPanel;
		private JPanel inputSubstPanel;
		private JPanel inputTransPanel;
		private JPanel inputKeyPanel;
		private JButton apply;
		
		private JTextField eText;
		private JTextField output;
		private JButton encrypt;
		private JButton decrypt;
		
		public cView(cController c, cModel m) {
		
		this.setTitle("Verschluesselung");
		this.setSize(new Dimension(400, 500));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.m1 = m;
		this.c1 = c;
	
		//1) Attribute
		
		this.select = new JPanel();
		this.alphBox = new JPanel();
		this.inputSubstPanel = new JPanel();
		this.inOutputBox = new JPanel();
		this.inputShiftPanel = new JPanel();
		this.inputTransPanel = new JPanel();
		this.inputKeyPanel = new JPanel();
		
		this.radioGroup = new ButtonGroup();
		this.shiftCipher = new JRadioButton("Shift Cipher");
		this.subCipher = new JRadioButton("Substitution", true);
		this.transCipher = new JRadioButton("Transposition", true);
		this.keyCipher = new JRadioButton("Keyword", true);

		this.subLabel = new JLabel("Substitution: ");
		this.shiftLabel = new JLabel("Shifting: ");
		this.transLabel = new JLabel("Transposition: ");
		this.keyLabel = new JLabel("Keyword: ");
		
		this.inputShift = new JTextField();
		this.inputSub = new JTextField();
		this.inputTrans = new JTextField();
		this.inputKey = new JTextField();
		this.eText = new JTextField();
		this.output = new JTextField();
		
		this.apply = new JButton("Apply");
		this.encrypt = new JButton("Encrypt");
		this.decrypt = new JButton("Decrypt");
		
		//2) Radio Buttons
		
		this.shiftCipher.addActionListener(this.c1);
		this.subCipher.addActionListener(this.c1);
		this.transCipher.addActionListener(this.c1);
		this.keyCipher.addActionListener(this.c1);
		this.radioGroup.add(this.subCipher);
		this.radioGroup.add(this.shiftCipher);
		this.radioGroup.add(this.transCipher);
		this.radioGroup.add(this.keyCipher);
	
		//3) Panels
		
		this.select.setBorder(BorderFactory.createTitledBorder("Methode"));
		this.select.add(this.subCipher);
		this.select.add(this.shiftCipher);
		this.select.add(this.transCipher);
		this.select.add(this.keyCipher);
	
		this.alphBox.setBorder(BorderFactory.createTitledBorder("Alphabet"));
		this.alphBox.setLayout(new GridLayout(5, 1));
	
		this.inputSubstPanel.setLayout(new GridLayout(1, 2));
		this.inputSubstPanel.add(this.subLabel);
		this.inputSubstPanel.add(this.inputSub);
		
	
		//Textfield on false
		
		this.inputShift.setEditable(false);
		this.inputShiftPanel.setLayout(new GridLayout(1, 2));
		this.inputShiftPanel.add(this.shiftLabel);
		this.inputShiftPanel.add(this.inputShift);
		
		this.inputTrans.setEditable(false);
		this.inputTransPanel.setLayout(new GridLayout(1, 2));
		this.inputTransPanel.add(this.transLabel);
		this.inputTransPanel.add(this.inputTrans);
		
		this.inputKey.setEditable(false);
		this.inputKeyPanel.setLayout(new GridLayout(1, 2));
		this.inputKeyPanel.add(this.keyLabel);
		this.inputKeyPanel.add(this.inputKey);
	
		this.apply.addActionListener(this.c1);
		JPanel applyPanel = new JPanel();
		applyPanel.setLayout(new GridLayout(1, 3));
		applyPanel.add(new Container());
		applyPanel.add(this.apply);
		applyPanel.add(new Container());
	
		this.alphBox.add(this.inputSubstPanel);
		this.alphBox.add(this.inputShiftPanel);
		this.alphBox.add(this.inputTransPanel);
		this.alphBox.add(this.inputKeyPanel);
		this.alphBox.add(applyPanel);
	
		this.inOutputBox.setBorder(BorderFactory.createTitledBorder("Input & Output"));
		this.inOutputBox.setLayout(new GridLayout(4, 1));
	
		JLabel textLabel = new JLabel("Input: ");
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
		textPanel.add(textLabel);
		textPanel.add(this.eText);
	
		JLabel outLabel = new JLabel("Output: ");
		JPanel outPanel = new JPanel();
		outPanel.setLayout(new GridLayout(1, 2));
		outPanel.add(outLabel);
		outPanel.add(this.output);
		this.output.setEditable(false);
	
		this.encrypt.addActionListener(this.c1);
		this.decrypt.addActionListener(this.c1);
	
		this.inOutputBox.add(textPanel);
		this.inOutputBox.add(outPanel);
		this.inOutputBox.add(this.encrypt);
		this.inOutputBox.add(this.decrypt);
	
		this.add(this.select);
		this.add(this.alphBox);
		this.add(this.inOutputBox);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		public void refresh() {
			this.repaint();
		}
		
		public boolean isSubCipher(ActionEvent e) {
			if(this.subCipher == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean isShiftCipher(ActionEvent e) {
			if(this.shiftCipher == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean isTransCipher(ActionEvent e) {
			if(this.transCipher == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		public boolean isKeyCipher(ActionEvent e) {
			if(this.keyCipher == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean isApply(ActionEvent e) {
			if(this.apply == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}	
		
		public boolean isEncrypt(ActionEvent e) {
			if(this.encrypt == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean isDecrypt(ActionEvent e) {
			if(this.decrypt == e.getSource()) {
				return true;
			}else {
				return false;
			}
		}
		
		public void activateSubC() {
			this.inputShift.setEditable(false);
			this.inputSub.setEditable(true);
			this.inputTrans.setEditable(false);
			this.inputKey.setEditable(false);
			this.m1.m1 = this.m1.su1;
		}
		
		public void activateShiftC() {
			this.inputShift.setEditable(true);
			this.inputSub.setEditable(false);
			this.inputTrans.setEditable(false);
			this.inputKey.setEditable(false);
			this.m1.m1 = this.m1.sh1;
		}
		
		public void activateTransC() {
			this.inputShift.setEditable(false);
			this.inputSub.setEditable(false);
			this.inputTrans.setEditable(true);
			this.inputKey.setEditable(false);
		}
		public void activateKeyC() {
			this.inputShift.setEditable(false);
			this.inputSub.setEditable(false);
			this.inputTrans.setEditable(false);
			this.inputKey.setEditable(true);
			this.m1.m1 = this.m1.k1;
		}
		public boolean isTrans() {
			if(transCipher.isSelected()) return true;
			return false;
		}
		public String getSubAlph() {
			return inputSub.getText();
		}
		public String getKeyAlph() {
			return inputKey.getText();
		}
		public String getShiftAlph() {
			return inputShift.getText();
		}
		public String getText() {
			return this.eText.getText();
		}
		public void setOutput(String str) {
			this.output.setText(str);
		}
}