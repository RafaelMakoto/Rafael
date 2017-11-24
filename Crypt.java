import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Crypt {
	// field

	// method
	public static void main(String[] args) {
		WindowMan man = new WindowMan();
	}
}


class WindowMan implements ActionListener{
	// field
	JFrame frame;
	JTextArea taPlain;
	JTextArea taEncrypted;
	JButton buttonEncrypt;
	JScrollPane spPlain;
	JScrollPane spEncrypted;
	JPanel panelButton;

	// method
	public WindowMan() {
		// frame������
		frame = new JFrame("Cryptman");
		frame.setLocation(400, 400);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �p�[�c������
		//   ���e�L�X�g
		taPlain = new JTextArea(5, 20);
		spPlain = new JScrollPane(taPlain);

		//   �{�^��
		buttonEncrypt = new JButton("Encrypt");
		buttonEncrypt.addActionListener(this);
		panelButton = new JPanel();
		panelButton.add(buttonEncrypt);

		//   �Í����e�L�X�g
		taEncrypted = new JTextArea(5, 20);
		spEncrypted = new JScrollPane(taEncrypted);

		// �ڂ���
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(spPlain);
		con.add(panelButton);
		con.add(spEncrypted);

		// frame����������
		frame.setVisible(true);
	}

	// �{�^�����N���b�N�������̏���
	public void actionPerformed(ActionEvent ae){
		String textPlain = taPlain.getText();
		CryptMan cman = new CryptMan();
		String textEncrypted = cman.getTextEncrypted(textPlain);

		taEncrypted.setText(textEncrypted);
	}
}


class CryptMan {
	// field
	private int numCaesar;
	private char[] resource;

	// method
	// �R���X�g���N�^
	public CryptMan() {
		this.numCaesar = +1;
	}

	// �e�L�X�g���A�V�[�U�[�Í�������
	public String getTextEncrypted(String str) {
		// �e�L�X�g���A�����̔z��ɂ���
		this.resource = str.toCharArray();

		// �ꕶ�����A�Í�������
		for(int i = 0;  i < str.length();  i++) {
			int tmp = this.resource[i];
			tmp += this.numCaesar;
			this.resource[i] = (char)tmp;
		}

		// �Í������ꂽ�e�L�X�g��Ԃ�
		return String.valueOf(this.resource);
	}
}