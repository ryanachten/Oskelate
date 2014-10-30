package com.illposed.osc.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class LumaPanel extends EffectPanel{

	
	public LumaPanel(){
		super("FX: LUMA");
		add(new JSlider(SwingConstants.HORIZONTAL));
		
	}
	
	
}
