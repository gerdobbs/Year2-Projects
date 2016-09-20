package Lab7;

/* Created by : Ger Dobbs

 * Date: 		Jan 2016
 * 
 * Purpose:		To create an application that implements a 
 * 				currency converter.
 * 
 */


 import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

	public class CurrencyConverter extends JFrame implements ItemListener,ActionListener
	{
		
		private static final long serialVersionUID = 1L;
		//The Exchange Rates
		private static Double euroToSterling = .7589;
		private static Double euroToDollars = 1.088;
		private static Double euroToEuro =1.0;
		private static Double euroToAus = 1.5654;
		private static Double sterlingToSterling =1.0;
		private static Double sterlingToDollars = 1.4404;
		private static Double sterlingToEuro = 1.3234;
		private static Double sterlingToAus = 2.0719;
		private static Double dollarsToSterling = 1.4404;
		private static Double dollarsToDollars =1.0 ;
		private static Double dollarsToEuro =.9488;
		private static Double dollarsToAus = 1.4384;
		private static Double ausToSterling = .4825;
		private static Double ausToDollars = .6951;
		private static Double ausToEuro = .6386;
		private static Double ausToAus =1.0;
		private static Double result =0.0;
		private static String answer="";
		
		//Gui containers & components
		private Container content;
		private JPanel panel1;
		private JPanel panel2;
		private JPanel panel3;
		private JPanel panel4;
		private JLabel currencies;
		private JLabel to;
		private JLabel exchange;
		private JLabel amount;
		private JComboBox<String> convertFromChoice;
		private JComboBox<String> convertToChoice;
		private JButton convertButton;
		private JButton clearButton;
		private JTextField exchangeRateText;
		private JTextField amountText;
		private JTextField resultText;
		
		//Default Exchange Rate
		private Double rate = euroToSterling;
		
		public  CurrencyConverter()
		{
			super("Currency Conversion");
			content = getContentPane();
			setBackground(Color.lightGray);
			setLayout(new FlowLayout());
			//Create the panel containers
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			//Drop down boxes for currency selection
			convertFromChoice = new JComboBox<String>();
			convertToChoice = new JComboBox<String>();
			convertFromChoice.addItem("Euro");
			convertFromChoice.addItem("Sterling");
			convertFromChoice.addItem("Dollars");
			convertFromChoice.addItem("Aus Dollars");
			convertToChoice.addItem("Sterling");
			convertToChoice.addItem("Dollars");
			convertToChoice.addItem("Euro");
			convertToChoice.addItem("Aus Dollars");
		
			currencies = new JLabel("Currencies");
			exchange = new JLabel("Exchange Rate");
			amount = new JLabel("Enter the Amount");
			to = new JLabel("to");
			
			//Box to hold the exchange rate
			exchangeRateText = new JTextField(Double.toString(euroToSterling),10);
			//Box to enter the currency amount
			amountText = new JTextField(10);
			amountText.setText(result.toString());
			//Box to output result
			resultText = new JTextField(17);
			//Disable exchange rate box
			exchangeRateText.setEditable(false);
			
			//Disable result box
			resultText.setEditable(false);
			//Let amount box receive key events
			amountText.setFocusable(true);
			amountText.setText("");
			convertButton = new JButton("Convert");
			exchangeRateText.setFocusable(false);
			resultText.setFocusable(false);
			clearButton= new JButton("Clear");
			
			//Top Panel
			panel1.add(currencies);
			panel1.add(convertFromChoice);
			panel1.add(to);
			panel1.add(convertToChoice);
			//2nd Panel
			panel2.add(exchange);
			panel2.add( exchangeRateText);
			//3rd Panel
			panel3.add(amount);
			panel3.add(amountText);
			//4th Panel
			panel4.add(convertButton);
			panel4.add(resultText);
			panel4.add(clearButton);
			//Add panels to frame
			content.add(panel1);
			content.add(panel2);
			content.add(panel3);
			content.add(panel4);
			//add(content);
			//Add Listeners for choice boxes & Button
			convertFromChoice.addItemListener(this);
			convertToChoice.addItemListener(this);
			convertButton.addActionListener(this);
			clearButton.addActionListener(this);
		
			//Add Listener to close frame
			addWindowListener(new WindowAdapter(){
		           public void windowClosing(WindowEvent e){
		           System.exit(0);}});
		}
		public void clear()
		{
			result = 0.0;
			amountText.setText("");
			resultText.setText(result.toString());
		}
		
		//Listener method for choice boxes
		@Override
		public void itemStateChanged(ItemEvent e) 
		{
			// TODO Auto-generated method stub
			//If Either choice box changed
			if (e.getSource()==convertToChoice||e.getSource()==convertFromChoice)
			  {
				//Variable to hold state of currency to be converted from
				String fromStatus = (String) convertFromChoice.getSelectedItem();
				//Variable to hold state of currency to be converted to
				String toStatus = (String) convertToChoice.getSelectedItem();
				//Convert from euro
				if(fromStatus == "Euro")
				  {
					  if(toStatus =="Euro")
					  {
						  exchangeRateText.setText(Double.toString(euroToEuro));
					  	rate = euroToEuro;
					  	amountText.setText(answer);
					  	resultText.setText(answer);
					  }
					  else if(toStatus == "Sterling")
					  {
						  
						  exchangeRateText.setText(Double.toString(euroToSterling));
						  rate =euroToSterling;
						  amountText.setText(answer);
						  resultText.setText("\u00A3"+answer);
						  
					  }
					  else if(toStatus == "Dollars")
					  {
						  exchangeRateText.setText(Double.toString(euroToDollars));
						  rate =euroToDollars;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Aus Dollars")
					  {
						  exchangeRateText.setText(Double.toString(euroToAus));
						  rate =euroToAus;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
				  }
				//Convert from sterling
				  else if(fromStatus == "Sterling")
				  {
					  if(toStatus =="Sterling")
					  {
						  exchangeRateText.setText(Double.toString(sterlingToSterling));
						  rate =sterlingToSterling;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Euro")
					  {
						  exchangeRateText.setText(Double.toString(sterlingToEuro));
						  rate =sterlingToEuro;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Dollars")
					  {
						  exchangeRateText.setText(Double.toString(sterlingToDollars));
						  rate =sterlingToDollars;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Aus Dollars")
					  {
						  exchangeRateText.setText(Double.toString(sterlingToAus));
						  rate =sterlingToAus;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
				  }
				//Convert from dollars
				  else if(fromStatus == "Dollars")
				  {
					  if(toStatus =="Dollars")
					  {
						  exchangeRateText.setText(Double.toString(dollarsToDollars));
						  rate =dollarsToDollars;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Sterling")
					  { 
						  exchangeRateText.setText(Double.toString(dollarsToSterling));
						  rate=  dollarsToSterling;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Euro")
					  {
						  exchangeRateText.setText(Double.toString(dollarsToEuro));
						  rate =dollarsToEuro;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Aus Dollars")
					  {
						  exchangeRateText.setText(Double.toString(dollarsToAus));
						  rate =dollarsToAus;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
				  }
				//Convert from Australian dollars
				 else if(fromStatus == "Aus Dollars")
				  {
					  if(toStatus =="Aus Dollars")
					  {
						  exchangeRateText.setText(Double.toString(ausToAus));
						  rate =ausToAus;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Sterling")
					  {
						  exchangeRateText.setText(Double.toString(ausToSterling));
						  rate =ausToSterling;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Dollars")
					  {
						  exchangeRateText.setText(Double.toString(ausToDollars));
						  rate = ausToDollars;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
					  else if(toStatus == "Euro")
					  {
						  exchangeRateText.setText(Double.toString(ausToEuro));
						  rate =ausToEuro;
						  result=0.0;
						  amountText.setText(answer);
						  resultText.setText(answer);
					  }
				  }
			 }
		}
	@Override
	//Listener method for button
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		 if(e.getSource()==convertButton)
		{
			Double amount2=0.0;
			try{
			//Get the amount to be converted
			String amount = amountText.getText();
			//Change amount to a Double
			amount2= Double.parseDouble(amount);
			//Calculate the conversion
			}
			catch(NumberFormatException ex)
			{
				clear();
				amountText.setText("Not a valid Number,");
			}
			result = rate*amount2;
			//Round Conversion to 2 decimal places
			Double roundedResult = (double) Math.round(result*100.0)/100;
			//convert result to a String
			answer =Double.toString(roundedResult);
			//output result
			resultText.setText(answer);
		}
		else if(e.getSource()==clearButton)
		{
			result = 0.0;
			amountText.setText("");
			resultText.setText(result.toString());
		}
	}
}
