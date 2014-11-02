package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
		c.insets = new Insets(0,0,ScreenRes.getScaledHeight(0.025),0);//28
		c.weightx = 0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(l1, c);
		
		final JButton t1 = new JButton("text", loadImageAsIcon("redBut.png"));
		t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t1.setBackground(Color.RED);
		t1.setBorderPainted(false);
		t1.setOpaque(true);
		c.weightx = 0.1;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t1, c);
		
		t1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(t1.getBackground() == Color.RED)
					t1.setBackground(Color.GREEN);
				else
					t1.setBackground(Color.RED);
			}		
		});
		
		final JButton t2 = new JButton("text", loadImageAsIcon("redBut.png"));
		t2.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t2.setBackground(Color.RED);
		t2.setBorderPainted(false);
		t2.setOpaque(true);
		c.weightx = 0.1;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t2, c);
		
		t2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				if(t2.getBackground() == Color.RED)
					t2.setBackground(Color.GREEN);
				else
					t2.setBackground(Color.RED);
			}		
		});
		
		final JButton t3 = new JButton("text", loadImageAsIcon("redBut.png"));
		t3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		t3.setBackground(Color.RED);
		t3.setBorderPainted(false);
		t3.setOpaque(true);
		c.weightx = 0.1;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(t3, c);
		
		t3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				if(t3.getBackground() == Color.RED)
					t3.setBackground(Color.GREEN);
				else
					t3.setBackground(Color.RED);
			}		
		});
		
		
		JButton b1 = new JButton();
		b1.setName(name);
		b1.setBackground(Color.RED);

		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.01), ScreenRes.getScaledHeight(0.01) ) );
		b1.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton jButton = (JButton)e.getSource();
				
				
				if (jButton != null)
				{
					String name = jButton.getName();
					System.out.println("Button clicked: "+name);
					if (name != null && name.equals("NORMAL TX"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/txnormal", args);			
					}
					else if (name != null && name.equals("TX:CUBISM"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/txcubism", args);			
					}
				}
			
			
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
	
	private ImageIcon loadImageAsIcon(String path){
		try
		{
		  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		  InputStream input = getClass().getResourceAsStream(path);
		  Image logo = ImageIO.read(input);
		  ImageIcon i = new ImageIcon(logo);
		  return i;
		}
		catch ( Exception e ) { return null; }
	}
}
