package com.game.pig3;

import android.widget.PopupWindow;

public class PlayerWindow extends PopupWindow
{
//public static final Dimension DEFAULT_SIZE = new Dimension(450, 300)
//private static final Dimension DEFAULT_PPANEL_SIZE = new Dimension(420, 70);
	private static PlayerWindow _instance_;

public static void setPlayersAndClose(Player p1, Player p2) {
	MainActivity.setPlayer1(p1);
	MainActivity.setPlayer2(p2);
	_instance_.dismiss();
	_instance_ = null;
}
public PlayerWindow() {
	if (_instance_ == null) {
		_instance_ = this;
		//JPanel p1Panel = GetPlayerPanel();
		//JTextField p1text = this.getPlayerTextField("Player 1");
//		p1Panel.add(p1text);
//		JPanel p2Panel = GetPlayerPanel();
//		JTextField p2text = this.getPlayerTextField("Player 2");
//		p2Panel.add(p2text);
//		this.add(p1Panel);
//		this.add(p2Panel);
//		JButton submitButton = new JButton("Submit");
//		submitButton.addActionListener((e) -> {
//			if (this.checkIfInputValid(p1text) && this.checkIfInputValid(p2text)) {
//				setPlayersAndClose(new Player(p1text.getText()), new Player(p2text.getText()));
//			}
//
//		});
//		this.add(submitButton);
//		this.setPreferredSize(DEFAULT_SIZE);
//		this.setSize(this.getPreferredSize());
//		this.pack();
//		this.setAlwaysOnTop(true);
//		this.setVisible(true);
//	}
}
//
//private static JPanel GetPlayerPanel() {
//	JPanel ppan = new JPanel();
//	ppan.setPreferredSize(DEFAULT_PPANEL_SIZE);
//	ppan.setSize(ppan.getPreferredSize());
//	ppan.setBackground(Color.gray);
//	return ppan;
//}
//
//private JTextField getPlayerTextField(String s) {
//	JTextField ptext = new JTextField(s);
//	ptext.setBackground(Color.darkGray);
//	ptext.setFont(GameWindow.DEFAULT_FONT);
//	ptext.setForeground(Color.WHITE);
//	ptext.setPreferredSize(new Dimension(DEFAULT_PPANEL_SIZE.width, DEFAULT_PPANEL_SIZE.height));
//	ptext.setSize(this.getPreferredSize());
//	ptext.setVisible(true);
//	return ptext;
//}
//
//private boolean checkIfInputValid(JTextField p1text) {
//	return !p1text.getText().isEmpty();
}
}
