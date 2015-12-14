import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Ch7 extends JApplet implements ActionListener
{
	private JPanel Panel1;    
	private JPanel Panel2; 
	private JPanel Panel3; 
	private JPanel Panel4; 
	private JPanel Panel5;
	private JPanel Panel6;
	private JTextField a1;   
	private JButton a2_1; 
	private JButton a2_2;
	private JButton a2_3;
	private JButton a2_4;
	private JRadioButton a3_1;
	private JRadioButton a3_2;
	private JRadioButton a3_3;
	private JRadioButton a3_4;
	private JCheckBox a4_1; 
	private JCheckBox a4_2;
	private JCheckBox a4_3;
	private JCheckBox a4_4;
	private JRadioButton a5_1;
	private JRadioButton a5_2;
	private JRadioButton a5_3;
	private JRadioButton a5_4;
	private JLabel tscore;   
	private JButton sButton;  
	private Fillblank Q1; 
	private Fillblank Q2; 
	private Fillblank Q3; 
	private Fillblank Q4; 
	private Fillblank Q5;
	private int score;
	private boolean cheat;
	/**
      init method
	 */

	public void init()
	{
		cheat=false;
		score=0;

		// Build the panels.
		buildpanel1();
		buildpanel2();
		buildpanel3();
		buildpanel4();
		buildpanel5();
		buildpanel6();


		// Create a layout manager.
		setLayout(new GridLayout(6, 1));

		// Add the panels to the applet.
		add(Panel1);
		add(Panel2);
		add(Panel3);
		add(Panel4);
		add(Panel5);
		add(Panel6);

	}


	private void buildpanel1()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		// Create the panel.
		Panel1 = new JPanel();

		// Create a label to display a message.
		JLabel q1 =
			new JLabel(Q1.getQuestion());

		a1 = new JTextField(9);


		// Create a layout manager for the panel.
		Panel1.setLayout(new GridLayout(5, 2));

		// Add the label and text field to the panel.
		Panel1.add(q1);
		Panel1.add(a1);

		//Sets the panel visible
		setVisible(true);
	}
	private void buildpanel2()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		//setLayout(new FlowLayout());
		// Create the panel.
		Panel2 = new JPanel();

		// Create a label to display a message.
		JLabel q2 =
			new JLabel(Q2.getQuestion());

		JButton a2_1 = new JButton("Answer 1");
		JButton a2_2 = new JButton("Answer 2");
		JButton a2_3 = new JButton("Answer 3");
		JButton a2_4 = new JButton("Answer 4");

		a2_1.setPreferredSize(new Dimension(100,25));
		a2_2.setPreferredSize(new Dimension(100,25));
		a2_3.setPreferredSize(new Dimension(100,25));
		a2_4.setPreferredSize(new Dimension(100,25));
		// Create a layout manager for the panel.
		//Panel2.setLayout(new GridLayout(5, 1));

		// Add the label and text field to the panel.
		Panel2.add(q2);
		Panel2.add(a2_1);
		Panel2.add(a2_2);
		Panel2.add(a2_3);
		Panel2.add(a2_4);

		a2_1.addActionListener(new a2_1Listener());
		//Display Window
		setVisible(true);

	}
	private void buildpanel3()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the panel.
		Panel3 = new JPanel();

		// Create a label to display a message.
		JLabel q3 =
			new JLabel(Q3.getQuestion());

		a3_1 = new JRadioButton("Choice 1");
		a3_2 = new JRadioButton("Choice 2");
		a3_3 = new JRadioButton("Choice 3");
		a3_4 = new JRadioButton("Choice 4");

		//Create a ButtonGroup object.
		ButtonGroup group = new ButtonGroup();

		//Add the Radio Buttons to the Button Object.
		group.add(a3_1);
		group.add(a3_2);
		group.add(a3_3);
		group.add(a3_4);



		// Create a layout manager for the panel.
		Panel3.setLayout(new GridLayout(5, 2));

		// Add the label and text field to the panel.
		Panel3.add(q3);
		Panel3.add(a3_1);
		Panel3.add(a3_2);
		Panel3.add(a3_3);
		Panel3.add(a3_4);

		//Sets the panel visible
		setVisible(true);
	}
	private void buildpanel4()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the panel.
		Panel4 = new JPanel();

		// Create a label to display a message.
		JLabel q4 =
			new JLabel(Q4.getQuestion());

		a4_1 = new JCheckBox("Hello");
		a4_2 = new JCheckBox("Hello");
		a4_3 = new JCheckBox("Hello");
		a4_4 = new JCheckBox("Hello");


		// Create a layout manager for the panel.
		Panel3.setLayout(new GridLayout(5, 2));

		// Add the label and text field to the panel.
		Panel4.add(q4);
		Panel4.add(a4_1);
		Panel4.add(a4_2);
		Panel4.add(a4_3);
		Panel4.add(a4_4);

		//Sets the panel visible
		setVisible(true);
	}
	private void buildpanel5()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the panel.
		Panel5 = new JPanel();

		// Create a label to display a message.
		JLabel q5 =
			new JLabel(Q5.getQuestion());

		a5_1 = new JRadioButton("Choice 1");
		a5_2 = new JRadioButton("Choice 2");
		a5_3 = new JRadioButton("Choice 3");
		a5_4 = new JRadioButton("Choice 4");

		//Create a ButtonGroup object.
		ButtonGroup group = new ButtonGroup();

		//Add the Radio Buttons to the Button Object.
		group.add(a5_1);
		group.add(a5_2);
		group.add(a5_3);
		group.add(a5_4);



		// Create a layout manager for the panel.
		Panel5.setLayout(new GridLayout(5, 2));

		// Add the label and text field to the panel.
		Panel5.add(q5);
		Panel5.add(a5_1);
		Panel5.add(a5_2);
		Panel5.add(a5_3);
		Panel5.add(a5_4);

		//Sets the panel visible
		setVisible(true);
	}


	private void buildpanel6()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the panel.
		Panel6 = new JPanel();
		sButton = new JButton("submit");
		tscore = new JLabel();
		//tscore.setEditable(false);
		Panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		Panel6.add(sButton);
		Panel6.add(tscore);

		sButton.addActionListener(new sButtonListener());


		//Sets the panel visible
		setVisible(true);
	}



	private class a2_1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (cheat == false){
				score = score + 20;
				cheat =true;
			}
		}

	}
	private class sButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String A="";
			if (Q1.attempt(a1.getText())){
				score = score + 20;
			}

			if (a3_4.isSelected()){
				score +=20;	
			}
			if (a4_1.isSelected()||a4_3.isSelected()){
			}

			else if
			
			(a4_4.isSelected()&&a4_2.isSelected()){
				score+=20;
			}
			if (a5_2.isSelected()){
				score +=20;	
			}
			A+= score;
			JOptionPane.showMessageDialog(null, "Your score is " + A);
			score =0;
			cheat=false;

		}

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
