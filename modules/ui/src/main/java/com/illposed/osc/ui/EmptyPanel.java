package com.illposed.osc.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
		
		final JButton t1 = new JButton(loadImageAsIcon("redBut.png"));
		//t1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.02), ScreenRes.getScaledHeight(0.02) ) );
		//t1.setSize(new Dimension(1,1));
		//c.weightx = 0.1;
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		//c.weightx = 0.1;
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
		JPanel buf1 = new JPanel();
		buf1.setOpaque(false);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(buf1, c);
		
		
		final JButton t2 = new JButton(loadImageAsIcon("redBut.png"));
		//t2.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		//c.weightx = 0.1;
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());
		c.gridx = 3;
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
		
		JPanel buf2 = new JPanel();
		buf2.setOpaque(false);
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(buf2, c);
		
		final JButton t3 = new JButton(loadImageAsIcon("redBut.png"));
		//t3.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.0156), ScreenRes.getScaledHeight(0.0185) ) );
		//c.weightx = 0.1;
		//c.weightx = 0.1;
		t3.setOpaque(false);
		t3.setBorder(BorderFactory.createEmptyBorder());
		c.gridx = 5;
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
		
		JPanel buf3 = new JPanel();
		buf3.setOpaque(false);
		c.gridx = 6;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(buf3, c);
		
		JButton b1 = new JButton();
		b1.setName(name);
		b1.setBackground(Color.RED);
		b1.setBorderPainted(false);
		b1.setOpaque(true);

		b1.setPreferredSize( new Dimension( ScreenRes.getScaledWidth(0.01), ScreenRes.getScaledHeight(0.01) ) );
		b1.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton jButton = (JButton)e.getSource();			
				
				if (jButton != null)
				{
					String name = jButton.getName();
					System.out.println("Button clicked: "+name);
					
					// TEXTURES
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
					else if (name != null && name.equals("TX:OSKWAVE"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/txoskwave", args);
					}
					
					// EFFECTS
					else if (name != null && name.equals("FX:FRAME"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/fxframe", args);
					}
					else if (name != null && name.equals("FX:MBLUR"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/fxmblur", args);
					}
					else if (name != null && name.equals("FX:REFRACT"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/fxrefract", args);
					}
					else if (name != null && name.equals("FX:KALEI"))
					{
						args.clear();
						args.add(new Integer(16));
						args.add(new Integer(5));
						oscUI.doSendMessage("/fxkalei", args);
					}
					else 
						System.out.println("Unknown button: "+name);
					
					
					
					
					
					
				}
			
			
			}
				
		});
		c.weightx = 1;
		c.gridx = 7;
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
