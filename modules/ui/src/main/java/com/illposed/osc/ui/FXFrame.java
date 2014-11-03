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

public class FXFrame extends EffectPanel{

	public FXFrame(String name) {
		super("");
		double scaler = 1.5;
		this.setPreferredSize( new Dimension((int)(250*scaler),(int)(260*scaler)) );
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		Font font1 = new Font("Verdana", Font.BOLD, (int)(20*scaler));
		Font font2 = new Font("Verdana", Font.BOLD, (int)(10*scaler));
		
		JLabel l1 = new JLabel(name,JLabel.CENTER);
		l1.setForeground(Color.white);
		l1.setFont(font1);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		JLabel l2 = new JLabel("Framesync Video <-> Sound",JLabel.CENTER);
		l2.setForeground(Color.white);
		l2.setFont(font2);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		this.add(l2, c);
		
		JLabel l3 = new JLabel("Delay Magnitude",JLabel.CENTER);
		l3.setForeground(Color.white);
		l3.setFont(font2);
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 2;
		this.add(l3, c);
		
		JLabel t1 = new JLabel("0");
		t1.setPreferredSize( new Dimension( 55,15 ) );
		t1.setBackground(Color.WHITE);
		t1.setOpaque(true);
		c.insets = new Insets(0,5,0,0);
		c.gridx =0;
		c.gridy =3;
		c.gridwidth = 1;
		this.add(t1,c);
		
		JButton b1 = new JButton();
		b1.setPreferredSize( new Dimension( 35,35 ) );
		//t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02), ScreenRes.getScaledHeight(0.02) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		c.insets = new Insets(0,30,0,0);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.add(b1, c);
		
		
		JPanel buffer1 = new JPanel();
		buffer1.setOpaque(false);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		this.add(buffer1, c);

		
		
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider2.setBackground(new Color(109, 110, 115));
		c.insets = new Insets(0,0,0,0);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		
		c.gridx =0;
		c.gridy =3;
		c.gridwidth = 8;
		this.add(slider2,c);
		
		
	}

}
