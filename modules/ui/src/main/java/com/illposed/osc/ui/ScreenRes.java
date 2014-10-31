package com.illposed.osc.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class ScreenRes {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();

	
	public static int getScaledWidth(int w){
		
		if(width == 1920)
			return w;
		else
			return w;
	}
	
	public static int getScaledHeight(int h){
		
		if(height == 1080)
			return h;
		else
			return h;
	}
	

}
