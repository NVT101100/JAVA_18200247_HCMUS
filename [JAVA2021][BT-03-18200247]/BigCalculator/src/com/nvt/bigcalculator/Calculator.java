package com.nvt.bigcalculator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num1_textfield;
	private JTextField num2_textfield;
	private JTextField operation_textfield;
	private int operation = 1;
	private String finalresult = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Big Calculator");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		num1_textfield = new JTextField();
		num1_textfield.setToolTipText("Enter first number");
		num1_textfield.setBounds(29, 20, 477, 40);
		contentPane.add(num1_textfield);
		num1_textfield.setColumns(10);
		
		num2_textfield = new JTextField();
		num2_textfield.setToolTipText("Enter Second number");
		num2_textfield.setBounds(29, 117, 477, 40);
		contentPane.add(num2_textfield);
		num2_textfield.setColumns(10);
		
		JButton plus_button = new JButton("+");
		plus_button.setBounds(29, 196, 50, 25);
		contentPane.add(plus_button);
		plus_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operation_textfield.setText("+");	
				operation =1;
			}
		});
		
		JButton sub_button = new JButton("-");
		sub_button.setBounds(184, 196, 50, 25);
		contentPane.add(sub_button);
		sub_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operation_textfield.setText("-");	
				operation =2;
			}
		});
		
		JButton mul_button = new JButton("x");
		mul_button.setBounds(332, 196, 50, 25);
		contentPane.add(mul_button);
		mul_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operation_textfield.setText("x");
				operation =3;
			}
		});
		
		JButton div_button = new JButton("/");
		div_button.setBounds(456, 196, 50, 25);
		contentPane.add(div_button);
		div_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operation_textfield.setText("/");
				operation =4;
			}
		});
		
		JTextArea result_textfield = new JTextArea();
		result_textfield.setWrapStyleWord(true);
		result_textfield.setEditable(false);
		result_textfield.setBounds(29, 360, 477, 159);
		contentPane.add(result_textfield);
		
		JButton result_button = new JButton("Result");
		result_button.setBounds(81, 284, 97, 25);
		contentPane.add(result_button);
		result_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String num1,num2;
				num1 = num1_textfield.getText();
				num2 = num2_textfield.getText();
				Calculate calculate = new Calculate();
				if(num1.isEmpty()||!calculate.checknum(num1)) JOptionPane.showMessageDialog(contentPane, "Please enter the first number");
				else if(num2.isEmpty()||!calculate.checknum(num2)) JOptionPane.showMessageDialog(contentPane, "Please enter the second number");
				else {
					switch(operation) {
					case 1:
						finalresult = calculate.plus(num1, num2);
						break;
					case 2:
						finalresult = calculate.subtract(num1, num2);
						break;
					case 3:
						finalresult = calculate.multiply(num1, num2);
						break;
					case 4:
						finalresult = calculate.divide(num1, num2);
						break;
					}
					if(finalresult == null) JOptionPane.showMessageDialog(contentPane, "Cannot Calculate the numbers");
					else result_textfield.setText(finalresult);
				}
			}
		});
		
		operation_textfield = new JTextField();
		operation_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		operation_textfield.setText("+");
		operation_textfield.setEditable(false);
		operation_textfield.setBounds(226, 73, 59, 22);
		contentPane.add(operation_textfield);
		operation_textfield.setColumns(10);
		
		JButton delete_button = new JButton("Delete");
		delete_button.setBounds(353, 284, 97, 25);
		contentPane.add(delete_button);
		delete_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num1_textfield.setText("");
				num2_textfield.setText("");
				result_textfield.setText("");
			}
		});
	}
}
