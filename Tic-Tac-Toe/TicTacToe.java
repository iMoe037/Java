import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TicTacToe implements ActionListener	{

	//Setting up GUI Buttons and Panels
	JFrame window = new JFrame("Tic-Tac-Toe");

	JMenuBar mnuMain = new JMenuBar();
	JMenuItem 	mnuNewGame = new JMenuItem("Main Menu");	

	JButton 	btn1v1 = new JButton("Player vs Player"),
			btn1vCPU = new JButton("Player vs Computer"),
			btnContinue = new JButton("Continue..."),
			btnReset = new JButton("Reset Board");
	JButton btnEmpty[] = new JButton[10];

	JPanel 	pnlNewGame = new JPanel(),
			pnlMenu = new JPanel(),
			pnlMain = new JPanel(),
			pnlTop = new JPanel(),
			pnlBottom = new JPanel(),
			pnlReset = new JPanel(),
			pnlPlayingField = new JPanel();

	JLabel 	lblTurn = new JLabel(),
			lblStatus = new JLabel("", JLabel.CENTER);
	JTextArea txtMessage = new JTextArea();

	final int winCombo[][] = new int[][]	{
			{1, 2, 3}, 			{1, 4, 7}, 		{1, 5, 9},
			{4, 5, 6}, 			{2, 5, 8}, 		{3, 5, 7},
			{7, 8, 9}, 			{3, 6, 9}
	};
	final int X = 535, Y = 342;

	int 	turn = 1, 
			player1Won = 0, 
			player2Won = 0,
			wonNumber1 = 1, 
			wonNumber2 = 1, 
			wonNumber3 = 1;
	int option;
	boolean inGame = false;
	boolean CPUGame=false;
	boolean win = false;
	boolean btnEmptyClicked = false;
	String message, whoTurn, 
	Player1 = "Player 1", Player2 = "Player 2";


	public TicTacToe()	{	
		//Window Sizes
		window.setSize(X, Y);
		window.setLocation(350, 260);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the Layouts
		pnlMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));


		//Setting up Panel rest
		pnlReset.setLayout(new GridLayout(1, 2, 2, 2));
		pnlReset.add(btnReset);


		//Adding menu items to menu bar
		mnuMain.add(mnuNewGame);

		//Adding buttons to NewGame panel
		pnlNewGame.setLayout(new GridLayout(4, 1, 2, 10));
		pnlNewGame.add(btnContinue);
		pnlNewGame.add(btn1v1);
		pnlNewGame.add(btn1vCPU);

		//Button settings
		btnReset.setEnabled(false);
		btnContinue.setEnabled(false);

		//Adding Action Listener to all the Buttons and Menu Items
		mnuNewGame.addActionListener(this);
		btn1v1.addActionListener(this);
		btn1vCPU.addActionListener(this);
		btnContinue.addActionListener(this);
		btnReset.addActionListener(this);

		//Setting up the playing field
		pnlPlayingField.setLayout(new GridLayout(3, 3, 2, 2));
		for(int i=1; i<=9; i++)	{
			btnEmpty[i] = new JButton();
			btnEmpty[i].addActionListener(this);
			pnlPlayingField.add(btnEmpty[i]);//	Playing Field is Compelte
		}

		//Adding to the Panels
		pnlMenu.add(mnuMain);
		pnlTop.add(pnlNewGame);
		pnlMain.add(pnlTop);

		//Adding to window and Showing window
		window.add(pnlMenu, BorderLayout.NORTH);
		window.add(pnlMain, BorderLayout.CENTER);
		window.setVisible(true);
	}

	public static void main(String[] args)	{
		new TicTacToe();
	}

	public void showGame()	{	
		//	Shows the Playing Field
		clearPanelSouth();
		pnlMain.setLayout(new BorderLayout());
		pnlTop.setLayout(new BorderLayout());
		pnlBottom.setLayout(new BorderLayout());
		pnlTop.add(pnlPlayingField);
		pnlBottom.add(lblTurn, BorderLayout.WEST);
		pnlBottom.add(lblStatus, BorderLayout.CENTER);
		pnlBottom.add(pnlReset, BorderLayout.EAST);
		pnlMain.add(pnlTop, BorderLayout.CENTER);
		pnlMain.add(pnlBottom, BorderLayout.SOUTH);
		pnlPlayingField.requestFocus();
		inGame = true;
		checkTurn();
		checkWinStatus();
	}

	public void newGame()	{	
		//	Sets the game and shows the tic tac toe board
		for(int i=1; i<10; i++)	{
			btnEmpty[i].setText("");
			btnEmpty[i].setEnabled(true);
		}
		turn = 1;
		win = false;
		showGame();
	}

	public void checkWin()	{	
		for(int i=0; i<8; i++)	{
			if(
					!btnEmpty[winCombo[i][0]].getText().equals("") &&
					btnEmpty[winCombo[i][0]].getText().equals(btnEmpty[winCombo[i][1]].getText()) &&
					btnEmpty[winCombo[i][1]].getText().equals(btnEmpty[winCombo[i][2]].getText()))	{

				win = true;
				wonNumber1 = winCombo[i][0];
				wonNumber2 = winCombo[i][1];
				wonNumber3 = winCombo[i][2];
				break;
			}
		}
		if(win || (!win && turn>9))	{
			if(win)	{
				if(btnEmpty[wonNumber1].getText().equals("X"))	{
					message = Player1 + " has won";
					player1Won++;
				}
				else	{
					message = Player2 + " has won";
					player2Won++;
				}
			}	else if(!win && turn>9)
				message = "Both players have tied!\nBetter luck next time.";
			showMessage(message);
			for(int i=1; i<=9; i++)	{
				btnEmpty[i].setEnabled(false);
			}
			btnReset.setEnabled(true);
			checkWinStatus();
		}// else
			//checkTurn();
	}
	public void AI()	{
		int computerButton;
		if(turn <= 9)	{
			turn++;
			computerButton = CPU.doMove(
					btnEmpty[1], btnEmpty[2], btnEmpty[3],
					btnEmpty[4], btnEmpty[5], btnEmpty[6],
					btnEmpty[7], btnEmpty[8], btnEmpty[9]);
			if(computerButton == 0)
				Random();
			else {
				btnEmpty[computerButton].setText("O");
				btnEmpty[computerButton].setEnabled(false);
			}
			checkWin();
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------	
	public void Random()	{
		int random;
		if(turn <= 9)	{
			random = 0;
			while(random == 0)	{
				random = (int)(Math.random() * 10);
			}
			if(CPU.doRandomMove(btnEmpty[random]))	{
				btnEmpty[random].setText("O");
				btnEmpty[random].setEnabled(false);
			} else {
				Random();
			}
		}
	}

	public void checkTurn()
	// checks whos turn
	{
		if(!(turn % 2 == 0))	{
			whoTurn = Player1 + " [X]";
		}	else	{
			whoTurn = Player2 + " [O]";
		}
		lblTurn.setText("Turn: " + whoTurn);
	}

	public void checkWinStatus()
	//Checks who won
	{
		lblStatus.setText(Player1 + ": " + player1Won + " | " + Player2 + ": " + player2Won);	
	}

	public void setDefaultLayout()	{
		pnlMain.setLayout(new GridLayout(2, 1, 2, 5));
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public int askMessage(String message, String title, int option)	{
		return JOptionPane.showConfirmDialog(null, message, title, option);
	}

	public String getInput(String message, String setText)	{
		return JOptionPane.showInputDialog(null, message, setText);
	}

	public void showMessage(String message)	{
		JOptionPane.showMessageDialog(null, message);
	}

	public void clearPanelSouth()	{	//Removes all the possible panels 
		//that pnlMain, pnlTop, pnlBottom
		//could have.
		pnlMain.remove(pnlTop);
		pnlMain.remove(pnlBottom);
		pnlTop.remove(pnlNewGame);
		pnlTop.remove(txtMessage);
		pnlTop.remove(pnlPlayingField);
		pnlBottom.remove(lblTurn);
		pnlBottom.remove(pnlReset);
	}

	public void actionPerformed(ActionEvent click)	{
		Object source = click.getSource();
		for(int i=1; i<=9; i++)	{
			if(source == btnEmpty[i] && turn <	10)	{
				btnEmptyClicked = true;
				if(!(turn % 2 == 0))
					btnEmpty[i].setText("X");
				else
					btnEmpty[i].setText("O");
				btnEmpty[i].setEnabled(false);
				pnlPlayingField.requestFocus();
				turn++;
				checkWin();
				if(CPUGame && win == false)
					AI();
			}
		}
		if(source == mnuNewGame)	{
			clearPanelSouth();
			setDefaultLayout();

			if(source == mnuNewGame)	{//NewGame
				pnlTop.add(pnlNewGame);
			}	
			pnlMain.add(pnlTop);
		}
		else if(source == btn1v1 || source == btn1vCPU)	{
			if(inGame)	{
				option = askMessage("If you start a new game," +
						"your current game will be lost..." + "\n" +
						"Are you sure you want to continue?", 
						"Quit Game?" ,JOptionPane.YES_NO_OPTION
						);
				if(option == JOptionPane.YES_OPTION)
					inGame = false;
			}
			if(!inGame)	{
				btnContinue.setEnabled(true);
				if(source == btn1v1)	{// 1 v 1 Game
					//Player2 = tempPlayer2;
					player1Won = 0;
					player2Won = 0;
					CPUGame = false;	
					newGame();
				} else	{// 1 v CPU Game
					//Player2 = "Computer";
					player1Won = 0;
					player2Won = 0;
					CPUGame = true;
					newGame();
				}
			}
		}
		else if(source == btnContinue)	{
			checkTurn();
			showGame();
		}
		else if(source == btnReset)	{
			newGame();
			btnReset.setEnabled(false);
		}
		pnlMain.setVisible(false);
		pnlMain.setVisible(true);
	}
}
