package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class FXMBlur extends EffectPanel{

	public FXMBlur(String name) {
		super("");
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		Font font1 = new Font("Verdana", Font.BOLD, 30);
		Font font2 = new Font("Verdana", Font.BOLD, 10);
		
//		JPanel bufferLeft = new JPanel();
//		c.weightx = 0;
//		c.gridwidth = 1;
//		c.gridx = 0;
//		c.gridy = 0;
//		bufferLeft.setOpaque(false);
//		this.add(bufferLeft, c);
//		
//		JPanel bufferRight = new JPanel();
//		c.weightx = 0;
//		c.gridwidth = 1;
//		c.gridx = 6;
//		c.gridy = 0;
//		bufferRight.setOpaque(false);
//		this.add(bufferRight, c);
		
		
		JLabel l1 = new JLabel(name,JLabel.CENTER);
		l1.setForeground(Color.white);
		l1.setFont(font1);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		JLabel l2 = new JLabel("Luma Offset Distribution",JLabel.CENTER);
		l2.setForeground(Color.white);
		l2.setFont(font2);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		this.add(l2, c);
		
		
		JButton b1 = new JButton();
		b1.setPreferredSize( new Dimension( 35,35 ) );
		//t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02), ScreenRes.getScaledHeight(0.02) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		c.insets = new Insets(0,30,0,0);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(b1, c);
		

		
		JButton b2 = new JButton();
		b2.setPreferredSize( new Dimension( 35,35 ) );
		//t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02), ScreenRes.getScaledHeight(0.02) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		c.insets = new Insets(0,30,0,0);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(b2, c);
		

		
		JButton b3 = new JButton();
		b3.setPreferredSize( new Dimension( 35,35 ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		c.insets = new Insets(0,35,0,0);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(b3, c);
		
		JPanel buffer1 = new JPanel();
		buffer1.setOpaque(false);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		this.add(buffer1, c);

		JLabel t1 = new JLabel("0");
		t1.setPreferredSize( new Dimension( 55,15 ) );
		t1.setBackground(Color.WHITE);
		t1.setOpaque(true);
		c.insets = new Insets(0,0,0,0);
		c.gridx =0;
		c.gridy =4;
		c.gridwidth = 1;
		this.add(t1,c);
		
		JLabel l3 = new JLabel("Magnitude",JLabel.CENTER);
		l3.setForeground(Color.white);
		l3.setFont(font2);
		
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 5;
		this.add(l3, c);
		
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider2.setBackground(new Color(109, 110, 115));
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		
		c.gridx =0;
		c.gridy =6;
		c.gridwidth = 8;
		this.add(slider2,c);
		
		JLabel t2 = new JLabel("0");
		t2.setBackground(Color.WHITE);
		t2.setOpaque(true);
		t2.setPreferredSize( new Dimension( 55,15 ) );
		c.gridx =0;
		c.gridy =7;
		c.gridwidth = 1;
		this.add(t2,c);
		
		JLabel l4 = new JLabel("Spaciing",JLabel.CENTER);
		l4.setForeground(Color.white);
		l4.setFont(font2);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 8;
		this.add(l4, c);
		
		JSlider slider3 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider3.setBackground(new Color(109, 110, 115));
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		
		c.gridx =0;
		c.gridy =9;
		c.gridwidth = 8;
		this.add(slider3,c);
		
	}

}
