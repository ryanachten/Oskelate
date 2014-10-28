package com.illposed.osc.ui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.illposed.osc.ui.OscUI.EFFECT;

public class EffectPanel extends JPanel{

	private EFFECT name;
	private JComboBox comboBox;

	public EffectPanel(EFFECT name) {
		setLayout(new GridLayout(3, 1));
		setBorder(OscUI.lineBorder);
		this.name = name;
		add(OscUI.makeLabel(name.toString(), OscUI.font16));
		setVisible(true);
		setOpaque(true);
		switch (name) {
		case EMPTY:
			addChooser();	
			break;

		default:
			break;
		}
	}

	private void addChooser() {
		add(this.comboBox = new JComboBox(OscUI.EFFECT.values()));
	}

}
