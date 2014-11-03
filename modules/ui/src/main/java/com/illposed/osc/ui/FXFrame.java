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

	public FXFrame(String name, OscUI oscUI) {
		super("");
		double scaler = 1.5;
		this.setPreferredSize( new Dimension(ScreenRes.getScaledWidth(0.1042*scaler),ScreenRes.getScaledHeight(0.213*scaler)) );
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		Font font1 = new Font("Verdana", Font.BOLD, ScreenRes.getScaledHeight(0.016*scaler));
		Font font2 = new Font("Verdana", Font.BOLD, ScreenRes.getScaledHeight(0.008*scaler));
		
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
		c.insets = new Insets(ScreenRes.getScaledHeight((-0.14*scaler)),0,0,0);//28   -170*scaler
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 7;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		JLabel l2 = new JLabel("Delay Magnitude",JLabel.CENTER);
		l2.setForeground(Color.white);
		l2.setFont(font2);
		c.insets = new Insets(ScreenRes.getScaledHeight(0*scaler),ScreenRes.getScaledWidth(-0.0355*scaler),0,0);//28
		//c.ipady = ScreenRes.getScaledHeight(p);      //make this component tall
		//c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 4;
		this.add(l2, c);
		
		JLabel t1 = new JLabel("0");
		t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02865*scaler),ScreenRes.getScaledHeight(0.0139*scaler) ) );
		t1.setBackground(Color.WHITE);
		t1.setOpaque(true);
		c.insets = new Insets(ScreenRes.getScaledHeight(0.005*scaler),0,0,0);
		c.gridx =0;
		c.gridy =2;
		c.gridwidth = 1;
		this.add(t1,c);
		
		JButton b1 = new JButton();
		b1.setName(name);
		b1.addActionListener(new EffectListener(oscUI));
		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02), ScreenRes.getScaledHeight(0.02) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		c.insets = new Insets(ScreenRes.getScaledHeight(-0.1111),ScreenRes.getScaledWidth(0.0495),0,0);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(b1, c);
		
		
		JPanel buffer1 = new JPanel();
		buffer1.setOpaque(false);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		this.add(buffer1, c);

		
		
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider2.setBackground(new Color(109, 110, 115));
		c.insets = new Insets(ScreenRes.getScaledHeight(0.0093),ScreenRes.getScaledWidth(-0.04427),0,0);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		
		c.gridx =0;
		c.gridy =5;
		c.gridwidth = 8;
		this.add(slider2,c);
		
		
	}

}
