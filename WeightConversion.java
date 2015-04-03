/**
 * @(#)WeightConversion.java
 *
 *
 * @Derick Warshaw // Lab 11 // COSC1337
 * @version 1.00 2014/4/17
 */

import javax.swing.*;			// needed for swing class
import java.awt.event.*;		// needed for ActionListener interface
import java.text.DecimalFormat; // to format message dialogue box


public class WeightConversion extends JFrame
{
		private JPanel panel;					// holding panel
    	private JLabel messageLabel;			// message to the user
    	private JTextField poundsTextField;		// to hold user input
    	private JRadioButton ouncesButton;		// to convert to ounces
    	private JRadioButton grainsButton;		// to convert to grain
    	private JRadioButton kilogramsButton;	// to convert to kilograms
    	private ButtonGroup radioButtonGroup;	// to group the radio buttons


	/**
    The WeightConversion constructor performs setup operations for the GUI
    */
    public WeightConversion()
    {

    	// setting the title
    	setTitle("Pounds Converter");

    	// setting action for the close button
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// building panel and adding it to the frame
    	buildPanel();

    	// add the panel to the frame's contents pane
    	add(panel);

    	// display the window
    	setVisible(true);

		// gives the window a perfect fit size for height and width
    	pack();

    }

	/**The buildPanel method is a private method that handles the building of
	 *the panel of the GUI. It creates the label, text field, radio buttons
	 *and then groups them together. Action listeners are connected to radio
	 *buttons and all of these ingredients are added to the panel. */
	private void buildPanel()
	{

		// create label, text field, and radio buttons
		messageLabel = new JLabel("Enter a weight in pounds");
		poundsTextField = new JTextField(10); // text field with length of 10
		grainsButton = new JRadioButton("Convert to grains");
		ouncesButton = new JRadioButton("Convert to ounces");
		kilogramsButton = new JRadioButton("Convert to kilograms");

		// group the radio buttons
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(grainsButton);
		radioButtonGroup.add(ouncesButton);
		radioButtonGroup.add(kilogramsButton);

		// add action listeners to the radio buttons
		grainsButton.addActionListener(new RadioButtonListener());
		ouncesButton.addActionListener(new RadioButtonListener());
		kilogramsButton.addActionListener(new RadioButtonListener());

		// create a panel and add the components to it
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(poundsTextField);
		panel.add(grainsButton);
		panel.add(ouncesButton);
		panel.add(kilogramsButton);

	}


	/**RadioButtonListener is a private class that implements ActionListener.
	 *Inside the class there is a public method as per requirement of
	 *actionListener interface - called actionPerformed.
	 * */
	private class RadioButtonListener implements ActionListener
	{
		/**actionPerformed is a public method required since the
		 *RadioButtonListener class implements ActionListener interface. This is
		 *where listeners are kept that take action depending on which event
		 *fired. */
		public void actionPerformed(ActionEvent e)
		{

			String input;				// holds user input
			String converTo = "";		// units to convert to
			String formula = "";		// formula for the conversion
			double result = 0.0;		// to hold the conversion
			double parsedResult = 0.0;	// to hold parsed value to be validated

			// create decimal format object for use with purse values
			DecimalFormat formatter = new DecimalFormat("#0.0000");

			// get pounds entered
			input = poundsTextField.getText();

			// find out which button was clicked
			if (e.getSource() == grainsButton)
			{
				// convert to grains
				converTo = " grains";
				formula = "Formula: 1 pound equals 7000 grains.";
				parsedResult = Double.parseDouble(input) * 7000;
				result = dataValidation(parsedResult);

			}
			else if (e.getSource() == ouncesButton)
			{

				// convert to grains
				converTo = " ounces";
				formula = "Formula: 1 pound equals 16 ounces.";
				parsedResult = Double.parseDouble(input) * 16;
				result = dataValidation(parsedResult);
			}
			else if (e.getSource() == kilogramsButton)
			{
				// convert to grains
				converTo = " kilograms";
				formula = "Formula: 1 pound equals 0.453592 kilograms.";
				parsedResult = Double.parseDouble(input) * 0.453592;
				result = dataValidation(parsedResult);
			}

			// display conversion in JOption Pane
			JOptionPane.showMessageDialog(null, input +
				                          " pounds is " +
				                          formatter.format(result) + converTo +
				                          "\n" + formula);

		}

		/**dataValidation is a private method that varifies that a double
		 *data type parameter doesn't have a negative value
		 *@param data is a double datatype value passed in when the user
		 *attempts to convert a value to another value.
		 *@returns a double datatype value that is unchanged if non negative.
		 *if negative it sets return value to 99999 and prints an error to the
		 *console.
		 **/
		private double dataValidation(double data)
		{
			// error if user enters a negative number
			if (data < 0)
			{
				data = 99999;
				System.out.println("ERROR: INVALID DATA ENTERED");
				return data;

			}
			else
			{
				// returns value unchanged if it passes test for negative
				return data;
			}

		}

	}

	/**main is an embedded main so a seperate file isn't needed to run program. */
	public static void main(String[] args)
	{
		new WeightConversion();
	}

}


