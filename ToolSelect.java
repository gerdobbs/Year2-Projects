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

public class ToolSelect extends Frame implements ItemListener, ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem MultiConverter, CurrencyConverter,Calculator;
	private JComboBox<String> getChoice;
	private JLabel testLabel;
	private SwingCalculator calc;
	private CurrencyConverter ccon;
	private MultiConverter mcon ;
	public ToolSelect()
	{
		 menuBar = new JMenuBar();
		 menu = new JMenu("Other Tools");
		 MultiConverter = new JMenuItem("MultiConverter");
		 CurrencyConverter = new JMenuItem("CurrencyConverter");
		Calculator = new JMenuItem("Calculator");
		getChoice = new JComboBox<String>();
		testLabel= new JLabel("Select an Option");
		getChoice.addItem("Select a tool");
		getChoice.addItem("Calculator");
		getChoice.addItem("Currency Converter");
		getChoice.addItem("Multi Conversion");
		setBackground(Color.lightGray);
		setLayout(new FlowLayout());
		add(testLabel);
		add(getChoice);
		getChoice.addItemListener(this);
		calc = new SwingCalculator();
		ccon = new CurrencyConverter();
		mcon = new MultiConverter();
		addWindowListener(new WindowAdapter(){
	           public void windowClosing(WindowEvent e)
	           {
	        	   System.exit(0);
	           }
	          });
		 MultiConverter.addActionListener(this);
		 CurrencyConverter.addActionListener(this);
		 Calculator.addActionListener(this);
		 MultiConverter.addItemListener(this);
		 CurrencyConverter.addActionListener(this);
		 Calculator.addItemListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToolSelect tool = new ToolSelect();
		tool.setLocation(400,200);
		tool.setSize(180,200);
		tool.setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(getChoice.getSelectedItem()=="Calculator")
		{
			this.setVisible(false);
			ccon.setVisible(false);
			mcon.setVisible(false);
			calc.setLocation(400,200);
			calc.setSize(260,320);
			calc.setVisible(true);
			menu.add(MultiConverter);
			menu.add(CurrencyConverter);
			menuBar.add(menu);
			calc.setJMenuBar(menuBar);
			
		}
		else if(getChoice.getSelectedItem()=="Currency Converter")
		{
			ccon.setLocation(400,200);
			ccon.setSize(400,240);
			calc.setVisible(false);
			ccon.setVisible(true);
			mcon.setVisible(false);
			this.setVisible(false);
			menu.add(Calculator);
			menu.add(MultiConverter);
			menuBar.add(menu);
			ccon.setJMenuBar(menuBar);
		}
		else if(getChoice.getSelectedItem()=="Multi Conversion")
		{
			mcon.setLocation(400,200);
			mcon.setSize(360,200);
			calc.setVisible(false);
			ccon.setVisible(false);
			mcon.setVisible(true);
			this.setVisible(false);
			menu.add(Calculator);
			menu.add(CurrencyConverter);
			menuBar.add(menu);
			ccon.setJMenuBar(menuBar);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==MultiConverter)
		 {
			mcon.setVisible(true);
			calc.setVisible(false);
			ccon.setVisible(false);
			mcon.setLocation(400,200);
			mcon.setSize(360,200);
			this.setVisible(false);
			menu.add(Calculator);
			menu.add(CurrencyConverter);
			mcon.setJMenuBar(menuBar);
			menu.remove(MultiConverter);
		 }
		 else if(e.getSource()==CurrencyConverter)
		 {
			ccon.setLocation(400,200);
			ccon.setSize(400,240);
			ccon.setVisible(true);
			calc.setVisible(false);
			mcon.setVisible(false);
			this.setVisible(false);
			menu.add(Calculator);
			menu.add(MultiConverter);
			menu.remove(CurrencyConverter);
			ccon.setJMenuBar(menuBar);
		 }
		 else if(e.getSource()==Calculator)
		 {
			calc.setVisible(true);
			mcon.setVisible(false);
			ccon.setVisible(false);
			calc.setLocation(400,200);
			calc.setSize(340,280);
			this.setVisible(false);
			menu.add(CurrencyConverter);
			menu.add(MultiConverter);
			menu.remove(Calculator);
			calc.setJMenuBar(menuBar);
		 }
	}
}
