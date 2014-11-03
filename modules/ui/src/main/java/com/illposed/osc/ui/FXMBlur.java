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
import javax.swing.SpringLayout;

public class FXMBlur extends EffectPanel{

	public FXMBlur(String name, OscUI oscUI) {
		super("");
		double scaler = 1.5;
		this.setPreferredSize( new Dimension(ScreenRes.getScaledWidth(0.1042*scaler),ScreenRes.getScaledHeight(0.213*scaler)) );
		
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        SpringLayout.Constraints  contentPaneCons = 
                layout.getConstraints(this);
        
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
		
		layout.putConstraint(SpringLayout.NORTH, l1,
				ScreenRes.getScaledHeight(0),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, l1,
				ScreenRes.getScaledWidth(0.017),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(ScreenRes.getScaledHeight((-0.035*scaler)),0,0,0);//28   -40*scaler

		this.add(l1);
		

		

		

		
		JButton b3 = new JButton();
		b3.setBackground(Color.RED);
		b3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		//b1.setOpaque(false);
		//b1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
		//c.insets = new Insets(0,ScreenRes.getScaledWidth(0.01042*scaler),0,0);
		
		layout.putConstraint(SpringLayout.NORTH, b3,
				ScreenRes.getScaledHeight(0.04623),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b3,
				ScreenRes.getScaledWidth(0.1094),
                SpringLayout.NORTH, this);

		this.add(b3);
		
		JLabel t3 = new JLabel("Motion Blur Magnitude)");
		t3.setFont(font2);
		t3.setForeground(Color.white);
		t3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.06*scaler),ScreenRes.getScaledHeight(0.0139*scaler) ) );
		t3.setBackground(new Color(109, 110, 115));
		t3.setOpaque(true);
		//t3.setBounds(0,-70,0,0);
		layout.putConstraint(SpringLayout.NORTH, t3,
				ScreenRes.getScaledHeight(0.13),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, t3,
				ScreenRes.getScaledWidth(0.0078),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(0,-70,0,0);
		this.add(t3);

		JSlider slider4 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider4.setBackground(new Color(109, 110, 115));
		//slider4.setBounds(60,-80,0,0);
		layout.putConstraint(SpringLayout.NORTH, slider4,
				ScreenRes.getScaledHeight(0.1522),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, slider4,
				ScreenRes.getScaledWidth(0.0078),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(60,-80,0,0);
		slider4.setPaintTicks(true);
		slider4.setPaintLabels(true);		

		this.add(slider4);
		
		
		
		JLabel t1 = new JLabel("0");
		t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.01*scaler),ScreenRes.getScaledHeight(0.0139*scaler) ) );
		t1.setBackground(Color.WHITE);
		t1.setOpaque(true);
		//t1.setBounds(-160,80,0,0);
		//c.insets = new Insets(-160,80,0,0);
		layout.putConstraint(SpringLayout.NORTH, t1,
				ScreenRes.getScaledHeight(0.1522),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, t1,
				ScreenRes.getScaledWidth(0.12),
                SpringLayout.NORTH, this);
		this.add(t1);

		
		
	
		
	}

}
