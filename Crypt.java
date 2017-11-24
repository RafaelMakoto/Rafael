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
		// frameをつくる
		frame = new JFrame("Cryptman");
		frame.setLocation(400, 400);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// パーツをつくる
		//   元テキスト
		taPlain = new JTextArea(5, 20);
		spPlain = new JScrollPane(taPlain);

		//   ボタン
		buttonEncrypt = new JButton("Encrypt");
		buttonEncrypt.addActionListener(this);
		panelButton = new JPanel();
		panelButton.add(buttonEncrypt);

		//   暗号化テキスト
		taEncrypted = new JTextArea(5, 20);
		spEncrypted = new JScrollPane(taEncrypted);

		// 載せる
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(spPlain);
		con.add(panelButton);
		con.add(spEncrypted);

		// frameを可視化する
		frame.setVisible(true);
	}

	// ボタンをクリックした時の処理
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
	// コンストラクタ
	public CryptMan() {
		this.numCaesar = +1;
	}

	// テキストを、シーザー暗号化する
	public String getTextEncrypted(String str) {
		// テキストを、文字の配列にする
		this.resource = str.toCharArray();

		// 一文字ずつ、暗号化する
		for(int i = 0;  i < str.length();  i++) {
			int tmp = this.resource[i];
			tmp += this.numCaesar;
			this.resource[i] = (char)tmp;
		}

		// 暗号化されたテキストを返す
		return String.valueOf(this.resource);
	}
}