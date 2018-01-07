import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GFX {
	private JFrame gameFrame;
	private JPanel gamePanel;
	private JButton[] gameButtons;
	public int playerTurn = 1;

	public GFX(ActionListener gameActionListener) {
		gameFrame = new JFrame();
		gamePanel = new JPanel(new GridLayout(3, 3));
		gameButtons = new JButton[9];

		gamePanel.setPreferredSize(new Dimension(600, 600));
		gameFrame.add(gamePanel);
		for (int i = 0; i < gameButtons.length; i++) {
			gameButtons[i] = new JButton();
			gamePanel.add(gameButtons[i]);
			gameButtons[i].setText("1" + i);
			gameButtons[i].addActionListener(gameActionListener);
		}

		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.pack();
	}

	public int getClickedButtonLocation(JButton clickedButton) {
		int clickedButtonPosition = 0;

		for (int i = 0; i < gameButtons.length; i++) {
			if (gameButtons[i] == clickedButton) {
				clickedButtonPosition = i;
				break;
			}
		}

		return clickedButtonPosition;
	}

	public void update(JButton clickedButton) {
		if (playerTurn == 1) {
			clickedButton.setText("X");
		} else {
			clickedButton.setText("O");
		}
	}

}
