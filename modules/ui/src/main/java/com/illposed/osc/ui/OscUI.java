/*
 * Copyright (C) 2001-2014, C. Ramakrishnan / Illposed Software.
 * All rights reserved.
 *
 * This code is licensed under the BSD 3-Clause license.
 * See file LICENSE (or LICENSE.html) for more information.
 */

// this is the package we are in
package com.illposed.osc.ui;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;
import com.illposed.osc.OSCPortOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 * OscUI is a subClass of JPanel.
 *
 * @author Chandrasekhar Ramakrishnan
 * @author JT
 */
public class OscUI extends JPanel {

	// declare some variables
	private JFrame parent;
	private JTextField addressWidget;
	private JLabel portWidget;
	private JTextField textBox;
	private JTextField textBox2;
	private JTextField textBox3;
	private JTextField textBox4 = new JTextField(String.valueOf(1000), 8);
	private JLabel delayLabel;
	public static final Color OSK_PINK = new Color(249, 197, 201);
	public static final Color OSK_MEDPINK = new Color(253, 235, 236);
	public static final Color OSK_PALEPINK = new Color(253, 235, 236);
	public static final Color OSK_PALEGREY = new Color(232, 233, 232);
	public static final Color OSK_MEDGREY = new Color(197, 201, 202);
	public static final Color OSK_DARKGREY = new Color(109, 110, 115);
	public static final Color OSK_RED = new Color(235, 89, 114);
	public static final Color OSK_BLUE = new Color(46, 151, 216);


	public enum EFFECT {LUMA, BLUR, FRAME, REFRACT, KALEI, CUBISM, OSKWAVE, EMPTY  };
	
	// fonts
	public static final  Font font11 = new Font("Helvetica Neue", Font.PLAIN, 11);
	public static final  Font font11b = new Font("Helvetica Neue", Font.BOLD, 11);
	public static final  Font font16 = new Font("Helvetica Neue", Font.PLAIN, 16);
	public static final  Font font16b = new Font("Helvetica Neue", Font.BOLD, 16);
	public static final Font font22 = new Font("Helvetica Neue", Font.PLAIN, 22);
	public static final Font font22b = new Font("Helvetica Neue", Font.BOLD, 22);
	public static final Font font30 = new Font("Helvetica Neue", Font.PLAIN, 30);
	public static final Font font30b = new Font("Helvetica Neue", Font.BOLD, 30);
	
	//borders
	public static final Border lineBorder = new LineBorder(Color.BLACK, 2);
	public static final Border emptyBorder = new EmptyBorder(5, 5, 5, 5);


	
	

	private JButton firstSynthButtonOn, secondSynthButtonOn, thirdSynthButtonOn, fourthSynthButtonOn;
	private JButton firstSynthButtonOff, secondSynthButtonOff, thirdSynthButtonOff,fourthSynthButtonOff;
	private JSlider slider, slider2, slider3;

	private OSCPortOut oscPortOut;
	private OSCPortIn oscPortIn;
	private JPanel livePanel;
	private JPanel averagePanel; 
	
	// create a constructor
	// OscUI takes an argument of myParent which is a JFrame
	public OscUI(JFrame myParent) {
		super();
		parent = myParent;
		makeDisplay();
		try {
			oscPortOut = new OSCPortOut();
			oscPortIn = new OSCPortIn(OSCPort.defaultSCOSCPort());
			oscPortIn.addListener("/livelevel", new OSCListener() {
				private List<Integer> samples = new ArrayList<Integer>();
				private int count = 10;

				@Override
				public void acceptMessage(Date time, OSCMessage message) {
					
					
					System.out.println("ACCEPTED MESAGE");
					
					List<Object> messageArgs = message.getArguments();
					// args should have length 1 and have a float value
					if (messageArgs != null && !messageArgs.isEmpty())
					{
						Object level = messageArgs.get(0);
						if (level instanceof Float)
						{
							samples.add(Math.round((Float)level));
							System.out.println("as int: "+Math.round((Float)level));
							
						}
						if (samples.size() == count)
						{
							int total = 0;
							for (Integer i : samples)
							{
								total += i;
							}
							fillLevels(total / count);
							samples.clear();
							
						}
						
						System.out.println(level.getClass().getName());
					}
					
					
					printArgs(messageArgs); // for debugging
					
					
//					message.addArgument("$1");
//					List<Object> args = message.getArguments();
//					for(Object a : args){
//						System.out.println("RECEIVED ARGS: " + a);
//					}
				}	
			});
			
			oscPortIn.startListening();
			
			
		} catch (Exception ex) {
			// this is just a demo program, so this is acceptable behavior
			ex.printStackTrace();
		}
	}
	
