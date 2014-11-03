package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmptyPanel extends EffectPanel {

	
	
	private String name = "";
	private List<Object> args = new ArrayList<Object>(); 

	public EmptyPanel (String n, double w, double h, int f1, int f2, double p, final OscUI oscUI){
		super("");
		this.name = n;
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
		b1.setName(name);
		b1.setBackground(Color.RED);
		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0030), ScreenRes.getScaledHeight(0.0139) ) );
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e != null)
				{
					Object obj = e.getSource();
					if (obj instanceof JButton)
					{
						JButton jb = (JButton)obj;
						if (jb != null)
						{
							String name = jb.getName();
							if (name != null && name.equals("NORMAL TX"))
							{
								if (oscUI != null)
								{
									args.clear();
									args.add(new Integer(16));
									args.add(new Integer(5));
									oscUI.doSendMessage("/txnormal", args);									
								}
								else 
									System.out.println("oscui is null");
							}
							else 
								System.out.println("name is null");
						}
						else 
							System.out.println("jb is null");
					}
					else 
						System.out.println("obj is not JButton");
				}
				else 
					System.out.println("e is null");
			}
		});
		c.weightx = 1;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(b1, c);
		

		
		//add 1 red box
	}
	
	@Override
	public String getName(){
		return this.name;
	}
}
