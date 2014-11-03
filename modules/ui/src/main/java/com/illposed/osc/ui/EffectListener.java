package com.illposed.osc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class EffectListener implements ActionListener {
	
	private List<Object> args;
	private OscUI oscUI;

	public EffectListener (OscUI oscUI)
	{
		this.args = new ArrayList<Object>();
		this.oscUI = oscUI;
	}

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
			else if (name != null && name.equals("FX:_F_R_A_M_E"))
			{
				args.clear();
				args.add(new Integer(16));
				args.add(new Integer(5));
				oscUI.doSendMessage("/fxframe", args);
			}
			else if (name != null && name.equals("FX:_M_B_L_U_R"))
			{
				args.clear();
				args.add(new Integer(1));
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
			else if (name != null && name.equals("FX:_L_U_M_A"))
			{
				args.clear();
				args.add(new Integer(1));
				oscUI.doSendMessage("/fxluma", args);
			}
			else 
				System.out.println("Unknown button: "+name);
			
			
			
			
			
		}
	
	
	}
		
}