	// tries to conver Object to int, returns null f it can't
	private int toInt(Object obj){
//		if (obj instanceof Float)
			return 6;
			
		
	}

	/** Prints list of objects */
	protected void printArgs(List<Object> args) {
		if (args == null || args.isEmpty()) {
			System.out.println("Argument list is null or empty");
			return;
		}
		for (int i = 0; i < args.size(); i++){
			Object o = args.get(i);
			if (o instanceof String){
				System.out.println("Arg "+i+": (String)"+o);
			}
			else if (o instanceof Integer){
				System.out.println("Arg "+i+": (Integer)"+Integer.valueOf((Integer)o));
			}
			else if (o instanceof Float){
				System.out.println("Arg "+i+": (Float)"+Float.valueOf((Float)o));
			}
			else 
				System.out.println("Arg "+i+": not String, Integer or FLoat");

			
			
			
		}
	}

	// create a method for widget building
	private final void makeDisplay() {

		// setLayout to be a BoxLayout
		setLayout(new BorderLayout());
		setBackground(OSK_PINK);
		setOpaque(true);
		
		// call these methods ???? to be defined later
		
		addTopPanel();
		addMainPanel();
		
		
//		addOscServerAddressPanel();
//		addGlobalControlPanel();
//		addFirstSynthPanel();
//		addSecondSynthPanel();
//		addThirdSynthPanel();
//		addFourthSynthPanel();

	}
	
