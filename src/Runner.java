import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Runner implements ActionListener{
	public GFX gfx;
	public Logic logic;
	
	
	public static void main(String[] args){
		Runner tictactoe = new Runner();
		tictactoe.start();
	}
	
	public void start() {
		gfx = new GFX(this);
		logic = new Logic();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clickedButton = (JButton)e.getSource();
		gfx.update(clickedButton);
		logic.changeButtonState(gfx, clickedButton, gfx.playerTurn);
		if (logic.checkForVictory(gfx.playerTurn)) {
			JOptionPane.showMessageDialog(null, "Player " + gfx.playerTurn + " wins!");
		} else {
			logic.changeTurn(gfx.playerTurn);
		}	
	}


}
