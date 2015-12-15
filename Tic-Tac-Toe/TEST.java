import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TEST implements ActionListener	{
//Setting up ALL the variables
	JFrame window = new JFrame("Tic-Tac-Toe ");
	
	JMenuBar mnuMain = new JMenuBar();
	JMenuItem 	mnuNewGame = new JMenuItem("New Game");
	
	JButton 	btn1v1 = new JButton("Player vs Player"),
				btn1vCPU = new JButton("Player vs Computer"),
				btnContinue = new JButton("Continue..."),
				btnReset = new JButton("Try Again?");
	JButton btnEmpty[] = new JButton[10];
	
	JPanel 	pnlNewGame = new JPanel(),
				pnlMenu = new JPanel(),
				pnlMain = new JPanel(),
				pnlTop = new JPanel(),
				pnlBottom = new JPanel(),
				pnlReset = new JPanel(),
				pnlPlayingField = new JPanel();
				
	JLabel 	lblTitle = new JLabel("Tic-Tac-Toe"),
				lblTurn = new JLabel(),
				lblStatus = new JLabel("", JLabel.CENTER),
				lblMode = new JLabel("", JLabel.LEFT);
	JTextArea txtMessage = new JTextArea();
	
	final int winCombo[][] = new int[][]	{
		{1, 2, 3}, 			{1, 4, 7}, 		{1, 5, 9},
		{4, 5, 6}, 			{2, 5, 8}, 		{3, 5, 7},
		{7, 8, 9}, 			{3, 6, 9}
/*Horizontal Wins*/	/*Vertical Wins*/ /*Diagonal Wins*/
	};
	final int X = 535, Y = 342;
	int 	turn = 1,
			player1Won = 0, player2Won = 0,
			wonNumber1 = 1, wonNumber2 = 1, wonNumber3 = 1,
			option;
	boolean 	inGame = false,
				CPUGame = false,
				win = false;
	String 	message,
				Player1 = "Player 1", Player2 = "Player 2",
				tempPlayer2 = "Player 2";
	

	public TEST()	{	//Setting game properties and layout and sytle...
	//Setting window properties:
		window.setSize(X, Y);
		window.setLocation(350, 260);
		//window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Setting Menu, Main, Top, Bottom Panel Layout/Backgrounds
		pnlMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	//Setting up Panel Reset
		pnlReset.setLayout(new GridLayout(1, 2, 2, 2));
		pnlReset.add(btnReset);

		
	//Adding menu items to menu bar
		mnuMain.add(mnuNewGame);
		
	//Adding buttons to NewGame panel
		pnlNewGame.setLayout(new GridLayout(4, 1, 2, 10));
		pnlNewGame.add(btnContinue);
		pnlNewGame.add(btn1v1);
		pnlNewGame.add(btn1vCPU);
	
	//Setting Button propertied
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

	//Adding everything needed to pnlMenu and pnlMain
		pnlMenu.add(lblMode);
		pnlMenu.add(mnuMain);
		pnlMain.add(lblTitle);
		
	//Adding to window and Showing window
		window.add(pnlMenu, BorderLayout.NORTH);
		window.add(pnlMain, BorderLayout.CENTER);
		window.setVisible(true);
	}
	
	public static void main(String[] args)	{
		new TEST();//	Calling the class construtor.
							//		PROGRAM STARTS HERE!
	}



/*
		-------------------------
		Start of all METHODS.	|
		-------------------------
*/
	public void showGame()	{	//	Shows the Playing Field
										//	*IMPORTANT*- Does not start out brand new (meaning just shows what it had before)
		clearPanelSouth();
		pnlMain.setLayout(new BorderLayout());
		pnlTop.setLayout(new BorderLayout());
		pnlBottom.setLayout(new BorderLayout());
		pnlTop.add(pnlPlayingField);
		pnlBottom.add(lblTurn, BorderLayout.WEST);
		pnlBottom.add(lblStatus, BorderLayout.CENTER);
		pnlMain.add(pnlTop, BorderLayout.CENTER);
		pnlMain.add(pnlBottom, BorderLayout.SOUTH);
		pnlPlayingField.requestFocus();
		inGame = true;
		checkTurn();
		checkWinStatus();
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	public void newGame()	{	//	Sets all the game required variables to default
											//	and then shows the playing field.
											//	(Basically: Starts a new 1v1 Game)
		for(int i=1; i<10; i++)	{
			btnEmpty[i].setText("");
			btnEmpty[i].setEnabled(true);
		}
		turn = 1;
		win = false;
		showGame();
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	public void checkWin()	{	//	checks if there are 3 symbols in a row vertically, diagonally, or horizontally.
										//	then shows a message and disables buttons. If the game is over then it asks
										//	if you want to play again.
		for(int i=0; i<8; i++)	{
			if(
				!btnEmpty[winCombo[i][0]].getText().equals("") &&
				btnEmpty[winCombo[i][0]].getText().equals(btnEmpty[winCombo[i][1]].getText()) &&
				//								if {1 == 2 && 2 == 3}
				btnEmpty[winCombo[i][1]].getText().equals(btnEmpty[winCombo[i][2]].getText()))	{
				/*
					The way this checks the if someone won is:
					First: it checks if the btnEmpty[x] is not equal to an empty string-	x being the array number 
						inside the multi-dementional array winCombo[checks inside each of the 7 sets][the first number]
					Secong: it checks if btnEmpty[x] is equal to btnEmpty[y]- x being winCombo[each set][the first number]
						y being winCombo[each set the same as x][the second number] (So basically checks if the first and
						second number in each set is equal to each other)
					Third: it checks if btnEmtpy[y] is eual to btnEmpty[z]- y being the same y as last time and z being
						winCombo[each set as y][the third number]
					Conclusion:	So basically it checks if it is equal to the btnEmpty is equal to each set of numbers
				*/
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
		} else
			checkTurn();
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
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
//-----------------------------------------------------------------------------------------------------------------------------------	
	public void checkTurn()	{
		String whoTurn;
		if(!(turn % 2 == 0))	{
			whoTurn = Player1 + " [X]";
		}	else	{
			whoTurn = Player2 + " [O]";
		}
		lblTurn.setText("Turn: " + whoTurn);
	}

//-----------------------------------------------------------------------------------------------------------------------------------	
	public void setDefaultLayout()	{
		pnlMain.setLayout(new GridLayout(2, 1, 2, 5));
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	public void checkWinStatus()	{
		lblStatus.setText(Player1 + ": " + player1Won + " | " + Player2 + ": " + player2Won);	
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	public int askMessage(String msg, String tle, int op)	{
		return JOptionPane.showConfirmDialog(null, msg, tle, op);
	}
//-----------------------------------------------------------------------------------------------------------------------------------
	public String getInput(String msg, String setText)	{
		return JOptionPane.showInputDialog(null, msg, setText);
	}
//-----------------------------------------------------------------------------------------------------------------------------------
	public void showMessage(String msg)	{
		JOptionPane.showMessageDialog(null, msg);
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	public void clearPanelSouth()	{	//Removes all the possible panels 
												//that pnlMain, pnlTop, pnlBottom
												//could have.
		pnlMain.remove(lblTitle);
		pnlMain.remove(pnlTop);
		pnlMain.remove(pnlBottom);
		pnlTop.remove(pnlNewGame);
		pnlTop.remove(txtMessage);
		pnlTop.remove(pnlPlayingField);
		pnlBottom.remove(lblTurn);
		pnlBottom.remove(pnlReset);
	}
/*
		-------------------------------------
		End of all non-Abstract METHODS.		|
		-------------------------------------
*/

//-------------------ACTION PERFORMED METHOD (Button Click --> Action?)-------------------------//	
	public void actionPerformed(ActionEvent click)	{
		Object source = click.getSource();
		for(int i=1; i<=9; i++)	{
			if(source == btnEmpty[i] && turn <	10)	{
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
			
				txtMessage.setText(message);
				pnlTop.add(txtMessage);
			}	
			pnlMain.add(pnlTop);
		
		 if(source == btn1v1 || source == btn1vCPU)	{
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
					Player2 = tempPlayer2;
					player1Won = 0;
					player2Won = 0;
					lblMode.setText("1 v 1");
					CPUGame = false;	
					newGame();
				} else	{// 1 v CPU Game
					Player2 = "Computer";
					player1Won = 0;
					player2Won = 0;
					lblMode.setText("1 v CPU");
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