	/****** ADD PANEL METHODS  ******/
	/****** LOOK THE DIAGRAM BELOW **/
	/****** GRIDBAGLAYOUT BRAH, GOOGLE IT
	
	/**|_____1______|  
	/**| 2 | 3  | 4 |
	/**|___|____|___|
	/**| 5 | 6  | 7 |
	/**|___|____|___|
	
	/** 1 **/
	private void addTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(OSK_PINK);
		topPanel.setOpaque(true);
		add(topPanel, BorderLayout.NORTH);
//		topPanel.add(loadImage("oskImg.png"), BorderLayout.EAST);
		JPanel titlePanel = new JPanel();
		titlePanel.add(makeLabel("[", font30));
		titlePanel.add(makeLabel("OSKELATE ", font30b));
		titlePanel.add(makeLabel("VISUALISER", font30));
		titlePanel.add(makeLabel("]", font30));
		titlePanel.setBackground(OSK_PINK);
		titlePanel.setOpaque(true);
		topPanel.add(titlePanel, BorderLayout.CENTER);
		
//		JTextArea textArea = new JTextArea();
//		topPanel.add(textArea, BorderLayout.WEST);
		
		
		
		
	}
	
	
	/** 2, 3, 4, 5, 6, 7 **/
	private void addMainPanel() {
		JPanel mainPanel = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		mainPanel.setLayout(gridBag);
		GridBagConstraints cons = new GridBagConstraints();
		cons.weightx = 0.5;
		

		
		add(mainPanel, BorderLayout.CENTER);
		
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 0;
		cons.gridy = 0;
		addLogoPanel(mainPanel, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridwidth = 2;
		addSkeletalPanel(mainPanel, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 3;
		cons.gridy = 0;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		addLevelsPanel(mainPanel, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 1;
		addGemPanel(mainPanel, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridwidth = 2;
		addAudioPanel(mainPanel, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		addVideoPanel(mainPanel, cons);
		

		
	}
	
	
	
	/** 4 
	 * @param cons **/
	private void addLevelsPanel(JPanel upperPanel, GridBagConstraints cons) {
		JPanel levelsPanel = new JPanel();
		levelsPanel.setBackground(OSK_PALEPINK);
		levelsPanel.setOpaque(true);
		levelsPanel.setLayout(new BorderLayout());
		levelsPanel.add(makeLabel("SOUND LEVEL", font22), BorderLayout.NORTH);
		levelsPanel.add(makeLevels(), BorderLayout.CENTER);
		
		upperPanel.add(levelsPanel, cons);
		
	
		
	
	}

	/** 3 
	 * @param cons **/
	private void addSkeletalPanel(JPanel mainPanel, GridBagConstraints cons) {
		JPanel skeletalPanel = new JPanel();
		skeletalPanel.setBackground(OSK_PALEPINK);
		skeletalPanel.setOpaque(true);
		skeletalPanel.setLayout(new GridLayout(3, 1, 5, 5));
		skeletalPanel.setBorder(emptyBorder);
		skeletalPanel.add(makeLabel("SKELETAL", font22));
		
		// FX and TX
		JPanel skelFXPanel = new JPanel();
		for (int i = 0; i < 5; i++){
			skelFXPanel.add(new EmptyPanel());
		}
		skeletalPanel.add(skelFXPanel);
		
		JPanel skelTXPanel = new JPanel();
		for (int i = 0; i < 3; i++){
			skelTXPanel.add(new EmptyPanel());
		}
		skeletalPanel.add(skelTXPanel);
		
		skeletalPanel.setVisible(true);
		skeletalPanel.setOpaque(true);
		
		mainPanel.add(skeletalPanel, cons);

		
	}

	/** 2 
	 * @param cons **/
	private void addLogoPanel(JPanel mainPanel, GridBagConstraints cons) {
		mainPanel.add(makeLabel("===IMAGE===", font30b), cons);
		
	}

	


	/** 6 
	 * @param cons **/
	private void addAudioPanel(JPanel mainPanel, GridBagConstraints cons) {
		JPanel audioPanel = new JPanel();
		audioPanel.setBackground(OSK_PALEPINK);
		audioPanel.setOpaque(true);
		audioPanel.setLayout(new GridLayout(3, 1, 5, 5));
		audioPanel.setBorder(emptyBorder);
		audioPanel.add(makeLabel("AUDIO", font22));
		
		// FX and TX
		JPanel auFXPanel = new JPanel();
		for (int i = 0; i < 5; i++){
			auFXPanel.add(new EmptyPanel());
		}
		audioPanel.add(auFXPanel);
		
		JPanel auTXPanel = new JPanel();
		for (int i = 0; i < 3; i++){
			auTXPanel.add(new EmptyPanel());
		}
		audioPanel.add(auTXPanel);
		
		
		
	
		
		for (int i = 0; i < 8; i++){
//			audioPanel.add(new EmptyPanel());
		}
		
		audioPanel.setVisible(true);
		audioPanel.setOpaque(true);
		
		
		mainPanel.add(audioPanel, cons);
		
	}

	/** 5 
	 * @param cons **/
	private void addGemPanel(JPanel mainPanel, GridBagConstraints cons) {
		mainPanel.add(makeLabel("====GEM====", font30b), cons);

		
	}
	
	/** 7 
	 * @param cons **/
	private void addVideoPanel(JPanel mainPanel, GridBagConstraints cons) {
		
		JPanel videoPanel= new JPanel();
		videoPanel.setBackground(OSK_PALEPINK);
		videoPanel.setOpaque(true);
		JButton videoButton = new JButton("Choose video file");
		
		videoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				doSendSlider((float)1000.00, 1000);
				doSendVideo(1000,"/Documents/Oskelate/test.mp4");
				
			}

		});
		videoPanel.add(videoButton);
		
		mainPanel.add(videoPanel, cons);

	}
	
	/** THAT'S ALL THE MAIN PANELS **/

	


	// /javaosc-ui/src/main/java/res/oskImg.png
	private Component loadImage(String path){
		try
		{
		  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		  InputStream input = getClass().getResourceAsStream(path);
		  Image logo = ImageIO.read(input);

		  JLabel label = new JLabel( new ImageIcon( logo ) );
		  return label;
		}
		catch ( Exception e ) { return new JLabel("image load failed"); }
	}




	
	
	/****** MAKE COMPONENT METHODS ******/
	
	/* returns JLabel with text*/
	public static Component makeLabel(String name, Font font) {
		JLabel temp = new JLabel();
		temp.setFont(font);
		temp.setText(name);
		temp.setBorder(emptyBorder);
		return temp;
	}
	
	private Component makeLevels() {
		JPanel levelsPanel = new JPanel();
		levelsPanel.setLayout(new GridLayout(1, 2, 20, 1));
		livePanel= new JPanel();
		livePanel.setLayout(new GridLayout(15, 1, 0, 1));
		levelsPanel.add(livePanel);
		
		averagePanel = new JPanel();
		averagePanel.setLayout(new GridLayout(15, 1, 0, 1));
		
		/** make sure you only call fillLevels once both livePanel and 
		 * average panel have been created
		 */
		fillLevels(5);
//		fillLevels(8);
		levelsPanel.add(averagePanel);


		
		
		return levelsPanel;
	}

	private void fillLevels(int num) {
		livePanel.removeAll();
		averagePanel.removeAll();
		if (num < 0) num = 0;
		num = num / 4;
		if (num > 15) num = 15;		// SRIRAM DID THIS THANKS BRAH
		
		
		for (int i = 0; i < (15 - num); i++)
		{
			livePanel.add(new JLabel("   "));
			averagePanel.add(new JLabel("   "));

		}
		for (int i = 0;  i < num; i++)
		{
			JLabel square = new JLabel("   ");
			square.setOpaque(true);
			square.setBackground(Color.GREEN);
			averagePanel.add(square);
			livePanel.add(square);
		}
		averagePanel.repaint();
		averagePanel.revalidate();
		livePanel.repaint();
		livePanel.revalidate();
		
	}
	
	

	protected void addFourthSynthPanel() {
		// TODO Auto-generated method stub
		JPanel fourthSynthPanel = makeNewJPanel();
		fourthSynthPanel.setBackground(new Color(13, 23, 0));
		fourthSynthButtonOn = new JButton("On");
		fourthSynthButtonOff = new JButton("Off");
		fourthSynthButtonOff.setEnabled(false);
		
		fourthSynthPanel.add(fourthSynthButtonOn);
		// add firstSendButtonOff to the firstSynthPanel
		fourthSynthPanel.add(fourthSynthButtonOff);
		// add the firstSynthpanel to the OscUI Panel
		add(fourthSynthPanel);
	}

	// create a method for adding ServerAddress Panel to the OscUI Panel
	protected void addOscServerAddressPanel() {

		// variable addressPanel holds an instance of JPanel.
		// instance of JPanel received from makeNewJPanel method
		JPanel addressPanel = makeNewJPanel1();
		addressPanel.setBackground(new Color(123, 150, 123));
		// variable addressWidget holds an instance of JTextField
		addressWidget = new JTextField("localhost");
		// variable setAddressButton holds an insatnce of JButton with
		// a "Set Address" argument for its screen name
		JButton setAddressButton = new JButton("Set Address");
		setAddressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// perform the addressChanged method when action is received
				addressChanged();
			}
		});

		// variable portWidget holds an instance of JLabel with the OSCPortOut
		// as the text it looks like OSCPortOut has a method to get the default
		// SuperCollider port
		portWidget = new JLabel(Integer.toString(OSCPort.defaultSCOSCPort()));

		portWidget.setForeground(new Color(255, 255, 255));
		JLabel portLabel = new JLabel("Port");
		portLabel.setForeground(new Color(255, 255, 255));

		// add the setAddressButton to the addressPanel
		addressPanel.add(setAddressButton);
		// portWidget = new JTextField("57110");
		// add the addressWidget to the addressPanel
		addressPanel.add(addressWidget);
		// add the JLabel "Port" to the addressPanel
		addressPanel.add(portLabel);
		// add te portWidget tot eh addressPanel
		addressPanel.add(portWidget);

		//??? add address panel to the JPanel OscUI
		add(addressPanel);
	}

	public void addGlobalControlPanel() {
		JPanel globalControlPanel = makeNewJPanel();
		JButton globalOffButton = new JButton("All Off");
		JButton globalOnButton = new JButton("All On");
		textBox4 = new JTextField(String.valueOf(1000), 8);
		delayLabel = new JLabel("All Off delay in ms");
		delayLabel.setForeground(new Color(255, 255, 255));
		globalControlPanel.setBackground(new Color(13, 53, 0));

		globalOnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSendGlobalOn(1000, 1001, 1002);
				firstSynthButtonOn.setEnabled(false);
				firstSynthButtonOff.setEnabled(true);
				slider.setEnabled(true);
				slider.setValue(2050);
				textBox.setEnabled(true);
				textBox.setText("440.0");
				secondSynthButtonOn.setEnabled(false);
				secondSynthButtonOff.setEnabled(true);
				slider2.setEnabled(true);
				slider2.setValue(2048);
				textBox2.setEnabled(true);
				textBox2.setText("440.0");
				thirdSynthButtonOn.setEnabled(false);
				thirdSynthButtonOff.setEnabled(true);
				slider3.setEnabled(true);
				slider3.setValue(2052);
				fourthSynthButtonOn.setEnabled(false);
				fourthSynthButtonOff.setEnabled(true);
				textBox3.setEnabled(true);
				textBox3.setText("440.0");
			}
		});
		// ??? have an anonymous class listen to the setAddressButton action
		globalOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSendGlobalOff(1000, 1001, 1002);
				firstSynthButtonOn.setEnabled(true);
				firstSynthButtonOff.setEnabled(false);
				slider.setEnabled(false);
				slider.setValue(0);
				textBox.setEnabled(false);
				textBox.setText("0");
				secondSynthButtonOn.setEnabled(true);
				secondSynthButtonOff.setEnabled(false);
				slider2.setEnabled(false);
				slider2.setValue(0);
				textBox2.setEnabled(false);
				textBox2.setText("0");
				thirdSynthButtonOn.setEnabled(true);
				thirdSynthButtonOff.setEnabled(false);
				slider3.setEnabled(false);
				slider3.setValue(0);
				textBox3.setEnabled(false);
				textBox3.setText("0");
			}
		});

		globalControlPanel.add(globalOnButton);
		globalControlPanel.add(globalOffButton);
		globalControlPanel.add(textBox4);
		globalControlPanel.add(delayLabel);
		add(globalControlPanel);
	}

	// create method for adding a the buttons and synths of the
	// first synth on one panel
	public void addFirstSynthPanel() {
		// the variable firstSynthPanel holds an instance of Jpanel
		// created by the makeNewJPanel method
		JPanel firstSynthPanel = makeNewJPanel();
		// the variable firstSynthButytonOn holds an instance of JButton labeled
		// "On"

		firstSynthPanel.setBackground(new Color(13, 23, 0));
		firstSynthButtonOn = new JButton("On");
		//firstSynthButtonOn.setBackground(new Color(123, 150, 123));
		// the variable firstSynthButtonOff holds an instance of JButton labeled
		// "Off"
		firstSynthButtonOff = new JButton("Off");
		firstSynthButtonOff.setEnabled(false);
		// the variable slider holds an instance of JSlider which is
		// set to be a Horizontal slider
		slider = new JSlider(JSlider.HORIZONTAL);
		// set the minimum value of the slider to 20
		slider.setMinimum(0);
		slider.setMaximum(10000);
		// set the inital value of the slider to 400
		//slider.setValue(1 / 5);
		slider.setEnabled(false);

		textBox = new JTextField(String.valueOf((1 / 5) * 10000), 8);
		textBox.setEnabled(false);

		firstSynthButtonOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the on button is pushed, doSendOn method is invoked
				// send the arguments for frequency and node
				doSendOn(440, 1000);
				firstSynthButtonOn.setEnabled(false);
				firstSynthButtonOff.setEnabled(true);
				textBox.setText("440.0");
				textBox.setEnabled(true);
				slider.setValue(2050);
				slider.setEnabled(true);
			}
		});
		// when the on button is pushed, doSendOff method is invoked
		// send the argument for node
		firstSynthButtonOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the action occurs the doSend1 method is invoked
				doSendOff(1000);
				firstSynthButtonOn.setEnabled(true);
				firstSynthButtonOff.setEnabled(false);
				slider.setEnabled(false);
				slider.setValue(0);
				textBox.setEnabled(false);
				textBox.setText("0");
			}
		});

		// when the slider is moved, doSendSlider method is invoked
		// send the argument for freq and node
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JSlider mySlider = (JSlider) e.getSource();
				if (mySlider.getValueIsAdjusting()) {
					float freq = (float) mySlider.getValue();
					freq = (freq / 10000) * (freq / 10000);
					freq = freq * 10000;
					freq = freq + 20;
					doPrintValue(freq);
					doSendSlider(freq, 1000);
				}
			}
		});

		// when the value in the textbox is changed, doSendSlider method is
		// invoked; send the argument for freq and node
		textBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField field = (JTextField) e.getSource();
				float freq = (Float.valueOf(field.getText())).floatValue();
				if (freq > 10020) { freq = 10020; doPrintValue(freq); }
				if (freq < 20) { freq = 20; doPrintValue(freq); }
				slider.setValue((int)(10000*Math.sqrt(((freq - 20) / 10000))));
				doSendSlider(freq, 1000);
			}
		});


		// add firstSynthButtonOn to the firstSynthPanel
		firstSynthPanel.add(firstSynthButtonOn);
		// add firstSendButtonOff to the firstSynthPanel
		firstSynthPanel.add(firstSynthButtonOff);
		// add slider to the firstSynthPanel
		firstSynthPanel.add(slider);
		firstSynthPanel.add(textBox);

		// add the firstSynthpanel to the OscUI Panel
		add(firstSynthPanel);
	}

	///********************
	// create method for adding a the Second Synth Panel
	protected void addSecondSynthPanel() {
		// make a new JPanel called secondSynthPanel
		JPanel secondSynthPanel = makeNewJPanel();
		secondSynthPanel.setBackground(new Color(13, 23, 0));
		// the variable secondSynthButtonOn holds an instance of JButton
		secondSynthButtonOn = new JButton("On");
		// the variable secondSynthButtonOff holds an instance of JButton
		secondSynthButtonOff = new JButton("Off");
		secondSynthButtonOff.setEnabled(false);
		// the variable slider2 holds an instance of JSlider positioned
		// horizontally
		slider2 = new JSlider(JSlider.HORIZONTAL);
		slider2.setMinimum(0);
		slider2.setMaximum(10000);
		slider2.setEnabled(false);

		textBox2 = new JTextField(String.valueOf((2 / 5) * 10000), 8);
		textBox2.setEnabled(false);

		secondSynthButtonOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the action occurs the doSendOn method is invoked
				// with the arguments for freq and node
				doSendOn(440, 1001);
				secondSynthButtonOn.setEnabled(false);
				secondSynthButtonOff.setEnabled(true);
				slider2.setEnabled(true);
				slider2.setValue(2050);
				textBox2.setEnabled(true);
				textBox2.setText("440.0");
			}
		});
		// add the action for the Off button
		secondSynthButtonOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the action occurs the doSendOff method is invoked
				// with the argument for node
				doSendOff(1001);
				secondSynthButtonOn.setEnabled(true);
				secondSynthButtonOff.setEnabled(false);
				slider2.setEnabled(false);
				slider2.setValue(0);
				textBox2.setEnabled(false);
				textBox2.setText("0");
			}
		});
		// add the action for the slider
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider mySlider2 = (JSlider) e.getSource();
				if (mySlider2.getValueIsAdjusting()) {
					float freq = (float) mySlider2.getValue();
					freq = (freq / 10000) * (freq / 10000);
					freq = freq * 10000;
					freq = freq + 20;
					doPrintValue2(freq);
					// arguments for freq and node
					doSendSlider(freq, 1001);
				}
			}
		});

		// when the value in the textbox is changed, doSendSlider method is
		// invoked; send the argument for freq and node
		textBox2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField field = (JTextField) e.getSource();
				float freq = (Float.valueOf(field.getText())).floatValue();
				if (freq > 10020) { freq = 10020; doPrintValue2(freq); }
				if (freq < 20) { freq = 20; doPrintValue2(freq); }
				slider2.setValue((int)(10000*Math.sqrt(((freq - 20) / 10000))));
				doSendSlider(freq, 1001);
			}
		});

		// ******************
		// add Buttons and Slider to secondSynthPanel
		secondSynthPanel.add(secondSynthButtonOn);
		secondSynthPanel.add(secondSynthButtonOff);
		secondSynthPanel.add(slider2);
		secondSynthPanel.add(textBox2);
		// add the secondSynthPanel2 to the OscUI Panel
		add(secondSynthPanel);

	}

	protected void addThirdSynthPanel() {
		JPanel thirdSynthPanel = makeNewJPanel();
		thirdSynthPanel.setBackground(new Color(13, 23, 0));
		thirdSynthButtonOn = new JButton("On");
		thirdSynthButtonOff = new JButton("Off");
		thirdSynthButtonOff.setEnabled(false);
		slider3 = new JSlider(JSlider.HORIZONTAL);
		slider3.setMinimum(0);
		slider3.setMaximum(10000);
		slider3.setEnabled(false);

		textBox3 = new JTextField(String.valueOf((1 / 25) * 10000), 8);
		textBox3.setEnabled(false);

		thirdSynthButtonOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the action occurs the doSendOn method is invoked
				// with arguments for freq and node
				doSendOn(440, 1002);
				thirdSynthButtonOn.setEnabled(false);
				thirdSynthButtonOff.setEnabled(true);
				slider3.setEnabled(true);
				slider3.setValue(2050);
				textBox3.setEnabled(true);
				textBox3.setText("440.0");
			}
		});

		thirdSynthButtonOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the action occurs the doSendOff method is invoked
				// with argument for node
				doSendOff(1002);
				thirdSynthButtonOn.setEnabled(true);
				thirdSynthButtonOff.setEnabled(false);
				slider3.setEnabled(false);
				slider3.setValue(0);
				textBox3.setEnabled(false);
				textBox3.setText("0");
			}
		});

		slider3.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				//  JSlider source = (JSlider) e.getSource();
				JSlider mySlider3 = (JSlider) e.getSource();
				//if (source.getValueIsAdjusting()) {
				if (mySlider3.getValueIsAdjusting()) {
					// int freq = (int)source.getValue();
					float freq = (float) mySlider3.getValue();
					freq = (freq / 10000) * (freq / 10000);
					freq = freq * 10000;
					freq = freq + 20;
					doPrintValue3(freq);
					// when the action occurs the doSendSlider method is invoked
					// with arguments for freq and node
					doSendSlider(freq, 1002);
				}
			}
		});

		// when the value in the textbox is changed, doSendSlider method is
		// invoked; send the argument for freq and node
		textBox3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField field = (JTextField) e.getSource();
				float freq = (Float.valueOf(field.getText())).floatValue();
				if (freq > 10020) { freq = 10020; doPrintValue3(freq); }
				if (freq < 20) { freq = 20; doPrintValue3(freq); }
				slider3.setValue((int)(10000*Math.sqrt(((freq - 20) / 10000))));
				doSendSlider(freq, 1002);
			}
		});


		// ******************
		// add thirdSynthButtons and slider to the thirdSynthPanel
		thirdSynthPanel.add(thirdSynthButtonOn);
		thirdSynthPanel.add(thirdSynthButtonOff);
		thirdSynthPanel.add(slider3);
		thirdSynthPanel.add(textBox3);
		// add the sendButtonPanel2 to the OscUI Panel
		add(thirdSynthPanel);

	}

	// here is the make new JPanel method
	protected JPanel makeNewJPanel() {
		// a variable tempPanel holds an instance of JPanel
		JPanel tempPanel = new JPanel();
		// set the Layout of tempPanel to be a FlowLayout aligned left
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// function returns the tempPanel
		return tempPanel;
	}

	// here is the make new JPanel method
	protected JPanel makeNewJPanel1() {
		// a variable tempPanel holds an instance of JPanel
		JPanel tempPanel1 = new JPanel();
		// set the Layout of tempPanel to be a FlowLayout aligned left
		tempPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// function returns the tempPanel
		return tempPanel1;
	}

	// actions
	// create a method for the addressChanged action (Set Address)
	public void addressChanged() {
		// the variable OSCPortOut tries to get an instance of OSCPortOut
		// at the address indicated by the addressWidget
		try {
			oscPortOut =
				new OSCPortOut(InetAddress.getByName(addressWidget.getText()));
			// if the oscPort variable fails to be instantiated then sent
			// the error message
		} catch (Exception e) {
			showError("Couldn't set address");
		}
	}

	// create a method for the doSend action (Send)
	public void doSendOn(float freq, int node) {
		// if "Set Address" has not been performed then give the message to set
		// it first
		if (null == oscPortOut) {
			showError("Please set an address first");
		}

		// send an OSC message to start the synth "pink" on node 1000.
		List<Object> args = new ArrayList<Object>(6);
		args.add("javaosc-example");
		args.add(new Integer(node));
		args.add(new Integer(1));
		args.add(new Integer(0));
		args.add("freq");
		args.add(new Float(freq));
		// a comma is placed after /s_new in the code
		OSCMessage msg = new OSCMessage("/s_new", args);

		// Object[] args2 = {new Symbol("amp"), new Float(0.5)};
		// OscMessage msg2 = new OscMessage("/n_set", args2);
		//oscPort.send(msg);

		// try to use the send method of oscPort using the msg in nodeWidget
		// send an error message if this doesn't happen
		try {
			oscPortOut.send(msg);
		} catch (Exception ex) {
			showError("Couldn't send");
		}
	}

	// create a method for the doSend1 action (Send)
	public void doSendOff(int node) {
		// if "Set Address" has not been performed then give the message to set
		// it first
		if (null == oscPortOut) {
			showError("Please set an address first");
		}

		// send an OSC message to free the node 1000
		List<Object> args = new ArrayList<Object>(1);
		args.add(new Integer(node));
		OSCMessage msg = new OSCMessage("/n_free", args);

		// try to use the send method of oscPort using the msg in nodeWidget
		// send an error message if this doesn't happen
		try {
			oscPortOut.send(msg);
		} catch (Exception e) {
			showError("Couldn't send");
		}
	}

	public void doPrintValue(float freq) {
		textBox.setText(String.valueOf(freq));
	}

	public void doPrintValue2(float freq) {
		textBox2.setText(String.valueOf(freq));
	}

	public void doPrintValue3(float freq) {
		textBox3.setText(String.valueOf(freq));
	}
	
	/** SEND METHODS */

	// create a method for the doSend3 action (Send)
	public void doSendSlider(float freq, int node) {
		// if "Set Address" has not been performed then give the message to set
		// it first
		if (null == oscPortOut) {
			showError("Please set an address first");
		}

		// send an OSC message to set the node 1000
		List<Object> args = new ArrayList<Object>(3);
		args.add(new Integer(node));
		args.add("freq");
		args.add(new Float(freq));
		OSCMessage msg = new OSCMessage("/n_set", args);

		// try to use the send method of oscPort using the msg in nodeWidget
		// send an error message if this doesn't happen
		try {
			oscPortOut.send(msg);
		} catch (Exception e) {
			showError("Couldn't send");
		}
	}
	
	private void doSendVideo(int node, String path) {
		if (null == oscPortOut) {
			showError("Please set an address first");
		}
		
		List<Object> args = new ArrayList<Object>(2);
		args.add("Video:");
		args.add(path);
		OSCMessage msg = new OSCMessage("/video_path", args);
		msg.setAddress("/video_path");
		
		try {
			oscPortOut.send(msg);
		} catch (Exception e) {
			showError("Couldn't send");
		}

	}

	public void doSendGlobalOff(int node1, int node2, int node3) {
		if (null == oscPortOut) {
			showError("Please set an address first");
		}

		List<Object> args1 = new ArrayList<Object>(1);
		args1.add(new Integer(node1));
		OSCMessage msg1 = new OSCMessage("/n_free", args1);

		List<Object> args2 = new ArrayList<Object>(1);
		args2.add(new Integer(node2));
		OSCMessage msg2 = new OSCMessage("/n_free", args2);

		List<Object> args3 = new ArrayList<Object>(1);
		args3.add(new Integer(node3));
		OSCMessage msg3 = new OSCMessage("/n_free", args3);

		// create a timeStamped bundle of the messages
		List<OSCPacket> packets = new ArrayList<OSCPacket>(3);
		packets.add(msg1);
		packets.add(msg2);
		packets.add(msg3);
		Date newDate = new Date();
		long time = newDate.getTime();
		Integer delayTime = Integer.valueOf(textBox4.getText());
		time = time + delayTime.longValue();
		newDate.setTime(time);

		OSCBundle bundle = new OSCBundle(packets, newDate);

		try {
			oscPortOut.send(bundle);
		} catch (Exception e) {
			showError("Couldn't send");
		}

	}

	public void doSendGlobalOn(int node1, int node2, int node3) {
		if (null == oscPortOut) {
			showError("Please set an address first");
		}

		List<Object> args1 = new ArrayList<Object>(4);
		args1.add("javaosc-example");
		args1.add(new Integer(node1));
		args1.add(new Integer(1));
		args1.add(new Integer(0));
		OSCMessage msg1 = new OSCMessage("/s_new", args1);

		List<Object> args2 = new ArrayList<Object>(4);
		args2.add("javaosc-example");
		args2.add(new Integer(node2));
		args2.add(new Integer(1));
		args2.add(new Integer(0));
		OSCMessage msg2 = new OSCMessage("/s_new", args2);

		List<Object> args3 = new ArrayList<Object>(4);
		args3.add("javaosc-example");
		args3.add(new Integer(node3));
		args3.add(new Integer(1));
		args3.add(new Integer(0));
		OSCMessage msg3 = new OSCMessage("/s_new", args3);

		try {
			oscPortOut.send(msg1);
		} catch (Exception e) {
			showError("Couldn't send");
		}

		try {
			oscPortOut.send(msg2);
		} catch (Exception e) {
			showError("Couldn't send");
		}

		try {
			oscPortOut.send(msg3);
		} catch (Exception e) {
			showError("Couldn't send");
		}
	}

	// create a showError method
	protected void showError(String anErrorMessage) {
		// tell the JOptionPane to showMessageDialog
		System.out.println(anErrorMessage);
	}
}
