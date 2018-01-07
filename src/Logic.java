import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Logic {
	private int buttonStates[];
	private int numTurns;

	public Logic() {
		buttonStates = new int[9];
		numTurns = 0;

		for (int i = 0; i < 9; i++) {
			buttonStates[i] = i;
		}
	}

	public int changeTurn(int playerTurn) {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}

		numTurns++;
		return playerTurn;
	}

	public void changeButtonState(GFX gfx, JButton clickedButton, int playerTurn) {
		buttonStates[gfx.getClickedButtonLocation(clickedButton)] = playerTurn;
	}

	public boolean checkForVictory(int playerTurn) {

		int possWinner = playerTurn;
		boolean isVictorious = false;
		if (numTurns >= 5) {
			if (buttonStates[0] == possWinner && buttonStates[1] == possWinner && buttonStates[2] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[3] == possWinner && buttonStates[4] == possWinner
					&& buttonStates[5] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[6] == possWinner && buttonStates[7] == possWinner
					&& buttonStates[8] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[0] == possWinner && buttonStates[3] == possWinner
					&& buttonStates[6] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[1] == possWinner && buttonStates[4] == possWinner
					&& buttonStates[7] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[2] == possWinner && buttonStates[5] == possWinner
					&& buttonStates[8] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[0] == possWinner && buttonStates[4] == possWinner
					&& buttonStates[8] == possWinner) {
				isVictorious = true;
			} else if (buttonStates[2] == possWinner && buttonStates[4] == possWinner
					&& buttonStates[6] == possWinner) {
				isVictorious = true;
			}
		}
		return isVictorious;

	}
}
