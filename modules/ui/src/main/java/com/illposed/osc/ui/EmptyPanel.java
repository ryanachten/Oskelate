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

	
	
	public EmptyPanel (String n, double w, double h, int f1, int f2, double p){
		super("");
		this.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(w), ScreenRes.getScaledHeight(h) ) );//130 90
		//add 3 white boxes
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Font font1 = new Font("Verdana", Font.BOLD, f1);
		Font font = new Font("Verdana", Font.PLAIN, f2);
		
		final JLabel l1 = new JLabel(n,JLabel.CENTER);
		l1.setForeground(Color.white);
		l1.setFont(font1);
		c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		c.weightx = 0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		final JTextField t1 = new JTextField(1);
		t1.setFont(font);
		t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t1.setEditable(false);
		c.weightx = 0.1;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t1, c);
		
		final JTextField t2 = new JTextField(1);
		t2.setFont(font);
		t2.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t2.setEditable(false);
		c.weightx = 0.1;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t2, c);
		
		final JTextField t3 = new JTextField(1);
		t3.setFont(font);
		t3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t3.setEditable(false);
		c.weightx = 0.1;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t3, c);
		
		
		JButton b1 = new JButton();
		b1.setBackground(Color.RED);
		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0030), ScreenRes.getScaledHeight(0.0139) ) );
		c.weightx = 1;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(b1, c);
		

		
		//add 1 red box
	}
}
