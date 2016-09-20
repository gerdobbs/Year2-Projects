/* Created by : Ger Dobbs

 * Date: 		Jan 2016
 * 
 * Purpose:		To create a ulti conversion tool.
 * 
 */
package Lab7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiConverter extends JFrame implements ItemListener,ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Container contentPane;
	private JComboBox<String> whichConverter  ;
	private JLabel MessageLabel;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JTextField fromText;
	private JTextField toText;
	private JPanel headingPanel;
	private JPanel conversionPanel;
	private JPanel buttonPanel;
	private JButton convert;
	private JButton clear;
	
	public MultiConverter()
	{
		super("Multi Conversion Tool");
		//setBackground(Color.lightGray);
		contentPane = getContentPane();
		whichConverter = new JComboBox();
		MessageLabel = new JLabel("Select a Conversion");
		fromLabel = new JLabel();
		toLabel = new JLabel();
		headingPanel = new JPanel();
		conversionPanel = new JPanel();
		buttonPanel = new JPanel();
		fromText = new JTextField(10);
		toText = new JTextField(10);
		convert = new JButton("Convert");
		clear = new JButton("Clear");
		toText.setEditable(false);
		toText.setFocusable(false);
		//Add Items to Choice Box
		whichConverter.addItem("Inches to Feet");
		whichConverter.addItem("Pounds to Euro");
		whichConverter.addItem("Celcius to Fahrenheit");
		//Set Frame Layout
		setLayout(new FlowLayout());
		//Set Panel Layout
		conversionPanel.setLayout(new FlowLayout());
		//Add Labels & text fields to panel
		headingPanel.add(MessageLabel);
		headingPanel.add(fromLabel);
		headingPanel.add(whichConverter);
		buttonPanel.add(convert);
		buttonPanel.add(clear);
		conversionPanel.add(fromLabel);
		conversionPanel.add(fromText);
		conversionPanel.add(toLabel);
		conversionPanel.add(toText);
		//add Choice Box to top of frame
		//Add Panel to bottom of frame
		contentPane.add(headingPanel,"NORTH");
		contentPane.add(conversionPanel,"Center");
		contentPane.add(buttonPanel,"SOUTH");
		//Add listener for Choice Box
		whichConverter.addItemListener(this);
		convert.addActionListener(this);
		fromLabel.setText("Inches");
		toLabel.setText("Feet");
		clear.addActionListener(this);
		addWindowListener(new WindowAdapter(){
	           public void windowClosing(WindowEvent e){
	           System.exit(0);}});
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		// TODO Auto-generated method stub
		if(whichConverter.getSelectedItem()=="Celcius to Fahrenheit")
		{
			fromLabel.setText("Celcius");
			toLabel.setText("Fahrenheit");
		}
		else if(whichConverter.getSelectedItem()=="Pounds to Euro")
		{
			fromLabel.setText("Pounds");
			toLabel.setText("Euro");
		}
		else if(whichConverter.getSelectedItem()=="Inches to Feet")
		{
			fromLabel.setText("Inches");
			toLabel.setText("Feet");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

		 if(e.getSource()==convert&&fromText.getText()!="")
		{
			try{
			if(fromLabel.getText()=="Inches")
			{
				 double doubleResult = (Double.parseDouble(fromText.getText())/12);
				 doubleResult = (double) Math.round(doubleResult*10000.0)/10000;
				 toText.setText(""+doubleResult);
			}
			if(fromLabel.getText()=="Celcius")
			{
				 double doubleResult = (Double.parseDouble(fromText.getText())*9.5+32);
				 doubleResult = (double) Math.round(doubleResult*10000.0)/10000;
				 toText.setText(""+doubleResult);
			}
			if(fromLabel.getText()=="Pounds")
			{
				 double doubleResult = (Double.parseDouble(fromText.getText())*.79);
				 doubleResult = (double) Math.round(doubleResult*10000.0)/10000;
				 toText.setText(""+doubleResult);
			}
			}
			catch(NumberFormatException ex)
			{
				 toText.setText("Not a Valid Entry");
			}
		}
		else if(e.getSource()==clear)
		{
			toText.setText("");
			fromText.setText("");
		}
	}
}
