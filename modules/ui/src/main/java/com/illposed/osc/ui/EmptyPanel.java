package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmptyPanel extends EffectPanel {

	
	
	public EmptyPanel (){
		super("");
		this.setPreferredSize( new Dimension( 150, 90 ) );
		//add 3 white boxes
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Font font1 = new Font("Verdana", Font.BOLD, 13);
		Font font = new Font("Verdana", Font.PLAIN, 15);
		
		final JLabel l1 = new JLabel("M O D U L E: N",JLabel.CENTER);
		l1.setForeground(Color.white);
		l1.setFont(font1);
		c.ipady = 15;      //make this component tall
		c.weightx = 0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		final JTextField t1 = new JTextField(2);
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t1, c);
		
		final JTextField t2 = new JTextField(2);
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t2, c);
		
		final JTextField t3 = new JTextField(2);
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t3, c);
		
		final JTextField t4 = new JTextField(2);
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t4, c);
		
		JButton b1 = new JButton();
		b1.setBackground(Color.RED);
		b1.setPreferredSize(new Dimension(25, 15));
		c.weightx = 1;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(b1, c);
		

		
		//add 1 red box
	}
}
