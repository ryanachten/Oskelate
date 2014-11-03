package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;

public class FXOskwave extends EffectPanel {

	
	public FXOskwave(String name, OscUI oscUI)
	{
		super("");
		double scaler = 1.5;
		this.setPreferredSize( new Dimension(ScreenRes.getScaledWidth(0.1042*scaler),ScreenRes.getScaledHeight(0.213*scaler)) );

		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		SpringLayout.Constraints  contentPaneCons = layout.getConstraints(this);
		
		Font font1 = new Font("Verdana", Font.BOLD, ScreenRes.getScaledHeight(0.016*scaler));
		Font font2 = new Font("Verdana", Font.BOLD, ScreenRes.getScaledHeight(0.008*scaler));
		
		//label 
		
		JLabel l1 = new JLabel(name,JLabel.CENTER);
		l1.setVisible(true);
		l1.setForeground(Color.white);
		l1.setFont(font1);
		
		
		layout.putConstraint(SpringLayout.NORTH, l1, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, l1,	ScreenRes.getScaledWidth(0.0078), 
				SpringLayout.NORTH, this);
		
		add(l1);
		
		// button 1
		
		JButton b1 = new JButton();
		b1.setBackground(Color.RED);
		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//b1.setBounds(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		layout.putConstraint(SpringLayout.NORTH, b1,
				ScreenRes.getScaledHeight(0.04623),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b1,
				ScreenRes.getScaledWidth(0.1094),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		this.add(b1);
		
		//button 2
		
		JButton b2 = new JButton();
		b2.setBackground(Color.RED);
		b2.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//b1.setBounds(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		layout.putConstraint(SpringLayout.NORTH, b2,
				ScreenRes.getScaledHeight(0.04623),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b2,
				ScreenRes.getScaledWidth(0.1094),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		this.add(b2);
		
		//button3 

		JButton b3 = new JButton();
		b3.setBackground(Color.RED);
		b3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//b1.setBounds(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		layout.putConstraint(SpringLayout.NORTH, b3,
				ScreenRes.getScaledHeight(0.04623),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b3,
				ScreenRes.getScaledWidth(0.1094),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		this.add(b3);
		
		//buttons 4
		
		JButton b4 = new JButton();
		b4.setBackground(Color.RED);
		b4.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.018*scaler),ScreenRes.getScaledHeight(0.0324*scaler) ) );
		//b1.setBounds(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		layout.putConstraint(SpringLayout.NORTH, b4,
				ScreenRes.getScaledHeight(0.04623),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b4,
				ScreenRes.getScaledWidth(0.1094),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(ScreenRes.getScaledHeight(-0.1),ScreenRes.getScaledWidth(0.1),0,0);
		this.add(b4);
		
		// Force label
		
		JLabel l2 = new JLabel("FORCE",JLabel.CENTER);
		l2.setVisible(true);
		l2.setForeground(Color.white);
		l2.setFont(font1);
		
		
		layout.putConstraint(SpringLayout.NORTH, l2, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, l2,	ScreenRes.getScaledWidth(0.0078), 
				SpringLayout.NORTH, this);
		
		add(l2);
		
		
		// Force slider
		
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,50,0);
		slider2.setPreferredSize(new Dimension(120,40));
		slider2.setBackground(new Color(109, 110, 115));
		//slider2.setBounds(-150,-130,0,0);
		layout.putConstraint(SpringLayout.NORTH, slider2,
				ScreenRes.getScaledHeight(0.0926),
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, slider2,
				ScreenRes.getScaledWidth(0.0078),
                SpringLayout.NORTH, this);
		//c.insets = new Insets(-150,-130,0,0);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);		

		this.add(slider2);
		
		
		
		
	}
}
