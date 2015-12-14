import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Chapter8 extends JApplet implements ActionListener {

	/**
	 * @param args
	 */
	private JPanel Panel1;    
	private JPanel Panel2; 
	private JPanel Panel3; 
	private JPanel Panel4; 
	private JTextField a1;   
	private JCheckBox a2_1; 
	private JCheckBox a2_2;
	private JCheckBox a2_3;
	private JCheckBox a2_4;
	private JRadioButton a3_1;
	private JRadioButton a3_2;
	private JRadioButton a3_3;
	private JRadioButton a3_4;
	private JLabel tscore;   
	private JButton sButton;  
	private double score;
	private String[] ques = {"What is my first name?",
			"What is my middle name",
			"What is my last name?","What's not my name?"};
			
	private String[] ans = {"Immad", "Ahmed", "Mohamed", "Bill"};
	/**
    init method
	 */

	public void init()
	{
		score=0;

		// Build the panels.
		buildpanel1();
		buildpanel2();
		buildpanel3();
		buildpanel4();

		// Create a layout manager.
		setLayout(new GridLayout(5, 1));

		// Add the panels to the applet.
		add(Panel1);
		add(Panel2);
		add(Panel3);
		add(Panel4);

	}


	private void buildpanel1()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		// Create the panel.
		Panel1 = new JPanel();

		// Create a label to display a message.
		JLabel q1 =
			new JLabel(ques[0]);

		a1 = new JTextField(9);

		// Add the label and text field to the panel.
		Panel1.add(q1);
		Panel1.add(a1);

		//Sets the panel visible
		setVisible(true);
	}
	private void buildpanel2()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the panel.
		Panel2 = new JPanel();

		// Create a label to display a message.
		JLabel q2 =
			new JLabel(ques[1]);

		a2_1 = new JCheckBox ("Immad");
		a2_2 = new JCheckBox ("Ahmed");
		a2_3 = new JCheckBox ("Mohamed");
		a2_4 = new JCheckBox ("Bill");

		// Add the label and text field to the panel.
		Panel2.add(q2);
		Panel2.add(a2_1);
		Panel2.add(a2_2);
		Panel2.add(a2_3);
		Panel2.add(a2_4);

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
			new JLabel(ques[2]);

		a3_1 = new JRadioButton("Immad");
		a3_2 = new JRadioButton("Ahmed");
		a3_3 = new JRadioButton("Mohamed");
		a3_4 = new JRadioButton("Bill");

		//Create a ButtonGroup object.
		ButtonGroup group = new ButtonGroup();

		//Add the Radio Buttons to the Button Object.
		group.add(a3_1);
		group.add(a3_2);
		group.add(a3_3);
		group.add(a3_4);

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
		sButton = new JButton("Submit");
		tscore = new JLabel();
		//tscore.setEditable(false);
		Panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		Panel4.add(sButton);
		Panel4.add(tscore);

		sButton.addActionListener(new sButtonListener());


		//Sets the panel visible
		setVisible(true);
	}


	private class sButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String A="";
			if (a1.getText().equalsIgnoreCase(ans[0])){
				score = score + 33.3;
			}
			
			if (a2_1.isSelected()||a2_4.isSelected()){
			}

			else if
			
			(a2_2.isSelected()&&a2_3.isSelected()){
				score+=33.3;
			}
			if (a3_4.isSelected()){
				score +=33.3;	
			}
			A+= (int)(score + 0.5);
			JOptionPane.showMessageDialog(null, "Your score is " + A);
			score =0;
			

		}

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
