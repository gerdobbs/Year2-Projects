package Lab7;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwingCalculator extends JFrame implements ActionListener,KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int width = 300;
	final int height= 300;
	private Container contentPane;
	private JPanel outputPanel;
	private JPanel buttonPanel;
	private JPanel buttonPanel2;
	private JTextField outputField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button0;
	private JButton buttona;
	private JButton buttons;
	private JButton buttond;
	private JButton buttonm;
	private JButton buttonDec;
	private JButton buttone;
	private JButton buttonc;
	private JButton buttondel;
	private JButton buttonsqr;
	private JButton buttonroot;
	private String operation="",total="",number2="";
	private int count=0;			//Has 1st number been entered
	private double firstNumber,secondNumber;
	private boolean numberSet=false;//false if operator entered, true if number entered
	private boolean pointSet=false;//Booleans for decimal point already entered in number
	
	public SwingCalculator()
	{
		 super("Calculator");
		 setBackground(Color.lightGray);
		 super.requestFocusInWindow();
		 //Create the Panels,Fields & buttons
		 outputPanel = new JPanel();
		 buttonPanel = new JPanel();
		 buttonPanel2 = new JPanel();
		 outputField = new JTextField(20);
		 outputField.setBorder(BorderFactory.createCompoundBorder(outputField.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		 outputField.setEditable(false);
		 button1 = new JButton("1");
		 button2 = new JButton("2");
		 button3 = new JButton("3");
		 button4 = new JButton("4");
		 button5 = new JButton("5");
		 button6 = new JButton("6");
		 button7 = new JButton("7");
		 button8 = new JButton("8");
		 button9 = new JButton("9");
		 button0 = new JButton("0");
		 buttona = new JButton("+");
		 buttons = new JButton("-");
		 buttond = new JButton("/");
		 buttonm = new JButton("*");
		 buttonDec = new JButton(".");
		 buttone= new JButton("=");
		 buttonc= new JButton("C");
		 buttondel = new JButton("\u21e6");
		 buttonsqr = new JButton("x\u00b2");
		 buttonroot = new JButton("\u221a");
		 buttonPanel.setLayout(new GridLayout(5,10,4,15));
		 buttonPanel2.setLayout(new GridLayout(1,40,4,15));
		 //Set the pane to put items on
		 contentPane = getContentPane();
		 //Add result text field to top panel
		 outputPanel.add(outputField);
		 //Add buttons to Bottom panel
		 buttonPanel.add(buttondel);
		 buttonPanel.add(buttonc);
		 buttonPanel.add(buttonsqr);
		 buttonPanel.add(buttonroot);
		 buttonPanel.add(button7);
		 buttonPanel.add(button8);
		 buttonPanel.add(button9);
		 buttonPanel.add(buttond);
		 buttonPanel.add(button4);
		 buttonPanel.add(button5);
		 buttonPanel.add(button6);
		 buttonPanel.add(buttonm);
		 buttonPanel.add(button1);
		 buttonPanel.add(button2);
		 buttonPanel.add(button3);
		 buttonPanel.add(buttons);
		 buttonPanel.add(button0);
		 buttonPanel.add(buttonDec);
		 buttonPanel.add(buttona);
		 buttonPanel.add(buttone);
		 //Add top panel
		 contentPane.add(outputPanel,"North");
		 //Add bottom panel
		 contentPane.add(buttonPanel,"Center");
		 contentPane.add(buttonPanel2,"South");
		 
		 //Create instance of WindowCloser class
		 WindowCloser listener = new WindowCloser();
		 //Add the Window closer listener
		 addWindowListener(listener);
		 button1.addActionListener(this);
		 button2.addActionListener(this);
		 button3.addActionListener(this);
		 button4.addActionListener(this);
		 button5.addActionListener(this);
		 button6.addActionListener(this);
		 button7.addActionListener(this);
		 button8.addActionListener(this);
		 button9.addActionListener(this);
		 button0.addActionListener(this);
		 buttonDec.addActionListener(this);
		 buttona.addActionListener(this);
		 buttons.addActionListener(this);
		 buttonm.addActionListener(this);
		 buttond.addActionListener(this);
		 buttone.addActionListener(this);
		 buttonc.addActionListener(this);
		 buttondel.addActionListener(this);
		 buttonroot.addActionListener(this);
		 buttonsqr.addActionListener(this);
		 outputField.addKeyListener(this);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
		public void operator(String op)
		 {
			 try
			 {
				 if(numberSet==true)			//Has a number been entered
				 {
					if(count==0)			//First number entry has been completed so operation can be done
					{
						count++;
						firstNumber = Double.parseDouble(total);//Accept & convert 1st number to a double & wait for next number
						total="";
					}
					else
					{
						secondNumber = Double.parseDouble(number2);
						firstNumber=doOperation(op,firstNumber,secondNumber);//Send the numbers & operation to be done to method
					}
				 }
				 	numberSet=false;
				 	pointSet = false;
			 }
			catch(NumberFormatException ex)
			{
				outputField.setText("Not Valid");
				clear();
			}
		 }
		 public void clear()
		 {
			firstNumber=0;
			secondNumber=0;
			total="";
			number2="";
			numberSet=false;
			pointSet = false;
		}
		public double doOperation (String op,double num1,double num2)
		{
			double result=0;
			if(op=="x")
				result=num1*num2;
			else if(op=="/")
				result=num1/num2;
			else if(op=="+")
				result=num1+num2;
			else
				result=num1-num2;
			outputField.setText(""+result);
			clear();
			return result;
		}
		public void getNumber(String num)
		{
			if(count==0)
			{
				total = total + num;
				outputField.setText(total);
			}
			else
			{
				number2 = number2 + num;
				outputField.setText(number2);
			}
			numberSet=true;
			outputField.requestFocusInWindow();	
		}
		 //WindowerCloser class to closs the window properly
		public class WindowCloser extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				//System.exit(0);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 }
		 }
		 @Override
		 public void actionPerformed(ActionEvent e)
		 {
			 // TODO Auto-generated method stub
			 //Which button was pressed
			
			 if(e.getSource()==button1)
			 {
				 getNumber("1");
			 }	
			 else if(e.getSource()==button2)
			{
				 getNumber("2");
			}	
			else if(e.getSource()==button3)
			{
				getNumber("3");
			}	
			else if(e.getSource()==button4)
			{
				getNumber("4");
			}	
			else if(e.getSource()==button5)
			{
				 getNumber("5");
			}	
			else if(e.getSource()==button6)
			{
				getNumber("6");
			}	
			else if(e.getSource()==button7)
			{
				 getNumber("7");
			}	
			else if(e.getSource()==button8)
			{
				 getNumber("8");
			}	
			else if(e.getSource()==button9)
			{
				 getNumber("9");
			}	
			else if(e.getSource()==button0)
			{
				 getNumber("0");
			}	
			else if(e.getSource()==buttonDec)
			{
				if(pointSet==false)
				{
					if(count==0)
					{
						total = total + ".";
						outputField.setText(total);
					}
					else
					{
						number2 = number2 + ".";
						outputField.setText(number2);
					}
						numberSet=false;
						pointSet=true;//Decimal point entered once already in number
				}
				outputField.requestFocusInWindow();
			}	
			//Multiplication
			else if(e.getSource()==buttonm)
			{
				 outputField.setText("x");
				 operator(operation);
				 operation="x";
				 outputField.requestFocusInWindow();
			}	
			//Division
			else if(e.getSource()==buttond)
			{
				outputField.setText("/");
				operator(operation);
				operation="/";
				outputField.requestFocusInWindow();
			}	
			//Addition
			else if(e.getSource()==buttona)
			{
				outputField.setText("+");
				operator(operation);
				operation="+";
				outputField.requestFocusInWindow();
			}	
			//Subtraction
			else if(e.getSource()==buttons)
			{
				 outputField.setText("-");
				 operator(operation);
				 operation="-";
				 outputField.requestFocusInWindow();
			}	
			else if(e.getSource()==buttone)
			{
				try
				{
					if(numberSet==true)
					{
						secondNumber = Double.parseDouble(number2);//number entered is second number
						doOperation(operation,firstNumber,secondNumber);
					}
					numberSet=false;
					pointSet=false;
					count=0;
				}
				catch(Exception ex)
				{
				}
				outputField.requestFocusInWindow();
			}
			else if(e.getSource()==buttondel)
			{
				if(total.length()>0||number2.length()>0)
				{
					if(count==0)
					{
						total = total.substring(0,total.length()-1);
						outputField.setText(total);
					}
					else
					{
						number2 = number2.substring(0,number2.length()-1);
						outputField.setText(number2);
					}
				}
				outputField.requestFocusInWindow();
			}	
			 else if(e.getSource()==buttonc)
			{
				clear();
				outputField.setText("0");
				outputField.requestFocusInWindow();
			}
			else if(e.getSource()==buttonsqr)
			{
				try
				{
					 Double root = Double.parseDouble(total);
					 root = Math.pow(root,2);
					 outputField.setText(root.toString());
					 total=root.toString();
				 }
				 catch(Exception ex)
				 {
				 }
				 outputField.requestFocusInWindow();
			}
			else if(e.getSource()==buttonroot)
			{
				try
				{
					 Double root = Double.parseDouble(total);
					 root = Math.pow(root,0.5);
					 outputField.setText(root.toString());
					 total=root.toString();
				 }
				 catch(Exception ex)
				 {
				 }
				 outputField.requestFocusInWindow();
			 }
		}
			
			@Override
		public void keyPressed(KeyEvent e)
		{
				// TODO Auto-generated method stub
				if(e.getKeyChar()=='0')
				{
					getNumber("0");
				}
				else if(e.getKeyChar()=='1')
				{
					getNumber("1");
				}
				else if(e.getKeyChar()=='2')
				{
					getNumber("2");
				}
				else if(e.getKeyChar()=='3')
				{
					getNumber("3");
				}
				else if(e.getKeyChar()=='4')
				{
					getNumber("4");
				}
				else if(e.getKeyChar()=='5')
				{
					getNumber("5");
				}
				else if(e.getKeyChar()=='6')
				{
					getNumber("6");
				}
				else if(e.getKeyChar()=='7')
				{
					getNumber("7");
				}
				else if(e.getKeyChar()=='8')
				{
					getNumber("8");
				}
				else if(e.getKeyChar()=='9')
				{
					getNumber("9");
				}
				else if(e.getKeyChar()=='+')
				{
					outputField.setText("+");
					operator(operation);
					operation="+";
				}
				else if(e.getKeyChar()=='-')
				{
					outputField.setText("-");
					operator(operation);
					operation="-";
				}
				else if(e.getKeyChar()=='*')
				{
					outputField.setText("x");
					operator(operation);
					operation="x";
				}
				else if(e.getKeyChar()=='/')
				{
					outputField.setText("/");
					operator(operation);
					operation="/";
				}
				else if(e.getKeyChar()=='=')
				{
					try
					{
						if(numberSet==true)
						{
							secondNumber = Double.parseDouble(number2);//number entered is second number
							doOperation(operation,firstNumber,secondNumber);
						}
							numberSet=false;
							pointSet=false;
							count=0;
					}
					catch(Exception ex)
					{
					}
					outputField.requestFocusInWindow();
				}
				else if(e.getKeyChar()=='.')
				{
					if(pointSet==false)
					{
						if(count==0)
						{
							total = total + ".";
							outputField.setText(total);
						}
						else
						{
							number2 = number2 + ".";
							outputField.setText(number2);
						}
							numberSet=false;
							pointSet=true;//Decimal point entered once already in number
					}
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
				{
					if(total.length()>0||number2.length()>0)
					{
						if(count==0)
						{
							total = total.substring(0,total.length()-1);
							outputField.setText(total);
						}
						else
						{
							number2 = number2.substring(0,number2.length()-1);
							outputField.setText(number2);
						}
					 }
				}
				else //if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try
					{
						if(numberSet==true)//
						{
							secondNumber = Double.parseDouble(number2);//number entered is second number
							doOperation(operation,firstNumber,secondNumber);
						}
						numberSet=false;
						pointSet=false;
						count=0;
					}
					catch(Exception ex){
					}
				}
				outputField.requestFocusInWindow();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
}
